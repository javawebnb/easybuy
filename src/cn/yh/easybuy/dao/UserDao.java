package cn.yh.easybuy.dao;

import java.util.List;
import java.util.Map;

import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.User;
/**
 * @author tigerJay
 */
public interface UserDao {
	/**
	 * �����û�
	 * @param user ������û���Ϣ
	 * @return ���µ�����
	 */
	Integer saveUser(User user);
	
	/**
	 * �����û�
	 * @param user ������û�������Ϣ
	 * @return ���µ�����
	 */
	Integer updateUser(User user);
	
	/**
	 * ɾ���û�
	 * @param id ������û�id 
	 * @return ɾ��������
	 */
	Integer delUser(Integer id);
	
	/**
	 * @param condition ��ѯ����
	 * @return ��ѯ�����
	 */

	List<User> findUser(Map<String,Object> condition);
	
	/**
	 * page����user
	 */
	List<User> findAllUser(Page<User> page);
	
	/**
	 * ͳ��������
	 */
	int getCount();
	
	/**
	 * ͨ��id���Ҷ���
	 */
	User checkUser(int id);

}
