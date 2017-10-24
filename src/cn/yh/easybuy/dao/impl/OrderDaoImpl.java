package cn.yh.easybuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.yh.easybuy.dao.OrderDao;
import cn.yh.easybuy.entity.Order;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

public class OrderDaoImpl implements OrderDao{

	@Override
	public List<Order> findOrdersByuserId(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		OrderDao od = session.getMapper(OrderDao.class);
		List<Order> list = od.findOrdersByuserId(id);
		session.close();
		return list;
	}

	@Override
	public List<Order> findOrdersByuserName(String name) {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		OrderDao od = session.getMapper(OrderDao.class);
		List<Order> list = od.findOrdersByuserName(name);
		session.close();
		return list;
	}

	@Override
	public Integer savenewOrders(Order order) {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		OrderDao od = session.getMapper(OrderDao.class);
		int i = od.savenewOrders(order);
		session.commit();
		session.close();
		return i;
	}

	@Override
	public Integer updateOrders(Order order) {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		OrderDao od = session.getMapper(OrderDao.class);
		int i = od.updateOrders(order);
		session.commit();
		session.close();
		return i;
	}

	@Override
	public Integer delOrders(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		OrderDao od = session.getMapper(OrderDao.class);
		int i = od.delOrders(id);
		session.commit();
		session.close();
		return i;
	}

	@Override
	public List<Order> findOrder() {
		// TODO Auto-generated method stub
		List<Order> list = null;
		
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		OrderDao dao = session.getMapper(OrderDao.class);
		
		list = dao.findOrder();
		
		session.commit();
		session.close();
		
		return list;
	}


	
}
