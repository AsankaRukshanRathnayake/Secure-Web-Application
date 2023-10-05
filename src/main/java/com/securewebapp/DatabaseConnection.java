package com.securewebapp;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
  
// This class can be used to initialize the database connection 
public class DatabaseConnection { 
    protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException { 
        // Initialize all the information regarding 
        // Database Connection 
        String dbDriver = "com.mysql.jdbc.Driver"; 
        String databaseURL = "jdbc:mysql://localhost:3306/"; 
        // Database name to access 
        String database = "isec_assessment2"; 
        String username = "root"; 
        String password = ""; 
  
        Class.forName(dbDriver); 
        Connection con = DriverManager.getConnection(databaseURL + database, username,  password); 
        return con; 
    } 
} 
