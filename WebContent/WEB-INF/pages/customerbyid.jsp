<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<link rel="stylesheet" href="../css/customer.css" type="text/css"/>
    <title>Customer Information</title>
</head>
<body>

<h2>Customer Information</h2>

<table class="silver">
	<!-- <tr>
		<td>Customer ID:</td><td>${customer.customerId}</td>
	</tr>
	-->
	<tr>
		<td>First Name:</td><td>${customer.firstName}</td>
	</tr>
	<tr>
		<td>Last Name:</td><td>${customer.lastName}</td>
	</tr>
	<tr>
		<td>Street:</td><td>${customer.address1}</td>
	</tr>
	<tr>
		<td>City:</td><td>${customer.city}</td>
	</tr>
	<tr>
		<td>State:</td><td>${customer.state}</td>
	</tr>
	<tr>
		<td>Zipcode:</td><td>${customer.zipcode}</td>
	</tr>
	<tr>
		<td>Phone:</td><td>${customer.phone}</td>
	</tr>	
</table>


</body>
</html>
