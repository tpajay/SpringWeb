<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Customer</title>
    <!-- had to define in MainWeb-servlet.xml: <mvc:resources mapping="/resources/**" location="/resources/" /> -->
    <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css" />' />
</head>

<body>

<div class="generic-container">
<div class="panel panel-default">
<div class="panel-heading"><span class="lead">Customer Information</span></div>

<form:form method="POST" action="/SpringWeb/addCustomer">

<div class="form-group">
	<div class="form-group row">
		<label for="example-text-input" class="col-xs-2 col-form-label">
			<spring:message code="customer.firstname"/>
		</label>
		<div class="col-xs-10">
			<form:input path="firstName" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group row">
		<label for="example-text-input" class="col-xs-2 col-form-label">
			<spring:message code="customer.lastname"/>
		</label>
		<div class="col-xs-10">
			<!-- <input class="form-control" type="text" value="last name here" id="lastName"> -->
			<form:input path="lastName" cssClass="form-control" />
		</div>
	</div>
	<div class="form-group row">
		<label for="example-text-input" class="col-xs-2 col-form-label">
			<spring:message code="customer.phone"/>
		</label>
		<div class="col-xs-10">
			<!-- <input class="form-control" type="text" value="phone number here" id="phone"> -->
			<form:input path="phone" cssClass="form-control" />
		</div>
	</div>
	<input type="submit" value="Submit"/>
</div>


</form:form>

</div>
</div>

</body>
</html>