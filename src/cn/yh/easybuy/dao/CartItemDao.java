package cn.yh.easybuy.dao;

import java.util.List;
import java.util.Map;

import cn.yh.easybuy.entity.CartItem;

/**
 * 购物车项接口
 * @author tigerjay
 *
 */
public interface CartItemDao {
	/**
	 * 保存购物车
	 */
	Integer saveCartItems(CartItem cartItem);
	
	/**
	 * 获取购物车
	 */
	List<CartItem> getCartItems(Integer userId);
	
	/**
	 * 删除购物车信息
	 */
	Integer deleteCartItems(Integer userId);
	
}
