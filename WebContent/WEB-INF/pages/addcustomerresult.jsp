<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <title>Customer</title>
</head>
<body>

<h2>Submitted Customer Information</h2>
   <table>
    <tr>
        <td>First Name</td>
        <td>${firstName}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${lastName}</td>
    </tr>
    <tr>
        <td>Phone</td>
        <td>${phone}</td>
    </tr>
</table>

<a href="<c:url value="/showCustomers"/>">Show Customers</a>

</body>
</html>
