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
import cn.yh.easybuy.entity.Page;
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
		
		//用户登陆
		if("login".equals(action)){
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
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
					session.setAttribute("error","用户名密码不符");
					response.sendRedirect("/easybuy/login.jsp");
					return;
				}
			}else{
				session.setAttribute("error", "验证码错误");
				response.sendRedirect("/easybuy/login.jsp");
				return;
			}
			
		//用户注册
		}else if("register".equals(action)){
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
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
		//用户注销
		}else if("logout".equals(action)){
			User user = (User)session.getAttribute("login");
			session.removeAttribute("login");
			CartItemBiz cib = new CartItemBizImpl();
			List<CartItem> listItems = ((Cart)session.getAttribute("cart")).getListItems();
			cib.saveCartItems(listItems,user.getId());
			response.sendRedirect("/easybuy/index.jsp");
			listItems.clear();
			return;
			
		//后台页面分页
		}else if("page".equals(action)){
			int pageIndex = 1;
			int pageSize = 5;
			String index = request.getParameter("index");
			if(index!=null){
				pageIndex = Integer.valueOf(index);
			}
			Page<User> pageUser = ub.findAllUser(pageIndex,pageSize);
			session.setAttribute("pageUser",pageUser);
			response.sendRedirect("/easybuy/manage/user.jsp");
		}
		//删除用户
		else if("delUser".equals(action)){
			int id = Integer.valueOf(request.getParameter("userId"));
			int re = ub.delete(id);
			if(re>0){
				session.setAttribute("delUserState","删除成功");
			}else{
				session.setAttribute("delUserState","删除失败");
			}
			response.sendRedirect("/easybuy/manage/user.jsp");
		}
		//通过id获取对象存入session
		else if("getUser".equals(action)){
			int id = Integer.valueOf(request.getParameter("userId"));
			User user = ub.findUser(id);
			session.setAttribute("getUser",user);
			response.sendRedirect("/easybuy/manage/user-modify.jsp");
		}
		//修改用户
		else if("modifyUser".equals(action)){
			User user = new User();
			user.setId(Integer.valueOf(request.getParameter("id")));
			user.setUserName(request.getParameter("userName"));
			user.setPassword(request.getParameter("passWord"));
			user.setSex(request.getParameter("sex"));
			user.setAddress(request.getParameter("address"));
			user.setMobile(request.getParameter("mobile"));
			String year = request.getParameter("birthyear");
			String month = request.getParameter("birthmonth");
			String birthday = request.getParameter("birthday");
			String day = year+"-"+month+"-"+birthday;
			user.setBirthday(new java.sql.Date(DateUtil.string2Date(day).getTime()));
			int re = ub.update(user);
			if(re>0){
				session.setAttribute("modiText","修改成功");
				response.sendRedirect("/easybuy/manage/manage-result.jsp");
			}else{
				session.setAttribute("modiText","修改失败");
				response.sendRedirect("/easybuy/manage/user.jsp");
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
