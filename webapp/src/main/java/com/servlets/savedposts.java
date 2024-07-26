package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.models.posts;
import com.test.*;
import com.utility.Utility;

import antlr.collections.List;
import javassist.bytecode.stackmap.BasicBlock.Catch;

/**
 * Servlet implementation class savedposts
 */
@WebServlet("/savedpost")
public class savedposts extends HttpServlet {       
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		Session session = Utility.getSessionFactory().openSession();
		Transaction sTransaction = session.beginTransaction();
		System.out.println("1:Display all posts");
		System.out.println("2:Delete a specific post");
		System.out.println("3:Update a specific post");
		Query<posts> stuQuery = session.createQuery("FROM posts", posts.class);
		java.util.List<posts> data = stuQuery.getResultList();
		sTransaction.commit();
		session.close();
		System.out.println(data);
		
	}
	
	
}
