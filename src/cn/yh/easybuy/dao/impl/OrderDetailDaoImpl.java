
package cn.yh.easybuy.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.yh.easybuy.dao.OrderDetailDao;
import cn.yh.easybuy.entity.OrderDetail;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

public class OrderDetailDaoImpl implements OrderDetailDao {

	@Override
	public List<OrderDetail> findOrderDetail() {
		// TODO Auto-generated method stub
		Map map = null;
		
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		OrderDetailDao dao = session.getMapper(OrderDetailDao.class);
		
		List<OrderDetail> list = dao.findOrderDetail();
		
		session.commit();
		session.close();
		
		return list;
		
	}

	@Override
	public List<OrderDetail> findDetailByid(Integer id) {
		// TODO Auto-generated method stub
		List<OrderDetail> list = null;
		
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		OrderDetailDao dao = session.getMapper(OrderDetailDao.class);
		
		list = dao.findDetailByid(id);
		
		session.commit();
		session.close();
		
		return list;
	}

	@Override
	public Integer savaOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		Integer res = null;
		try{
			session = SqlSessionFactoryUtil.getSqlSession();
			OrderDetailDao dao = session.getMapper(OrderDetailDao.class);
			res = dao.savaOrderDetail(orderDetail);
		}catch(Exception e){
			session.rollback();
			throw new RuntimeException();
		}finally{
			session.commit();
			session.close();
		}
		return res;
	}

}
