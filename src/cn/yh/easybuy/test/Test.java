package cn.yh.easybuy.test;

import java.sql.Date;
import java.util.List;

import cn.yh.easybuy.dao.CommentDao;
import cn.yh.easybuy.dao.impl.CommentDaoImpl;
import cn.yh.easybuy.entity.Comment;
import cn.yh.easybuy.entity.Page;

public class Test {
	static CommentDao cdao = new CommentDaoImpl();
	public static void main(String[] args) {
		
//		findCommmentByPage();
//		saveComment();
		delComment();
//		updateCommnet();
	}
	
	public static void findCommmentByPage(){
		
		Page<Comment> page = new Page<Comment>();
		page.setPageIndex(0);
		page.setPageSize(10);
		List<Comment> comments = cdao.findCommentByPage(page);
		for (Comment c : comments){
			System.out.println(c.getContent());
		}
	}
	
	public static void saveComment(){
		Comment comment = new Comment();
		comment.setContent("石破天惊逗秋雨");
		comment.setCreateTime(new Date(new java.util.Date().getTime()));
		comment.setNickName("lbl");
		int n = cdao.saveComment(comment);
		if(n > 0){
			System.out.println("添加成功！");
		}
	}
	
	public static void delComment(){
		int n = cdao.delComment(1);
		if(n > 0){
			System.out.println("删除成功！");
		}
	}
	
	public static void updateCommnet(){
		Comment com = new Comment();
		com.setId(1);
		com.setReply("小荷才露尖尖角");
		com.setReplyTime(new Date(new java.util.Date().getTime()));
		int n = cdao.updateCommentById(com);
		if( n > 0){
			System.out.println("回复成功！");
		}
	}
}
