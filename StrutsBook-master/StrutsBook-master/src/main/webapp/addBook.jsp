<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
    <style>
        /* Add your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            background-image:url("https://c4.wallpaperflare.com/wallpaper/285/640/905/library-books-interior-monastery-wallpaper-preview.jpg");
            background-repeat: no-repeat;
            background-attachment: fixed; 
            background-size: 100% 100%;
        }
        h1 {
            color: #333;
            text-align: center;
            padding: 20px 0;
            background-color: orange;
            color: #fff;
            margin: 0;
        }
        .form-container {
            width: 50%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
            overflow: hidden;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-group input[type="text"], .form-group input[type="date"], .form-group input[type="number"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .form-group input[type="submit"] {
            background-color: orange;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-group input[type="submit"]:hover {
            background-color: #FF8C00;
        }
    </style>
</head>
<body>
    <h1>Add Book</h1>

    <div class="form-container">
        <form action="addBookAction" method="post">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" name="book.title" required />
            </div>
            <div class="form-group">
                <label for="author">Author:</label>
                <input type="text" name="book.author" required />
            </div>
            <div class="form-group">
                <label for="isbn">ISBN:</label>
                <input type="number" name="book.isbn" required />
            </div>
            <div class="form-group">
                <label for="genre">Genre:</label>
                <input type="text" name="book.genre" required />
            </div>
            <div class="form-group">
                <label for="copiesAvailable">Copies Available:</label>
                <input type="number" name="book.numCopies" required />
            </div>
            <div class="form-group">
                <input type="submit" value="Add Book" />
            </div>
        </form>
    </div>
</body>
</html>
