<%@ page import="static org.jesperancinha.console.consolerizer.ConsolerizerColor.RED" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Login Success Page</title>
</head>
<body>
<%
    String userNameSession = null;
    String userNameCookie = null;
    if (session.getAttribute("username") == null) {
        RED.printGenericLn("This is a protection agains URL rewriting. Although we can add a JSESSION id to the URL, our session also determines if we are logged or not.");
        response.sendRedirect("/jee-app-2-2-wildfly-1.0.0-SNAPSHOT");
    } else
        userNameSession = (String) session.getAttribute("username");
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName()
                    .equals("username"))
                userNameCookie = cookie.getValue();
        }
    }
%>
<h2>You are known as  <%=userNameSession %>, in the session.</h2>
<h2>You are also known as <%=userNameCookie %>, in the cookie set.</h2>
<br>
<h3>You can now Logout of the Girl Band store!</h3>
<h4>I hope you enjoyed this exercise!</h4>
<form action="<%=response.encodeURL("LogoutGirlBandRecordStoreServlet") %>" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>