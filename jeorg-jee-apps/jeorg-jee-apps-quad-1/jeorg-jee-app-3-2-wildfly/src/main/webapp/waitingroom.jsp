<!--
Created by IntelliJ IDEA.
User: jofisaes
Date: 14/01/2021
Time: 11:01
To change this template use File | Settings | File Templates.
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Title</title></head>
<body>
<jsp:useBean id="pwr" class="org.jesperancinha.jtd.jee.spain.secure.PalaceWaitingRoom" scope="session"/>
<p>Is user a Manager? <%=pwr.isUserInRole("Manager")%>
<p>Is user a Bubu?<%=pwr.isUserInRole("Bubu")%>
</p>
</body>
</html>
