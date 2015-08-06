package com.koumi.framework.product.rcs.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SpringUtils {

	public static ServletContext getServletContext(){
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext(); 
        return webApplicationContext.getServletContext();  
	}
	
	public static HttpSession getHttpSession(){
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession(); 
	}
	
	public static String getServletContextPath(){
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getContextPath();
	}
}
