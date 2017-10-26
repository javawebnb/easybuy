package cn.yh.easybuy.dao;

import java.util.List;

import java.util.Map;

import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.Product;

public interface ProductDao {

	/**
	 * 查询指定分类的商品(分页)
	 */
	public List<Product> selAllProductByPage(Map<String,Integer> map);

	/**
	 * 返回指定分类下的记录数
	 */
	public Integer getCount(Integer cid);
	
	/**
	 * 查询所有商品（分页）
	 */
	public List<Product> selAllProduct(Page<Product> page);
	
	/**
	 * 返回所有商品的记录数
	 */
	public Integer getAllCount();

	/**
	 * 添加商品
	 */
	public Integer saveProduct(Product product);
	
	/**
	 * 通过id删除商品
	 */
	public Integer delProduct(Integer id);
	/**
	 * 通过cid删除商品
	 */
	public Integer delProductByCid(Integer cid);
	
	/**
	 * 通过childId删除
	 */
	public Integer delProductByChildId(Integer childId);
	
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
