package cn.yh.easybuy.biz;

import java.util.List;

import cn.yh.easybuy.entity.Comment;
import cn.yh.easybuy.entity.Page;

public interface CommentBiz {
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
