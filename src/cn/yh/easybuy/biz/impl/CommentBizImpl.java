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
	 * �������
	 */
	@Override
	public int saveComment(Comment comment) {
		// TODO Auto-generated method stub
		
		return cdao.saveComment(comment);
	}
	/**
	 * ɾ������
	 */
	@Override
	public int delComment(Integer id) {
		// TODO Auto-generated method stub
		return cdao.delComment(id);
	}
	/**
	 * ��������
	 * (��Թ���Ա�Ļظ�)
	 */
	@Override
	public int updateCommentById(Comment comment) {
		// TODO Auto-generated method stub
		return cdao.updateCommentById(comment);
	}
	/**
	 * ͨ��ҳ���������(��ҳ��ѯ)
	 */
	@Override
	public List<Comment> findCommentByPage(Page<Comment> page) {
		// TODO Auto-generated method stub
		return cdao.findCommentByPage(page);
	}

}
