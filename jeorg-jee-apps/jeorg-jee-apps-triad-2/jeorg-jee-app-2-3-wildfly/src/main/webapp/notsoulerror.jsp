<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 08/01/2021
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <title>That's not a music of soul type</title>
</head>
<body>

<%=request.getParameter("song")%> is not of soul type!
<c:set var="exception" value="${requestScope['javax.servlet.error.exception']}"/>

<h2>We can get exception from requestScope</h2>
<p>${requestScope['javax.servlet.error.exception']}</p>
<h2>We also setup an exception variable</h2>
<p>${exception}</p>

<p>Exceprion details</p>
<ul>
    <li>Exception: <c:out value="${requestScope['javax.servlet.error.exception']}"/></li>
    <li>Exception type: <c:out value="${requestScope['javax.servlet.error.exception_type']}"/></li>
    <li>Exception message: <c:out value="${requestScope['javax.servlet.error.message']}"/></li>
    <li>Request URI: <c:out value="${requestScope['javax.servlet.error.request_uri']}"/></li>
    <li>Servlet name: <c:out value="${requestScope['javax.servlet.error.servlet_name']}"/></li>
    <li>Status code: <c:out value="${requestScope['javax.servlet.error.status_code']}"/></li>
</ul>
</body>
</html>
