package cn.yh.easybuy.biz;

import java.util.List;

import cn.yh.easybuy.entity.CartItem;
/**
 * 
 * @author tigerJay
 *
 */
public interface CartItemBiz {
	
	/**
	 * ��ȡ���ﳵ��Ϣ
	 */
	List<CartItem> getCartItems(Integer userId);
	
	
	/**
	 * ���湺�ﳵ��Ϣ
	 */
	Integer saveCartItems(List<CartItem> listItems,Integer userId);
}
