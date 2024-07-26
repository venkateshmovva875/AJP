<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Information</title>
</head>
<body>
    <h2>Profile Information</h2>
    <table border="1">
        <tr>
            <th>Profile Name</th>
            <th>Contact Information</th>
            <th>Bio</th>
            <th>Profile Picture</th>
        </tr>
        <c:forEach items="${profiles}" var="profile">
            <tr>
                <td><c:out value="${profile.name}"/></td>
                <td><c:out value="${profile.contactInformation}"/></td>
                <td><c:out value="${profile.bio}"/></td>
                <td><c:out value="${profile.profilePicture}"/></td>
            </tr>
        </c:forEach>
    </table>
    <a href="view">home</a>
</body>
</html>
