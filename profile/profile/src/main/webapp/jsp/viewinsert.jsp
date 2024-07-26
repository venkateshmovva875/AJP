<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Information System</title>
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
	<h4>STUDENT ADDED SUCCESSFULLY</h4>
	<table>
	<tr>
			<td><c:out value="${student.rollNo}"/></td>
			<td><c:out value="${student.name}"/></td>
			<td><c:out value="${student.yoj}"/></td>
			<td><c:out value="${student.course.courseid}"/></td>
			<td><c:out value="${student.course.coursename}"/></td>
		</tr>
		</table>
	<h4>Select Your option</h4>
	<menu>
		<li><a href=addStudent>Add Student</a></li>
		<li><a href=DeleteStudent>Delete Student</a></li>
		<li><a href=UpdateStudent>Modify/Update Student Info</a></li>
		<li><a href=StudentDetail>Student Details</a></li>
		<li><a href=allstudentdetails>All Student Details</a></li>
		<li><a href=view>Home</a></li>
	</menu>
</body>
</html>