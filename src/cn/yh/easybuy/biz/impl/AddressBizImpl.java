package cn.yh.easybuy.biz.impl;

import java.util.List;

import cn.yh.easybuy.biz.AddressBiz;
import cn.yh.easybuy.dao.AddressDao;
import cn.yh.easybuy.dao.impl.AddressDaoImpl;
import cn.yh.easybuy.entity.Address;

public class AddressBizImpl implements AddressBiz{
	private AddressDao addr = new AddressDaoImpl();
	@Override
	public Integer saveAddress(Address add) {
		// TODO Auto-generated method stub
		return addr.saveAddress(add);
	}
	@Override
	public List<Address> findAddressByUid(Integer userId) {
		// TODO Auto-generated method stub
		return addr.findAddressByUid(userId);
	}
}
