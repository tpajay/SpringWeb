<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Customer List</title>
    <!-- had to define in MainWeb-servlet.xml: <mvc:resources mapping="/resources/**" location="/resources/" /> -->
    <link rel="stylesheet" href='<c:url value="/resources/css/bootstrap.css" />' />
</head>
<body>

<div class="generic-container">
<div class="panel panel-default">
<div class="panel-heading"><span class="lead">Patient List</span></div>

  <c:if test="${!empty customerList}">
  <div class="container">
   <table class="table table-hover">
    <tr
     style="background-color: teal; color: white; text-align: center;"
     height="40px">
     
     <td>First Name</td>
     <td>Last Name</td>
     <td>Address</td>
     <td>Phone</td>
     <td>Edit</td>
     <td>Delete</td>
    </tr>
    <c:forEach items="${customerList}" var="customer">
     <tr
      style="background-color: white; color: black; text-align: center;"
      height="30px">
      
      <td><c:out value="${customer.firstName}" />
      </td>
      <td><c:out value="${customer.lastName}" />
      </td>
      <td><c:out value="${customer.address1}" />
      </td>
      <td><c:out value="${customer.phone}" />
      </td>
      <td><a href="customerbyid?id=${customer.customerId}">Edit</a></td>
      <td><a href="deleteCustomer?id=${customer.customerId}">Delete1</a></td>
      <td><a href="delete/${customer.customerId}">Delete2</a></td>
      <!-- 
      <td><a href="edit?id=${customer.customerId}">Edit</a></td>
      <td><a href="delete?id=${customer.customerId}">Delete</a></td>
      -->      
     </tr>
    </c:forEach>
   </table>
   </div>
  </c:if>
  
  </div>
  </div>
  
  <a href="customer">Add Customer</a>
 
</body>
</html>