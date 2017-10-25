package cn.yh.easybuy.entity;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Order {
	private Integer id;             //订单号
	private String userName;		//用户名
	private String userAddress;     //收货地址
	private Date createTime;		//下单时间
	private Integer status;			//订单状态
	private Double cost;            //金额
	private List<OrderDetail> listDetail = new LinkedList<OrderDetail>();//订单详情
	
	
	
	
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public List<OrderDetail> getListDetail() {
		return listDetail;
	}
	public void setListDetail(List<OrderDetail> listDetail) {
		this.listDetail = listDetail;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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


	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userName=" + userName + ", userAddress=" + userAddress
				+ ", createTime=" + createTime + ", status=" + status + ", cost=" + cost + ", listDetail=" + listDetail
				+ "]";
	}
	
}
