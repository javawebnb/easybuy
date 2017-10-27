package cn.yh.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yh.easybuy.biz.OrderBiz;
import cn.yh.easybuy.biz.impl.OrderBizImpl;
import cn.yh.easybuy.dao.ProductDao;
import cn.yh.easybuy.dao.impl.ProductDaoImpl;
import cn.yh.easybuy.entity.Cart;
import cn.yh.easybuy.entity.CartItem;
import cn.yh.easybuy.entity.Order;
import cn.yh.easybuy.entity.OrderDetail;
import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.Product;
import cn.yh.easybuy.entity.User;


/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//��ȡinput�������
		String opr = request.getParameter("opr");
		String id = request.getParameter("entityId");
		String username = request.getParameter("userName");
		
//		OrderDetailBiz biz = new OrderDetailBizImpl();	
		OrderBiz biz = new OrderBizImpl();
		
		//�Ի�ȡ���Ķ����ź��û��������жϻ�ȡ����
		if("showAll".equals(opr)){
			String role = request.getParameter("role");
			Integer pageIndex = 1;
			Integer pageSize = 3;
			String index = request.getParameter("i");
			if(index != null){
				pageIndex = Integer.valueOf(index);
			}
			Page<Order> OrderPage = biz.findAllOrders(pageIndex, pageSize);
			session.setAttribute("OrderPage", OrderPage);
			if ("manager".equals(role)){
				response.sendRedirect(request.getContextPath()+"/manage/order.jsp");
			}else{
				response.sendRedirect("index.jsp");
			}
		}
		if("saveOrder".equals(opr)){
			saveOrder(request,response,session);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    /**
     * ���涩��
     * @throws IOException 
     */
	private void saveOrder(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException{
		String tag = (String)session.getAttribute("tag");
		ProductDao pd = new ProductDaoImpl();
		//��ȡ������Ϣ ������ �û��� ��ַ ʱ�� ��� ״̬
		Cart cart = (Cart)session.getAttribute("cart");
		Order order = new Order();
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());//ʱ��
		Integer orderId = Integer.valueOf((int)date.getTime());//������
		Double totalPrice = cart.getTotalPrice();//�ܼ�
		Integer status = 1;//����״̬
		String userName = ((User)session.getAttribute("login")).getUserName();//�û���
		String address = request.getParameter("address");//��ַ
		OrderBiz ob = new OrderBizImpl();
		if("cart".equals(tag)){
			List<OrderDetail> orderDetails = new LinkedList<OrderDetail>();
			//��ȡ�������� ������ ��Ʒid ���� ���
			List<CartItem> listItems = cart.getListItems();
			//��װ����
			order.setCost(totalPrice);
			order.setId(orderId);
			order.setCreateTime(date);
			order.setStatus(status);
			order.setUserAddress(address);
			order.setUserName(userName);
			for(CartItem c : listItems){
				OrderDetail od = new OrderDetail();
				od.setId(orderId);
				od.setP_id(pd.findIdByPname(c.getGoodsName()));
				od.setQuantity(c.getQuantity());
				od.setCost(c.getPrice()*c.getQuantity());
				orderDetails.add(od);
			}
			order.setListDetail(orderDetails);
		}
		if("single".equals(tag)){
			Integer pid = (Integer)session.getAttribute("pid");
			Product p = pd.selProductById(pid);
			order.setCost(p.getPrice());
			order.setId(orderId);
			order.setCreateTime(date);
			order.setStatus(status);
			order.setUserAddress(address);
			order.setUserName(userName);
			OrderDetail od = new OrderDetail();
			od.setId(orderId);
			od.setP_id(p.getId());
			od.setQuantity(1);
			od.setCost(p.getPrice());
			order.getListDetail().add(od);
		}
		int res = ob.savenewOrders(order);
		if(res>0){
			if("cart".equals(tag)){
				cart.getListItems().clear();
			}
			response.sendRedirect("/easybuy/shopping-result.jsp");
		}
		
	}
	
}
