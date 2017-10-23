package cn.yh.easybuy.biz;

import java.util.List;

import cn.yh.easybuy.entity.Comment;
import cn.yh.easybuy.entity.Page;

public interface CommentBiz {
	/**
	 * 添加评论
	 */
	int saveComment(Comment comment);
	/**
	 * 删除评论
	 */
	int delComment(Integer id);
	/**
	 * 修改评论
	 * (针对管理员对评论的回复)
	 */
	int updateCommentById(Comment comment);
	/**
	 * 
	 * 查询所有评论(分页) 
	 */
	List<Comment> findCommentByPage(Page<Comment> page);
}
