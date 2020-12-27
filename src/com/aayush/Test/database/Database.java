package com.aayush.Test.database;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Database {
	

	
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/hello","root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
