<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 08/01/2021
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="girlPower" class="org.jesperancinha.jtd.jee.girl.bands.servlets.GirlPowerBean" scope="session"/>
<jsp:useBean id="leftNameServlet" class="org.jesperancinha.jtd.jee.girl.bands.servlets.LeftNameServlet"
             scope="session"/>
<jsp:useBean id="rightNameServlet" class="org.jesperancinha.jtd.jee.girl.bands.servlets.RightNameServlet"
             scope="session"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Love for JSP's</h1>
<p>application -> <%=application%>
</p>
<p>config -> <%=config%>
</p>
<p>girlPowerBean -> <%=girlPower%>
</p>
<p>Make calculation<% int a = 2; %></p>
<p>a -> <%=a%>
</p>
<p>LeftNameServlet -> <%=leftNameServlet%>
</p>
<p>You already know this but in LeftNameServlet we had <%=leftNameServlet.getSongName()%> and in the right servlet we
    had <%=rightNameServlet.getSongName()%>
</p>
<p>So the song becomes: <%=leftNameServlet.getSongName() + " " + rightNameServlet.getSongName()%>
</p>
<h2>What this exercise tells you is that you can access pretty much the same as Servlets can via JSP's and JSF's</h2>
</body>
</html>
