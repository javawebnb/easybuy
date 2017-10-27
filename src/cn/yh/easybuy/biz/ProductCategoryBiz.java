package cn.yh.easybuy.biz;

import java.util.List;

import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.ProductCategory;

public interface ProductCategoryBiz {
	/**
	 * 添加产品分类
	 * @param productcategory产品类名
	 * @return
	 */
	public int saveProductCategory(ProductCategory productcategory);
	/**
	 * 删除产品大类
	 * @param productcategory
	 * @return
	 */
	public int delProductCategorybig(Integer id);
	/**
	 * 删除产品小类
	 */
	public int delProductCategoryson(Integer id);
	/**
	 * 修改产品分类
	 */
	public int updateProductCategory(ProductCategory productcategory);
	/**
	 * 通过ID查找单个产品分类
	 */
	public ProductCategory findProductCategoryByid(Integer id);
	/**
	 * 按照父分类查询
	 */
	public List<ProductCategory> getProductCategoryByParentId(Integer parentId);

	/**
	 * 查找子分类
	 * @return
	 */
	public List<ProductCategory> findProductCategoryson();
	/**
	 * 查找父分类
	 */
	public List<ProductCategory> getAllProductCategorybig();
	/**
	 * 分页查询分类
	 */
	public List<ProductCategory> getProductCategoryBypage(Page<ProductCategory> page);
}
