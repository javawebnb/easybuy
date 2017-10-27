package cn.yh.easybuy.dao;

import java.util.List;

import cn.yh.easybuy.entity.Order;

import cn.yh.easybuy.entity.Page;
public interface OrderDao {

	//查找所有订单
	List<Order> findOrder();
	
	//通过用户id查找信息
	List<Order> findOrdersByuserId(Integer id);
 
    //通过用户名字查找信息
	List<Order> findOrdersByuserName(String name);

	//添加订单信息
	Integer savenewOrders(Order order);
 
    //更新订单信息
	Integer updateOrders(Order order);
 
    //清除订单信息 
	Integer delOrders(Integer id);
	
	//分页查询订单信息
	List<Order> findAllOrders(Page<Order> page);
	//获得订单的总记录数
	Integer getCount();
}
