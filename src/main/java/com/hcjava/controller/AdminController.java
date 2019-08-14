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
			//业务逻辑自己处理
			req.setAttribute("message", e.getMessage());
			req.setAttribute("name", req.getParameter("name"));
			req.setAttribute("password", req.getParameter("password"));
			return "main/login";
		}else {
			//系统抛出异常,交给spring容器处理
			throw e;
		}
	}
	@Resource
	private AdminSecvice adminSecvice;
	//通过发送请求跳转登陆到登陆页面
	@RequestMapping("/toLogin.do")
	public String toLogin() {
		return "main/login";
	}//通过请求到主界面
	@RequestMapping("toIndex.do")
	public String toIndex() {
		return "main/index";
	}
	//登陆检查
	@RequestMapping("/checkLogin.do")
	
	public String checkLogin(String name,String password,ModelMap model,HttpSession session) {
		System.out.println(name);
		System.out.println(session);
		//测试Spring系统异常捕获
		//String a=null;
		//a.charAt(0);
		Admin admin = adminSecvice.checkNamePwd(name, password);
		session.setAttribute("admin", admin);
		/*try {
		Admin admin = adminSecvice.checkNamePwd(name, password);
		session.setAttribute("admin", admin);
		//若是出现异常
		} catch (NameException e) {
		//获取抛出的异常放入message类型中转到AdminServiceImpl类中
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
		//成功登陆
		return "redirect:../cost/list.333";
	}
	
}
