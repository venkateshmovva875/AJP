<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.models.*" %>
<%@page import="com.Utility.*" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
   try {
      Person person = (Person) session.getAttribute("person");
      Query query = utility.getSession().createQuery("from Person");
      List<Person> persons = query.list();
      for (Person p : persons) {
    	  out.println(p.getNameString());
    	  out.println(p.getDobString());
         out.println(p.getAgeString());
	
      }
   } catch (Exception e) {
      out.println("An error occurred: " + e.getMessage());
   }
%>
</body>

</html>