<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Doctors</title>
    <link href="./css/style.css" rel="stylesheet">
</head>
<body>
<div id="navbar">
    <a href="admindashboard">Dashboard</a>
    <a href="adddoctor.jsp">Add Doctors</a>
    <a href="viewdoctors" class="active">View Doctors</a>
    <a href="addcategory.jsp">Add Category</a>
    <a href="viewcategory">View Category</a>
    <a href="adddrugs">Add Drugs</a>
    <a href="aviewdrugs">View Drugs</a>
    <a href="adminorders">View Orders</a>
    <a href="logout">Logout</a>
</div>
<center>
    <h1>Registered Doctors</h1>
    <div class="card-grid">
        <c:forEach var="doc" items="${doctors}">
            <div class="category-card">
                <h3>${doc.name}</h3>
                <p>${doc.hospital}</p>
                <a href="deletedoctor?id=${doc.id}" class="delete-btn" onclick="return confirm('Delete this doctor?')">Delete</a>
            </div>
        </c:forEach>
    </div>
    
    <a href="adddoctor.jsp" class="btn">+ Add New Doctor</a>
</center>
</body>
</html>