<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Recipe</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <style>
        /* Custom CSS for buttons */
        .btn-block {
            margin-bottom: 10px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
        }
        .btn-danger:hover {
            background-color: #c82333;
            border-color: #bd2130;
        }
        .btn-success {
            background-color: #28a745;
            border-color: #28a745;
        }
        .btn-success:hover {
            background-color: #218838;
            border-color: #1e7e34;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-top: 30px;
        }

        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        td a {
            color: #007bff;
            text-decoration: none;
        }

        td a:hover {
            color: #0056b3;
            text-decoration: underline;
        }

        td:last-child a {
            color: #dc3545;
        }

        td:last-child a:hover {
            color: #bd2130;
            text-decoration: underline;
        }

        .home-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
        }

        .home-link:hover {
            text-decoration: underline;
        }
        .container a {
		    color: #fff;
		    font-size: 25px;
		    text-decoration: none;
		    font-weight: bold;
		}
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a href="#"><kk style="color: pink;">Recipe</kk> <span style="color: green;">Management</span> <span style="color: orange;">System</span></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                <ul class="navbar-nav">
                	<li class="nav-item">
                        <button type="button" class="btn btn-primary mr-2" onclick="location.href='/'">Home</button>
                    </li>
                    
                    <li class="nav-item">
                        <button type="button" class="btn btn-primary mr-2" onclick="location.href='/add_recipe'">Add Recipe</button>
                    </li>
                    <li class="nav-item">
                        <button type="button" class="btn btn-primary mr-2" onclick="location.href='/view'">View All Recipes</button>
                    </li>
                    <li class="nav-item">
                        <button type="button" class="btn btn-danger mr-2" onclick="location.href='/delete_recipe'">Delete Recipe</button>
                    </li>
                    <li class="nav-item">
                        <button type="button" class="btn btn-success mr-2" onclick="location.href='/update_recipe'">Update Recipe</button>
                    </li>
                    <li class="nav-item">
                        <button type="button" class="btn btn-success" onclick="location.href='/logout'">Logout</button>
                    </li>
                </ul>
            </div>
        </div>
    </nav>



    <!-- Bootstrap JS (optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<h2>Recipes List</h2>
<table border="1">
    <tr>
        <th>id</th>
        <th>recipe_name</th>
        <th>ingredients</th>
        <th>steps</th>
        <th>cooking_time</th>
        <th>Serving_size</th>
    </tr>
    <c:forEach items="${recipes}" var="recipe">
        <tr>
            <td>${recipe.id}</td>
            <td>${recipe.recipe_name}</td>
            <td>${recipe.ingredients}</td>
            <td>${recipe.steps}</td>
            <td>${recipe.cooking_time}</td>
           <td>${recipe.serving_size}</td>
        </tr>
    </c:forEach>
</table>


<div class="container mt-5">
        <h2>Delete Recipe</h2>
        <form action="deleteToDB" method="POST">
        	<div class="form-group">
                <label for="id">Enter ID u want to Delete:</label>
                <input type="number" class="form-control" id="id" name="id" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

</body>
</html>