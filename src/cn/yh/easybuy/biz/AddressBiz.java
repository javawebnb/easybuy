package cn.yh.easybuy.biz;

import java.util.List;

import cn.yh.easybuy.entity.Address;

public interface AddressBiz {
	/**
	 * ��ӵ�ַ
	 * @param add ��ַ����
	 * @return
	 */
	Integer saveAddress(Address add);
	
	/**
	 * ��ȡ���û����е�ַ
	 * @param userId �û�id
	 */
	List<Address> findAddressByUid(Integer userId);
}
