package cn.yh.easybuy.biz.impl;

import java.util.List;
import java.util.Map;

import cn.yh.easybuy.biz.OrderDetailBiz;
import cn.yh.easybuy.dao.OrderDetailDao;
import cn.yh.easybuy.dao.impl.OrderDetailDaoImpl;
import cn.yh.easybuy.entity.OrderDetail;

public class OrderDetailBizImpl implements OrderDetailBiz {
	
	OrderDetailDao dao = new OrderDetailDaoImpl();
	@Override
	public List<OrderDetail> findOrderDetail() {
		// TODO Auto-generated method stub
		return dao.findOrderDetail();
	}

	@Override
	public List<OrderDetail> findDetailByid(Integer id) {
		// TODO Auto-generated method stub
		return dao.findDetailByid(id);
	}

}
