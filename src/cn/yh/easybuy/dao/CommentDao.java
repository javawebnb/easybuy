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
	 * 
	 * ��ѯ��������(��ҳ) 
	 */
	List<Comment> findCommentByPage(Page<Comment> page);
	
	
}
