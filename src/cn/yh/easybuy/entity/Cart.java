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
	 * �����Ʒ�����ﳵ
	 * @param product ��Ʒ��Ϣ
	 * @param userId �û�id
	 */
	public void addCart(Product product,Integer userId){
		boolean flag = true;
		Iterator<CartItem> it = listItems.iterator();
		//�жϹ��ﳵ���Ƿ���ڸ���Ʒ
		while(it.hasNext()){
			CartItem ci = it.next();
			//������Ʒ������һ
			if(ci.getGoodsName().equals(product.getName())){
				ci.setQuantity(ci.getQuantity()+1);
				flag = false;
			}
		}
		//�����ڰѸ���Ʒ���뵽���ﳵ
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
	 * ɾ�����ﳵ��Ʒ��Ϣ
	 * @param cartItemId ���ﳵ��id
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
	 * ����ܼ�
	 * @param cartItems ���ﳵ��Ϣ
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
	 * �ı乺�ﳵ����
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
