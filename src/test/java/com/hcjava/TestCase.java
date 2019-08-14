package com.hcjava;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CharacterEncodingFilter;

@Component
public class TestCase {
//测试连接数据库
	@SuppressWarnings("resource")
	@Test
	public void testConn() throws SQLException {
	String cfg="spring-mvc.xml";
	ApplicationContext ac = new ClassPathXmlApplicationContext(cfg);
	DataSource bean = ac.getBean("dataSource",DataSource.class);
	Connection conn = bean.getConnection();
	System.out.println(conn);
	}
	//CharacterEncodingFilter
}
