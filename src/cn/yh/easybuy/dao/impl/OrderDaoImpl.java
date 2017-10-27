package cn.yh.easybuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.yh.easybuy.dao.OrderDao;
import cn.yh.easybuy.dao.OrderDetailDao;
import cn.yh.easybuy.entity.Order;
import cn.yh.easybuy.entity.OrderDetail;
import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

public class OrderDaoImpl implements OrderDao{
	private OrderDetailDao odd = new OrderDetailDaoImpl();
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
		SqlSession session = null;
		int i = 0;
		try{
		    session = SqlSessionFactoryUtil.getSqlSession();
			OrderDao od = session.getMapper(OrderDao.class);
			i = od.savenewOrders(order);
			for(OrderDetail ode : order.getListDetail()){
				int r = odd.savaOrderDetail(ode);
			}
		}catch(Exception e){
			e.printStackTrace();
			session.rollback();
		}finally{
			session.commit();
			session.close();
		}
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
	public static void main(String[] args) {
		OrderDaoImpl odi = new OrderDaoImpl();
		List<Order> list = odi.findOrder();
		for(Order o : list){
			System.out.println(o);
		}
	}

	@Override
	public List<Order> findAllOrders(Page<Order> page) {
		// TODO Auto-generated method stub
		
		List<Order> list = null;
		
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		OrderDao dao = session.getMapper(OrderDao.class);
		
		list = dao.findAllOrders(page);
		
		session.commit();
		session.close();
		
		return list;
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		Integer count = 0;
		
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		OrderDao dao = session.getMapper(OrderDao.class);
		
		count = dao.getCount();
		
		session.commit();
		session.close();
		
		return count;
	}
}
