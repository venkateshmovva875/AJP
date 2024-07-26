<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Content Management System</title>
    <style>
        /* Add your CSS styles here */
        body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
     background-image:url("https://weblog.wemanity.com/wp-content/uploads/2022/03/Blog-articles-headers-1024x682-1-1024x570.jpeg");
     background-repeat: no-repeat;
     background-attachment: fixed; 
     background-size: 100% 100%;
	}
	h1 {
    color: #333;
    text-align: center;
    padding: 20px 0;
    background-color: #FFA500; /* orange color */
    color: #fff;
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
    background-color: #FFA500; /* orange color */
    color: #fff;
    border: 1px solid #FF8C00; /* darker orange border */
    border-radius: 5px;
    transition: background-color 0.3s;
	}
	.operation-links a:hover {
    background-color: #FF8C00; /* darker orange hover color */
	}

    </style>
</head>
<body>
    <h1>Content Management System</h1>
    
    <div class="operation-links">
        <s:a href="addArticle.jsp">Add Article</s:a>
        <s:a href="displayArticles.jsp">Display Articles</s:a>
        <s:a href="updateArticle.jsp">Update Article</s:a>
        <s:a href="deleteArticle.jsp">Delete Article</s:a>
    </div>
</body>
</html>
