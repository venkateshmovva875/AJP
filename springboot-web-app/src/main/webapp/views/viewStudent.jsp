<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>View Students</title>
</head>
<body>
    <h2>List of Students</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <!-- Add more columns if needed -->
            </tr>
        </thead>
        <tbody>
            <c:forEach var="students" items="${students}">
                <tr>
                    <td>${students.name}</td>
                    <td>${students.course}</td>
                    <td>${students.email}</td>
                    <td>${students.message}</td>
                    
                    <!-- Add more columns if needed -->
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
