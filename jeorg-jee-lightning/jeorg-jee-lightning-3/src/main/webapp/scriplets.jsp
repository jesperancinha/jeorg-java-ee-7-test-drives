<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 06/02/2021
  Time: 09:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Scriptlets</title>
</head>
<body>
<h1>JSP Exercises</h1>

<%--<p><%= out.println(LocalDateTime.now())%></p>--%>
<h2>out does work to print out directly to the page!</h2>
<p><% out.println(LocalDateTime.now()); %></p>
<h2>And so does with a scriptlet</h2>
<p><%= LocalDateTime.now() %>
</p>
<h2>System.out is legal but we don't see output in the page. Check your logs!</h2>
<p><% System.out.println(LocalDateTime.now());%></p>


<p>
    More on scriptelets:
</p>
<p>
    <a href="https://en.wikipedia.org/wiki/Scriptlet">https://en.wikipedia.org/wiki/Scriptlet</a>
</p>

<p>
    <a href="index.jsp">Back</a>
</p>

</body>
</html>
