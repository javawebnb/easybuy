package cn.yh.easybuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.yh.easybuy.dao.CommentDao;
import cn.yh.easybuy.entity.Comment;
import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

public class CommentDaoImpl implements CommentDao {
	
	SqlSession session = SqlSessionFactoryUtil.getSqlSession();
	CommentDao cdao = session.getMapper(CommentDao.class);
	int n = 0;
	/**
	 * 添加评论
	 */
	@Override
	public int saveComment(Comment comment) {
		// TODO Auto-generated method stub
		n = cdao.saveComment(comment);
		session.commit();
		if(session != null){
			session.close();
		}
		return n;
	}
	/**
	 * 删除评论
	 */
	@Override
	public int delComment(Integer id) {
		// TODO Auto-generated method stub
		n = cdao.delComment(id);
		session.commit();
		if(session != null){
			session.close();
		}
		return n;
	}
	/**
	 * 修改评论
	 */
	@Override
	public int updateCommentById(Comment comment) {
		// TODO Auto-generated method stub
		n = cdao.updateCommentById(comment);
		session.commit();
		if(session != null){
			session.close();
		}
		return n;
	}
	/**
	 * 
	 */
	@Override
	public List<Comment> findCommentByPage(Page<Comment> page) {
		// TODO Auto-generated method stub
		List<Comment> list = null;
		list = cdao.findCommentByPage(page);
		session.commit();
		if(session != null){
			session.close();
		}
		return list;
	}

}
