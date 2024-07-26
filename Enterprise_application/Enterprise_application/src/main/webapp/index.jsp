<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enterprise_application</title>
    <style>
        /* General styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
			background: rgb(2,0,36);
			background: linear-gradient(270deg, rgba(2,0,36,.3) 0%, rgba(216,73,223,1) 17%, rgba(234,227,245,1) 41%, rgba(253,243,121,1) 68%, rgba(0,212,255,1) 100%);       
        /* Container styles */
        }
        
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 20vh;
            padding: 0 50px;
			margin: 230px;
        }

        /* Header styles */
        h1 {
            color: #fff;
            margin: 20px 0;
            text-align: center;
        }

        /* Operation links styles */
        .operation-links {
            display: flex;
            justify-content: center;
            margin-top: 20px;
            
        }

        .operation-links a {
            text-decoration: none;
            padding: 12px 20px;
            background-color: #fff;
			background: rgb(251,63,121);
			background: radial-gradient(circle, rgba(251,63,121,1) 14%, rgba(236,252,70,1) 89%);            background-clip: text;
            -webkit-background-clip: text;
            border: 1px solid #007bff;
            border-radius: 5px;
            margin-right: 10px;
            transition: background-color 0.6s, border-color 0.6s;
            font-size: 16px;
        }

        .operation-links a:hover {
            background-color: #007bff;
            border-color: #007bff;
            transform: scale(1.1);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 style='background: linear-gradient(90deg, rgba(234,238,19,1) 2%, rgba(30,215,222,1) 34%, rgba(214,44,29,0.5) 74%, rgba(28,213,19,1) 95%);padding: 20px;'>Enterprise Application</h1>

        <div class="operation-links">
            <a href="create_account.jsp">Add new Customer</a>
            <a href="viewall.jsp">view all customers</a>
            <a href="delete_account.jsp">Delete Customer</a>
            <a href="update_account.jsp">Update Customer</a>
        </div>
    </div>
</body>
</html>