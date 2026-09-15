<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Orders</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
<link href="./css/style.css" rel="stylesheet" type="text/css">
<!-- <script src="./js/script.js" defer></script> -->
</head>
<body>
<div id="navbar" class="navbar">
<a href="uviewdrugs">View Drugs</a>
<a href="#" class="active">My Orders</a>
<a href="cart.jsp">My Cart</a>
<a href="logout">Logout</a>
</div>

<head>
    <title>My Orders</title>
</head>
<body>
<center>
<h2>My Orders</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Total</th>
        <th>Date</th>
        <th>Status</th>
    </tr>

    <c:forEach var="o" items="${orders}">
        <tr>
            <td>${o.id}</td>
            <td>${o.total_amount}</td>
            <td>${o.order_date}</td>
            <td>${o.status}</td>
        </tr>
    </c:forEach>

</table>
</center>
</body></html>