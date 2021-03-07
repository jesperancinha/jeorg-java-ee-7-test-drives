<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 09/01/2021
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Welcome! You are an exceptional soul fan!</h1>

<p>Request URI: ${pageContext.errorData.requestURI}</p>
<p>Servlet Name: ${pageContext.errorData.servletName}</p>
<p>Status Code: ${pageContext.errorData.statusCode}</p>
<p>Throwable: ${pageContext.errorData.throwable}</p>
</body>
</html>
