package cn.yh.easybuy.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.yh.easybuy.dao.UserDao;
import cn.yh.easybuy.entity.User;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

public class UserDaoImpl implements UserDao{
	
	@Override
	public Integer saveUser(User user) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		Integer res = 0;
		try{
		session = SqlSessionFactoryUtil.getSqlSession();
		UserDao userDao = session.getMapper(UserDao.class);
		res = userDao.saveUser(user);
		}catch(Exception e){
			session.rollback();
			e.printStackTrace();
		}finally{
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		Integer res = 0;
		try{
		session = SqlSessionFactoryUtil.getSqlSession();
		UserDao userDao = session.getMapper(UserDao.class);
		res = userDao.updateUser(user);
		}catch(Exception e){
			session.rollback();
			e.printStackTrace();
		}finally{
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public Integer delUser(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		Integer res = 0;
		try{
		session = SqlSessionFactoryUtil.getSqlSession();
		UserDao userDao = session.getMapper(UserDao.class);
		res = userDao.delUser(id);
		}catch(Exception e){
			session.rollback();
			e.printStackTrace();
		}finally{
			session.commit();
			session.close();
		}
		return res;
	}


	@Override
	public List<User> findUser(Map<String,Object> condition) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		List<User> list = new ArrayList<User>();
		try{
		session = SqlSessionFactoryUtil.getSqlSession();
		UserDao userDao = session.getMapper(UserDao.class);
		list = userDao.findUser(condition);
		}catch(Exception e){
			session.rollback();
			e.printStackTrace();
		}finally{
			session.commit();
			session.close();
		}
		return list;
	}
	
}
