package cn.yh.easybuy.dao;

import java.util.List;

import cn.yh.easybuy.entity.OrderDetail;

public interface OrderDetailDao {
	
	//显示所有订单详细信息
	List<OrderDetail> findOrderDetail();
	
	//通过订单编号查询订单详细信息
	List<OrderDetail> findDetailByid(Integer d_id);

}
