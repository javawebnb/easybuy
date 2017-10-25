package cn.yh.easybuy.biz;

import java.util.List;

import cn.yh.easybuy.entity.Order;

public interface OrderBiz {
		//查找所有订单
		List<Order> findOrder();
	
		//通过用户id查找信息
		List<Order> findOrdersByuserId(Integer id);
	 
	    //通过用户名字查找信息
		List<Order> findOrdersByuserName(String name);

		//添加商品信息
		Integer savenewOrders(Order order);
	 
	    //更新商品信息
		Integer updateOrders(Order order);
	 
	    //清除商品信息 
		Integer delOrders(Integer id);
}
