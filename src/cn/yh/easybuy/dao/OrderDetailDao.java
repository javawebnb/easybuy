
package cn.yh.easybuy.dao;

import java.util.List;
import cn.yh.easybuy.entity.OrderDetail;

public interface OrderDetailDao {
	
	//��ʾ���ж�����ϸ��Ϣ
	List<OrderDetail> findOrderDetail();
	
	//ͨ������Id��ѯ������ϸ��Ϣ
	List<OrderDetail> findDetailByid(Integer id);
}
