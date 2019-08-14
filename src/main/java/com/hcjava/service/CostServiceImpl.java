package com.hcjava.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcjava.cotorller.Cost;
import com.hcjava.dao.CostDao;

@Service
public class CostServiceImpl implements CostService{
	@Resource
	public CostDao costDao;
	public List<Cost> findAll() {
		return costDao.findAll();
	}

}
