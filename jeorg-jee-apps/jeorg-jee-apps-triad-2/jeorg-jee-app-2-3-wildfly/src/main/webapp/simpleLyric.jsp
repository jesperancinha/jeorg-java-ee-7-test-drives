<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 09/01/2021
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="simpleLyricBean" scope="request" class="org.jesperancinha.jtd.jee.soul.beans.Lyric">
    <jsp:setProperty name="simpleLyricBean" property="artist" value="Michael Jackson"/>
    <jsp:setProperty name="simpleLyricBean" property="lyrics" value="Rock with you all night"/>
</jsp:useBean>
<%--page is the default scope--%>
<jsp:useBean id="simpleLyricBean2" scope="page" type="org.jesperancinha.jtd.jee.soul.beans.LyricsExtended"
             class="org.jesperancinha.jtd.jee.soul.beans.Lyric">
    <jsp:setProperty name="simpleLyricBean2" property="artist" value="Donna Summer"/>
    <jsp:setProperty name="simpleLyricBean2" property="lyrics" value="She Works Hard for the Money "/>
</jsp:useBean>

<h2>This is the typed version. We cannot access superLyrics</h2>
<p><%=simpleLyricBean.getArtist()%>
</p>
<p><%=simpleLyricBean.getLyrics()%>
</p>

<h2>This is the typed version. We can access superLyrics</h2>
<p><%=simpleLyricBean2.getArtist()%>
</p>
<p><%=simpleLyricBean2.getLyrics()%>
</p>
<p><%=simpleLyricBean2.superLyrics()%>
</p>

</body>
</html>
