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
            <th>Name</th>
            <th>Contact Information</th>
            <th>Bio</th>
            <th>Profile Picture</th>
        </tr>   
        <tr>
            <td><c:out value="${profile.name}"/></td>
            <td><c:out value="${profile.contactInformation}"/></td>
            <td><c:out value="${profile.bio}"/></td>
            <td><c:out value="${profile.profilePicture}"/></td>
        </tr>       
    </table>
    <a href="view">Home</a>
</body>
</html>
