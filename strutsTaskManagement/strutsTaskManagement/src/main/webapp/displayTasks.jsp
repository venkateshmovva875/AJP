<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="com.example.Task" %>
<%@ page import="com.example.FactoryProvider" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Your CSS styles -->
    <style>
    body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333;
            text-align: center;
            padding: 20px 0;
            background-color: orange; /* Changed to orange */
            color: #fff;
            margin: 0; /* Added margin */
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .container {
            text-align: center;
            margin-top: 20px;
        }
        .btn {
            margin-top: 10px;
            text-decoration: none;
            padding: 10px 20px;
            background-color: orange; /* Changed to orange */
            color: #fff;
            border: 1px solid #FF8C00; /* Changed border color */
            border-radius: 5px;
            transition: background-color 0.3s;
            display: inline-block; /* Added display property */
        }
        .btn:hover {
            background-color: #FF8C00; /* Changed hover color */
        }
        </style>
</head>
<body>
    <h1>List of Tasks</h1>
    
    <table>
        <tr>
            <!-- Table headers -->
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Due Date</th>
            <th>Priority</th>
        </tr>
        
        <% 
            Session session1 = null;
            try {
                session1 = FactoryProvider.getFactory().openSession();
                session1.beginTransaction();
                List<Task> tasks = session1.createQuery("from Task").getResultList();
                
                for (Task i : tasks) {
        %>
                <tr>
                    <!-- Display task information -->
                    <td><%= i.getId() %></td>
                    <td><%= i.getName() %></td>
                    <td><%= i.getDescription() %></td>
                    <td><%= i.getDueDate() %></td>
                    <td><%= i.getPriority() %></td>
                </tr>
        <%
                }
                session1.getTransaction().commit();
            } catch (Exception e) {
                // Print the exception details for debugging
                e.printStackTrace();
                if (session1 != null && session1.isOpen()) {
                    session1.getTransaction().rollback();
                    session1.close();
                }
            }
        %>
    </table>
    <div class="container">
        <a href="index.jsp" class="btn">Home</a>
    </div>
</body>
</html>
