package cn.yh.easybuy.dao;

import java.util.List;

import java.util.Map;

import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.Product;

public interface ProductDao {

	/**
	 * ��ѯָ���������Ʒ(��ҳ)
	 */
	public List<Product> selAllProductByPage(Map<String,Integer> map);

	/**
	 * ����ָ�������µļ�¼��
	 */
	public Integer getCount(Integer cid);
	
	/**
	 * ��ѯ������Ʒ����ҳ��
	 */
	public List<Product> selAllProduct(Page<Product> page);
	
	/**
	 * ����������Ʒ�ļ�¼��
	 */
	public Integer getAllCount();

	/**
	 * �����Ʒ
	 */
	public Integer saveProduct(Product product);
	
	/**
	 * ͨ��idɾ����Ʒ
	 */
	public Integer delProduct(Integer id);
	/**
	 * ͨ��cidɾ����Ʒ
	 */
	public Integer delProductByCid(Integer cid);
	
	/**
	 * ͨ��childIdɾ��
	 */
	public Integer delProductByChildId(Integer childId);
	
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
