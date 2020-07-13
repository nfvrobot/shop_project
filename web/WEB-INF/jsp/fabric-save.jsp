<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="lib-content.jsp"%>
<html>
<head>
    <title>Title</title>
    <%@include file="styles.jsp"%>
</head>
<body>
<%@include file="header.jsp"%><br>
    <form action="${pageContext.request.contextPath}/fabric-save" method="post">
        <label><fmt:message key="label.fabricName"/>:
            <input type="text" name="name">
        </label><br>
        <label><fmt:message key="label.fabricCountry"/>:
            <input type="text" name="country">
        </label><br>
        <input type="submit" value="<fmt:message key="button.Save"/>">
    </form>
<%@include file="footer.jsp"%><br>
</body>
</html>
