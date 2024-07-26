package com.servlets;

import java.awt.image.RescaleOp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.posts;
import com.test.Saveobject;

/**
 * Servlet implementation class Create_posts
 */
@WebServlet("/post")
public class Create_posts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
   {
	   PrintWriter out = res.getWriter();
	   int id=Integer.parseInt(req.getParameter("id"));
	   String contentString=req.getParameter("content");
	   int user_id=Integer.parseInt(req.getParameter("user_id"));
	   int post_id=Integer.parseInt(req.getParameter("post_id"));
	   String timestampString=req.getParameter("timestamp");
	   
	   posts postmodel = new posts(id, contentString, user_id, post_id, timestampString);
	   int count=Saveobject.savepost(postmodel);
	   if(count==0)
	   {
		   out.println("<h2>post is not registeres</h2>");
		   
	   }else {
		   out.println("<h2>post is stored in database</h2>");
	   }


	   
   }

}
