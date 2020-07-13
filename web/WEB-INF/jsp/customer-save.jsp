<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="lib-content.jsp"%>
<html>
<head>
    <title>Title</title>
    <%@include file="styles.jsp"%>
</head>
<body>
    <form action="${pageContext.request.contextPath}/customer-save" method="post">
        <label><fmt:message key="label.FirstName"/>:
            <input type="text" name="firstName">
        </label><br>
        <label><fmt:message key="label.LastName"/>:
            <input type="text" name="lastName">
        </label><br>
        <label><fmt:message key="label.email"/>:
            <input type="text" name="email">
        </label><br>
        <label><fmt:message key="label.password"/>:
            <input type="text" name="password">
        </label><br>
        <label><fmt:message key="label.Phone"/>:
            <input type="text" name="phone">
        </label><br>
        <label><fmt:message key="label.Address"/>:
            <input type="text" name="address">
        </label><br>
        <input type="submit" value="<fmt:message key="button.Save"/>">
    </form>
</body>
</html>
