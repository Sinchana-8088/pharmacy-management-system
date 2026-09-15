<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="./css/style.css" rel="stylesheet" type="text/css" >
<link href="./css/style.css" rel="stylesheet" type="text/css">
<!-- <script src="./js/script.js" defer></script> -->
</head>
<body>
<div id="navbar" class="navbar">
<div class="logo">Pharma Choice</div>
<a href="index.jsp" >Home</a>
<a href="#" class="active">Login</a>
<a href="register.jsp">Register</a>
</div>
<center>
<form action="login" method="post" id="myform">
<h1>Login</h1>
<%
String msg = request.getParameter("message");
%>

<% if (msg != null) { %>
    <p style="color:green;"><%= msg %></p>
<% } %>
<table>
<tr><td><label>Login Type</label></td></tr>
<tr><td><select name="logintype" id = "logintype">
<option value="">-- select --</option>
<option value="Admin">Admin</option>
<option value="User">User</option>
</select></td></tr>

<tr><td><label>Email</label></td></tr>
<tr><td><input type ="email" name= "email" id="email" required></td></tr>

<tr><td><label>Password</label></td></tr>
<tr><td><input type ="password" name= "password" id="password" required></td></tr>

<tr><td><input type="submit" value="Login" id="submitbtn"></td></tr>
</table>
</form>
<!-- <h4>If you are a new user register here</h4> -->
<!-- <button onclick="window.location.href='register.jsp'" id="submitbtn">Register</button> -->
</center>

</body>
</html>