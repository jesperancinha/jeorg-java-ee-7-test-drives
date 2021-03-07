<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 19/01/2021
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sql:setDataSource var="snapshot" driver="org.postgresql.Driver"
                   url="jdbc:postgresql://localhost:5432/postgres"
                   user="postgres" password="admin"/>
<sql:query var="users" dataSource="${snapshot}">
    select * from public.users_pride
</sql:query>

<c:forEach var="row" items="${users.rows}">
    <p>${row}</p>
</c:forEach>
<p><a href="index.xhtml">Back</a></p>
</body>
</html>
