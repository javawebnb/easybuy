package cn.yh.easybuy.biz;

import java.util.List;


import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.Product;

public interface ProductBiz {

	
	/**
	 * ��ѯ������Ʒ
	 */
	public List<Product> selAllProductByPage(Page<Product> product);

	/**
	 * �����Ʒ
	 */
	public Integer saveProduct(Product product);
	
	/**
	 * ɾ����Ʒ
	 */
	public Integer delProduct(Integer id);
	
	/**
	 * �޸���Ʒ����
	 */
	public Integer updateProduct(Product product);
	
	/**
	 *������Ʒ��Ų��� 
	 */
	public Product selProductById(Integer id);

	/**
	 * ������������ID����
	 */
	public List<Product> selProductByCid(Integer cid);
	
	/**
	 * ����������������ID����
	 */
	public List<Product> selProductByChildId(Integer childId);

}
