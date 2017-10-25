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
		//判断session中有无购物车
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
	 * 显示购物车信息
	 * @throws IOException 
	 */
	private void listCart(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException{
		User user = (User)session.getAttribute("login");
		List<CartItem> loginCart = new LinkedList<CartItem>();
		//判断是否登录
		if(user!=null){
			//登录
			loginCart = cib.getCartItems(user.getId());
		}
		cart.addAll(loginCart);
		response.sendRedirect("/easybuy/shopping.jsp");
	}
	/**
	 * 把商品添加到购物车
	 */
	private void addCart(HttpServletRequest request, HttpServletResponse response,HttpSession session){
		Product product = null;
		Integer userId = null;
		//判断是否登录
		if(session.getAttribute("login")!=null){
			//获取登录用户id
			userId = (Integer)((User)session.getAttribute("login")).getId();
		}
		String productId = request.getParameter("pid");
		//通过id获取要添加到购物车的产品信息
		product = pb.selProductById(Integer.valueOf(productId));
		//添加到购物车列表
		cart.addCart(product, userId);
		//返回数据到页面
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
	 * 修改购物车项信息
	 */
	private void changeNum(HttpServletRequest request){
		//获取购物车商品数量
		String quantity = request.getParameter("quantity");
		//获取商品名称
		String goodsName = request.getParameter("goodsName");
		//创建购物车项对象
		CartItem ci = new CartItem();
		ci.setGoodsName(goodsName);
		ci.setQuantity(Integer.valueOf(quantity));
		//更新session购物车项信息
		cart.changeCart(ci, cart.getListItems());
	}
	
	/**
	 * 删除购物车项
	 */
	private void deleteCartItem(HttpServletRequest request,HttpServletResponse response){
		//获取商品名
		String goodsName = request.getParameter("goodsName");
		cart.delFromItem(goodsName);
		//返回数据到页面
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
	 * 返回购物车商品数量
	 * @param request
	 * @param response
	 */
	private void getGoodsNum(HttpServletResponse response,HttpServletRequest request,HttpSession session){
			
		
			  PrintWriter out = null;
			 try {
				 User user = (User)session.getAttribute("login");
					List<CartItem> loginCart = new LinkedList<CartItem>();
					//判断是否登录
					if(user!=null){
						//登录
						loginCart = cib.getCartItems(user.getId());
					}
				  cart.addAll(loginCart);
				//返回数据到页面
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
