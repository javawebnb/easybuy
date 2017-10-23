package cn.yh.easybuy.biz;

import java.util.List;

import cn.yh.easybuy.entity.ProductCategory;

public interface ProductCategoryBiz {
	/**
	 * 添加产品分类
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
	public List<ProductCategory> findProductCategoryByid(Integer id);
	/**
	 * 查找得到全部分类
	 */
	public List<ProductCategory> getAllProductCategory();
}
