package com.blipkart.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BlipkartConnection {

	public static Connection getBlipkartConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/blipkart","root","root");
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	
}
