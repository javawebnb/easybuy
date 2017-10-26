package cn.yh.easybuy.dao;

import java.util.List;

import cn.yh.easybuy.entity.Comment;
import cn.yh.easybuy.entity.Page;

public interface CommentDao {
	/**
	 * �������
	 */
	int saveComment(Comment comment);
	/**
	 * ɾ������
	 */
	int delComment(Integer id);
	/**
	 * �޸�����
	 * (��Թ���Ա�����۵Ļظ�)
	 */
	int updateCommentById(Comment comment);
	/**
	 * ��ѯ�õ���������
	 */
	int getCount();
	/**
	 * 
	 * ��ѯ��������(��ҳ) 
	 */
	List<Comment> findCommentByPage(Page<Comment> page);
	/**
	 * ͨ��id��ѯ��Ӧ����
	 */
	Comment findCommentById(Integer id);
	
}
