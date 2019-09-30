package com.boot.project;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private DataSource datasource;
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void contextLoads() {
	}
	
	//메서드가 오류없이 정상적으로 처리되는지의 여부를 알수있게해줌 @Test
	@Test
	public void testConnection() throws SQLException {
		System.out.println(datasource);
		Connection conn = datasource.getConnection();
		System.out.println(conn);
		conn.close();
	}
	
	@Test
	public void testSqlSessionDactory() {
		System.out.println("check SessionFactory : " + sessionFactory);
	}
	
	
}
