<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All contacts</title>
</head>
<body>
<c:if test="${not empty contacts}">
    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Birth Date_1</th>
            <th>Birth Date_2</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contacts}" var="contact">
            <tr>
                <th>${contact.firstName}</th>
                <th>${contact.lastName}</th>
                <th>${contact.birthDate}</th>
                <th><joda:format value="${contact.birthDate}" pattern="yyyy-MM-dd"/></th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:forEach items="${header.entrySet()}" var="entry">
        <ul>
            <li>
                    ${entry.key} - ${entry.value}
            </li>
        </ul>
    </c:forEach>
</c:if>
</body>
</html>
