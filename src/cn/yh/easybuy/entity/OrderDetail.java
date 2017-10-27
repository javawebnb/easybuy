
package cn.yh.easybuy.entity;


public class OrderDetail {
	
	
	private Integer d_id;			//订单编号
	private Integer id;             //订单号
	private Integer p_id;			//商品编号
	private Integer quantity;		//商品数量
	private Double cost;            //价格
	private Product product = new Product();        //商品
	
	
	@Override
	public String toString() {
		return "OrderDetail [d_id=" + d_id + ", id=" + id + ", p_id=" + p_id + ", quantity=" + quantity + ", cost="
				+ cost + ", product=" + product + ", price=" + price + "]";
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	private Double price;//商品金额
	public Integer getD_id() {
		return d_id;
	}
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
