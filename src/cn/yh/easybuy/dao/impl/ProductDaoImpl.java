package cn.yh.easybuy.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import cn.yh.easybuy.dao.ProductDao;
import cn.yh.easybuy.entity.Product;
import cn.yh.easybuy.utils.SqlSessionFactoryUtil;

public class ProductDaoImpl implements ProductDao {

	
	SqlSession session = null;
	List<Product> list = null;
	Integer num = 0;

	@Override
	public List<Product> selAllProduct() {
		// TODO Auto-generated method stub
		
		
		session = SqlSessionFactoryUtil.getSqlSession();
		ProductDao productDao = session.getMapper(ProductDao.class);
		list = productDao.selAllProduct();
		if(session!=null){
			session.close();
		}
		return list;
	}

	@Override
	public Integer saveProduct(Product product) {
		// TODO Auto-generated method stub
		
		session = SqlSessionFactoryUtil.getSqlSession();
		ProductDao productDao = session.getMapper(ProductDao.class);
		num = productDao.saveProduct(product);
		session.commit();
		if(session!=null){
			session.close();
		}
		return num;
	}

	@Override
	public Integer delProduct(Integer id) {
		// TODO Auto-generated method stub
		
		session = SqlSessionFactoryUtil.getSqlSession();
		ProductDao productDao = session.getMapper(ProductDao.class);
		 num = productDao.delProduct(id);
		session.commit();
		if(session!=null){
			session.close();
		}
		
		return num;
	}

	@Override
	public Integer updateProduct(Product product) {
		// TODO Auto-generated method stub
		
		session = SqlSessionFactoryUtil.getSqlSession();
		ProductDao productDao = session.getMapper(ProductDao.class);
		num = productDao.updateProduct(product);
		session.commit();
		if(session!=null){
			session.close();
		}
		return num;
	}

	@Override
	public Product selProductById(Integer id) {
		// TODO Auto-generated method stub
		session = SqlSessionFactoryUtil.getSqlSession();
		ProductDao productDao = session.getMapper(ProductDao.class);
		Product product = productDao.selProductById(id);
		if(session!=null){
			session.close();
		}
		
		return product;
	}

	@Override
	public List<Product> selProductByCid(Integer cid) {
		// TODO Auto-generated method stub
		session = SqlSessionFactoryUtil.getSqlSession();
		ProductDao productDao = session.getMapper(ProductDao.class);
		list = productDao.selProductByCid(cid);
		if(session!=null){
			session.close();
		}
				
		return list;
	}

	@Override
	public List<Product> selProductByChildId(Integer childId) {
		// TODO Auto-generated method stub
		session = SqlSessionFactoryUtil.getSqlSession();
		ProductDao productDao = session.getMapper(ProductDao.class);
		list = productDao.selProductByChildId(childId);
		if(session!=null){
			session.close();
		}
				
		return list;
	}

}
