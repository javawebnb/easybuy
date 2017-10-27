package cn.yh.easybuy.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
		HttpSession session = request.getSession();
		String ps = request.getParameter("ps");
		ProductBiz pb = new ProductBizImpl();
		if("showKind".equals(ps)){
			String index = request.getParameter("index");
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
			Product product = pb.selProductById(Integer.valueOf(id));
			session.setAttribute("product", product);
			request.getRequestDispatcher("product-view.jsp").forward(request, response);
		}else if("addProduct".equals(ps)){
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(factory);
			if(sfu.isMultipartContent(request)){//判断是否是isMultipartContent类型
				PrintWriter out = response.getWriter();
				String productName = null;
				String productDetail = null;
				String productPrice = null;
				String productNumber = null;
				String parentId = null;
				String photo = null;
				try {
					List<FileItem> items = sfu.parseRequest(request);
					
					for (FileItem item : items) {
						if(item.isFormField()){
							if("productName".equals(item.getFieldName())){
								 productName = item.getString("UTF-8");
							}
							if("productDetail".equals(item.getFieldName())){
								 productDetail = item.getString("UTF-8");
							}
							if("productPrice".equals(item.getFieldName())){
								productPrice = item.getString("UTF-8");
							}
							if("productNumber".equals(item.getFieldName())){
								productNumber = item.getString("UTF-8");
							}
							if("parentId".equals(item.getFieldName())){
								parentId = item.getString("UTF-8");
							}
						}else{
							photo = item.getName();//获得文件名
							
							String ext = photo.substring(photo.lastIndexOf(".")+1);//拿到文件名中的后缀
							
							photo = cn.yh.easybuy.utils.DateUtil.date2String(new java.util.Date(), "yyyyMMddhhmmss")+"."+ext;
							
							item.write(new File(request.getServletContext().getRealPath("/images"),photo));//把文件的内容写到指定的目录下
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Product product = new Product();
				product.setName(productName);
				product.setDescription(productDetail);
				product.setStock(Integer.valueOf(productNumber));;
				product.setPrice(Double.valueOf(productPrice));
				product.setCid(Integer.valueOf(parentId));
				product.setFileName(photo);
				Integer num = pb.saveProduct(product);
				if(num>0){
					response.sendRedirect("manage/index.jsp");
				}	
			}
		}else if("showAllProduct".equals(ps)){
			String index = request.getParameter("index");
			Integer pageIndex = 1;
			if(index != null){
				pageIndex = Integer.valueOf(index);
			}
			Integer pageSize = 5;
			Page<Product> page = pb.selAllProduct(pageIndex, pageSize);
			session.setAttribute("pages", page);
			response.sendRedirect("manage/product.jsp");	
		}else if("updateProduct".equals(ps)){
			
			String id = request.getParameter("id");
			Product product = pb.selProductById(Integer.valueOf(id));
			session.setAttribute("product",product);
			response.sendRedirect("manage/product-modify.jsp");
		}else if("updateProductTwo".equals(ps)){
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(factory);
			if(sfu.isMultipartContent(request)){//判断是否是isMultipartContent类型
				PrintWriter out = response.getWriter();
				String name = null;
				String description = null;
				String price = null;
				String stock = null;
				String parentId = null;
				String fileName = null;
				String id = request.getParameter("id");
				try {
					List<FileItem> items = sfu.parseRequest(request);
					for (FileItem item : items) {
						if(item.isFormField()){
							if("name".equals(item.getFieldName())){
								name = item.getString("UTF-8");
							}
							if("description".equals(item.getFieldName())){
								description = item.getString("UTF-8");
							}
							if("price".equals(item.getFieldName())){
								price = item.getString("UTF-8");
							}
							if("stock".equals(item.getFieldName())){
								stock = item.getString("UTF-8");
							}
							if("parentId".equals(item.getFieldName())){
								parentId = item.getString("UTF-8");
							}
						}else{
							fileName = item.getName();//获得文件名
							
							String ext = fileName.substring(fileName.lastIndexOf(".")+1);//拿到文件名中的后缀
							
							fileName = cn.yh.easybuy.utils.DateUtil.date2String(new java.util.Date(), "yyyyMMddhhmmss")+"."+ext;
							
							item.write(new File(request.getServletContext().getRealPath("/images"),fileName));//把文件的内容写到指定的目录下
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Product product = new Product();
				product.setId(Integer.valueOf(id));
				product.setName(name);
				product.setDescription(description);
				product.setStock(Integer.valueOf(stock));;
				product.setPrice(Double.valueOf(price));
				product.setCid(Integer.valueOf(parentId));
				product.setFileName(fileName);
			
			if(pb.updateProduct(product)>0){
				response.sendRedirect("manage/index.jsp");
			}
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
