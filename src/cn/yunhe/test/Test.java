package cn.yunhe.test;

import cn.yh.easybuy.dao.ProductDao;
import cn.yh.easybuy.dao.impl.ProductDaoImpl;
import cn.yh.easybuy.entity.Product;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * ��ѯ����
		 */
		/*ProductDao pdi = new ProductDaoImpl();
		Page<Product> page = new Page<Product>();
		page.setPageIndex(2);
		page.setPageSize(2);
		
		List<Product> list = pdi.selAllProductByPage(page);
		for (Product product : list) {
			System.out.println(product.getName());
		}*/
		
		/**
		 * ͨ������ID��ѯ
		 */
	/*	ProductCategoryBizImpl pc = new ProductCategoryBizImpl();
		List<ProductCategory> list = pc.getProductCategoryByParentId(1);
		for (ProductCategory productCategory : list) {
			System.out.println(productCategory.getName()+"........."+productCategory.getParentId());
		}
	*/	
		
		/**
		 * ��������
		 */
		ProductDao pdi = new ProductDaoImpl();
		
		Product product = new Product();
		product.setId(7);
		product.setName("��������Ь");
		product.setDescription("��������");
		product.setPrice((float) 100);
		product.setStock(20);
		product.setCid(3);
		product.setChildId(2);
		product.setFileName("/images/product/2.jpg");
		Integer nums = pdi.saveProduct(product);
		System.out.println(nums);
	
		/**
		 * ɾ������
		 */
		/*ProductDao pdi = new ProductDaoImpl();
		
		Integer it = pdi.delProduct(1);
		System.out.println(it);*/
		
		/**
		 * �޸�����
		 */
		
		/*ProductDao pdi = new ProductDaoImpl();
		
		Product product = new Product();
		product.setName("�ɿ����뵶");
		product.setId(2);
		product.setDescription("��������");
		product.setPrice((float) 100);
		product.setStock(20);
		product.setCid(3);
		product.setChildId(2);
		product.setFileName("����");
		Integer num = pdi.updateProduct(product);
		System.out.println(num);
		*/
		
		/**
		 * ͨ��ID��ѯ
		 */
		/*ProductDao pdi = new ProductDaoImpl();
		Product product = pdi.selProductById(2);
		System.out.println(product.getName());*/
		/**
		 * ͨ��CID��ѯ
		 */
		/*ProductDao pdi = new ProductDaoImpl();
		List<Product> list = pdi.selProductByCid(3);
		for (Product product : list) {
			System.out.println(product.getName());
		}*/
		
		/**
		 * ͨ��ChildId
		 */
		/*ProductDao pdi = new ProductDaoImpl();
		List<Product> list = pdi.selProductByChildId(2);
		for (Product product : list) {
			System.out.println(product.getName());
		}*/
		
	}

}
