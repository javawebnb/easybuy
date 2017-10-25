package cn.yh.easybuy.dao;

import java.util.List;

import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.ProductCategory;

public interface ProductCategoryDao {
	/**
	 * 添加产品分类
	 * 
	 * @param productcategory产品类名
	 * @return
	 */
	public int saveProductCategory(ProductCategory productcategory);

	/**
	 * 删除产品分类
	 */
	public int delProductCategory(Integer id);

	/**
	 * 修改产品分类
	 */
	public int updateProductCategory(ProductCategory productcategory);

	/**
	 * 通过ID查找单个产品分类
	 */
	public ProductCategory findProductCategoryByid(Integer id);

	/**
	 * 查找子分类
	 * 
	 * @return
	 */

	/**
	 * 按照父分类查询
	 */
	public List<ProductCategory> getProductCategoryByParentId(Integer parentId);

	public List<ProductCategory> findProductCategoryson();

	/**
	 * 查找得到父分类
	 */
	public List<ProductCategory> getAllProductCategorybig();

	/**
	 * 查找总分类个数
	 * 
	 * @return
	 */
	public int getCount();

	/**
	 * 分页查询分类
	 */
	public List<ProductCategory> getProductCategoryBypage(Page<ProductCategory> page);
}
