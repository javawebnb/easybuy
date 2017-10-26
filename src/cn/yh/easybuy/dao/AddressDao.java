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
	 * ͨ���û�id���ҵ�ַ
	 * @param uId �û�id
	 * @return ���ز�ѯ���ĵ�ַ����
	 */
	List<Address> findAddressByUid(Integer uId);
	
	/**
	 * �����ַ
	 * @param addr Ҫ����ĵ�ַ����
	 * @return ���ز��������
	 */
	Integer saveAddress(Address addr);
}
