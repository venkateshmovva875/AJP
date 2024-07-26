package com.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.users;
import com.test.Saveobject;


@WebServlet("/user")
public class Create_user extends HttpServlet {
	private static final long serialVersionUID = 1L;

   public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
   {
	   PrintWriter out = res.getWriter();
	   int id = Integer.parseInt(req.getParameter("id"));
	   String nameString=req.getParameter("name");
	   String emailString = req.getParameter("email");
	   
	   users usermodel = new users(id, nameString, emailString);

	   int count=Saveobject.save(usermodel);
	   if(count==0)
	   {
		   out.println("<h2>user is not registeres</h2>");
		   
	   }else {
		   out.println("<h2>user is stored in database</h2>");
	   }
   }

}
