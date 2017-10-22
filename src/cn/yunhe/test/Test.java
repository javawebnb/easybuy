package cn.yunhe.test;

import java.util.List;

import cn.yh.easybuy.dao.ProductDao;
import cn.yh.easybuy.dao.impl.ProductDaoImpl;
import cn.yh.easybuy.entity.Product;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 查询所有
		 */
		/*ProductDao pdi = new ProductDaoImpl();
		List<Product> list = pdi.selAllProduct();
		for (Product product : list) {
			System.out.println(product.getName());
		}*/
		
		/**
		 * 插入数据
		 */
		/*ProductDao pdi = new ProductDaoImpl();
		
		Product product = new Product();
		product.setId(2);
		product.setName("李宁篮球鞋");
		product.setDescription("质量还行");
		product.setPrice((float) 100);
		product.setStock(20);
		product.setCid(3);
		product.setChildId(2);
		product.setFileName("李宁");
		Integer nums = pdi.saveProduct(product);
		System.out.println(nums);*/
	
		/**
		 * 删除数据
		 */
		/*ProductDao pdi = new ProductDaoImpl();
		
		Integer it = pdi.delProduct(1);
		System.out.println(it);*/
		
		/**
		 * 修改数据
		 */
		
		/*ProductDao pdi = new ProductDaoImpl();
		
		Product product = new Product();
		product.setName("飞科剃须刀");
		product.setId(2);
		product.setDescription("质量还行");
		product.setPrice((float) 100);
		product.setStock(20);
		product.setCid(3);
		product.setChildId(2);
		product.setFileName("李宁");
		Integer num = pdi.updateProduct(product);
		System.out.println(num);
		*/
		
		/**
		 * 通过ID查询
		 */
		/*ProductDao pdi = new ProductDaoImpl();
		Product product = pdi.selProductById(2);
		System.out.println(product.getName());*/
		/**
		 * 通过CID查询
		 */
		/*ProductDao pdi = new ProductDaoImpl();
		List<Product> list = pdi.selProductByCid(3);
		for (Product product : list) {
			System.out.println(product.getName());
		}*/
		
		/**
		 * 通过ChildId
		 */
		ProductDao pdi = new ProductDaoImpl();
		List<Product> list = pdi.selProductByChildId(2);
		for (Product product : list) {
			System.out.println(product.getName());
		}
		
	}

}
