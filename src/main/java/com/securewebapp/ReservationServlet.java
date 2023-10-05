package com.securewebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
		try {
			
			//set content type
			response.setContentType("text/html");
			
			//get print writer
			PrintWriter out = response.getWriter();
			
			try {
				// Initialize the database 
				Connection con = DatabaseConnection.initializeDatabase(); 
				
				try {
					PreparedStatement st = con.prepareStatement("insert into vehicle_service (date, time, location, vehicle_no, mileage, message, username) values(?,?,?,?,?,?,?)"); 

			        st.setDate(1, Date.valueOf(request.getParameter("reservationDate")));
			        st.setTime(2, Time.valueOf(request.getParameter("reservationTime")));
			        st.setString(3, request.getParameter("location"));
			        st.setString(4, (request.getParameter("reg1")+request.getParameter("reg2")+request.getParameter("reg3"))); 
			        st.setInt(5, Integer.valueOf(request.getParameter("mileage")));
			        st.setString(6,request.getParameter("message"));
			        st.setString(7,"userTest");
			        

			        // Execute the insert command using executeUpdate() 
			        // to make changes in database 
			        st.executeUpdate(); 
					
			        st.close(); 
				}catch (Exception e) {
					out.println("Insert Query failed");
				}
				
				// Close all the connections
		        con.close();
        
        
		}catch (Exception e) {
			out.println("Connection failed");
		}

		
		//set html content
		out.println("<html><body>");
		out.println("Your reservation is successfully placed.<br>");
		out.println("Date                : "+request.getParameter("reservationDate")+"<br>");
		out.println("Time                : "+request.getParameter("reservationTime")+"<br>");
		out.println("Registration Number : "+request.getParameter("reg1")+" "+request.getParameter("reg2")+"-"+request.getParameter("reg3")+"<br>");
		out.println("District            : "+request.getParameter("district")+"<br>");
		out.println("Mileage             : "+request.getParameter("mileage")+"<br>");
		out.println("Message             : "+request.getParameter("message")+"<br>");
		out.println("<a href='home.jsp'>Home</a>");
		out.println("</body></html>");
		
		
		}catch (Exception e) { 
            e.printStackTrace(); 
        } 
		
	}

}
