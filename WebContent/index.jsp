<%@ page import="src.Hello" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    
    
    <link rel="stylesheet" href="CSS/reset.css">

    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Montserrat:400,700'>
<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

        <link rel="stylesheet" href="CSS/style.css">

    
    
    
  </head>

  <body>
    
<div class="container">
  <div class="info">
    <h1>Login Form</h1>
  </div>
</div>
<div class="form">
  <div class="thumbnail"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/169963/hat.svg"/></div>
  <form class="register-form" name="signup" action="Hello" method="doGet">
    
    <input type="text" name="fname" placeholder="firstname" maxlength = "10"/>
    <input type="text"  name="lname" placeholder="lastname" maxlength = "10"/>
    <input type="text" name="uname" placeholder="username" maxlength = "10"/>
    <input type="password" name="pass" placeholder="password" maxlength = "15"/>
    
    <input type="email" name = "email" placeholder="email address" maxlength = "40"/>
     <label> Date of Birth</label>
            <input type="Date" name="dob"/>
  <div class="some-class">
    <input type="radio" class="radio" name = "gender" value="M" id="y" />
    <label for="M">Male</label>
    <input type="radio" class="radio" name = "gender" value="F" id="z" />
    <label for="F">Female</label>
  </div>    
    <button name = "signup">create</button>
    <p class="message">Already registered? <a href="#">Sign In</a></p>
  </form>
  <form class="login-form" name="login" action="Hello" method="doGet" >
    <input type="text"  name="unameLog" placeholder="username"/>
    <input type="password"  name="pass" placeholder="password"/>
    <button name = "login">login</button>
    <p class="message">Not registered? <a href="#">Create an account</a></p>
  </form>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="JS/index.js"></script>

    
    
    
  </body>
</html>