<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task Management</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            
            margin: 0;
            padding: 0;
            background-image:url("https://www.cflowapps.com/wp-content/uploads/2018/07/task-management-process.png");
            background-repeat: no-repeat;
            background-attachment: fixed; 
            background-size: 100% 100%;
        }
        h1 {
            color: #fff;
            text-align: center;
            padding: 20px 0;
            background-color: orange; /* orange */
            margin: 0;
        }
        .operation-links {
            text-align: center;
            margin-top: 20px;
        }
        .operation-links a {
            margin: 0 10px;
            text-decoration: none;
            padding: 10px 20px;
            background-color: orange; /*orange */
            color: #fff;
            border: 1px solid orange; /* orange */
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .operation-links a:hover {
            background-color: #FF8C00; /* dark orange */
        }
    </style>
</head>
<body>
    <h1>Task Management</h1>
    
    <div class="operation-links">
        <s:a href="addTask.jsp">Add Task</s:a>
        <s:a href="displayTasks.jsp">Display Tasks</s:a>
        <s:a href="updateTask.jsp">Update Task</s:a>
        <s:a href="deleteTask.jsp">Delete Task</s:a>
    </div>
</body>
</html>
