package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;
import com.vignan.Order;
import com.vignan.OrderItem;

@WebServlet("/createaccountServlet")
public class createaccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public createaccountServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String itemIdParameter = request.getParameter("item_id");
        Long item_id = null;
        if (itemIdParameter != null && !itemIdParameter.isEmpty()) {
            try {
                item_id = Long.parseLong(itemIdParameter);
            } catch (NumberFormatException e) {
                e.printStackTrace(); // Or log the error
            }
        }

        
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        // Create a new OrderItem instance
        Order order=new Order();
        session.persist(order);
        
        OrderItem orderItem = new OrderItem();
        orderItem.setItemId(item_id);
        Long id=order.getId();
        orderItem.setId(id);
        // Retrieve the Order object from the database
        

        // Assuming you want to persist the orderItem without a specific order for now
        session.persist(orderItem);

        // Commit the transaction and close the session
        tx.commit();
        session.close();

        // Print the success message
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1 style='text-align:center;'>Customer is added successfully</h1>");
        out.println("<h1 style='text-align:center;'><a href='viewall.jsp'>View all Recipe</a></h1>");
        out.println("<h1 style='text-align:center;'><a href=\"index.jsp\">Home</a></h1>");
    }
}
