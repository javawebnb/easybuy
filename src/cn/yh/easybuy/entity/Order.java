package cn.yh.easybuy.entity;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Order {
	private Integer id;             //������
	private String userName;		//�û���
	private String userAddress;     //�ջ���ַ
	private Date createTime;		//�µ�ʱ��
	private Integer status;			//����״̬
	private Double cost;            //���
	private List<OrderDetail> listDetail = new LinkedList<OrderDetail>();//��������
	
	
	
	
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
