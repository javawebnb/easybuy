package cn.yh.easybuy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yh.easybuy.biz.AddressBiz;
import cn.yh.easybuy.biz.impl.AddressBizImpl;
import cn.yh.easybuy.entity.Address;
import cn.yh.easybuy.entity.User;

/**
 * Servlet implementation class AddressServlet
 */
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AddressBiz ab = new AddressBizImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
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
		if("listAddr".equals(opr)){
			listAddr(request,response,session);
		}
		if("saveAddr".equals(opr)){
			saveAddr(request,response,session);
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
	 * 显示所有地址
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	private void listAddr(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException{
		String userId = request.getParameter("userId");
		List<Address> list = ab.findAddressByUid(Integer.valueOf(userId));
		session.setAttribute("addrList", list);
		response.sendRedirect("/easybuy/address.jsp");
	}
	/**
	 * 添加新地址
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void saveAddr(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException{
		String address = request.getParameter("address");
		Integer userId = ((User)session.getAttribute("login")).getId();
		Address addr = new Address();
		addr.setUserId(userId);
		addr.setAddress(address);
		ab.saveAddress(addr);
		response.sendRedirect("/easybuy/address.jsp");
	}

}
