package cn.yh.easybuy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yh.easybuy.biz.CartItemBiz;
import cn.yh.easybuy.biz.impl.CartItemBizImpl;
import cn.yh.easybuy.biz.impl.UserBizImpl;
import cn.yh.easybuy.entity.Cart;
import cn.yh.easybuy.entity.CartItem;
import cn.yh.easybuy.entity.User;
import cn.yh.easybuy.utils.DateUtil;

/**
 * Servlet implementation class UserServlet
 */ 
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		UserBizImpl ub = new UserBizImpl();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		//µÇÂ½
		if("login".equals(action)){
			String safeCode = (String)session.getAttribute("rand");
			String code = request.getParameter("code");
			User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			User loginUser = ub.login(user);
			if(code.equalsIgnoreCase(safeCode)){
				if(loginUser!=null){
					session.setAttribute("login",loginUser);
					response.sendRedirect("/easybuy/index.jsp");
					return;
				}else{
					session.setAttribute("error","ÓÃ»§ÃûÃÜÂë²»·û");
					return;
				}
			}else{
				session.setAttribute("error", "ÑéÖ¤Âë´íÎó");
				response.sendRedirect("/easybuy/login.jsp");
				return;
			}
			
		//×¢²á
		}else if("register".equals(action)){
			String sex = request.getParameter("sex");
			String birthday = request.getParameter("birthday");
			String identityCode = request.getParameter("identityCode");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String address = request.getParameter("address");
			User user = new User();
			user.setPassword(password);
			user.setUserName(userName);
			user.setSex(sex);
			user.setBirthday(new java.sql.Date(DateUtil.string2Date(birthday).getTime()));
			user.setIdentityCode(identityCode);
			user.setEmail(email);
			user.setStatus(0);
			user.setMobile(mobile);
			user.setAddress(address);
			user.setLogin(0d);
			int re = ub.regist(user);
			if(re>0){
				response.sendRedirect("/easybuy/reg-result.jsp");
				return;
			}else{
				response.sendRedirect("/easybuy/register.jsp");
			}
		//×¢Ïú
		}else if("logout".equals(action)){
			User user = (User)session.getAttribute("login");
			session.removeAttribute("login");
			CartItemBiz cib = new CartItemBizImpl();
			List<CartItem> listItems = ((Cart)session.getAttribute("cart")).getListItems();
			cib.saveCartItems(listItems,user.getId());
			response.sendRedirect("/easybuy/index.jsp");
			listItems.clear();
			return;
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
