<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete User</title>

    <!-- Include your CSS stylesheets here -->

</head>
<body>
    <div class="container">
        <h1>Delete User</h1>

        <form action="${pageContext.request.contextPath}/students/deleteuser" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter the name to delete" required>
            </div>

            <button type="submit" class="btn btn-danger">Delete User</button>
        </form>
    </div>

    <!-- Include your JavaScript scripts here -->

</body>
</html>
