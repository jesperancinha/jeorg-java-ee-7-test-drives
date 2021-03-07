<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>

<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 20/01/2021
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: red">ERROR Handled!</h1>
<c:set var="exception" value="${requestScope['javax.servlet.error.exception']}"/>
<p>${exception.toString()}</p>
<p><a href="http://localhost:8080/jee-mastery-app-1-1.0.0-SNAPSHOT/index.xhtml">Back to Index and login again</a></p>
</body>
</html>
