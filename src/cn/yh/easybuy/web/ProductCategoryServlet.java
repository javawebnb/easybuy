package cn.yh.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yh.easybuy.dao.ProductCategoryDao;
import cn.yh.easybuy.dao.impl.ProductCategoryDaoImpl;
import cn.yh.easybuy.entity.Page;
import cn.yh.easybuy.entity.ProductCategory;

/**
 * Servlet implementation class ProductCategoryServlet
 */
public class ProductCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductCategoryDaoImpl pci = new ProductCategoryDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opr = request.getParameter("opr");
		try {
			if ("pclist".equals(opr)) {// ��ҳ�����б�
				pclist(request, response);
			}
			if ("pagelist".equals(opr)) {// ��̨�����ҳ��ʾ�����б�
				pagelist(request, response);
			}
			if ("toupdt".equals(opr)) {// ����modify�޸�ҳ��
				toupdt(request, response);
			}
			if ("updt".equals(opr)) {// �޸ķ���
				updt(request, response);
			}
			if ("del".equals(opr)) {// ɾ�����༰�����²�Ʒ
				del(request, response);
			}
			if ("tosave".equals(opr)) {// �������ҳ��
				tosave(request, response);
			}
			if ("save".equals(opr)) {// ��ӷ���
				save(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 *  ��ӷ���
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int i = 0;
		String name = request.getParameter("className");
		name = new String(name.getBytes("ISO8859-1"), "UTF-8");
		String optionId = request.getParameter("parentId");
		ProductCategory pcy = new ProductCategory();
		pcy.setName(name);
		if (Integer.valueOf(optionId) == 0) {
			pcy.setParentId(0);
			i = pci.saveProductCategory(pcy);
		} else {
			pcy.setParentId(Integer.valueOf(optionId));
			i = pci.saveProductCategory(pcy);
		}
		if (i > 0) {
			out.print("<script>alert('��ӳɹ���');location.href='/easybuy/manage/manage-result.jsp'</script>");
		}
	}

	/**
	 * �������ҳ��
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void tosave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProductCategory> biglist = pci.getAllProductCategorybig();
		HttpSession session = request.getSession();
		session.setAttribute("biglist", biglist);
		request.getRequestDispatcher("/manage/productClass-add.jsp").forward(request, response);
	}

	/**
	 * ɾ�����༰�����²�Ʒ
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int i = 0;
		String epcid = request.getParameter("epcid");
		String parentId = request.getParameter("parentId");

		if (Integer.valueOf(parentId) == 0) {
			i = pci.delProductCategory(Integer.valueOf(epcid));
		} else {
			i = pci.delProductCategory(Integer.valueOf(epcid));
		}
		if (i > 0) {
			out.print("<script>alert('ɾ���ɹ���');location.href='/easybuy/manage/manage-result.jsp'</script>");
		}
	}

	/**
	 * �޸ķ���
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void updt(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int i = 0;
		String epcid = request.getParameter("epcid");
		String name = request.getParameter("className");
		name = new String(name.getBytes("ISO8859-1"), "UTF-8");

		String parentId = request.getParameter("parentid");
		String optionId = request.getParameter("parentId");
		ProductCategory pcy = new ProductCategory();
		pcy.setId(Integer.valueOf(epcid));
		pcy.setName(name);

		if (Integer.valueOf(parentId) == 0) {
			pcy.setParentId(Integer.valueOf(parentId));
			i = pci.updateProductCategory(pcy);
		} else if (Integer.valueOf(optionId) == 0) {
			pcy.setParentId(0);
			i = pci.updateProductCategory(pcy);
		} else {
			pcy.setParentId(Integer.valueOf(optionId));
			i = pci.updateProductCategory(pcy);
		}
		if (i > 0) {
			out.print("<script>alert('�޸ĳɹ���');location.href='/easybuy/manage/manage-result.jsp'</script>");
		}
	}

	/**
	 * ����modify�޸�ҳ��
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void toupdt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String epcid = request.getParameter("epcid");
		ProductCategory pcy = pci.findProductCategoryByid(Integer.valueOf(epcid));
		List<ProductCategory> biglist = pci.getAllProductCategorybig();
		HttpSession session = request.getSession();
		session.setAttribute("biglist", biglist);
		session.setAttribute("pc", pcy);
		request.getRequestDispatcher("/manage/productClass-modify.jsp").forward(request, response);

	}

	/**
	 * ��ҳ�����б�
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void pclist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ProductCategory> listbig = pci.getAllProductCategorybig();
		List<ProductCategory> listson = pci.findProductCategoryson();
		HttpSession session = request.getSession();
		session.setAttribute("listbg", listbig);
		session.setAttribute("listsn", listson);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * ��̨�����ҳ��ʾ�����б�
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void pagelist(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		int pageIndex = 1, pageSize = 5;
		String index = request.getParameter("i");
		if (index != null) {
			pageIndex = Integer.valueOf(index);
		}
		Page<ProductCategory> page = new Page<ProductCategory>();
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		ProductCategoryDao pc = new ProductCategoryDaoImpl();
		page.setCount(pc.getCount());

		List<ProductCategory> list = pci.getProductCategoryBypage(page);
		page.setPageList(list);
		HttpSession session = request.getSession();
		session.setAttribute("pagelist", list);
		session.setAttribute("page", page);
		request.getRequestDispatcher("/manage/productClass.jsp").forward(request, response);
	}

}
