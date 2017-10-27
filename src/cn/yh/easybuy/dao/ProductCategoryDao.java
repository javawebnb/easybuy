package cn.yh.easybuy.dao;

import java.util.List;

import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.ProductCategory;

public interface ProductCategoryDao {
	/**
	 * ��Ӳ�Ʒ����
	 * 
	 * @param productcategory��Ʒ����
	 * @return
	 */
	public int saveProductCategory(ProductCategory productcategory);
	/**
	 * ɾ����Ʒ�����
	 * @param id
	 * @return
	 */
	public int delProductCategorybig(Integer id);
	/**
	 * ɾ����ƷС����
	 */
	public int delProductCategoryson(Integer id);

	/**
	 * �޸Ĳ�Ʒ����
	 */
	public int updateProductCategory(ProductCategory productcategory);

	/**
	 * ͨ��ID���ҵ�����Ʒ����
	 */
	public ProductCategory findProductCategoryByid(Integer id);

	/**
	 * �����ӷ���
	 * 
	 * @return
	 */


	public List<ProductCategory> findProductCategoryson();

	/**
	 * ���ҵõ�������
	 */
	public List<ProductCategory> getAllProductCategorybig();

	/**
	 * �����ܷ������
	 * 
	 * @return
	 */
	public int getCount();

	/**
	 * ��ҳ��ѯ����
	 */
	public List<ProductCategory> getProductCategoryBypage(Page<ProductCategory> page);
}
