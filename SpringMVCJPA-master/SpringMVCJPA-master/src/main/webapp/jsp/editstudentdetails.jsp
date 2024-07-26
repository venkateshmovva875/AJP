<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student Details</title>
</head>
<style>
h4
{
	color: blue;
	text-decoration: none;
	cursor: pointer;
}
a {
	color: green;
	text-decoration: none;
	cursor: pointer;
}
</style>
<body>
	
<form action="updatestudentinfo">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="${student.name}"></td>
			</tr>
			<tr>
				<td>Roll Number</td>
				<td><input type="number" name="rollNo" value="${student.rollNo}"></td>
			</tr>
			<tr>
				<td>Year of Joining</td>
				<td><input type="text" name="yoj" value="${student.yoj}"></td>
			</tr>
			<tr>
				<td>Course ID</td>
				<td><input type="number" name="course.courseid" value="${student.course.courseid}"></td>
			</tr>
			<tr>
				<td>Course Name</td>
				<td><input type="text" name="course.coursename" value="${student.course.coursename}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="update Student"></td>
			</tr>
		</table>
	</form>
</body>
</html>