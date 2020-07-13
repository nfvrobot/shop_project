<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%@include file="styles.jsp"%>
    <%@include file="header.jsp"%>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <fmt:message key="label.email"/> : <label>
        <input type="text" name="email">
    </label><br>
        <fmt:message key="label.password"/> : <label>
        <input type="password" name="password">
    </label><br>
        <input type="submit" value="<fmt:message key="label.login"/>">
    </form>
<a href="customer-save"> <input type="button" value="<fmt:message key="label.register"/>"> </a>
</body>
</html>
