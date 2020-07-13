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
    <c:forEach items="${requestScope.customers}" var="customer">
        <a href="${pageContext.request.contextPath}/customer-full-info?id=${customer.id}"> ${customer.id} ${customer.firstName} ${customer.lastName}</a><br>
    </c:forEach>
</p>
<br>
<a href="customer-save"> <input type="button" value="<fmt:message key="button.createCustomer"/>"> </a>
<%@include file="footer.jsp"%>
</body>
</html>
