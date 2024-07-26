<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Student</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h4 {
            margin-top: 0;
            color: #333;
        }

        p {
            color: red;
        }

        table {
            width: 100%;
        }

        td {
            padding: 10px;
        }

        input[type="password"] {
            width: calc(100% - 22px); /* Adjust for padding and border */
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
    <script>
        function validateForm() {
            var password = document.getElementById("password").value;
            
            // You can add more complex validation logic here
            
            // Example: Check if the password is empty
            if (password === "") {
                alert("Password cannot be empty");
                return false;
            }
            
            // If everything is valid, allow the form to be submitted
            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <h4>STUDENT INFORMATION SYSTEM</h4>
    <h4>Update Student</h4>
    <p>User Information will only be updated if the existing password matches with the entered password</p>
    <form action="confirm" method="post" onsubmit="return validateForm()">
        <table>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" id="password"></td>
                <td><input type="submit" value="Update User"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
