package com.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnectionSetting {
	private Connection con;
	private PreparedStatement stmt;
	DbConnectionSetting(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/","root",""); 	
			String sql = "CREATE DATABASE IF NOT EXISTS college";
			stmt = con.prepareStatement(sql);
			stmt.execute();
			stmt=null;
			String sqlCreate = "CREATE TABLE IF NOT EXISTS college.students"
            + "  (name           	VARCHAR(500),"
            + "   roll_number    	VARCHAR(500),"
            + "   dob            	varchar(100),"
            + "   gender         	varchar(30),"
            + "   mobile_number  	VARCHAR(500),"
            + "   alternate_number  VARCHAR(500),"
            + "   address 			TEXT(20000),"
            + "   email 			varchar(200),"
            + "   primary key(roll_number))";
		   stmt = con.prepareStatement(sqlCreate);
		   stmt.execute();
		   
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}
	

}
