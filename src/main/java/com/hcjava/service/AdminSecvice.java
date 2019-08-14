package com.hcjava.service;

import com.hcjava.cotorller.Admin;
import com.hcjava.exception.NameException;
import com.hcjava.exception.PasswordException;

public interface AdminSecvice {
	public Admin checkNamePwd(String name,String password)throws NameException,PasswordException ;
}
