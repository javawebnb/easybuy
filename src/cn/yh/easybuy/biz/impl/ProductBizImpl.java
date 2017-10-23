package cn.yh.easybuy.biz.impl;

import java.util.List;

import cn.yh.easybuy.biz.ProductBiz;
import cn.yh.easybuy.dao.ProductDao;
import cn.yh.easybuy.dao.impl.ProductDaoImpl;
import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.Product;

public class ProductBizImpl implements ProductBiz {

	ProductDao productDao = new ProductDaoImpl();
	@Override
	public List<Product> selAllProductByPage(Page<Product> product) {
		// TODO Auto-generated method stub
		return productDao.selAllProductByPage(product);
	}

	@Override
	public Integer saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.saveProduct(product);
	}

	@Override
	public Integer delProduct(Integer id) {
		// TODO Auto-generated method stub
		
		return productDao.delProduct(id);
	}

	@Override
	public Integer updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public Product selProductById(Integer id) {
		// TODO Auto-generated method stub
		return productDao.selProductById(id);
	}

	@Override
	public List<Product> selProductByCid(Integer cid) {
		// TODO Auto-generated method stub
		return productDao.selProductByCid(cid);
	}

	@Override
	public List<Product> selProductByChildId(Integer childId) {
		// TODO Auto-generated method stub
		return productDao.selProductByChildId(childId);
	}

}
