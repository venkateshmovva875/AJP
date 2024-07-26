<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profiles</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        h4 {
            margin-top: 20px;
            text-align: center;
            color: #333;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            border-spacing: 0;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
        }

        th, td {
            padding: 15px;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: white;
            border-bottom: 2px solid #0056b3;
        }

        td {
            background-color: #fff;
            border-bottom: 1px solid #f2f2f2;
        }

        td a {
            text-decoration: none;
            color: #007bff;
            transition: color 0.3s;
            display: block;
            padding: 10px;
            border-radius: 5px;
        }

        td a:hover {
            background-color: #007bff;
            color: #fff;
        }

        td:last-child a {
            margin-right: 0;
        }
    </style>
</head>
<body>
<h4>User Profiles</h4>
<table>
    <tr>
        <th>Action</th>
    </tr>
    <tr>
        <td><a href="/new">Add new user</a></td>
    </tr>
    <tr>
        <td><a href="/users">View all users</a></td>
    </tr>
</table>
</body>
</html>
