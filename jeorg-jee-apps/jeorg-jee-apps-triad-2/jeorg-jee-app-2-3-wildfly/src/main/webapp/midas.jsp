<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 08/01/2021
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="midasBean" scope="request" class="org.jesperancinha.jtd.jee.soul.beans.MidasTouch">
    <jsp:setProperty name="midasBean" property="membera"/>
    <jsp:setProperty name="midasBean" property="memberb"/>
    <jsp:setProperty name="midasBean" property="memberc"/>
    <jsp:setProperty name="midasBean" property="memberd"/>
    <jsp:setProperty name="midasBean" property="membere"/>
    <jsp:setProperty name="midasBean" property="memberf"/>
    <jsp:setProperty name="midasBean" property="comment" param="review"/>
</jsp:useBean>
<html>
<head>
    <title>Members of the Band Midnight Star</title>
</head>
<body>
<h1>Midnight Star</h1>
<p>
    <jsp:getProperty name="midasBean" property="membera"/>
</p>
<p>
    <jsp:getProperty name="midasBean" property="memberb"/>
</p>
<p>
    <jsp:getProperty name="midasBean" property="memberc"/>
</p>
<p>
    <jsp:getProperty name="midasBean" property="memberd"/>
</p>
<p>
    <jsp:getProperty name="midasBean" property="membere"/>
</p>
<p>
    <jsp:getProperty name="midasBean" property="memberf"/>
</p>
<p>
    <jsp:getProperty name="midasBean" property="memberf"/>
</p>
<p>
    <jsp:getProperty name="midasBean" property="comment"/>
</p>
</body>
</html>
