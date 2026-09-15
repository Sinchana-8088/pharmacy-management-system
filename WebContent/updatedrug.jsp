<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updaet Drug</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
<script>
function calculateFinalPrice() {
    var price = document.getElementById("price").value;
    var discount = document.getElementById("discount").value;

    price = parseFloat(price) || 0;
    discount = parseFloat(discount) || 0;

    var finalPrice = price - (price * discount / 100);

    document.getElementById("final_price").value = finalPrice.toFixed(2);
}

window.onload = function() {
    calculateFinalPrice();

    let today = new Date();
    let formatted = today.getFullYear() + "-" + 
        String(today.getMonth() + 1).padStart(2, '0') + "-" + 
        String(today.getDate()).padStart(2, '0');

    document.getElementById("last_updated").value = formatted;
};
</script>
</head>
<body>
<div id="navbar" class="navbar">
<a href="admindashboard">Dashboard</a>
<a href="adddoctor.jsp">Add Doctors</a>
    <a href="viewdoctors">View Doctors</a>
<a href="addcategory.jsp">Add Category</a>
<a href="viewdoctors">View Category</a>
<a href="adddrugs.jsp">Add Drugs</a>
<a href="aviewdrugs">View Drugs</a>
<a href="adminorders">View Orders</a>
<a href="logout">Logout</a>
</div>

<form action="update" method="post">
<center>
<h1>Update Drug</h1>

<input type="hidden" name="id" value="${drug.id}">

<table>

<!-- Drug Name (READ ONLY) -->
<tr><td><label>Drug Name</label></td></tr>
<tr><td>
<input type="text" value="${drug.name}" readonly>
</td></tr>

<!-- CATEGORY DROPDOWN -->
<tr><td><label>Categories</label></td></tr>
<tr><td>
<select name="catergory_id" required>
<option value="">--Select Category--</option>

<c:forEach var="cat" items="${category}">
<option value="${cat.id}"
<c:if test="${cat.id == drug.catergory_id}">selected</c:if>>
${cat.name}
</option>
</c:forEach>

</select>
</td></tr>

<!-- PRICE -->
<tr><td><label>Price</label></td></tr>
<tr><td>
<input type="number" id="price" name="price"
value="${drug.price}" oninput="calculateFinalPrice()" required>
</td></tr>

<!-- DISCOUNT -->
<tr><td><label>Discount (%)</label></td></tr>
<tr><td>
<input type="number" id="discount" name="discount"
value="${drug.discount}" oninput="calculateFinalPrice()" required>
</td></tr>

<!-- FINAL PRICE -->
<tr><td>Final Price</td></tr>
<tr><td>
<input type="number" id="final_price" value="${drug.final_price}" readonly>
</td></tr>

<!-- STOCK -->
<tr><td>Stock</td></tr>
<tr><td>
<input type="number" name="stock" value="${drug.stock}" required>
</td></tr>

<!-- LAST UPDATED -->
<tr><td>Last Updated</td></tr>
<tr><td>
<input type="text" id="last_updated" readonly>
</td></tr>

<tr><td>
<input type="submit" value="Update Drug" id="submitbtn">
</td></tr>

</table>
</center>
</form>
</body>
</html>