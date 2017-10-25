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
	 * �˴����ص���һ��Page���󣬸ö����pageList���Լ�Ϊͨ��ҳ���ҳ��С���ҵ������ۼ���
	 */
	@Override
	public Page<Comment> showCommentByPage(Integer pageSize, Integer pageIndex) {
		// TODO Auto-generated method stub
		int count = cdao.getCount();
		Page<Comment> page = new Page<Comment>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setCount(count);
		//ͨ������õ���û�е�ǰҳ�漯��page������Ϊ�����õ���ǰҳ�漯(��ǰҳ�����������)
		List<Comment> list = cdao.findCommentByPage(page);
		page.setPageList(list);
		
		return page;
	}
	/**
	 * ͨ��id��ѯ��ʾ��ӦComment����
	 */
	@Override
	public Comment showCommentById(Integer id) {
		// TODO Auto-generated method stub
		return cdao.findCommentById(id);
	}

}
