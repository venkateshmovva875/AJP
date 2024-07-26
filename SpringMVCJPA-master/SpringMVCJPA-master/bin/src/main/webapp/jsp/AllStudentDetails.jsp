<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Student Information</h2>
	<table border=1>
		<tr>
			<th> Student Roll Number</th>
			<th> Student Name</th>
			<th> Year of Joining</th>
			<th> Course Id</th>
			<th> Course Name</th>
		</tr>
		<c:forEach items="${students}" var="student">
		<tr>
			<td><c:out value="${student.rollNo}"/></td>
			<td><c:out value="${student.name}"/></td>
			<td><c:out value="${student.yoj}"/></td>
			<td><c:out value="${student.course.courseid}"/></td>
			<td><c:out value="${student.course.coursename}"/></td>
		</tr>
		</c:forEach>
			
	</table>
		<a href=view>home</a>
</body>
</html>