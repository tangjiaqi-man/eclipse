package com.hcjava.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcjava.cotorller.Admin;
import com.hcjava.exception.NameException;
import com.hcjava.exception.PasswordException;
import com.hcjava.service.AdminSecvice;

@Controller
@RequestMapping("/login")
public class AdminController {
	@ExceptionHandler
	public String handerExceprion(HttpServletRequest req,HttpServletResponse resp,Exception e) throws Exception {
		if(e instanceof NameException||e instanceof PasswordException) {
			//ҵ���߼��Լ�����
			req.setAttribute("message", e.getMessage());
			req.setAttribute("name", req.getParameter("name"));
			req.setAttribute("password", req.getParameter("password"));
			return "main/login";
		}else {
			//ϵͳ�׳��쳣,����spring��������
			throw e;
		}
	}
	@Resource
	private AdminSecvice adminSecvice;
	//ͨ������������ת��½����½ҳ��
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		return "main/login";
	}//ͨ������������
	@RequestMapping("toIndex.do")
	public String toIndex() {
		return "main/index";
	}
	//��½���
	@RequestMapping("/checkLogin.do")
	
	public String checkLogin(String name,String password,ModelMap model,HttpSession session) {
		System.out.println(name);
		System.out.println(session);
		//����Springϵͳ�쳣����
		//String a=null;
		//a.charAt(0);
		Admin admin = adminSecvice.checkNamePwd(name, password);
		session.setAttribute("admin", admin);
		/*try {
		Admin admin = adminSecvice.checkNamePwd(name, password);
		session.setAttribute("admin", admin);
		//���ǳ����쳣
		} catch (NameException e) {
		//��ȡ�׳����쳣����message������ת��AdminServiceImpl����
		model.addAttribute("message", e.getMessage());
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		return "main/login";
		}catch (PasswordException e) {
			model.addAttribute("message", e.getMessage());
			model.addAttribute("name", name);
			model.addAttribute("password", password);
			return "main/login";
		}*/
		//�ɹ���½
		return "redirect:../cost/list.333";
	}
	
}
