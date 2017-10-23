package cn.yh.easybuy.biz.impl;

import java.util.List;

import cn.yh.easybuy.biz.CommentBiz;
import cn.yh.easybuy.dao.CommentDao;
import cn.yh.easybuy.dao.impl.CommentDaoImpl;
import cn.yh.easybuy.entity.Comment;
import cn.yh.easybuy.entity.Page;

public class CommentBizImpl implements CommentBiz {
	
	CommentDao cdao = new CommentDaoImpl();
	
	/**
	 * 添加评论
	 */
	@Override
	public int saveComment(Comment comment) {
		// TODO Auto-generated method stub
		
		return cdao.saveComment(comment);
	}
	/**
	 * 删除评论
	 */
	@Override
	public int delComment(Integer id) {
		// TODO Auto-generated method stub
		return cdao.delComment(id);
	}
	/**
	 * 更新评论
	 * (针对管理员的回复)
	 */
	@Override
	public int updateCommentById(Comment comment) {
		// TODO Auto-generated method stub
		return cdao.updateCommentById(comment);
	}
	/**
	 * 通过页码查找评论(分页查询)
	 */
	@Override
	public List<Comment> findCommentByPage(Page<Comment> page) {
		// TODO Auto-generated method stub
		return cdao.findCommentByPage(page);
	}

}
