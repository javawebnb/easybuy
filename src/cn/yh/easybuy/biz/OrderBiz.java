package cn.yh.easybuy.biz;

import java.util.List;

import cn.yh.easybuy.entity.Order;

public interface OrderBiz {
		//ͨ���û�id������Ϣ
		List<Order> findOrdersByuserId(Integer id);
	 
	    //ͨ���û����ֲ�����Ϣ
		List<Order> findOrdersByuserName(Integer name);

		//�����Ʒ��Ϣ
		Integer savenewOrders(Order order);
	 
	    //������Ʒ��Ϣ
		Integer updateOrders(Order order);
	 
	    //�����Ʒ��Ϣ 
		Integer delOrders(Integer id);
}
