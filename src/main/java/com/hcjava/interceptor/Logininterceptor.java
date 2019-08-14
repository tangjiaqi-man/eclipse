package com.hcjava.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
  * 登陆拦截的意义:只有登陆了才能访问内部资源,否则直接访问内部资源会强制登陆
 * 登陆拦截应该是拦截除了登陆请求外所有的请求,判断session中是否有User对象
 * 如果有则可以通过拦截,如果没有则强制登陆
 */
public class Logininterceptor implements HandlerInterceptor{
	/**
	 * 拦截请求做判断在这里编写
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object admin = session.getAttribute("admin");
		if(admin==null) {
			//如果用户信息不在session中直接重定向到登陆页面
			response.sendRedirect(request.getContextPath()+"/login/toLogin.do");
			return false;
		}//如果用户信息存在的话,则放行,可以访问内部资源
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
