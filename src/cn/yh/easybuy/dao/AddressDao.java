package cn.yh.easybuy.dao;

import java.util.List;

import cn.yh.easybuy.entity.Address;
/**
 * 
 * @author tigerJay
 *
 */
public interface AddressDao {
	/**
	 * 通过用户id查找地址
	 * @param uId 用户id
	 * @return 返回查询到的地址集合
	 */
	List<Address> findAddressByUid(Integer uId);
	
	/**
	 * 保存地址
	 * @param addr 要保存的地址对象
	 * @return 返回插入的行数
	 */
	Integer saveAddress(Address addr);
}
