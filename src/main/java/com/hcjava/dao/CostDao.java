package com.hcjava.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.hcjava.cotorller.Cost;

public interface CostDao {
	@Select("select id,name,status,createtime,starttime,type from cost")
	List<Cost> findAll();
}
