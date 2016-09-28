<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer Information</title>
    
    <!-- had to define in MainWeb-servlet.xml: <mvc:resources mapping="/resources/**" location="/resources/" /> -->
    <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css" />' />
    
    <!--
    <spring:url value="/resources/bootstrap.css" var="bootstrapCSS" />
    <link href="${bootstrapCSS}" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
    <link href="<c:url value='/app-resources/css/app.css' />" rel="stylesheet"></link>
    -->   
</head>

<body>

<h2>Customer Information</h2>

<a href="<c:url value="/showCustomers"/>">Show Customers</a>

<table class="table table-hover">
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

<br/>

<div class="generic-container">
<div class="panel panel-default">
	<div class="panel-heading"><span class="lead">Patient Records</span></div>
	<form:form method="POST" action="/SpringWeb/updateCustomer">
		<c:if test="${!empty customer.getRecords()}">
		   <table class="table table-hover">
		    <tr
		     style="background-color: teal; color: white; text-align: center;"
		     height="40px">
		     
		     <!-- <td>Record ID</td> -->
		     <td>Type</td>
		     <td>Description</td>
		     <td>Edit</td>
		     <td>Delete</td>
		    </tr>
		    <c:forEach items="${customer.getRecords()}" var="record">
		     <tr
		      style="background-color: white; color: black; text-align: center;"
		      height="30px">
		      
		      <!-- <td><c:out value="${record.getRecId()}" />
		      </td> -->
		      <td><c:out value="${record.getRecType()}" />
		      </td>
		      <td>
		      	<div class="form-group row">
		      		<!-- <label for="example-text-input" class="col-xs-2 col-form-label">Text</label> -->
		      		<div class="col-xs-10">
		      			<input class="form-control" type="text" value="<c:out value="${record.getRecDesc()}" />" id="recDesc">
		      		</div>
		      	</div>	      	
		      </td>
		      <td><a href="editrecord?id=${record.getRecId()}">Edit</a></td>
		      <td><a href="deleterecord?id=${record.getRecId()}">Delete</a></td>
		      <!-- 
		      <td><a href="edit?id=${customer.customerId}">Edit</a></td>
		      <td><a href="delete?id=${customer.customerId}">Delete</a></td>
		      -->      
		     </tr>
		    </c:forEach>
		   </table>
		  </c:if>
		<input type="submit" value="Submit"/>
	</form:form>
		
</div>
</div>

</body>
</html>