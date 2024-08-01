package com.example.demo.ApiRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApiRespositoryCls {
	
	@Autowired
	private DataSource dataSource;

	public String createTbl() {
		
		String q = "create table xxcust_emp_tbl(\r\n"
				+ "id number primary key,\r\n"
				+ "name varchar(30),\r\n"
				+ "city varchar(30)\r\n"
				+ ")";
		
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();
			st.executeUpdate(q);
			return "Table created!!";
			
		} catch (SQLException e) {
			return e.getMessage();
		}
		
		
		
	}
	
	
	
	

}
