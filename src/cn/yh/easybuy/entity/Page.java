package cn.yh.easybuy.entity;

import java.util.List;

public class Page<T> {
	private Integer pageIndex;//当前页码
	private Integer pageSize;//每页大小
	private Integer pageTotal;//总页数
	private Integer count;//评论的总记录数
	private List<T> pageList;//当前页面结果集
	
	
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	
	public Integer getCount() {
		return count;
	}
	/**
	 * 得到总记录数的同时，得到中页数
	 * @return
	 */
	public void setCount(Integer count) {
		this.count = count;
		if(this.pageSize != 0){
			this.setPageTotal(count % pageSize == 0 ? (count / pageSize) : (count / pageSize) + 1);
		}
	}
	
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	
	
}
