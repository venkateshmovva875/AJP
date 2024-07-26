package com.socialnetworking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//servlet1 is used to check if user data exist or not
@WebServlet("/serv")
public class servlet1 extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sai","root","root");
			PreparedStatement p = con.prepareStatement("select username,password from loginIndex where username=? and password=?");
			p.setString(1, username);
			p.setString(2, password);
			//execute the statement
			ResultSet rSet = p.executeQuery();
			//checking rset is exist or not
			if(rSet.next())
			{
				HttpSession session = req.getSession();
				session.setAttribute("username", rSet.getString("username"));
				res.sendRedirect("home.jsp");
			}
			else {
				String urlString ="Index.html?error=true";
				res.sendRedirect(urlString);
			}
		 }catch (Exception e) {
			e.printStackTrace();
			 // TODO: handle exception
		}
			
	}

}
