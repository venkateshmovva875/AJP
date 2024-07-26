<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Profile Details</title>
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
    <form action="updateProfileInfo">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${profile.name}"></td>
            </tr>
            <tr>
                <td>Contact Information</td>
                <td><input type="text" name="contactInformation" value="${profile.contactInformation}"></td>
            </tr>
            <tr>
                <td>Bio</td>
                <td><input type="text" name="bio" value="${profile.bio}"></td>
            </tr>
            <tr>
                <td>Profile Picture</td>
                <td><input type="text" name="profilePicture" value="${profile.profilePicture}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update Profile"></td>
            </tr>
        </table>
    </form>
</body>
</html>
