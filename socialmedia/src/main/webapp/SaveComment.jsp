<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
  <title>Save Comment</title>
</head>
<body>
  <%
    String commentContent = request.getParameter("commentContent");

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    try {
      Class.forName("com.mysql.jdbc.Driver");
      String jdbcURL = "jdbc:mysql://localhost:3306/sai";
      String dbUser = "root";
      String dbPassword = "root";
      
      connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
      
      String sql = "INSERT INTO content (commentcontent) VALUES (?)";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, commentContent);
      
      int rowsAffected = preparedStatement.executeUpdate();
      
      if (rowsAffected > 0) {
        out.println("<p>Comment added successfully!</p>");
      } else {
        out.println("<p>Failed to add comment.</p>");
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
