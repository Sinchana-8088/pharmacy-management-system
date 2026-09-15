<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dbtransactions.DbTransactions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Prescription</title>
    <link href="./css/style.css" rel="stylesheet">
</head>
<body>
<center>
    <h2>Doctor Prescription Required</h2>
    <p>Please provide your doctor's details and upload the prescription to proceed.</p>
    <%
        String error = request.getParameter("error");
        if (error != null) {
    %>
        <p style="color:red;"><%= error %></p>
    <% } %>
    <form action="verifyorderprescription" method="post" enctype="multipart/form-data" id="myform">
        <table>
            <tr><td>Doctor's Full Name</td><td><input type="text" name="doctor_name" required></td></tr>
            <tr><td>Hospital Name</td><td><input type="text" name="hospital_name" required></td></tr>
            <tr><td>Upload Prescription (PDF/Image)</td><td><input type="file" name="prescription" accept="image/*,application/pdf" required></td></tr>
            <tr><td colspan="2"><input type="submit" value="Verify & Proceed to Payment" id="submitbtn"></td></tr>
        </table>
    </form>
</center>
</body>
</html>