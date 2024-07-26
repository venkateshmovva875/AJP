package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.*;

/**
 * Servlet implementation class servlet
 */
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String dob = request.getParameter("date");
		Person person = new Person(name, age, dob);
		int c=PersonDao.saveperson(person);
		if(c==0)
		{	out.println("Data is stored in db");
			
		}else {
			out.println("person is registred");
		}
		HttpSession session = request.getSession();
		session.setAttribute("person", person);
		RequestDispatcher rDispatcher = request.getRequestDispatcher("/result.jsp");
		rDispatcher.forward(request, response);
		
	}

}
