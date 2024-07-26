<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Item List</title>
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
        input[type="text"], input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
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
    <h1>Item List</h1>
    
    <table>
        <thead>
            <tr>
                <th>Item ID</th>
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
                    String query = "SELECT * FROM item_list";
                    
                    // Creating a Statement object to execute the query
                    Statement stmt = conn.createStatement();
                    
                    // Executing the query and getting the result set
                    ResultSet resultSet = stmt.executeQuery(query);
                    
                    // Iterating over the ResultSet and printing each row in a table row
                    while (resultSet.next()) {
            %>
                        <tr>
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

    <h1>Create Customer</h1>
    
    <form action="createaccountServlet" method="post">
        <label for="item_id">Item Id you want:</label>
        <input type="text" name="item_id" required>
        <input type="submit" value="Create account">
    </form>
    <div class="operation-links">
    	<a href="index.jsp">Home</a>
    </div>
</body>
</html>
