<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://xmlns.jcp.org/jsf/html" prefix="h" %>

<html>

<head>
    <title>Title</title>
</head>

<body>
<% session.invalidate(); %>
You've been logged out!
</body>

</html>