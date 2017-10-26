package cn.yh.easybuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.yh.easybuy.dao.AddressDao;
import cn.yh.easybuy.entity.Address;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

public class AddressDaoImpl implements AddressDao{

	@Override
	public List<Address> findAddressByUid(Integer uId) {
		// TODO Auto-generated method stub
		SqlSession session  = SqlSessionFactoryUtil.getSqlSession();
		AddressDao addressDao = session.getMapper(AddressDao.class);
		List<Address> listAddress = addressDao.findAddressByUid(uId);
		session.close();
		return listAddress;
	}

	@Override
	public Integer saveAddress(Address addr) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		Integer res = 0;
		try{
			session  = SqlSessionFactoryUtil.getSqlSession();
			AddressDao addressDao = session.getMapper(AddressDao.class);
			res = addressDao.saveAddress(addr);
		}catch(Exception e){
			session.close();
			e.printStackTrace();
		}finally{
			session.commit();
		}
		return res;
	}
}
