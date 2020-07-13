<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="lib-content.jsp"%>
<html>
<head>
    <title><fmt:message key="title.fabric"/> </title>
    <%@include file="styles.jsp"%>
</head>
<body>
    <%@include file="header.jsp"%>
    <br>
    <p>
    <c:forEach items="${requestScope.fabrics}" var="fabric">
        ${fabric.id} ${fabric.name} ${fabric.country}<br>
    </c:forEach>
    </p>
    <br>
    <a href="fabric-save"> <input type="button" value="<fmt:message key="button.createFabric"/>"> </a>
    <%@include file="footer.jsp"%>
</body>
</html>
