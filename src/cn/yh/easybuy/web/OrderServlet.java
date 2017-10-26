package cn.yh.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yh.easybuy.biz.OrderDetailBiz;
import cn.yh.easybuy.biz.impl.OrderDetailBizImpl;
import cn.yh.easybuy.entity.OrderDetail;


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
		
		//获取input输入对象
		String opr = request.getParameter("opr");
		String id = request.getParameter("entityId");
		String username = request.getParameter("userName");
		
		OrderDetailBiz biz = new OrderDetailBizImpl();	
		
		//对获取到的订单号和用户名进行判断获取数据
		if("showAll".equals(opr)){
				List<OrderDetail> list = biz.findOrderDetail();
				session.setAttribute("orderdetail", list);
				response.sendRedirect("manage/order.jsp");
				if(id!=null && username == null){
					List<OrderDetail> dlist = biz.findDetailByid(Integer.valueOf(id));
					session.setAttribute("orderdetail", dlist);
					response.sendRedirect("manage/order.jsp");
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
