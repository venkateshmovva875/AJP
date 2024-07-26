<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile Information System</title>
</head>
<style>
h4 {
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
    <h4>PROFILE ADDED SUCCESSFULLY</h4>
    <table>
        <tr>
            <td><c:out value="${profile.name}"/></td>
            <td><c:out value="${profile.contactInformation}"/></td>
            <td><c:out value="${profile.bio}"/></td>
            <td><c:out value="${profile.profilePicture}"/></td>
        </tr>
    </table>
    <h4>Select Your option</h4>
    <menu>
        <li><a href=addProfile>Add Profile</a></li>
        <li><a href=DeleteProfile>Delete Profile</a></li>
        <li><a href=UpdateProfile>Modify/Update Profile Info</a></li>
        <li><a href=ProfileDetail>Profile Details</a></li>
        <li><a href=allprofiledetails>All Profile Details</a></li>
        
        <li><a href=view>Home</a></li>
    </menu>
</body>
</html>
