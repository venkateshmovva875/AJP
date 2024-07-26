<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Information Form</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">

    <style>
        .form-group {
            margin-bottom: 10px;
        }

        .form-control {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .btn-primary {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            padding: 10px 20px;
            cursor: pointer;
        }

        .btn-primary:hover {
            background-color: #0069d9;
        }

        .action-buttons {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .action-buttons button {
            margin: 0 10px;
        }

        #alertContainer {
            display: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Student Information Form</h1>

        <div class="action-buttons">
            <button type="button" class="btn btn-primary" onclick="navigateTo('/addStudent')">Add Student</button>
            <button type="button" class="btn btn-primary" onclick="navigateTo('/updateStudent')">Update Student</button>
            <button type="button" class="btn btn-primary" onclick="navigateTo('/deleteStudent')">Delete Student</button>
			<button type="button" class="btn btn-primary" onclick="navigateTo('/students/viewSStudents')">View Students</button>
        </div>

        <form action="#" id="studentForm">
            <!-- Your form content remains the same -->
        </form>

        <div id="alertContainer"></div>

        <script>
            function navigateTo(page) {
                window.location.href = page;
            }
        </script>
    </div>
</body>
</html>
