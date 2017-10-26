package cn.yh.easybuy.biz;

import java.util.List;

import cn.yh.easybuy.entity.Page;
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
	public ProductCategory findProductCategoryByid(Integer id);
	/**
	 * ���ո������ѯ
	 */
	public List<ProductCategory> getProductCategoryByParentId(Integer parentId);

	

	public List<ProductCategory> findProductCategoryson();
	/**
	 * ���Ҹ�����
	 */
	public List<ProductCategory> getAllProductCategorybig();
	/**
	 * ��ҳ��ѯ����
	 */
	public List<ProductCategory> getProductCategoryBypage(Page<ProductCategory> page);
}
