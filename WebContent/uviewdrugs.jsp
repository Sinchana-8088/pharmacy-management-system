<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Drugs</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="navbar">
    <a href="#" class="active">View Drugs</a>
    <a href="myorders">My Orders</a>
    <a href="cart.jsp">My Cart</a>
    <a href="logout">Logout</a>
</div>

<div>
<center>

    <h1>Available Medicines</h1>
<form action="ufilterdrugs" method="get" class="filter-bar">

<select name="category">
    <option value="">All Categories</option>
    <c:forEach var="cat" items="${category}">
        <option value="${cat.id}">${cat.name}</option>
    </c:forEach>
</select>

<select name="drugId">
    <option value="">All Drugs</option>
    <c:forEach var="d" items="${allDrugs}">
        <option value="${d.id}">${d.name}</option>
    </c:forEach>
</select>

<select name="sort">
    <option value="">Sort By</option>
    <option value="asc">A-Z</option>
    <option value="desc">Z-A</option>
</select>

<button type="submit">Apply</button>

</form>
</center>
</div>

<center>
    <div class="drug-grid">
        <c:forEach var="drug" items="${drugs}">
            <div class="drug-card">
               <h3>${drug.name}</h3>

        <p><strong>Category ID:</strong> ${drug.catergory_id}</p>

        <p>
            <strong>Price:</strong><br>
            <span class="final-price">₹${drug.final_price}</span><br>
            <span class="original-price">₹${drug.price}</span>
        </p>

        <p><strong>Discount:</strong> ${drug.discount}%</p>

        <p><strong>Last Updated:</strong> ${drug.last_updated}</p>

        <p><strong>Stock:</strong> ${drug.stock}</p>
                <div class="card-actions">
                   <a href="addtocart?drug_id=${drug.id}" class="btn">Add to Cart</a>
                </div>
            </div>
        </c:forEach>
    </div>
</center>
</body>
</html>