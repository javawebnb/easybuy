package cn.yh.easybuy.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncodeFilter
 */
public class EncodeFilter implements Filter {
	private String encode=null;
    /**
     * Default constructor. 
     */
    public EncodeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		encode=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
//		if(null==request.getCharacterEncoding()){
//			request.setCharacterEncoding(encode);
//			response.setCharacterEncoding(encode);
//		}
//		// pass the request along the filter chain
//		chain.doFilter(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletRequest proxy = (HttpServletRequest)Proxy.newProxyInstance(
				req.getClass().getClassLoader(), 
				new Class[]{HttpServletRequest.class}, 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						//获取方法名
						String methodName = method.getName();
						//设置返回值
						Object obj = null;
						if("getParameter".equals(methodName)){
							//获取请求方式
							String reqMethod = req.getMethod();
							//获取请求值
							String value = req.getParameter((String)args[0]);
							//对不同请求方式做处理
							if("Get".equals(reqMethod)){
								value = new String(value.getBytes("ISO8859-1"),"UTF-8");
							}
							return value;
						}else{
							obj = method.invoke(req, args);
						}
						return obj;
					}
				});
		chain.doFilter(proxy, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
//		String encode =fConfig.getInitParameter("EncodeFilter");
//		if(this.encode==null){
//			this.encode=encode;
//		}
	}

}
