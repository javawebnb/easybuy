package cn.yh.easybuy.biz;

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
}
