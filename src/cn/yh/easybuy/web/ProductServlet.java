package cn.yh.easybuy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yh.easybuy.biz.ProductBiz;
import cn.yh.easybuy.biz.impl.ProductBizImpl;
import cn.yh.easybuy.dao.impl.ProductCategoryDaoImpl;
import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.Product;
import cn.yh.easybuy.entity.ProductCategory;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductCategoryDaoImpl pci = new ProductCategoryDaoImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String ps = request.getParameter("ps");
		ProductBiz pb = new ProductBizImpl();
		if("showKind".equals(ps)){
			String index = request.getParameter("index");
			/*ProductBiz pb = new ProductBizImpl();*/
			Integer pageIndex = 1;
			if(index != null){
				pageIndex = Integer.valueOf(index);
			}
			Integer pageSize = 8;
			Page<Product> page = pb.selAllProduct(pageIndex, pageSize);
			session.setAttribute("page", page);
			response.sendRedirect("index.jsp");
		}else if("showProduct".equals(ps)){
			
			Integer cid = Integer.valueOf(request.getParameter("cid"));
			String index = request.getParameter("index");
		/*	ProductBiz pb = new ProductBizImpl();*/
			Integer pageIndex = 1;
			if(index != null){
				pageIndex = Integer.valueOf(index);
			}
			Integer pageSize = 8;
			Page<Product> page = pb.selAllProductByPage(pageIndex, pageSize, cid);
			session.setAttribute("page", page);
			session.setAttribute("cids", cid);
			response.sendRedirect("product-list.jsp");
			
		}else if("detail".equals(ps)){
			String id = request.getParameter("id");
			/*ProductBiz pb = new ProductBizImpl();*/
			Product product = pb.selProductById(Integer.valueOf(id));
			session.setAttribute("product", product);
			request.getRequestDispatcher("product-view.jsp").forward(request, response);
		}else if("addProduct".equals(ps)){
			String productName = request.getParameter("productName");
			String productDetail = request.getParameter("productDetail");
			String productPrice = request.getParameter("productPrice");
			String productNumber = request.getParameter("productNumber");
			String cid = request.getParameter("parentId");
			String photo = request.getParameter("photo");
			
			Product product = new Product();
			product.setName(productName);
			product.setDescription(productDetail);
			product.setStock(Integer.valueOf(productNumber));;
			product.setPrice(Float.valueOf(productPrice));
			product.setCid(Integer.valueOf(cid));
			product.setFileName(photo);
			Integer num = pb.saveProduct(product);
			if(num>0){
				response.sendRedirect("manage/index.jsp");
			}	
		}else if("showAllProduct".equals(ps)){
			String index = request.getParameter("index");
			Integer pageIndex = 1;
			if(index != null){
				pageIndex = Integer.valueOf(index);
			}
			Integer pageSize = 8;
			Page<Product> page = pb.selAllProduct(pageIndex, pageSize);
			session.setAttribute("pages", page);
			response.sendRedirect("manage/product.jsp");	
		}else if("updateProduct".equals(ps)){
			
			String id = request.getParameter("id");
			//String cid = request.getParameter("cid");
			Product product = pb.selProductById(Integer.valueOf(id));
			//ProductCategory pct = pci.findProductCategoryByid(Integer.valueOf(cid));
			session.setAttribute("product",product);
			//session.setAttribute("pct", pct);
			response.sendRedirect("manage/product-modify.jsp");
		}else if("updateProductTwo".equals(ps)){
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String cid = request.getParameter("parentId");
			String price = request.getParameter("price");
			String stock = request.getParameter("stock");
			String fileName = request.getParameter("photo");
			
			Product product = new Product();
			product.setId(Integer.valueOf(id));
			product.setName(name);
			product.setDescription(description);
			product.setCid(Integer.valueOf(cid));
			product.setPrice(Float.valueOf(price));
			product.setStock(Integer.valueOf(stock));
			product.setFileName(fileName);
			
			if(pb.updateProduct(product)>0){
				response.sendRedirect("manage/index.jsp");
			}
		}else if("delProduct".equals(ps)){
			
			String id = request.getParameter("id");
			if(pb.delProduct(Integer.valueOf(id))>0){
				response.sendRedirect("manage/index.jsp");
			}
		}else if("getSort".equals(ps)){
			List<ProductCategory> listbig = pci.getAllProductCategorybig();
			List<ProductCategory> listson = pci.findProductCategoryson();
			session.setAttribute("listbg", listbig);
			session.setAttribute("listsn", listson);
			response.sendRedirect("/easybuy/manage/product-add.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
