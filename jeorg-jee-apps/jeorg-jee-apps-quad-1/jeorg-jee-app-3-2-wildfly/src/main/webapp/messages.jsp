<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://xmlns.jcp.org/jsf/html" prefix="h" %>

<html>

<head>
    <title>Title</title>
</head>

<body>

<h1>In Spanish</h1>
<fmt:setLocale value="es"/>
<fmt:setBundle basename="org.jesperancinha.jtd.jee.spain.bundle.Bundle_Es" var="lang_es"/>
<fmt:setBundle basename="org.jesperancinha.jtd.jee.spain.bundle.Bundle" var="lang_en"/>
<fmt:bundle basename="org.jesperancinha.jtd.jee.spain.bundle.Bundle">
    <fmt:message key="count.one" bundle="${lang_es}"/><br/>
    <fmt:message key="count.two" bundle="${lang_es}"/><br/>
    <fmt:message key="count.three" bundle="${lang_es}"/><br/>
</fmt:bundle>

<h1>In English</h1>
<fmt:bundle basename="org.jesperancinha.jtd.jee.spain.bundle.Bundle">
    <fmt:message key="count.one" bundle="${lang_en}"/><br/>
    <fmt:message key="count.two" bundle="${lang_en}"/><br/>
    <fmt:message key="count.three" bundle="${lang_en}"/><br/>
</fmt:bundle>

<h1>In Spanish</h1>
<fmt:message key="count.one" bundle="${lang_es}"/><br/>
<fmt:message key="count.two" bundle="${lang_es}"/><br/>
<fmt:message key="count.three" bundle="${lang_es}"/><br/>
<p>English context:
    <jsp:text>${lang_en}</jsp:text>
</p>
<p>Spanish context:
    <jsp:text>${lang_es}</jsp:text>
</p>
<p></p>
</body>

</html>