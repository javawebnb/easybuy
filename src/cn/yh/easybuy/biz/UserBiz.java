package cn.yh.easybuy.biz;

import java.util.List;

import cn.yh.easybuy.entity.News;
import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.User;

/**
 * �û�ҵ��ӿ�
 * @author tigerJay
 *
 */
public interface UserBiz {
	
	/**
	 * ��¼
	 */
	User login(User user);
	
	/**
	 * ע��
	 */
	Integer regist(User user);
	
	/**
	 * �޸��û���Ϣ
	 */
	Integer update(User user);
	
	/**
	 * ɾ���û���Ϣ
	 */
	Integer delete(Integer id);
	
	/**
	 * page��ȡ�����û�
	 */
	public Page<User> findAllUser(Integer pageIndex, Integer pageSize);
	
	/**
	 * ͨ��id��ȡ����
	 */
	User findUser(int id);
}
