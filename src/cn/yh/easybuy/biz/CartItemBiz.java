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
	 * 获取购物车信息
	 */
	List<CartItem> getCartItems(Integer userId);
	
	
	/**
	 * 保存购物车信息
	 */
	Integer saveCartItems(List<CartItem> listItems,Integer userId);
}
