package cn.yh.easybuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.yh.easybuy.dao.ProductCategoryDao;
import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.ProductCategory;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

public class ProductCategoryDaoImpl implements ProductCategoryDao {
	
	

	@Override
	public int saveProductCategory(ProductCategory productcategory) {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		ProductCategoryDao pc=session.getMapper(ProductCategoryDao.class);

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
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		ProductCategoryDao pc=session.getMapper(ProductCategoryDao.class);
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
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		ProductCategoryDao pc=session.getMapper(ProductCategoryDao.class);
		int i = pc.updateProductCategory(productcategory);
		session.commit();
		if(session != null){
			session.close();
		}
		
		return i;
	}

	@Override
	public ProductCategory findProductCategoryByid(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();

		ProductCategoryDao pd=session.getMapper(ProductCategoryDao.class);
		ProductCategory pc = pd.findProductCategoryByid(id);
		session.commit();
		if(session != null){
			session.close();
		}
		return pc;
	}

	@Override
	public List<ProductCategory> findProductCategoryson() {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		ProductCategoryDao pc=session.getMapper(ProductCategoryDao.class);
		List<ProductCategory> list= pc.findProductCategoryson();
		session.commit();
		if(session != null){

	session.close();
		}
		
		return  list;
	}

	@Override
	public List<ProductCategory> getAllProductCategorybig() {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		ProductCategoryDao pc=session.getMapper(ProductCategoryDao.class);

		List<ProductCategory> list= pc.getAllProductCategorybig();
		session.commit();
		if(session != null){
			session.close();
		}
		
		return list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		ProductCategoryDao pc=session.getMapper(ProductCategoryDao.class);
		int count=pc.getCount();
		session.commit();
		if(session != null){
			session.close();
		}
		return count;
	}

	@Override
	public List<ProductCategory> getProductCategoryBypage(Page<ProductCategory> page) {
		// TODO Auto-generated method stub
		SqlSession session = SqlSessionFactoryUtil.getSqlSession();
		ProductCategoryDao pc=session.getMapper(ProductCategoryDao.class);
		List<ProductCategory> list= pc.getProductCategoryBypage(page);
		session.commit();
		if(session != null){
			session.close();
		}
		return list;
	}

}
