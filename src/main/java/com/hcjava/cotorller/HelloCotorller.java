package com.hcjava.cotorller;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//org.springframework.web.servlet.handler.SimpleMappingExceptionResolver
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Controller
@RequestMapping("/demo")
public class HelloCotorller {
	@RequestMapping("/hello.do")
	public String hello() {
		System.out.println("----------------");
		return "jsp/hello";
	}
	//BasicDataSource
	//SimpleMappingExceptionResolver
}
