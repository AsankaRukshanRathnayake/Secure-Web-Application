package com.vehicleserviceapp.model;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
  
// This class can be used to initialize the database connection 
public class DatabaseConnection { 
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/isec_assessment2","root","");
        	return connection;
    	}catch(Exception e) {
    		return null;
    	}
    } 
} 
