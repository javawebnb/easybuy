package cn.yh.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yh.easybuy.biz.CommentBiz;
import cn.yh.easybuy.biz.impl.CommentBizImpl;
import cn.yh.easybuy.entity.Comment;
import cn.yh.easybuy.entity.Page;

/**
 * Servlet implementation class CommentServlet
 */
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String opr = request.getParameter("opr");
		CommentBiz cbiz = new CommentBizImpl();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if("page".equals(opr)){//前段留言页面(分页查询)
			String role = request.getParameter("role");
			int pageIndex = 1;
			int pageSize = 7;//页面大小
			String index = request.getParameter("i");
			if(index != null){//index不为空，也就是点击了页码的时候
				pageIndex = Integer.valueOf(index);
			}
			Page<Comment> commentPage = cbiz.showCommentByPage(pageSize, pageIndex);
			session.setAttribute("commentPage", commentPage);
			if("manager".equals(role)){//后台管理角色跳转到对应页面
				response.sendRedirect(request.getContextPath()+"/manage/guestbook.jsp");
			}else{
				response.sendRedirect("guestbook.jsp");
			}
		}else if("saveComment".equals(opr)){//添加评论
			String nickName = request.getParameter("guestName");
			String content = request.getParameter("guestContent");
			Comment comment = new Comment();
			comment.setContent(content);
			comment.setNickName(nickName);
			comment.setCreateTime(new Date(new java.util.Date().getTime()));
			int n = cbiz.saveComment(comment);
			if(n > 0){
				out.print("<script>alert('添加成功！');location.href='guestbook.jsp'</script>");
			}
		}else if("replyPage".equals(opr)){//显示回复页面
			Integer id = Integer.valueOf(request.getParameter("id"));
			Comment comment = cbiz.showCommentById(id);
			session.setAttribute("comment", comment);
			response.sendRedirect("manage/guestbook-modify.jsp");
		}else if("reply".equals(opr)){//管理员回复评论，相当于修改操作
			String reply = request.getParameter("replyContent");
			Integer id = Integer.valueOf(request.getParameter("id"));
			Comment comment = new Comment();
			comment.setId(id);
			comment.setReply(reply);
			comment.setCreateTime(new Date(new java.util.Date().getTime()));
			int n = cbiz.updateCommentById(comment);
			if(n > 0){
				response.sendRedirect("manage/manage-result.jsp");
			}
		}else if("delComment".equals(opr)){//通过id删除评论
			Integer id = Integer.valueOf(request.getParameter("id"));
			int n = cbiz.delComment(id);
			if(n > 0){
				response.sendRedirect("manage/manage-result.jsp");
			}
		}
	}

}
