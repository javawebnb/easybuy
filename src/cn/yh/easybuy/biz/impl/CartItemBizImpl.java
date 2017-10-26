package cn.yh.easybuy.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.yh.easybuy.biz.CartItemBiz;
import cn.yh.easybuy.dao.CartItemDao;
import cn.yh.easybuy.dao.impl.CartItemDaoImpl;
import cn.yh.easybuy.entity.CartItem;

/**
 * 
 * @author tigerJay
 *
 */
public class CartItemBizImpl implements CartItemBiz{
	private CartItemDao cartDao = new CartItemDaoImpl();
	@Override
	public List<CartItem> getCartItems(Integer userId) {
		// TODO Auto-generated method stub
		List<CartItem> listItems = cartDao.getCartItems(userId);
		cartDao.deleteCartItems(userId);
		return listItems;
	}

	@Override
	public Integer saveCartItems(List<CartItem> listItems,Integer userId) {
		// TODO Auto-generated method stub
		Integer res = 0;
		for(CartItem c : listItems){
			c.setUserId(userId);
			if(cartDao.saveCartItems(c)>0){
				res++;
			}
		}
		return res;
	}
	
}
