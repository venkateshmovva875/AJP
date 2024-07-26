<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login Page in HTML with CSS Code Example</title>
  <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
 
</head>
<style>
  body {
    font-family: 'Open Sans', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f2f2f2; /* Light gray background color */
  }

  .box-form {
    display: flex;
    width: 80%;
    margin: 50px auto;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }

  .left {
    flex: 1;
    background: url('C:\Users\Acer\OneDrive\Desktop\1.jpeg') center/cover no-repeat;
    position: relative;
  }

  .left .overlay {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: #fff;
    text-align: center;
  }

  .right {
    flex: 1;
    padding: 20px;
    box-sizing: border-box;
  }

  h1 {
    margin: 0;
    font-size: 2em;
  }

  form {
    max-width: 300px;
    margin: 0 auto;
  }

  h5 {
    margin: 10px 0;
  }

  p {
    margin: 0;
  }

  .inputs input {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    box-sizing: border-box;
  }

  button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 15px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  button:hover {
    background-color: #45a049;
  }

  .remember-me--forget-password {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  input[type="checkbox"] {
    margin-right: 5px;
  }

</style>

<body>
  <div class="box-form">
    <div class="left">
      <div class="overlay">
        <h1>Student portal.</h1>
        <p></p>
        <span>
          <p>login with social media</p>
          <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
          <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i> Login with Twitter</a>
        </span>
      </div>
    </div>
    <div class="right">
      <form action="senddata" method="post">
        <!-- Use the appropriate action attribute ("/your-server-endpoint") and method (post or get) -->
        <h5>Login</h5>
        <p>Don't have an account? <a href="#">Create Your Account</a> it takes less than a minute</p>
        <div class="inputs">
          <input type="text" name="username" placeholder="user name">
          <br>
          <input type="password" name="password" placeholder="password">
        </div>
        <br><br>
        <div class="remember-me--forget-password">
          <label>
            <input type="checkbox" name="remember" checked/>
            <span class="text-checkbox">Remember me</span>
          </label>
          <p>forget password?</p>
        </div>
        <br>
        <button type="submit">Login</button>
      </form>
    </div>
  </div>
</body>

</html>
