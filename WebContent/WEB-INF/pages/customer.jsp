<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
	<link rel="stylesheet" href="./css/customer.css" type="text/css"/>
    <title>Add Customer</title>
</head>
<body>

<h2>Customer Information</h2>
<form:form method="POST" action="/HelloSpringWeb/addCustomer">
   <table>
    <tr>
        <td><form:label path="firstName"><spring:message code="customer.firstname"/></form:label></td>
        <td><form:input path="firstName" /></td>
    </tr>
    <tr>
        <td><form:label path="lastName"><spring:message code="customer.lastname"/></form:label></td>
        <td><form:input path="lastName" /></td>
    </tr>
    <tr>
        <td><form:label path="phone"><spring:message code="customer.phone"/></form:label></td>
        <td><form:input path="phone" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>
