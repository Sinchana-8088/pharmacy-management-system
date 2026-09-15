<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Doctor</title>
    <link href="./css/style.css" rel="stylesheet">
</head>
<body>
<div id="navbar">
    <a href="admindashboard">Dashboard</a>
    <a href="adddoctor.jsp" class="active">Add Doctors</a>
    <a href="viewdoctors">View Doctors</a>
    <a href="addcategory.jsp">Add Category</a>
    <a href="viewcategory">View Category</a>
    <a href="adddrugs">Add Drugs</a>
    <a href="aviewdrugs">View Drugs</a>
    <a href="adminorders">View Orders</a>
    <a href="logout">Logout</a>
</div>
<center>
    <h1>Add Doctor</h1>
    <% String error = request.getParameter("error"); %>
    <% if (error != null) { %>
        <p style="color:red;"><%= error %></p>
    <% } %>
    <form action="adddoctor" method="post" id="myform">
        <table>
            <tr><td><label>Doctor Name</label></td><td><input type="text" name="name" required></td></tr>
            <tr><td><label>Hospital Name</label></td><td><input type="text" name="hospital" required></td></tr>
            <tr><td colspan="2"><input type="submit" value="Add Doctor" id="submitbtn"></td></tr>
        </table>
    </form>
</center>
</body>
</html>