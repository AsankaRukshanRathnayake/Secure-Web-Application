package com.vehicleserviceapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vehicleserviceapp.model.*;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    String reservationDate=request.getParameter("reservationDate");
	    String reservationTime=request.getParameter("reservationTime");
	    String location=request.getParameter("district");
	    String vehicle_no=(request.getParameter("reg1")+" "+request.getParameter("reg2")+"-"+request.getParameter("reg3"));
	    String mileage=request.getParameter("mileage");
	    String message=request.getParameter("message");
	    String username=request.getParameter("username");
	    		
	    try {
	    	Connection connection = DatabaseConnection.initializeDatabase();
	    	
	    	PreparedStatement ps = connection.prepareStatement("insert into vehicle_service (date, time, location, vehicle_no, mileage, message, username) values (?,?,?,?,?,?,?)");
	    	
	    	ps.setString(1, reservationDate );
	    	ps.setString(2, reservationTime );
	    	ps.setString(3, location );
	    	ps.setString(4, vehicle_no);
	    	ps.setString(5, mileage);
	    	ps.setString(6, message);
	    	ps.setString(7, username);
	    	
	    	int x=ps.executeUpdate();
	    	
	    	if (x>0) {
	    		out.println("Reservation added successfully");
	    	}else {
	    		out.println("Reservation denied");
	    	}
	    	
	    }catch(Exception e) {
	    	out.println(e);
	    }
	}

}
