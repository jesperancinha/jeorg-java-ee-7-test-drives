<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 12/01/2021
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>I like to move it move it!</p>

<%

    final Map<String, String> kingsAndQueens = new HashMap<>();
    kingsAndQueens.put("Isabel I", "Trastámara");
    kingsAndQueens.put("Fernando V & II", "Trastámara");
    kingsAndQueens.put("Juana I", "Trastámara");
    kingsAndQueens.put("Felipe I", "Trastámara");
    request.setAttribute("kingsAndQueens", kingsAndQueens);
%>


<table>
    <tr>
        <th>Kings & Queens</th>
        <th>House</th>
    </tr>
    <c:forEach var="item" items="${kingsAndQueens}">
        <tr>
            <td>${item.key}</td>
            <td>${item.value}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
