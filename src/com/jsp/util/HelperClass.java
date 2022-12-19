package com.jsp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelperClass {

	String url="jdbc:mysql://localhost:3306/jdbc_crud_operation";
	String username = "root";
	String password = "root";
	
	// connection part
	public Connection getConnection() {
		Connection connection =null;
		try {
			// load or Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Established the Connection
			
			connection= DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
