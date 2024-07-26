<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Logout</title>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f2f5; /* Set your background color */
        }

        .container {
            text-align: center;
            margin: 100px auto;
            max-width: 400px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #1877f2; /* Facebook-like blue */
        }

        p {
            font-size: 18px;
            margin-bottom: 20px;
        }

        a {
            color: #1877f2;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Logged Out Successfully</h1>
        <p>You have been successfully logged out.</p>
        <p><a href="Index.html">Log in again</a></p>
    </div>
</body>
</html>
