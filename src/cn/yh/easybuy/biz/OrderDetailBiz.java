package cn.yh.easybuy.biz;

import java.util.List;

import cn.yh.easybuy.entity.OrderDetail;

public interface OrderDetailBiz {
	//��ʾ���ж�����ϸ��Ϣ
	List<OrderDetail> findOrderDetail();
	
	//ͨ��������Ų�ѯ������ϸ��Ϣ
	List<OrderDetail> findDetailByid(Integer d_id);

}
