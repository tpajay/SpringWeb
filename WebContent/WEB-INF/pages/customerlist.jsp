<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer List</title>
</head>
<body>
 <center>

  <div style="color: teal; font-size: 30px">Customer List</div>

  <c:if test="${!empty customerList}">
   <table border="1" bgcolor="black" width="600px">
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
      <td><a href="edit?id=${customer.customerId}">Edit</a></td>
      <td><a href="delete?id=${customer.customerId}">Delete</a></td>
     </tr>
    </c:forEach>
   </table>
  </c:if>


  <a href="customer">Add Customer</a>
 </center>
</body>
</html>