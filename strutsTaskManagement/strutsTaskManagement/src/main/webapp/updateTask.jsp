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
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h1 {
            color: #333;
            text-align: center;
            padding: 20px 0;
            background-color: orange;
            color: #fff;
            margin: 0;
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
            background-color: orange;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #FF8C00;
        }
        .form-group input[type="submit"] {
            background-color: orange;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-group input[type="submit"]:hover {
            background-color: #FF8C00;
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
        
        <s:iterator value="tasks" var="task">
            <tr>
                <td><s:property value="#task.id"/></td>
                <td><s:property value="#task.name"/></td>
                <td><s:property value="#task.description"/></td>
                <td><s:property value="#task.dueDate"/></td>
                <td><s:property value="#task.priority"/></td>
            </tr>
        </s:iterator>
    </table>

    <div class="container text-center mt-2">
        <a href="index.jsp" class="btn btn-primary">Home</a>
    </div>

    <h1>Update Task</h1>
    
    <form action="UpdateTaskAction" method="post">
        <div class="form-group">
            <label for="id">Id:</label>
            <input type="text" name="id" required />
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" name="name" required />
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" name="description" required />
        </div>
        <div class="form-group">
            <label for="dueDate">Due Date:</label>
            <input type="date" name="dueDate" required />
        </div>
        <div class="form-group">
            <label for="priority">Priority:</label>
            <input type="number" name="priority" required />
        </div>
        <div class="form-group">
            <input type="submit" value="Update Task" />
        </div>
    </form>
</body>
</html>
