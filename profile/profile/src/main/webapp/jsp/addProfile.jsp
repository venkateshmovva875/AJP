<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <h4>PROFILE INFORMATION</h4>
    <form action="addProfileInfo">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Contact Information</td>
                <td><input type="text" name="contactInformation"></td>
            </tr>
            <tr>
                <td>Bio</td>
                <td><input type="text" name="bio"></td>
            </tr>
            <tr>
                <td>Profile Picture</td>
                <td><input type="text" name="profilePicture"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Add Profile"></td>
            </tr>
        </table>
    </form>
</body>
</html>
