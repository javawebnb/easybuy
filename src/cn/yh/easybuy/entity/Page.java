package cn.yh.easybuy.entity;

import java.util.List;

public class Page<T> {
	private Integer pageIndex;//��ǰҳ��
	private Integer pageSize;//ÿҳ��С
	private Integer pageTotal;//��ҳ��
	private Integer count;//���۵��ܼ�¼��
	private List<T> pageList;//��ǰҳ������
	
	
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
	 * �õ��ܼ�¼����ͬʱ���õ���ҳ��
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
