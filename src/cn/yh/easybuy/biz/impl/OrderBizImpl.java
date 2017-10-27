package cn.yh.easybuy.biz.impl;

import java.util.List;

import cn.yh.easybuy.biz.OrderBiz;
import cn.yh.easybuy.dao.OrderDao;
import cn.yh.easybuy.dao.impl.OrderDaoImpl;
import cn.yh.easybuy.entity.Order;

import cn.yh.easybuy.entity.Page;

public class OrderBizImpl implements OrderBiz{
	OrderDao od=new OrderDaoImpl();
	@Override
	public List<Order> findOrdersByuserId(Integer id) {
		// TODO Auto-generated method stub
		
		return od.findOrdersByuserId(id);
	}

	@Override
	public List<Order> findOrdersByuserName(String name) {
		// TODO Auto-generated method stub
		return od.findOrdersByuserName(name);
	}

	@Override
	public Integer savenewOrders(Order order) {
		//插入订单以及订单详情
		//订单详情包括订单id 商品id 数量 金额 在此处理
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

	@Override
	public List<Order> findOrder() {
		// TODO Auto-generated method stub
		return od.findOrder();
	}

	@Override
	public Page<Order> findAllOrders(Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		Page<Order> page = new Page<Order>();
		Integer count = od.getCount();
		
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setCount(count);
		
		List<Order> list = od.findAllOrders(page);
		page.setPageList(list);
		
		return page;
	}
	
	
	
	

}
