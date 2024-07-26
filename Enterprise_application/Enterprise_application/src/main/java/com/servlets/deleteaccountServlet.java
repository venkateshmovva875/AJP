package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.helper.FactoryProvider;
import com.vignan.Order; // Make sure to import your Employee entity class
import com.vignan.OrderItem;

@WebServlet("/deleteaccountServlet")
public class deleteaccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the ID of the employee to delete from the form
        int customerId = Integer.parseInt(request.getParameter("id"));

        // Create a Hibernate  Session
        Session session = FactoryProvider.getFactory().openSession();

        try {
            // Begin a transaction
            session.beginTransaction();

            // Retrieve the employee with the given ID from the database
            Order order = session.get(Order.class, customerId);
            OrderItem orderitem = session.get(OrderItem.class, customerId);

            // Delete the employee if found
            if (order != null) {
                session.remove(order);
                session.remove(orderitem);
            } else {
            	response.setContentType("text/html");
        		PrintWriter out = response.getWriter();
            	out.println("<h1 style='text-align:center;'>customer Not Found</h1>");
        		out.println("<h1 style='text-align:center;'><a href='viewall.jsp'>View all customers</a></h1>");
            }
            // Commit the transaction
            session.getTransaction().commit();
        } finally {
            session.close();
        }

        // Redirect to a success page or a list of employees
        response.sendRedirect("viewall.jsp");
    }
}
