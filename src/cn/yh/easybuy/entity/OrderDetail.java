
package cn.yh.easybuy.entity;

import java.sql.Date;

public class OrderDetail {
	
	
	private Integer d_id;			//订单编号
	private String name;			//商品名称
	private Float price;			//商品单价
	private Integer status;			//订单状态
	private Date createTime;		//下单时间
	private Integer id;             //订单号
	private Integer p_id;			//商品编号
	private Integer quantity;		//商品数量
	private float cost;				//商品总价
	
	
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the d_id
	 */
	public Integer getD_id() {
		return d_id;
	}
	/**
	 * @param d_id the d_id to set
	 */
	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the p_id
	 */
	public Integer getP_id() {
		return p_id;
	}
	/**
	 * @param p_id the p_id to set
	 */
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the cost
	 */
	public float getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(float cost) {
		this.cost = cost;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderDetail [d_id=" + d_id + ", name=" + name + ", price=" + price + ", status=" + status
				+ ", createTime=" + createTime + ", id=" + id + ", p_id=" + p_id + ", quantity=" + quantity + ", cost="
				+ cost + "]";
	}

	
	
	
}
