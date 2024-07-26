package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;


import com.helper.FactoryProvider;
import com.vignan.Order; // Make sure to import your Employee entity class
import com.vignan.OrderItem;

@WebServlet("/updateaccountServlet")
public class updateaccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve data from the form
        int customerid = Integer.parseInt(request.getParameter("customerid"));
        String itemIdParameter = request.getParameter("itemid");
        Long itemid = null;
        if (itemIdParameter != null && !itemIdParameter.isEmpty()) {
            try {
                itemid = Long.parseLong(itemIdParameter);
            } catch (NumberFormatException e) {
                e.printStackTrace(); // Or log the error
            }
        }
 
        Session session = FactoryProvider.getFactory().openSession();

        try {
            // Begin a transaction
            session.beginTransaction();

            // Retrieve the employee with the given ID from the database
            OrderItem id = session.get(OrderItem.class, customerid);

            // Update the employee's information
            if (id != null) {
            	id.setItemId(itemid);
        		

                // Save the updated employee to the database
                session.merge(id);
            } else {
            	response.setContentType("text/html");
        		PrintWriter out = response.getWriter();
            	out.println("<h1 style='text-align:center;'>Customer Not Found</h1>");
        		out.println("<h1 style='text-align:center;'><a href='viewall.jsp'>View all Recipe</a></h1>");
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

