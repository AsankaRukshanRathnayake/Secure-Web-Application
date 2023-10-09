<%@ page import="java.sql.*" %>
<%@ page%>

<% 
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		
		PreparedStatement ps = connection.prepareStatement("insert into user(username, password) values(?,?)");
		ps.setString(1,username);
		ps.setString(2,password);
		
		int x=ps.executeUpdate();
		
		if(x>0){
			out.println("Registration Success");
		}else{
			out.println("Registration failed");
		}
	}catch(Exception e){
		out.println(e);
	}
%>

