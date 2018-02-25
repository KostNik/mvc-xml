<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>All contacts</title>

    <spring:message code="label_contact_list" var="contactListLabel"/>
    <spring:message code="label_contact_first_name" var="labelContactFirstName"/>
    <spring:message code="label_contact_last_name" var="labelContactLastName"/>
    <spring:message code="label_contact_birth_date" var="labelContactBirthDate"/>


    <spring:theme code="stylesheet" var="app_css"/>
    <spring:url value="/${app_css}" var="app_css_url"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${app_css_url}">

</head>
<body>
<h1>${contactListLabel}</h1>
<div>
    Languages
    <a href=${requestScope['javax.servlet.forward.request_uri']}?lang=en_US>To English</a>
    <a href=${requestScope['javax.servlet.forward.request_uri']}?lang=zh_HK>To China</a>
</div>

<c:if test="${not empty contacts}">
    <table>
        <thead>
        <tr>
            <th>${labelContactFirstName}</th>
            <th>${labelContactLastName}</th>
            <th>${labelContactBirthDate}_1</th>
            <th>${labelContactBirthDate}_2</th>
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
    <h3>Headers</h3>
    <p/>
    <ul>
        <c:forEach items="${header.entrySet()}" var="entry">
            <li>
                    ${entry.key} - ${entry.value}
            </li>
        </c:forEach>
    </ul>
    <h3>Cookies</h3>
    <h2>${spring:mvcUrl("/")}</h2>
    <p/>
    <ul>
        <c:forEach items="${cookie.entrySet()}" var="cookie">
            <li>
                    ${cookie.key} - ${cookie.value}
            </li>
        </c:forEach>
    </ul>
</c:if>

</body>
</html>
