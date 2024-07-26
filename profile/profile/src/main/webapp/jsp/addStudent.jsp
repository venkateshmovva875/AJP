<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>STUDENT INFORMATION SYSTEM</h4>
	<form action="addStudentInfo">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Roll Number</td>
				<td><input type="number" name="rollNo"></td>
			</tr>
			<tr>
				<td>Year of Joining</td>
				<td><input type="text" name="yoj"></td>
			</tr>
			<tr>
				<td>Course ID</td>
				<td><input type="number" name="course.courseid"></td>
			</tr>
			<tr>
				<td>Course Name</td>
				<td><input type="text" name="course.coursename"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add Student"></td>
			</tr>
		</table>
	</form>
</body>
</html>