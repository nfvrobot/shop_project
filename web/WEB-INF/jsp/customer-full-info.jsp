<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="styles.jsp"%>
</head>
<body>
<%@include file="header.jsp"%><br>
    <label>First name: ${requestScope.customer.firstName}</label><br>
    <label>Fast name: ${requestScope.customer.lastName}</label><br>
    <label>Email: ${requestScope.customer.email}</label><br>
    <label>Phone: ${requestScope.customer.phone}</label><br>
    <label>Address: ${requestScope.customer.address}</label><br>
<%@include file="footer.jsp"%>
</body>
</html>
