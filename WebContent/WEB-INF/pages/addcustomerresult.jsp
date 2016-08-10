<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
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
</body>
</html>
