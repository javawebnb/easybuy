package cn.yh.easybuy.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.yh.easybuy.biz.UserBiz;
import cn.yh.easybuy.dao.UserDao;
import cn.yh.easybuy.dao.impl.UserDaoImpl;
import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.User;

public class UserBizImpl implements UserBiz{
	private UserDao userDao = new UserDaoImpl();
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("userName", user.getUserName());
		condition.put("password", user.getPassword());
		List<User> list = userDao.findUser(condition);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Integer regist(User user) {
		// TODO Auto-generated method stub
		return userDao.saveUser(user);
	}

	@Override
	public Integer update(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return userDao.delUser(id);
	}

	@Override
	public Page<User> findAllUser(Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		UserDao ud = new UserDaoImpl();
		List<User> list = new ArrayList<User>();
		Page<User> page = new Page<User>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		int count = ud.getCount();
		page.setCount(count);
		list = ud.findAllUser(page);
		page.setPageList(list);
		return page;
	}

	@Override
	public User findUser(int id) {
		// TODO Auto-generated method stub
		UserDao ud = new UserDaoImpl();
		User user = ud.checkUser(id);
		return user;
	}
	
}
