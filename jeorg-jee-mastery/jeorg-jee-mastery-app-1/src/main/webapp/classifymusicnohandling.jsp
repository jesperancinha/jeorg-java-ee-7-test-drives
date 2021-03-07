<%@ page import="org.jesperancinha.jtd.jee.mastery1.exception.NotIndieMusicException" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ page errorPage="errordetailnohandling.jsp" %>
<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 20/01/2021
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% if(true){
        throw new NotIndieMusicException("Not indie from JSP");
    } %>
</html>
