<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dbtransactions.DbTransactions" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.Cart" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment</title>
    <link href="./css/style.css" rel="stylesheet">
</head>
<body>
<div id="navbar">
    <a href="payment.jsp">Payment</a>
</div>
<center>
    <h2>Order Summary & Payment</h2>
    <%
        DbTransactions db = new DbTransactions();
        String email = (String) session.getAttribute("users");
        int user_id = db.getUserIdByEmail(email);
        ArrayList<Cart> cartItems = db.getCartItems(user_id);
        double grandTotal = 0.0;
        for (Cart c : cartItems) {
            grandTotal += c.getPrice() * c.getQuantity();
        }
        request.setAttribute("cartItems", cartItems);
        request.setAttribute("grandTotal", grandTotal);
    %>
    <table border="1">
        <thead>
            <tr><th>Drug</th><th>Price (₹)</th><th>Quantity</th><th>Total (₹)</th></tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${cartItems}">
                <tr>
                    <td>${c.name}</td>
                    <td>${c.price}</td>
                    <td>${c.quantity}</td>
                    <td>${c.price * c.quantity}</td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="3" align="right"><strong>Grand Total:</strong></td>
                <td><strong>₹ ${grandTotal}</strong></td>
            </tr>
        </tfoot>
    </table>

    <h3>Select Payment Method</h3>
    <form action="placeorder" method="post">
        <select name="payment_method" required>
            <option value="">--Select--</option>
            <option value="UPI">UPI</option>
            <option value="Cash">Cash on Delivery</option>
            <option value="Card">Credit/Debit Card</option>
        </select>
        <br><br>
        <input type="submit" value="Proceed to Place Order" id="submitbtn">
    </form>
</center>
</body>
</html>