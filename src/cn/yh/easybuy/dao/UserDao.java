package cn.yh.easybuy.dao;

import java.util.List;
import java.util.Map;

import cn.yh.easybuy.entity.User;
/**
 * @author tigerJay
 */
public interface UserDao {
	/**
	 * 保存用户
	 * @param user 传入的用户信息
	 * @return 更新的行数
	 */
	Integer saveUser(User user);
	
	/**
	 * 更新用户
	 * @param user 传入的用户更新信息
	 * @return 更新的行数
	 */
	Integer updateUser(User user);
	
	/**
	 * 删除用户
	 * @param id 传入的用户id 
	 * @return 删除的行数
	 */
	Integer delUser(Integer id);
	
	/**
	 * @param condition 查询条件
	 * @return 查询结果集
	 */
	List<User> findUser(Map<String,Object> condition);
}
