package cn.yh.easybuy.biz.impl;

import java.util.List;

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
		return cartDao.getCartItems(userId);
	}

	@Override
	public Integer saveCartItems(List<CartItem> listItems) {
		// TODO Auto-generated method stub
		Integer res = 0;
		for(CartItem c : listItems){
			if(cartDao.saveCartItems(c)>0){
				res++;
			}
		}
		return res;
	}
	
}
