<%-- 
    Document   : empLogin
    Created on : May 18, 2021, 5:03:53 AM
    Author     : egypt2
--%>


<%@page import="java.util.GregorianCalendar"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.Duration"%>
<%@page import="java.time.Instant"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import= "java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
<title>Employee Attendance</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
    #login-alert{
        width: auto;
        margin: auto;
    }
    #loginbox{
        margin-top: 150px;
        margin-bottom: 50px;
    }
    
   
    #bbt:hover{
        background:#09C;
    }
    input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  cursor:pointer;
	width:100%;
	border:none;
	background:#0492C2;
	color:#FFF;
	margin:8px 0 5px;
	padding:10px;
	font-size:15px;
}
input[type=password] {
   width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit]:hover {
  background:#09C;
}

#form {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  width: 600px;
    margin: auto;
    margin-top: 10px;
}
label{
    font-size: 13px;
    color: gray;
}
h4{
    font-style: italic;
    
    margin-left: 370px;
}
.navbar-header{
   color: blue; 
   font-size: 15px;
}
#error{
    border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  width: 600px;
    margin: auto;
    margin-top: 130px;
               
                text-align: center;
                font-size: 20px;
                font-family:sans-serif;
                font-style: italic;
                color: #ed2939;
  text-shadow: 1px 1px 2px darkred, 0 0 30px #09C, 0 0 20px red;
            }
</style>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        
</head>
<body
	style="background-image: url(bb.jpg); background-size:1860px; background-repeat: no-repeat">
	<nav class="navbar navbar-expand-sm bg-white background:#0065A2">
		<!-- Brand/logo -->
		<img src="logo.jpg" width="120px" height="70px" />&nbsp; <a
                   
			class="navbar-brand" href="empLogin.jsp"><strong><span class="glyphicon glyphicon-user"></span>&nbsp;Employee Login</strong></a> <a
			
			class="navbar-brand" href="">&nbsp;</a> <a class="navbar-brand"
			href="">&nbsp;</a> <a class="navbar-brand" href="">&nbsp;</a> <a
			class="navbar-brand" href="">&nbsp;</a> <a class="navbar-brand"
			href="">&nbsp;</a> <a class="navbar-brand" href="">&nbsp;</a> <a
			class="navbar-brand" href="">&nbsp;</a> <a class="navbar-brand"
			href="">&nbsp;</a> <a class="navbar-brand" href="">&nbsp;</a> <a
			class="navbar-brand" href="">&nbsp;</a> <a class="navbar-brand"
			href="">&nbsp;</a><a class="navbar-brand" href="">&nbsp;</a><a
			class="navbar-brand" href=""><strong><%=(new java.util.Date()).toLocaleString()%></strong></a> &nbsp; &nbsp; &nbsp; &nbsp;
                         <h4 class="navbar-header"> <strong>Hello Employees</strong></h4>
                        

		<!-- Links -->
	</nav>
                          <div id = "error"> <p>Wrong username or password </p></div>
                          <div id="form">
           
  <form action="empValidation.jsp">
      
    <label for="id">User ID</label>
    <input type="text" id="name" name="idd">
    
    <label for="uname">User Name</label>
    <input type="text" id="uname" name="uname">

    <label for="pass">Password</label>
    <input type="password" id="pass" name="pass">
    <input type="checkbox" onclick="myFunction()"><b> Show Password</b>
      
    <br>
    <input type="submit" value="Log in" onclick="return ">
  </form>
</div>
      
                         
   <script>
            $('.btn').click(function () {
                $(this).toggleClass("click");
                $('.sidebar').toggleClass("show");
            });
            $('.recru-btn').click(function () {
                $('nav ul .recru-show').toggleClass("show");
                $('nav ul .first').toggleClass("rotate");
            });
            $('.affairs-btn').click(function () {
                $('nav ul .affairs-show').toggleClass("show1");
                $('nav ul .second').toggleClass("rotate");
            });
            
            $('.eva-btn').click(function () {
                $('nav ul .eva-show').toggleClass("show2");
                $('nav ul .third').toggleClass("rotate");
            });
            $('.payroll-btn').click(function () {
                $('nav ul .pay-show').toggleClass("show3");
                $('nav ul .forth').toggleClass("rotate");
            });
            $('.employee-btn').click(function () {
                $('nav ul .emp-show').toggleClass("show4");
                $('nav ul .fifth').toggleClass("rotate");
            });
            
            $('.pro-btn').click(function () {
                $('nav ul .pro-show').toggleClass("show6");
                $('nav ul .sixth').toggleClass("rotate");
            });
            $('nav ul li').click(function () {
                $(this).addClass("active").siblings().removeClass("active");
            });
            function myFunction() {
  var x = document.getElementById("pass");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
        </script>
</body>

</html>
