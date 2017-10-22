package cn.yh.easybuy.dao.impl.copy;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.yh.easybuy.dao.OrderDao;
import cn.yh.easybuy.entity.Order;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

public class OrderDaoImpl implements OrderDao{

	@Override
	public List<Order> findOrdersByuserId(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionFactoryUtil.getSqlSession();
		OrderDao od=session.getMapper(OrderDao.class);
		List<Order> list=od.findOrdersByuserId(id);
		session.close();
		return list;
	}

	@Override
	public List<Order> findOrdersByuserName(Integer name) {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionFactoryUtil.getSqlSession();
		OrderDao od=session.getMapper(OrderDao.class);
		List<Order> list=od.findOrdersByuserId(name);
		session.close();
		return list;
	}

	@Override
	public Integer savenewOrders(Order order) {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionFactoryUtil.getSqlSession();
		OrderDao od=session.getMapper(OrderDao.class);
		int i=od.savenewOrders(order);
		session.commit();
		session.close();
		return i;
	}

	@Override
	public Integer updateOrders(Order order) {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionFactoryUtil.getSqlSession();
		OrderDao od=session.getMapper(OrderDao.class);
		int i=od.updateOrders(order);
		session.commit();
		session.close();
		return i;
	}

	@Override
	public Integer delOrders(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session=SqlSessionFactoryUtil.getSqlSession();
		OrderDao od=session.getMapper(OrderDao.class);
		int i=od.delOrders(id);
		session.commit();
		session.close();
		return i;
	}
	
}
