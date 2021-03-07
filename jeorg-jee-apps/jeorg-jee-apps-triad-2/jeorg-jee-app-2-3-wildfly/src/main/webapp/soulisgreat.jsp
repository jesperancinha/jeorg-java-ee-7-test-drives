<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 09/01/2021
  Time: 09:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="soulexception.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="midasBean" scope="request" class="org.jesperancinha.jtd.jee.soul.beans.MidasTouch"/>
<% midasBean.midasTouchSoul(); %>;
</body>
</html>
