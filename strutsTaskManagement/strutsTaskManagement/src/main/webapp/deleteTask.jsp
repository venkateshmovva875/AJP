<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="org.hibernate.SessionFactory"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="com.example.Task"%>
<%@ page import="com.example.FactoryProvider"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Task</title>
<style>
/* Add your CSS styles here */
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
    margin: 0;
}

form {
    width: 50%;
    margin: 20px auto;
}

label {
    display: block;
    margin-bottom: 5px;
}

input {
    width: 100%;
    padding: 8px;
    margin-bottom: 10px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 3px;
}

button {
    padding: 10px;
    background-color: orange; /* Changed to orange */
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background-color: #FF8C00; /* Changed hover color */
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
</style>
</head>
<body>
    <h1>List of Tasks</h1>
    
    <table>
        <tr>
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
                if (session1 != null) {
                    session1.getTransaction().rollback();
                }
                e.printStackTrace();
            } finally {
                if (session1 != null && session1.isOpen()) {
                    session1.close();
                }
            }
        %>
        
    </table>
    <div class="container text-center mt-2">
        <a href="index.jsp" class="btn btn-primary">Home</a>
    </div>
    
    <h1>Delete Task</h1>

    <form action="DeleteTaskAction" method="post">
        <label for="id">Task ID:</label> 
        <input type="text" id="id" name="id"
            placeholder="Enter Task ID to Delete" required />

        <button type="submit">Delete Task</button>
    </form>
</body>
</html>
