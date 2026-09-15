<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Drug</title>
<link href="./css/style.css" rel="stylesheet" type="text/css">
<link href="./css/style.css" rel="stylesheet" type="text/css">
<!-- <script src="./js/script.js" defer></script> -->

<script>
function calculateFinalPrice() {
    var price = document.getElementById("price").value;
    var discount = document.getElementById("discount").value;

    price = parseFloat(price) || 0;
    discount = parseFloat(discount) || 0;

    var finalPrice = price - discount;

    if (finalPrice < 0) {
        finalPrice = 0;
    }

    document.getElementById("final_price").value = finalPrice.toFixed(2);
}
window.onload = function() {
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
<a href="viewcategory">View Category</a>
<a href="#" class="active">Add Drugs</a>
<a href="aviewdrugs">View Drugs</a>
<a href="adminorders">View Orders</a>
<a href="logout">Logout</a>
</div>
<form action="adddrugs" method="post" id="myform">
<center>
<h1>Add New Drugs</h1>
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
<tr><td><label>Drug Name</label></td></tr>
<tr><td><input type ="text" name= "name" id="name"  required></td></tr>

<tr><td><label>Categories</label></td><tr>
<tr><td><select name="catergory_id">
<option value="">--Select Category--</option>
<c:forEach var="cat" items="${category}">
<option value="${cat.id}">${cat.name}</option>
</c:forEach>

</select></td></tr>

<tr><td><label>Price</label></td></tr>
<tr><td><input type ="number" name= "price" id="price" oninput="calculateFinalPrice()" required></td></tr>
 
<tr><td><label>Discount</label></td></tr>
<tr><td><input type ="number" name= "discount" id="discount" oninput="calculateFinalPrice()" required></td></tr>

<tr><td>Final Price</td></tr>
<tr><td><input type="number" id="final_price" readonly></td></tr>

<tr><td>Stock</td></tr>
<tr><td><input type="number" name="stock" required></td></tr>

<tr><td>Date of Added</td></tr>
<tr><td><input type="text" id="last_updated" readonly></td></tr>

<tr><td><input type="submit" value="Save Drug" id="submitbtn"></td></tr>

</table>
</center>
</form>
</body>
</html>