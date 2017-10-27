package cn.yh.easybuy.dao;

import java.util.List;

import cn.yh.easybuy.entity.Order;

import cn.yh.easybuy.entity.Page;
public interface OrderDao {

	//�������ж���
	List<Order> findOrder();
	
	//ͨ���û�id������Ϣ
	List<Order> findOrdersByuserId(Integer id);
 
    //ͨ���û����ֲ�����Ϣ
	List<Order> findOrdersByuserName(String name);

	//��Ӷ�����Ϣ
	Integer savenewOrders(Order order);
 
    //���¶�����Ϣ
	Integer updateOrders(Order order);
 
    //���������Ϣ 
	Integer delOrders(Integer id);
	
	//��ҳ��ѯ������Ϣ
	List<Order> findAllOrders(Page<Order> page);
	//��ö������ܼ�¼��
	Integer getCount();
}
