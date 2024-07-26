<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recipe Management</title>
    <!-- Bootstrap CSS -->
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
        .a{
        display: flex;
        flex-direction: row;
        gap: 7px;
        margin-left: 50px;
        margin-top: 50px;
    }
    .a div{
        background-color: #f0f0f0;
        width: 290px;
        height: 450px;
        border-radius: 15px;
        background-image: linear-gradient(rgb(178, 118, 128),rgb(219, 219, 216));
        padding: 10px;
    }
    .a div h1{
        text-align: center;
        color: rgb(185, 19, 211);
        font-weight: bold;
        text-shadow: 2px 2px #0505e3;
        text-decoration: underline  red;

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
    
    <div class="a">
            <div>
                <h1>Vision:</h1>
                <p>Our vision is to create a dynamic online hub that brings together food enthusiasts from around the world, providing a platform for sharing, discovering, and celebrating the art of cooking and culinary traditions.</p>
            </div>
            <div>
                <h1>Mission:</h1>
                <p>We are committed to building a user-centric recipe sharing website that empowers individuals to showcase their culinary creativity, learn from one another, and promote a sense of unity through the universal language of food.</p>
            </div>
            <div>
                <h1>Objective:</h1>
                <p>1) Facilitate seamless recipe sharing, encouraging a diverse range of cooks to showcase their skills and creations.</p>
                <p>2) Cultivate a global community where users can learn, adapt, and appreciate different cooking styles and ingredients.</p>
            </div>
        </div>

    <!-- Bootstrap JS (optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
