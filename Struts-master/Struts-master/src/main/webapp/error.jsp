<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
        .error-message {
            color: #ff0000;
            font-size: 24px;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>Error</h1>
    
    <div class="error-message">
        An error occurred: <s:property value="actionErrors" escape="false" />
    </div>
    <div class="index-link">
        <a href="index.jsp">Home</a>
    </div>
</body>
</html>
