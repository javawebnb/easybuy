package cn.yh.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yh.easybuy.biz.OrderBiz;
import cn.yh.easybuy.biz.impl.OrderBizImpl;
import cn.yh.easybuy.entity.News;
import cn.yh.easybuy.entity.Order;
import cn.yh.easybuy.entity.Page;


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
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
