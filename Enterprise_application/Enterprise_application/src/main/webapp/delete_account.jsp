<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="org.hibernate.SessionFactory"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="com.vignan.OrderItem" %>
<%@ page import="com.vignan.Order" %>
<%@ page import="com.helper.FactoryProvider"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete customer details</title>
<style>
/* Add your CSS styles here */
body {
	font-family: Arial, sans-serif;
	background: rgb(2,0,36);
	background: linear-gradient(270deg, rgba(2,0,36,.3) 0%, rgba(216,73,223,1) 17%, rgba(234,227,245,1) 41%, rgba(253,243,121,1) 68%, rgba(0,212,255,1) 100%);       
        /* Container styles */
}

h1 {
	color: #333;
}

form {
	max-width: 400px;
	margin: 0 auto;
}

label {
	display: block;
	margin-bottom: 5px;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type="submit"] {
	background-color: #d9534f;
	color: #fff;
	border: none;
	border-radius: 5px;
	padding: 10px 20px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #c9302c;
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
.operation-links {
            margin-top: 20px;
        }
        .operation-links a {
            margin-right: 10px;
            text-decoration: none;
            padding: 5px 10px;
            background-color: #007bff;
            color: #fff;
            border: 1px solid #007bff;
            border-radius: 5px;
        }
        .operation-links a:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
</style>
</head>
<body>
	<h1>Delete customer</h1>

	<h2>List of customers</h2>
	
	
	
	<table>
        <thead>
            <tr>
                <th>ID</th>
                <th>item_D</th>
                <th>item_ID</th>
                <th>Item Name</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <%
                try {
                	
                	Class.forName("com.mysql.cj.jdbc.Driver");
                    
                    // Establish database connection
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprise", "root", "root");
                    
                    // Your SQL query to select data from the item_list table
                    String query = "select * from order_items inner Join item_list on order_items.item_id=item_list.item_id";
                    
                    // Creating a Statement object to execute the query
                    Statement stmt = conn.createStatement();
                    
                    // Executing the query and getting the result set
                    ResultSet resultSet = stmt.executeQuery(query);
                    
                    // Iterating over the ResultSet and printing each row in a table row
                    while (resultSet.next()) {
            %>
                        <tr>
                        	<td><%= resultSet.getInt("id") %></td>
                        	<td><%= resultSet.getInt("item_id") %></td>
                            <td><%= resultSet.getInt("item_id") %></td>
                            <td><%= resultSet.getString("item_name") %></td>
                            <td><%= resultSet.getDouble("price") %></td>
                        </tr>
            <%
                    }
                    
                    // Closing the result set, statement, and connection
                    resultSet.close();
                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </tbody>
    </table>
	
	
	

	<h2>Delete customer</h2>
	<form action="deleteaccountServlet" method="post">
		<label for="id">Customer ID:</label> <input type="text" name="id"
			required> <input type="submit" value="Delete Customer">
	</form>
	<div class="operation-links">
		<a href='viewall.jsp'>View all customers</a>
	</div>
</body>
</html>
