package com.besixplus.sii.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CrossDomainControl
 */
public class CrossDomainControl implements Filter {

    /**
     * Default constructor. 
     */
    public CrossDomainControl() {
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
		System.out.println("Clase: "+request.getClass().getName());
		
		if(request instanceof HttpServletRequest){
			chain.doFilter(request, response);
			((HttpServletResponse)response).setHeader("Access-Control-Allow-Origin", "*");
			((HttpServletResponse)response).setHeader("Access-Control-Allow-Methods", "POST, GET");
			
			System.out.println("Context: "+((HttpServletRequest) request).getContextPath());
			System.out.println("Servlet: "+ ((HttpServletRequest) request).getServletPath());
			System.out.println("Query: "+ ((HttpServletRequest) request).getInputStream());
			System.out.println("Content type: "+ ((HttpServletRequest) request).getContentType());
			Enumeration<String> tmpParamNames = request.getParameterNames();
			while (tmpParamNames.hasMoreElements()) {
				String tmpParamName = (String) tmpParamNames.nextElement();
				System.out.println("param: "+tmpParamName);
			}
		}else
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
