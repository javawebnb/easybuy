package cn.yh.easybuy.dao;

import java.util.List;
import java.util.Map;

import cn.yh.easybuy.entity.CartItem;

/**
 * ���ﳵ��ӿ�
 * @author tigerjay
 *
 */
public interface CartItemDao {
	/**
	 * ���湺�ﳵ
	 */
	Integer saveCartItems(CartItem cartItem);
	
	/**
	 * ��ȡ���ﳵ
	 */
	List<CartItem> getCartItems(Integer userId);
	
	/**
	 * ɾ�����ﳵ��Ϣ
	 */
	Integer deleteCartItems(Integer userId);
	
}
