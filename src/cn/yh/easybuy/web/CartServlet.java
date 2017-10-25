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

import cn.yh.easybuy.biz.CartItemBiz;
import cn.yh.easybuy.biz.ProductBiz;
import cn.yh.easybuy.biz.impl.CartItemBizImpl;
import cn.yh.easybuy.biz.impl.ProductBizImpl;
import cn.yh.easybuy.entity.Cart;
import cn.yh.easybuy.entity.CartItem;
import cn.yh.easybuy.entity.Product;
import cn.yh.easybuy.entity.User;

/**
 * 
 * @author tigerJay
 *
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CartItemBiz cib = new CartItemBizImpl();
    private ProductBiz pb = new ProductBizImpl();
    private Cart cart = new Cart();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opr = request.getParameter("opr");
		HttpSession session = request.getSession();
		//�ж�session�����޹��ﳵ
		if(session.getAttribute("cart")==null){
			session.setAttribute("cart", cart);
		}
		if("listCart".equals(opr)){
			listCart(request,response,session);
		}
		if("addCart".equals(opr)){
			addCart(request,response,session);
		}
		if("changeNum".equals(opr)){
			changeNum(request);
		}
		if("deleteCartItem".equals(opr)){
			deleteCartItem(request,response);
		}
		if("getGoodsNum".equals(opr)){
			getGoodsNum(response,request,session);
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
	 * ��ʾ���ﳵ��Ϣ
	 * @throws IOException 
	 */
	private void listCart(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException{
		User user = (User)session.getAttribute("login");
		List<CartItem> loginCart = new LinkedList<CartItem>();
		//�ж��Ƿ��¼
		if(user!=null){
			//��¼
			loginCart = cib.getCartItems(user.getId());
		}
		cart.addAll(loginCart);
		response.sendRedirect("/easybuy/shopping.jsp");
	}
	/**
	 * ����Ʒ��ӵ����ﳵ
	 */
	private void addCart(HttpServletRequest request, HttpServletResponse response,HttpSession session){
		Product product = null;
		Integer userId = null;
		//�ж��Ƿ��¼
		if(session.getAttribute("login")!=null){
			//��ȡ��¼�û�id
			userId = (Integer)((User)session.getAttribute("login")).getId();
		}
		String productId = request.getParameter("pid");
		//ͨ��id��ȡҪ��ӵ����ﳵ�Ĳ�Ʒ��Ϣ
		product = pb.selProductById(Integer.valueOf(productId));
		//��ӵ����ﳵ�б�
		cart.addCart(product, userId);
		//�������ݵ�ҳ��
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(cart.getListItems().size()+"");
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(out!=null){
				out.close();
			}
		}
	}
	/**
	 * �޸Ĺ��ﳵ����Ϣ
	 */
	private void changeNum(HttpServletRequest request){
		//��ȡ���ﳵ��Ʒ����
		String quantity = request.getParameter("quantity");
		//��ȡ��Ʒ����
		String goodsName = request.getParameter("goodsName");
		//�������ﳵ�����
		CartItem ci = new CartItem();
		ci.setGoodsName(goodsName);
		ci.setQuantity(Integer.valueOf(quantity));
		//����session���ﳵ����Ϣ
		cart.changeCart(ci, cart.getListItems());
	}
	
	/**
	 * ɾ�����ﳵ��
	 */
	private void deleteCartItem(HttpServletRequest request,HttpServletResponse response){
		//��ȡ��Ʒ��
		String goodsName = request.getParameter("goodsName");
		cart.delFromItem(goodsName);
		//�������ݵ�ҳ��
				PrintWriter out = null;
				try {
					out = response.getWriter();
					out.write(cart.getListItems().size()+"");
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(out!=null){
						out.close();
					}
				}
	}
	/**
	 * ���ع��ﳵ��Ʒ����
	 * @param request
	 * @param response
	 */
	private void getGoodsNum(HttpServletResponse response,HttpServletRequest request,HttpSession session){
			
		
			  PrintWriter out = null;
			 try {
				 User user = (User)session.getAttribute("login");
					List<CartItem> loginCart = new LinkedList<CartItem>();
					//�ж��Ƿ��¼
					if(user!=null){
						//��¼
						loginCart = cib.getCartItems(user.getId());
					}
				  cart.addAll(loginCart);
				//�������ݵ�ҳ��
					out = response.getWriter();
					out.write(cart.getListItems().size()+"");
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if(out!=null){
						out.close();
					}
				}
	}
}
