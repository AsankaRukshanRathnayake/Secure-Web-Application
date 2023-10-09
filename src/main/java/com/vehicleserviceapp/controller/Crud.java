package com.vehicleserviceapp.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.HashMap;
import java.sql.ResultSet;

import com.vehicleserviceapp.model.DatabaseConnection;

public class Crud {
	public static Map<String, String> displayReservations(String username) throws ClassNotFoundException, SQLException{
		Connection connection = DatabaseConnection.initializeDatabase();
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select date, time, location, vehicle_no, mileage, message from user where username='"+username+"'");
		
		 Map<String, String> dataMap = new HashMap<>();
		 
		 while (rs.next()) {
			 String date=rs.getString("date");
			 String time=rs.getString("time");
			 String location=rs.getString("location");
			 String vehicle_no=rs.getString("vehicle_no");
			 String mileage=rs.getString("mileage");
			 String message=rs.getString("message");
		 }
		 
		 return dataMap;
	}

}
