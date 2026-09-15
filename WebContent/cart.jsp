<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Cart</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="navbar">
    <a href="uviewdrugs">View Drugs</a>
    <a href="myorders">My Orders</a>
    <a href="#" class="active">My Cart</a>
    <a href="logout">Logout</a>
</div>
<center>
    <h2>My Cart</h2>

    <!-- Calculate grand total using JSTL -->
    <c:set var="grandTotal" value="0" />
    <c:forEach var="c" items="${cart}">
        <c:set var="grandTotal" value="${grandTotal + (c.price * c.quantity)}" />
    </c:forEach>

    <table>
        <thead>
            <tr>
                <th>Drug</th>
                <th>Price (₹)</th>
                <th>Quantity</th>
                <th>Total (₹)</th>
                <th>Action</th>
             </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${cart}">
                <tr>
                    <td>${c.name}</td>
                    <td>${c.price}</td>
                    <td>
    <a href="updatecart?action=decrease&id=${c.id}" class="qty-btn">-</a>

    <span style="margin: 0 10px;">${c.quantity}</span>

    <a href="updatecart?action=increase&id=${c.id}" class="qty-btn">+</a>
</td>
                    <td>${c.price * c.quantity}</td>
                    <td class="card-actions">
                        <a href="removecart?id=${c.id}" class="delete-btn" onclick="return confirm('Remove this item?')">Remove</a>
                    </td>
                 </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="4" style="text-align: right;"><strong>Grand Total:</strong></td>
                <td><strong>₹ ${grandTotal}</strong></td>
             </tr>
             <tr>
                <td colspan="5" style="text-align: center;">
                    <a href="uviewdrugs" class="btn">ADD Medicine</a>
                </td>
             </tr>
            <tr>
                <td colspan="5" style="text-align: center;">
                    <a href="prescription_order.jsp" class="btn">Place Order</a>
                </td>
             </tr>
        </tfoot>
    </table>
</center>
</body>
</html>