package cn.yh.easybuy.biz.impl;

import java.util.List;

import cn.yh.easybuy.biz.ProductCategoryBiz;
import cn.yh.easybuy.dao.ProductCategoryDao;
import cn.yh.easybuy.dao.impl.ProductCategoryDaoImpl;
import cn.yh.easybuy.entity.ProductCategory;

public class ProductCategoryBizImpl implements ProductCategoryBiz {
	ProductCategoryDao pc = new ProductCategoryDaoImpl();
	@Override
	public int saveProductCategory(ProductCategory productcategory) {
		// TODO Auto-generated method stub
		return pc.saveProductCategory(productcategory);
	}

	@Override
	public int delProductCategory(Integer id) {
		// TODO Auto-generated method stub
		return pc.delProductCategory(id);
	}

	@Override
	public int updateProductCategory(ProductCategory productcategory) {
		// TODO Auto-generated method stub
		return pc.updateProductCategory(productcategory);
	}

	@Override
	public List<ProductCategory> findProductCategoryByid(Integer id) {
		// TODO Auto-generated method stub
		return pc.findProductCategoryByid(id);
	}

	@Override
	public List<ProductCategory> getAllProductCategory() {
		// TODO Auto-generated method stub
		return pc.getAllProductCategory();
	}

	@Override
	public List<ProductCategory> getProductCategoryByParentId(Integer parentId) {
		// TODO Auto-generated method stub
		return pc.getProductCategoryByParentId(parentId);
	}

}
