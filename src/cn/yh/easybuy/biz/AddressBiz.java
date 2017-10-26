package cn.yh.easybuy.biz;

import java.util.List;

import cn.yh.easybuy.entity.Address;

public interface AddressBiz {
	/**
	 * 添加地址
	 * @param add 地址对象
	 * @return
	 */
	Integer saveAddress(Address add);
	
	/**
	 * 获取该用户所有地址
	 * @param userId 用户id
	 */
	List<Address> findAddressByUid(Integer userId);
}
