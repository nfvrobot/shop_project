<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="lib-content.jsp"%>
<form action="${pageContext.request.contextPath}/language">
    <label>
        <select class="btn btn-default dropdown-toggle" name="lang" onchange="submit()">
            <option value="en_US" ${sessionScope.language eq 'en_US' ? 'selected' : ''}>English</option>
            <option value="ru_RU" ${sessionScope.language eq 'ru_RU' ? 'selected' : ''}>Русский</option>
        </select>
    </label>
</form>
<p>
    <a href="fabric"> <input type="button" value="<fmt:message key="button.fabricList"/>"></a>
    <a href="guitarsList"> <input type="button" value="<fmt:message key="button.guitarList"/> "></a>
    <a href="customers"> <input type="button" value="<fmt:message key="button.customerList"/> "></a>
    <a href="logout"> <input type="button" value="<fmt:message key="button.logout"/>"></a>
</p>