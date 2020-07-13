<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="lib-content.jsp"%>
<html>
<head>
    <title>Title</title>
    <%@include file="styles.jsp"%>
    <%@include file="styles.jsp"%>
</head>
<body>
<%@include file="header.jsp"%><br>
<form action="${pageContext.request.contextPath}/createGuitar" method="post">
    <fmt:message key="field.FabricId"/>:
    <label>
        <input type="text" name="fabricId">
    </label> <br>
    <fmt:message key="field.FabricName"/>:
    <label>
        <input type="text" name="name">
    </label> <br>
    <fmt:message key="field.Strings"/>:
    <label>
        <input type="text" name="strings">
    </label> <br>
    <fmt:message key="field.Color"/>:
    <label>
        <select name="color">
            <option value="RED">Red</option>
            <option value="BLACK">Black</option>
            <option value="YELLOW">Yellow</option>
            <option value="ORANGE">Orange</option>
            <option value="WHITE">White</option>
            <option value="BROWN">Brown</option>
            <option value="BLUE">Blue</option>
        </select>
    </label><br>
    <fmt:message key="filed.Count"/>:
    <label>
        <input type="text" name="count">
    </label><br>
    <input type="submit" value="<fmt:message key="button.Create"/>">
</form>
<%@include file="footer.jsp"%><br>
</body>
</html>
