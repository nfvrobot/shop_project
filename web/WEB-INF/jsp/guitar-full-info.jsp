<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="styles.jsp"%>
</head>
<body>
    <%@include file="header.jsp"%><br>
    <label>Fabric id: ${requestScope.guitar.fabricId}</label><br>
    <label>Fabric name: ${requestScope.guitar.fabricName}</label><br>
    <label>Fabric country: ${requestScope.guitar.fabricCountry}</label><br>
    <label>Name: ${requestScope.guitar.name}</label><br>
    <label>Strings: ${requestScope.guitar.strings}</label><br>
    <label>Color: ${requestScope.guitar.colorName}</label><br>
    <label>Count: ${requestScope.guitar.count}</label><br>
    <c:if test="${requestScope.guitar.count > 0}">
        <a href="guitar-buy-succ"> <input type="button" value="<fmt:message key="button.buyGuitar"/>"></a><br>
    </c:if>
    <fmt:message key="field.Sure"/>:
    <label>
        <select name="status">
            <option value="Close">Close</option>
            <option value="Open">Open</option>
            <option value="In progress">In progress</option>
        </select>
    </label><br>
        <%@include file="footer.jsp"%>
</body>
</html>
