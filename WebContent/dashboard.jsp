<%@ page import="java.sql.*, dbconnectivity.DatabaseConnection" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="navbar">
    <a href="admindashboard" class="active">Dashboard</a>
    <a href="adddoctor.jsp">Add Doctors</a>
    <a href="viewdoctors">View Doctors</a>
    <a href="addcategory.jsp">Add Category</a>
    <a href="viewcategory">View Category</a>
    <a href="adddrugs">Add Drugs</a>
    <a href="aviewdrugs">View Drugs</a>
    <a href="adminorders">View Orders</a>
    <a href="logout">Logout</a>
</div>
<center>
    <h1>Admin Dashboard</h1>

    <h3>⚠️ Low Stock Drugs (Below 10)</h3>

<c:choose>

<c:when test="${empty lowStock}">
    <p style="color:green;">✅ All stocks are sufficient.</p>
</c:when>

<c:otherwise>

<div class="drug-grid">

<c:forEach var="drug" items="${lowStock}">

    <div class="drug-card">

        <h3>${drug.name}</h3>

        <p><strong>Stock:</strong> ${drug.stock}</p>

        <p style="color:red;">⚠️ Low Stock!</p>

        <a href="update?id=${drug.id}" class="update-btn">
            Restore Stock
        </a>

    </div>

</c:forEach>

</div>

</c:otherwise>

</c:choose>
</center>
</body>
</html>