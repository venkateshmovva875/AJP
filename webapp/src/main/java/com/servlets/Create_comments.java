package com.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.models.*;
import com.test.Saveobject;

/**
 * Servlet implementation class Create_comments
 */
@WebServlet("/comment")
public class Create_comments extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out = res.getWriter();
		String contentString = req.getParameter("content");
		int user_id=Integer.parseInt(req.getParameter("user_id"));
		int post_id= Integer.parseInt(req.getParameter("post_id"));
		String timestampString=req.getParameter("timestamp");
		
		comments commentmodel = new comments(contentString, user_id, post_id, timestampString);
		 int count=Saveobject.savecomment(commentmodel);
		   if(count==0)
		   {
			   out.println("<h2>comment is not registeres</h2>");
			   
		   }else {
			   out.println("<h2>comment is stored in database</h2>");
		   }

	}

}
