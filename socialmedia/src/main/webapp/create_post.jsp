<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Create a Post</title>
  <style type="text/css">
    body {
      font-family: Arial, sans-serif;
      background-image: url("wp2044774.webp");
      background-size: cover;
      background-repeat: no-repeat;
      margin: 0;
      padding: 0;
    }
    h1 {
      color: red;
    }
    form {
      width: 50%;
      margin: 0 auto;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
      background-color: rgba(249, 249, 249, 0.8); /* Transparent background color */
    }
    label {
      display: block;
      margin-bottom: 5px;
      color: #333;
    }
    input[type="text"],
    textarea {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 3px;
      transition: border-color 0.3s ease;
    }
    input[type="text"]:focus,
    textarea:focus {
      border-color: #66afe9;
      outline: none;
    }
    input[type="submit"] {
      background-color: #428bca;
      color: white;
      border: none;
      padding: 10px 20px;
      border-radius: 3px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }
    input[type="submit"]:hover {
      background-color: #357ebd;
    }
  </style>
</head>
<body>
  <h1>Create a New Post</h1>
  <form action="SavePost.jsp" method="post">
    <label for="postTitle">Post Title:</label>
    <input type="text" id="postTitle" name="postTitle" required>
    
    <label for="postContent">Post Content:</label>
    <textarea id="postContent" name="postContent" rows="4" cols="50" required></textarea>
    
    <input type="submit" value="Create Post">
  </form>
</body>
</html>
