package cn.yh.easybuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.yh.easybuy.dao.CommentDao;
import cn.yh.easybuy.entity.Comment;
import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

public class CommentDaoImpl implements CommentDao {
	/**
	 * �������
	 */
	@Override
	public int saveComment(Comment comment) {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		CommentDao cdao = session.getMapper(CommentDao.class);
		int n = cdao.saveComment(comment);
		session.commit();
		if(session != null){
			session.close();
		}
		return n;
	}
	/**
	 * ɾ������
	 */
	@Override
	public int delComment(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		CommentDao cdao = session.getMapper(CommentDao.class);
		int n = cdao.delComment(id);
		session.commit();
		if(session != null){
			session.close();
		}
		return n;
	}
	/**
	 * �޸�����
	 */
	@Override
	public int updateCommentById(Comment comment) {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		CommentDao cdao = session.getMapper(CommentDao.class);
		int n = cdao.updateCommentById(comment);
		session.commit();
		if(session != null){
			session.close();
		}
		return n;
	}
	/**
	 * ��ѯ����(ͨ����ҳ)
	 */
	@Override
	public List<Comment> findCommentByPage(Page<Comment> page) {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		CommentDao cdao = session.getMapper(CommentDao.class);
		List<Comment> list = null;
		list = cdao.findCommentByPage(page);
		session.commit();
		if(session != null){
			session.close();
		}
		return list;
	}
	/**
	 * ������۵��ܼ�¼��
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		CommentDao cdao = session.getMapper(CommentDao.class);
		int count = cdao.getCount();
		session.commit();
		if(session != null){
			session.close();
		}
		return count;
	}
	/**
	 * ͨ��id��ѯ��Ӧ����
	 */
	@Override
	public Comment findCommentById(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		CommentDao cdao = session.getMapper(CommentDao.class);
		Comment comment = cdao.findCommentById(id);
		session.commit();
		if(session != null){
			session.close();
		}
		return comment;
	}

}
