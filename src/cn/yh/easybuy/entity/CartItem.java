package cn.yh.easybuy.entity;

public class CartItem {
	private int id;//��Ʒid
	private String goodsName;//��Ʒ����
	private double price;//�۸�
	private int quantity;//����
	private int userId;//�û�id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsname) {
		this.goodsName = goodsname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
