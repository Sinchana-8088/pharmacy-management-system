<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Orders</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
<link href="./css/style.css" rel="stylesheet" type="text/css">
<!-- <script src="./js/script.js" defer></script> -->
</head>
<body>
<div id="navbar" class="navbar">
<a href="admindashboard">Dashboard</a>
<a href="adddoctor.jsp">Add Doctors</a>
    <a href="viewdoctors">View Doctors</a>
<a href="addcategory.jsp">Add Category</a>
<a href="viewcategory">View Category</a>
<a href="adddrugs">Add Drugs</a>
<a href="aviewdrugs">View Drugs</a>
<a href="#" class="active">View Orders</a>
<a href="logout">Logout</a>
</div>
<center>
<h2>All Orders</h2>

<table border="1">
<tr>
    <th>Order ID</th>
    <th>User</th>
    <th>Total</th>
    <th>Date</th>
    <th>Status</th>
    <th>Action</th>
</tr>

<c:forEach var="o" items="${orders}">
<tr>
    <td>${o.id}</td>
    <td>${o.name}</td>
    <td>${o.total_amount}</td>
    <td>${o.order_date}</td>
    <td>${o.status}</td>
        <td>
    <form action="updatestatus" method="get">
        <input type="hidden" name="order_id" value="${o.id}"/>

        <select name="status" onchange="this.form.submit()">
            <option value="">Change</option>
            <option value="PLACED">PLACED</option>
            <option value="SHIPPED">SHIPPED</option>
            <option value="DELIVERED">DELIVERED</option>
        </select>
    </form>
</td>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>