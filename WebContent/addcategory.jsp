<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add category</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
<link href="./css/style.css" rel="stylesheet" type="text/css">
<!-- <script src="./js/script.js" defer></script> -->
</head>
<body>
<div id="navbar" class="navbar">
<a href="admindashboard">Dashboard</a>
<a href="adddoctor.jsp">Add Doctors</a>
<a href="viewdoctors">View Doctors</a>
<a href="#" class="active" >Add Category</a>
<a href="viewcategory">View Category</a>
<a href="adddrugs">Add Drugs</a>
<a href="aviewdrugs">View Drugs</a>
<a href="adminorders">View Orders</a>
<a href="logout">Logout</a>
</div>
<center>
<h1>Add Category</h1>
<% String message = request.getParameter("message"); 
       String error = request.getParameter("error"); %>
    <% if (message != null) { %>
        <div style="color:green"><%= message %></div>
    <% } %>
    <% if (error != null) { %>
        <div style="color:red"><%= error %></div>
    <% } %>
<form action="addcategory" method="post" id="myform">
<table>
<tr><td><label>Enter Category name</label></td></tr>
<tr><td><input type ="text" name= "name" id="name" required></td></tr>

<tr><td></td></tr>
<tr><td><input type="submit" value="Save Category" id="submitbtn"></td></tr>
</table>
</form>
</center>
</body>
</html>