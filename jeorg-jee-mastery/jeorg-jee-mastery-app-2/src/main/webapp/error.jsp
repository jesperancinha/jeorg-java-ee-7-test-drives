<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 25/01/2021
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>
    Directly from exception: <%= exception %>
</p>
<p>
    Directly from getMessage: <%= exception.getMessage() %>
</p>
<p>
    Out from requestScope (Cannot resolve property or method 'javax.servlet.error.exception' (dynamic property?)). Yes. it is dynamic!: <c:out value="${requestScope['javax.servlet.error.exception']}"/>
</p>
<p>
    This won't show up (Result of 'Throwable.getMessage()' is ignored): <% exception.getMessage(); %>
</p>
<p>
    This won't show up (note that e does not exist!): <% System.out.println(exception.getMessage()); %>
</p>

<p><a href="../index.xhtml">Back</a></p>
</body>
</html>
