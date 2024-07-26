<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Information</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        h2 {
            color: #333;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        input, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 12px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Simple fade-in animation */
        @keyframes fadeIn {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }

        form {
            animation: fadeIn 0.5s ease-in-out;
        }
    </style>
</head>
<body>

    <s:form action="/pets/adddetails.action" method="post">
        <h2>Pet Information Form</h2>

        <s:textfield label="Pet Name:" key="petName" name="petName" required="true"/>
        <s:textfield label="Pet Breed:" key="petBreed" name="petBreed" required="true"/>
        <s:textfield label="Pet Age:" key="petAge" name="petAge" required="true"/>
        
        <s:select label="Pet Type:" headerKey="" headerValue="Select Pet Type" key="petType" name="petType" list="#{'Dog':'Dog', 'Cat':'Cat', 'Bird':'Bird'}" required="true"/>

        <s:submit value="Submit"/>
    </s:form>

</body>
</html>
