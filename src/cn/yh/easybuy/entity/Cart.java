package cn.yh.easybuy.entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Cart {
	private List<CartItem> listItems = new LinkedList<CartItem>();
	private double totalPrice;
	public List<CartItem> getListItems() {
		return listItems;
	}
	public void setListItems(List<CartItem> listItems) {
		this.listItems = listItems;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void addAll(List<CartItem> list){
		listItems.addAll(list);
		getTotalPrice(listItems);
	}
	/**
	 * 添加商品到购物车
	 * @param product 商品信息
	 * @param userId 用户id
	 */
	public void addCart(Product product,Integer userId){
		boolean flag = true;
		Iterator<CartItem> it = listItems.iterator();
		//判断购物车中是否存在该商品
		while(it.hasNext()){
			CartItem ci = it.next();
			//存在商品数量加一
			if(ci.getGoodsName().equals(product.getName())){
				ci.setQuantity(ci.getQuantity()+1);
				flag = false;
			}
		}
		//不存在把该商品加入到购物车
		if(flag){
			CartItem newCartItem = new CartItem();
			newCartItem.setGoodsName(product.getName());
			newCartItem.setPrice(product.getPrice());
			newCartItem.setQuantity(1);
			if(userId!=null){
				newCartItem.setUserId(userId);
			}
			listItems.add(newCartItem);
		}
		getTotalPrice(listItems);
	}
	
	/**
	 * 删除购物车商品信息
	 * @param cartItemId 购物车项id
	 */
	public void delFromItem(String goodsName){
		for(Iterator<CartItem> it =listItems.iterator();it.hasNext();){
			CartItem ci = it.next();
			if(ci.getGoodsName().equals(goodsName)){
				it.remove();
			}
		}
		getTotalPrice(listItems);
	}
	
	/**
	 * 获得总价
	 * @param cartItems 购物车信息
	 */
	public void getTotalPrice(List<CartItem> cartItems){
		double totalTemp = 0;
		for(Iterator<CartItem> it =cartItems.iterator();it.hasNext();){
			CartItem ci = it.next();
			totalTemp = totalTemp + ci.getPrice()*ci.getQuantity();
		}
		totalPrice = totalTemp;
	}
	
	/**
	 * 改变购物车数量
	 */
	public void changeCart(CartItem ci,List<CartItem> listCart){
		for(Iterator<CartItem> it =listCart.iterator();it.hasNext();){
			CartItem c = it.next();
			if(c.getGoodsName().equals(ci.getGoodsName())){
				c.setQuantity(ci.getQuantity());
			}
		}
		getTotalPrice(listCart);
	}
}
