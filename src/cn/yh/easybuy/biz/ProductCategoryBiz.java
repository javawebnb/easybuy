package cn.yh.easybuy.biz;

import java.util.List;

import cn.yh.easybuy.entity.ProductCategory;

public interface ProductCategoryBiz {
	/**
	 * ��Ӳ�Ʒ����
	 * @param productcategory��Ʒ����
	 * @return
	 */
	public int saveProductCategory(ProductCategory productcategory);
	/**
	 * ɾ����Ʒ����
	 */
	public int delProductCategory(Integer id);
	/**
	 * �޸Ĳ�Ʒ����
	 */
	public int updateProductCategory(ProductCategory productcategory);
	/**
	 * ͨ��ID���ҵ�����Ʒ����
	 */
	public List<ProductCategory> findProductCategoryByid(Integer id);
	/**
	 * ���ҵõ�ȫ������
	 */
	public List<ProductCategory> getAllProductCategory();
}
