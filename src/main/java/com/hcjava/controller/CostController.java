package com.hcjava.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcjava.cotorller.Cost;
import com.hcjava.service.CostService;
//¿ªÆôÉ¨Ãè×¢½â
@Controller
//
@RequestMapping("/cost")
public class CostController {
	@Resource
	private CostService costServite;
	@RequestMapping("/list.do")
	public String list(ModelMap model) {
		List<Cost> costs = costServite.findAll();
		model.addAttribute("costs", costs);
		return "main/cost";
	}
}
