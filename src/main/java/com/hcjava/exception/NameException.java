package com.hcjava.exception;
/**
 * 自定义账户和密码异常
 * @author lenovo
 *
 */
public class NameException extends RuntimeException{
	public NameException(String message) {
		super(message);
	}
}
