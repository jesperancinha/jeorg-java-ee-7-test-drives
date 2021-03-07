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
    String user = null;
    if (session.getAttribute("username") == null) {
        RED.printGenericLn(
                "This is a protection agains URL rewriting. Although we can add a JSESSION id to the URL, our session also determines if we are logged or not.");
        response.sendRedirect("/jee-app-2-2-wildfly-1.0.0-SNAPSHOT");
    } else
        user = (String) session.getAttribute("username");
    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName()
                    .equals("username"))
                userName = cookie.getValue();
            if (cookie.getName()
                    .equals("JSESSIONID"))
                sessionID = cookie.getValue();
        }
    } else {
        sessionID = session.getId();
    }
%>
<h3>Hi <%=userName %>, welcome to the store!</h3>
<h3>Your Session ID=<%=sessionID %>
</h3>
<h3>Your session isn't too important for this example, but we also want to make exercises with it!</h3>
<br>
User=<%=user %>
<br>
<a href="<%=response.encodeURL("checkout.jsp") %>">Checkout Page</a>
<form action="<%=response.encodeURL("LogoutGirlBandRecordStoreServlet") %>" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>