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
	 * 此处返回的是一个Page对象，该对象的pageList属性即为通过页码和页大小查找到的评论集合
	 */
	@Override
	public Page<Comment> showCommentByPage(Integer pageSize, Integer pageIndex) {
		// TODO Auto-generated method stub
		int count = cdao.getCount();
		Page<Comment> page = new Page<Comment>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setCount(count);
		//通过上面得到的没有当前页面集的page对象作为参数得到当前页面集(当前页面的所有评论)
		List<Comment> list = cdao.findCommentByPage(page);
		page.setPageList(list);
		
		return page;
	}
	/**
	 * 通过id查询显示对应Comment对象
	 */
	@Override
	public Comment showCommentById(Integer id) {
		// TODO Auto-generated method stub
		return cdao.findCommentById(id);
	}

}
