<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
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
      xmlns:c="http://java.sun.com/jsp/jstl/core"
>
<head>
    <title>Title</title>
</head>
<body>
<h1>Classify music... the wrong way 😊. This page handles errors</h1>
<form action="wrongpopsubmit" method="GET">
    <p>Scissor Sisters - Let's have a Kiki is Pop Music</p>
    <p>Debatable, but we'll say no 😊... for now...</p>
    <input value="Submit" type="submit"/>
</form>
<form action="wrongindiesubmit" method="GET">
    <p>Kylie Minogue - All The Lovers is Indie Music</p>
    <p>We can safely say no in this case 😊..</p>
    <input value="Submit" type="submit"/>
</form>
<p><i>Try to change values and see what happens!</i></p>
<p><a href="index.xhtml">Back</a></p>
</body>
</html>
