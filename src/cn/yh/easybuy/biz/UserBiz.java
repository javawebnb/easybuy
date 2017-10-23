package cn.yh.easybuy.biz;

import cn.yh.easybuy.entity.User;

/**
 * 用户业务接口
 * @author tigerJay
 *
 */
public interface UserBiz {
	
	/**
	 * 登录
	 */
	User login(User user);
	
	/**
	 * 注册
	 */
	Integer regist(User user);
	
	/**
	 * 修改用户信息
	 */
	Integer update(User user);
	
	/**
	 * 删除用户信息
	 */
	Integer delete(Integer id);
}
