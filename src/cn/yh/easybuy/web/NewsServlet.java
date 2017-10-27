package cn.yh.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yh.easybuy.biz.impl.NewsBizImpl;
import cn.yh.easybuy.entity.News;
import cn.yh.easybuy.entity.Page;

/**
 * Servlet implementation class NewsServlet
 */
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opr=request.getParameter("opr");
		NewsBizImpl nbi =new NewsBizImpl();
		News news=new News();
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		if("addNews".equals(opr)){
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			news.setTitle(title);
			news.setContent(content);
			news.setCreateTime(new java.sql.Date(new Date().getTime()));
			int i=nbi.saveNews(news);
			if(i>0){
				response.sendRedirect("manage/manage-result.jsp");
			}else{
				out.print("<script>alert('²Ù×÷Ê§°Ü');location.href = 'manage/news-add.jsp';</script>");
			}
		}else if("delNews".equals(opr)){
			String id=request.getParameter("id");
			int i=nbi.delNews(Integer.valueOf(id));
			if(i>0){
				response.sendRedirect("manage/manage-result.jsp");	
			}else{
				out.print("<script>alert('²Ù×÷Ê§°Ü');location.href = 'manage/news.jsp';</script>");
			} 
		}else if("toupdate".equals(opr)){
			String id=request.getParameter("id");
			news=nbi.findNewsById(Integer.valueOf(id));
			session.setAttribute("news", news);
			response.sendRedirect("manage/news-modify.jsp");
		}else if("updateNews".equals(opr)){
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			String id=request.getParameter("id");
			news.setId(Integer.valueOf(id));
			news.setTitle(title);
			news.setContent(content);
			int i=nbi.updateNews(news);
			if(i>0){
				response.sendRedirect("manage/manage-result.jsp");
			}else{
				out.print("<script>alert('²Ù×÷Ê§°Ü');location.href = 'manage/news-modify.jsp';</script>");
			}
		}else if("page".equals(opr)){
			String role = request.getParameter("role");
			Integer pageIndex = 1;
			Integer pageSize = 7;
			String index = request.getParameter("i");
			if(index != null){
				pageIndex = Integer.valueOf(index);
			}
			Page<News> pageObj = nbi.findAllNews(pageIndex, pageSize);
			session.setAttribute("newsPage", pageObj);
			if ("manager".equals(role)){
				response.sendRedirect(request.getContextPath()+"/manage/news.jsp");
			}else{
				response.sendRedirect("index.jsp");
			}
		}else if("read".equals(opr)){
			String id=request.getParameter("id");
			news=nbi.findNewsById(Integer.valueOf(id));
			session.setAttribute("readNew", news);
			response.sendRedirect("news-view.jsp");
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
