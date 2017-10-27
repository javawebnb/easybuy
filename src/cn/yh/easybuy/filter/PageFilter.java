package cn.yh.easybuy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yh.easybuy.entity.User;

/**
 * Servlet Filter implementation class PageFilter
 */
public class PageFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PageFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		String uri = req.getRequestURI();//�õ����Ǵ���Ŀ��������·��
		String contextPath = req.getContextPath();//�õ���Ŀ��
		uri = uri.substring(contextPath.length());
		User user = (User)session.getAttribute("login");
		if(user == null){
				res.sendRedirect("/easybuy/login.jsp");
				return;
		}else if(uri.indexOf("shopping")==-1 || uri.indexOf("product-view")==-1){
			res.sendRedirect("/easybuy/login.jsp");
			return;
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
