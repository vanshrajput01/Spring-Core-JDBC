package com.example.demo.ApiRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public String AddDataInfo(int id, String name, String city) {
		
		String q = "insert into xxcust_emp_tbl(id,name,city)\r\n"
				+ "values (?,?,?)";
		
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(q);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, city);
			
			ps.executeUpdate();
			return id + " id Data inserted SuccessFully!!";
		} catch (SQLException e) {
			
			return e.getMessage();
		}
		
		
		
		
	}

	public String updateDataInfo(int id, String name, String city) {
		
		String q = "update xxcust_emp_tbl\r\n"
				+ "set name = ? , city = ?\r\n"
				+ "where id = ?";
		
		try {
			Connection conn = dataSource.getConnection();
			
			PreparedStatement pstm = conn.prepareStatement(q);
			
			pstm.setString(1, name);
			pstm.setString(2,city);
			pstm.setInt(3, id);
			
			
			pstm.executeUpdate();
			
			return id + " id Update Data SuccessFully!!"; 
		} catch (SQLException e) {
			
			return e.getMessage();
		}
		
		
		
	}
// first create input class
		public String insertData(GetInputCls input) {
		
		String result = null;
		
		try {
			Connection connection = dataSource.getConnection();
			CallableStatement callableStatement = connection.prepareCall("call here procedure");
			ObjectMapper objectMapper = new ObjectMapper();
			String inputString;
			try {
				inputString = objectMapper.writeValueAsString(input);
				callableStatement.setString(1,inputString);
				callableStatement.registerOutParameter(2, Types.VARCHAR);
				
				callableStatement.execute();
				 result = callableStatement.getString(2);
				
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	

}
