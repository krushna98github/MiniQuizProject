package com.quizdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	
	  //  method for connection pooling which return connection object.
	
	public Connection getConnectionDetails()              
	{
		Connection con=null;
		try {
			   //Load the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			   
			   // Establish the connection 
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quedemo", "root", "root");
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return con;
	}

}
