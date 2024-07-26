<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
  <title>Save Post</title>
</head>
<body>
  <%
    String postTitle = request.getParameter("postTitle");
    String postContent = request.getParameter("postContent");

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      Class.forName("com.mysql.jdbc.Driver");
      String jdbcURL = "jdbc:mysql://localhost:3306/sai";
      String dbUser = "root";
      String dbPassword = "root";
      
      connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
      
      String sql = "INSERT INTO savedposts (title, content) VALUES (?, ?)";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, postTitle);
      preparedStatement.setString(2, postContent);
      
      int rowsAffected = preparedStatement.executeUpdate();
      
      if (rowsAffected > 0) {
        out.println("<p>Post created successfully!</p>");
      } else {
        out.println("<p>Failed to create post.</p>");
      }
    } catch (Exception e) {
      out.println("<p>Error: " + e.getMessage() + "</p>");
    } finally {
      if (preparedStatement != null) {
        preparedStatement.close();
      }
      if (connection != null) {
        connection.close();
      }
    }
  %>
</body>
</html>
