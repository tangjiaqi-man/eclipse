package com.hcjava.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
  * ��½���ص�����:ֻ�е�½�˲��ܷ����ڲ���Դ,����ֱ�ӷ����ڲ���Դ��ǿ�Ƶ�½
 * ��½����Ӧ�������س��˵�½���������е�����,�ж�session���Ƿ���User����
 * ����������ͨ������,���û����ǿ�Ƶ�½
 */
public class Logininterceptor implements HandlerInterceptor{
	/**
	 * �����������ж��������д
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object admin = session.getAttribute("admin");
		if(admin==null) {
			//����û���Ϣ����session��ֱ���ض��򵽵�½ҳ��
			response.sendRedirect(request.getContextPath()+"/login/toLogin.do");
			return false;
		}//����û���Ϣ���ڵĻ�,�����,���Է����ڲ���Դ
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
