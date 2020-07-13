<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="lib-content.jsp"%>
<html>
<head>
    <title>Title</title>
    <%@include file="styles.jsp"%>
</head>
<body>
    <%@include file="header.jsp"%>
    <br>
    <p>
    <c:forEach items="${requestScope.guitars}" var="guitar">
        <a href="${pageContext.request.contextPath}/guitarFullInfo?id=${guitar.id}"> ${guitar.id} ${guitar.name}</a><br>
    </c:forEach>
    </p>
    <br>
    <a href="createGuitar"> <input type="button" value="<fmt:message key="button.createGuitar"/>"> </a>
    <%@include file="footer.jsp"%>
</body>
</html>
