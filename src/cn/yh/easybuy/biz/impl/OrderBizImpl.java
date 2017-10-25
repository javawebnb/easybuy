package cn.yh.easybuy.biz.impl;

import java.util.List;

import cn.yh.easybuy.biz.OrderBiz;
import cn.yh.easybuy.dao.OrderDao;
import cn.yh.easybuy.dao.impl.OrderDaoImpl;
import cn.yh.easybuy.entity.Order;


public class OrderBizImpl implements OrderBiz{
	OrderDao od=new OrderDaoImpl();
	@Override
	public List<Order> findOrdersByuserId(Integer id) {
		// TODO Auto-generated method stub
		
		return od.findOrdersByuserId(id);
	}

	@Override
	public List<Order> findOrdersByuserName(Integer name) {
		// TODO Auto-generated method stub
		return od.findOrdersByuserName(name);
	}

	@Override
	public Integer savenewOrders(Order order) {
		// TODO Auto-generated method stub
		return od.savenewOrders(order);
	}

	@Override
	public Integer updateOrders(Order order) {
		// TODO Auto-generated method stub
		return od.updateOrders(order);
	}

	@Override
	public Integer delOrders(Integer id) {
		// TODO Auto-generated method stub
		return od.delOrders(id);
	}

}
