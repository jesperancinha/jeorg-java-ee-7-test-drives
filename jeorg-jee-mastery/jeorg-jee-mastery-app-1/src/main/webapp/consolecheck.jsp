<%@ page import="org.jesperancinha.console.consolerizer.ConsolerizerColor" %><%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 19/01/2021
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><% out.println(ConsolerizerColor.BLUE.getPText("We can also print via out. It has type %s", out.getClass().getCanonicalName())); %></p>

<p><% out.println(new java.util.Date()); %></p>

<p><%= new java.util.Date() %>
</p>

<p><a href="index.xhtml">Back</a></p>

</body>
</html>
