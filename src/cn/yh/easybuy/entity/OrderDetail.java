package cn.yh.easybuy.entity;

public class OrderDetail {
	
	private Integer d_id;		//编号
	private Integer id;			//订单号
	private Integer p_id;		//商品编号
	private Integer quantity;	//商品数量
	private float cost;			//商品金额
	
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderDetail [d_id=" + d_id + ", id=" + id + ", p_id=" + p_id + ", quantity=" + quantity + ", cost="
				+ cost + "]";
	}
	
	

}
