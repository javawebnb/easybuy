package cn.yh.easybuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.yh.easybuy.dao.ProductCategoryDao;
import cn.yh.easybuy.entity.ProductCategory;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

public class ProductCategoryDaoImpl implements ProductCategoryDao {
	
	SqlSession session = SqlSessionFactoryUtil.getSqlSession();
	ProductCategoryDao pc=session.getMapper(ProductCategoryDao.class);
	
	@Override
	public int saveProductCategory(ProductCategory productcategory) {
		// TODO Auto-generated method stub
	int i = pc.saveProductCategory(productcategory);
		session.commit();
		if(session != null){
			session.close();
		}
		
		return i;
	}

	@Override
	public int delProductCategory(Integer id) {
		// TODO Auto-generated method stub
		
		int i=pc.delProductCategory(id);
		session.commit();
		if(session != null){
			session.close();
		}
		return i;
	}

	@Override
	public int updateProductCategory(ProductCategory productcategory) {
		// TODO Auto-generated method stub
		int i = pc.updateProductCategory(productcategory);
		session.commit();
		if(session != null){
			session.close();
		}
		
		return i;
	}

	@Override
	public List<ProductCategory> findProductCategoryByid(Integer id) {
		// TODO Auto-generated method stub
		List<ProductCategory> list= pc.findProductCategoryByid(id);
		session.commit();
		if(session != null){
			session.close();
		}
		
		return  list;
	}

	@Override
	public List<ProductCategory> getAllProductCategory() {
		// TODO Auto-generated method stub
		List<ProductCategory> list= pc.getAllProductCategory();
		session.commit();
		if(session != null){
			session.close();
		}
		
		return list;
	}

}
