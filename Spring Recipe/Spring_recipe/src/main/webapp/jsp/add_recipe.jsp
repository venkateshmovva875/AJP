<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Recipe</title>
    <!-- Bootstrap CSS -->
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
    
    <div class="container mt-5">
        <h2>Create Recipe</h2>
        <form action="addToDB" method="POST">
            <div class="form-group">
                <label for="recipeName">Recipe Name</label>
                <input type="text" class="form-control" id="recipeName" name="recipe_name" required>
            </div>
            <div class="form-group">
                <label for="ingredients">Ingredients</label>
                <textarea class="form-control" id="ingredients" name="ingredients" rows="3" required></textarea>
            </div>
            <div class="form-group">
                <label for="steps">Steps</label>
                <textarea class="form-control" id="steps" name="steps" rows="3" required></textarea>
            </div>
            <div class="form-group">
                <label for="cookingTime">Cooking Time</label>
                <input type="text" class="form-control" id="cookingTime" name="cooking_time" required>
            </div>
            <div class="form-group">
                <label for="servingSize">Serving Size</label>
                <input type="number" class="form-control" id="servingSize" name="Serving_size" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</body>
</html>
