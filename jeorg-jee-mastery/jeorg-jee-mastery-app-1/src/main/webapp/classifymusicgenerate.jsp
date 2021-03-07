<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="errordetail.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ page import="org.jesperancinha.jtd.jee.mastery1.exception.NotPopMusicException" %>
<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 20/01/2021
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <title>Title</title>
</head>
<body>
<% if (true) {
    throw new NotPopMusicException("Not pop from JSP");
} %>
</body>
</html>
