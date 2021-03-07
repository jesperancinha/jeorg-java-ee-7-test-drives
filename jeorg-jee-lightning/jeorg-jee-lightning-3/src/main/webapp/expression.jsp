<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 08/02/2021
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <jsp:useBean id="vegetables" class="org.jesperancinha.jtd.jee.vegetables.VegetableBean" scope="request"/>
    <input type="text" value="${vegetables.riceWeight}"/>
    <c:out value="${vegetables.riceWeight}"/>
    <button type="submit" value="Submit"/>
    <p>
        <a href="index.jsp">Back</a>
    </p>
</form>
</body>
</html>
