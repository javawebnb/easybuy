package cn.yh.easybuy.biz;

import java.util.List;


import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.Product;

public interface ProductBiz {

	
	/**
	 * 查询所有商品
	 */
	public List<Product> selAllProductByPage(Page<Product> product);

	/**
	 * 添加商品
	 */
	public Integer saveProduct(Product product);
	
	/**
	 * 删除商品
	 */
	public Integer delProduct(Integer id);
	
	/**
	 * 修改商品属性
	 */
	public Integer updateProduct(Product product);
	
	/**
	 *按照商品编号查找 
	 */
	public Product selProductById(Integer id);

	/**
	 * 按照所属分类ID查找
	 */
	public List<Product> selProductByCid(Integer cid);
	
	/**
	 * 按照所属二级分类ID查找
	 */
	public List<Product> selProductByChildId(Integer childId);

}
