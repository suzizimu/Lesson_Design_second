package com.su_back.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class sessionFilter
 */
//@WebFilter("*.do")
public class sessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public sessionFilter() {
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
		 HttpServletRequest req=(HttpServletRequest) request; 
	     HttpServletResponse resp=(HttpServletResponse) response;
	        
	     String admin_name=(String) req.getSession().getAttribute("admin_name");
	     String password=(String) req.getSession().getAttribute("password");
	        	
	     String path=req.getContextPath();//得到的是项目发布路径 例如：/cy29
	     String url=req.getRequestURI();//得到的是访问路径   例如 ： /cy29/login.jsp
	     System.out.println(path+"+=====+"+url);
	     
	     if((admin_name!=null)&&(password!=null)||url.endsWith("login.jsp")||url.endsWith("login.do")){
	        	
	        	
	        chain.doFilter(request, response); //继续执行 否则不可执行跳转的路径
	        	
	     }else{
	    	
	        resp.sendRedirect("Back/login.jsp");
	     }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
