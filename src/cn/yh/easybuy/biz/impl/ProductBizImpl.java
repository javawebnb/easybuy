package cn.yh.easybuy.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.yh.easybuy.biz.ProductBiz;
import cn.yh.easybuy.dao.ProductDao;
import cn.yh.easybuy.dao.impl.ProductDaoImpl;
import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.Product;

public class ProductBizImpl implements ProductBiz {

	ProductDao productDao = new ProductDaoImpl();
	@Override
	public Page<Product> selAllProductByPage(Integer pageIndex,Integer pageSize,Integer cid) {
		// TODO Auto-generated method stub
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		Integer it = productDao.getCount(cid);
		map.put("cid", cid);
		map.put("pageIndex",pageIndex );
		map.put("pageSize", pageSize);
		List<Product> list = productDao.selAllProductByPage(map);
		Page<Product> page = new Page<Product>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setCount(it);
		page.setPageList(list);
		return page;

	}

	@Override
	public Page<Product> selAllProduct(Integer pageIndex,Integer pageSize) {
		
		// TODO Auto-generated method stub
		Integer it = productDao.getAllCount();
		Page<Product> page = new Page<Product>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setCount(it);
		List<Product> list = productDao.selAllProduct(page);
		page.setPageList(list);
		return page;
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
