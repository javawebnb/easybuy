package cn.yh.easybuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import cn.yh.easybuy.dao.OrderDetailDao;
import cn.yh.easybuy.entity.OrderDetail;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

/**
 * 
 * @author Administrator
 *
 */
public class OrderDetailDaoImpl implements OrderDetailDao {

	@Override
	public List<OrderDetail> findOrderDetail() {
		// TODO Auto-generated method stub
		List<OrderDetail> list = null;
		
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		OrderDetailDao dao = session.getMapper(OrderDetailDao.class);
		
		list = dao.findOrderDetail();
		
		session.commit();
		session.close();
		
		return list;
	}

	@Override
	public List<OrderDetail> findDetailByid(Integer d_id) {
		// TODO Auto-generated method stub
		List<OrderDetail> list = null;
		
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		OrderDetailDao dao = session.getMapper(OrderDetailDao.class);
		
		list = dao.findDetailByid(d_id);
		
		session.commit();
		session.close();
		
		return list;
	}

}
