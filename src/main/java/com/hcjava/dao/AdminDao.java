package com.hcjava.dao;

import org.apache.ibatis.annotations.Select;

import com.hcjava.cotorller.Admin;

public interface AdminDao {
	//����½
	@Select("select id,name,password,email,telephone from admin where name=#{name}")
	Admin findByName(String name);
}
