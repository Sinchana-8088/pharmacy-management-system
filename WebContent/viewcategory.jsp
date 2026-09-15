<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Categories</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="navbar">
    <a href="admindashboard">Dashboard</a>
    <a href="adddoctor.jsp">Add Doctors</a>
    <a href="viewdoctors">View Doctors</a>
    <a href="addcategory.jsp">Add Category</a>
    <a href="#" class="active">View Category</a>
    <a href="adddrugs">Add Drugs</a>
    <a href="aviewdrugs">View Drugs</a>
    <a href="adminorders">View Orders</a>
    <a href="logout">Logout</a>
</div>
<center>
    <h1>Available Categories</h1>
    <div class="card-grid">
        <c:forEach var="cat" items="${category}">
            <div class="category-card">
                <h3>${cat.name}</h3>
                <a href="deletecategory?id=${cat.id}" class="delete-btn" onclick="return confirm('Delete this category?')">Delete</a>
            </div>
        </c:forEach>
    </div>
</center>
</body>
</html>