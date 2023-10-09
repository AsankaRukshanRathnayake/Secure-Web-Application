<%@ page import="java.util.*" %>
<%@ page import="com.vehicleserviceapp.controller.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.vehicleserviceapp.controller.Crud" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>

<html>
	<head>
		<title>Home</title>
	</head>
	
	<body>
		<header>
			<h1 align="center">Vehicle Reservation Application</h1>
			
			<span>User ID</span>
			<table border="1">
				<tr>
					<td>User Name</td>
					<td>my_user_name</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>my_name</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>my_email</td>
				</tr>
				<tr>
					<td>Contact No.</td>
					<td>my_contact_no</td>
				</tr>
				<tr>
					<td>Country</td>
					<td>my_country</td>
				</tr>
			</table>
		</header>
		
		<section>
			<div>
				<form action="ReservationServlet" method="POST">
					<h2>Make A Reservation</h2>
					
					<table>
						<tr>
							<td><label for="reservationDate">Reservation Date</label></td>
							<td><input type="date" name="reservationDate" required></td>
						</tr>
						<tr>
							<td><label for="reservationTime">Reservation Time</label></td>
							<td>
								<input type="radio" name="reservationTime" value="10:00" required>10.00AM
								<input type="radio" name="reservationTime" value="11:00" required>11.00AM
								<input type="radio" name="reservationTime" value="12:00" required>12.00PM
							</td>
						</tr>
						<tr>
							<td><label for="district">District</label></td>
							<td>
								<select name="district">
									<option>Colombo</option>
									<option>Gampaha</option>
									<option>Kaluthara</option>
									<option>Kandy</option>
									<option>Mathale</option>
									<option>NuwaraEliya</option>
									<option>Galle</option>
									<option>Mathara</option>
									<option>Hambanthota</option>
									<option>Jaffna</option>
									<option>Kilinochchi</option>
									<option>Vauniya</option>
									<option>Mulathiv</option>
									<option>Mannar</option>
									<option>Batticloa</option>
									<option>Ampara</option>
									<option>Trincomalee</option>
									<option>Kurunegala</option>
									<option>Puththalam</option>
									<option>Anuradhapura</option>
									<option>Polonnaruwa</option>
									<option>Badulla</option>
									<option>Monaragala</option>
									<option>Rathnapura</option>
									<option>Kegalle</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<td><label for="">Registration No</label></td>
							<td>
								<select name="reg1" required>
									<option>WP</option>
									<option>CP</option>
									<option>SP</option>
									<option>NP</option>
									<option>EP</option>
									<option>NW</option>
									<option>NC</option>
									<option>UP</option>
									<option>SB</option>
								</select>
								
								<input type="text" name="reg2" maxlength="3" required> - <input type="text" name="reg3" maxlength="4" required>
							</td>
						</tr>
						<tr>
							<td><label for="mileage">Current Mileage</label></td>
							<td>
								<input type="number" name="mileage" min="0" max="999999">
							</td>
						</tr>
						<tr>
							<td><label for="message">Message</label></td>
							<td>
								<textarea name="message" rows="5" cols="50" maxlength="1000" required></textarea>
							</td>
						</tr>
					</table>
					
					<input type="hidden" name="username" value="user1">
					
					<input type="submit" value="Add">
				</form>
			</div>
			
			<div>
				 <h1>Reservations</h1>

    <%
        try {
            List<String[]> myList = Crud.displayReservations("user1");

            // Check if myList is not null and not empty
            if (myList != null && !myList.isEmpty()) {
    %>
    <table border="1">
        <tr>
        	<th>Booking ID</th>
            <th>Date</th>
            <th>Time</th>
            <th>Location</th>
            <th>Vehicle Number</th>
            <th>Mileage</th>
            <th>Message</th>
        </tr>
        <%
            for (String[] array : myList) {
        %>
        <tr>
            <td><%= array[0] %></td>
            <td><%= array[1] %></td>
            <td><%= array[2] %></td>
            <td><%= array[3] %></td>
            <td><%= array[4] %></td>
            <td><%= array[5] %></td>
            <td><%= array[6] %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
            } else {
    %>
    <p>No reservations found for this user.</p>
    <%
            }
        } catch (SQLException e) {
            e.printStackTrace();
    %>
    <p>An error occurred while retrieving reservations.</p>
    <%
        }
    %>
			</div>
		</section>
	</body>
</html>