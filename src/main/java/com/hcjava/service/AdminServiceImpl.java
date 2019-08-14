package com.hcjava.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcjava.cotorller.Admin;
import com.hcjava.dao.AdminDao;
import com.hcjava.exception.NameException;
import com.hcjava.exception.PasswordException;
@Service
public class AdminServiceImpl implements  AdminSecvice{
	@Resource
	private AdminDao adminDao;
	public Admin checkNamePwd(String name, String password)throws NameException,PasswordException {
		Admin admin = adminDao.findByName(name);
		if(admin==null) {
			throw new NameException("’À∫≈≤ª¥Ê‘⁄");
		}else if(!admin.getPassword().equals(password)) {
			throw new PasswordException("√‹¬Î¥ÌŒÛ");
		}else {
			return admin;
		}
	}
}
