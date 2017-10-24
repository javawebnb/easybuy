package cn.yh.easybuy.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import cn.yh.easybuy.dao.CartItemDao;
import cn.yh.easybuy.entity.CartItem;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

/**
 * @author tigerJay
 *
 */
public class CartItemDaoImpl implements CartItemDao{

	@Override
	public Integer saveCartItems(CartItem cartItem) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		Integer res = 0;
		try{
			session = SqlSessionFactoryUtil.getSqlSession();
			CartItemDao cartItemDao = session.getMapper(CartItemDao.class);
			res = cartItemDao.saveCartItems(cartItem);
		}catch(Exception e){
			session.rollback();
			e.printStackTrace();
		}finally{
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public List<CartItem> getCartItems(Integer userId) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		List<CartItem> listItems = new LinkedList<CartItem>();
		try{
			session = SqlSessionFactoryUtil.getSqlSession();
			CartItemDao cartItemDao = session.getMapper(CartItemDao.class);
			listItems = cartItemDao.getCartItems(userId);
		}catch(Exception e){
			session.rollback();
			e.printStackTrace();
		}finally{
			session.commit();
			session.close();
		}
		return listItems;
	}
}
