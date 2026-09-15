<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link href="./css/style.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div id="navbar" class="navbar">
<div class="logo">Pharma Choice</div>
<a href="index.jsp" >Home</a>
<a href="login.jsp">Login</a>
<a href="#" class="active">Register</a>
</div>
<center>


<form action="register" method="post" id="myform">
<h1>User Registration</h1>
<%
String msg = request.getParameter("message");
String err = request.getParameter("error");
%>

<% if (msg != null) { %>
    <p style="color:green;"><%= msg %></p>
<% } %>

<% if (err != null) { %>
    <p style="color:red;"><%= err %></p>
<% } %>
<table>
<tr><td>Name:</td><td><input type="text" name="name" required></td></tr>
<tr><td>Email:</td><td><input type="email" name="email" required></td></tr>
<tr><td>Phone:</td><td><input type="text" name="phone" required></td></tr>

<tr>
<td>Gender:</td>
<td>
<select name="gender" required>
<option value="--select--">Select</option>
<option value="MALE">Male</option>
<option value="FEMALE">Female</option>
</select>
</td>
</tr>

<tr><td>Age:</td><td><input type="number" name="age" required></td></tr>
<tr><td>Password:</td><td><input type="password" name="password" required></td></tr>
<tr><td>Address:</td><td><textarea name="address" required></textarea></td></tr>
<tr><td>Pincode:</td><td><input type="text" name="pincode" required></td></tr>

<tr><td></td><td><input type="submit" value="Register" id="submitbtn"></td></tr>
</table>
</form>
</center>
</body>
</html>