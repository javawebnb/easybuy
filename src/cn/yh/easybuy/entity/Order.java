package cn.yh.easybuy.entity;

import java.sql.Date;

public class Order {
	private Integer id;             //订单号
	private Integer d_id;			//编号
	private String userId;			//用户ID
	private String userName;		//用户名
	private String userAddress;     //收货地址
	private Date createTime;		//下单时间
	private Integer status;			//订单状态

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Date getCreateTime() {
		return createTime;
	}
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


	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", d_id=" + d_id + ", userId=" + userId + ", userName=" + userName + ", userAddress="
				+ userAddress + ", createTime=" + createTime + ", status=" + status + "]";
	}

	
	
	
	
	
}
