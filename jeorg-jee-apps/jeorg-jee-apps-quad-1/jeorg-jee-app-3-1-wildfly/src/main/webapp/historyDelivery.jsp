<%--
  Created by IntelliJ IDEA.
  User: jofisaes
  Date: 11/01/2021
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:useBean id="historySingletonDelivery" class="org.jesperancinha.jtd.jee.portugal.beans.HistorySingletonDelivery"
             scope="application"/>
<jsp:useBean id="historyStatefulDelivery" class="org.jesperancinha.jtd.jee.portugal.beans.HistoryStatefulDelivery"
             scope="session"/>
<jsp:useBean id="historyStatelessDelivery" class="org.jesperancinha.jtd.jee.portugal.beans.HistoryStatelessDelivery"
             scope="request"/>

<jsp:useBean id="historySingletonDeliverDefault"
             class="org.jesperancinha.jtd.jee.portugal.rest.def.scope.beans.HistorySingletonDeliveryDefault"
             scope="page"/>
<jsp:useBean id="historyStatefulDeliveryDefault"
             class="org.jesperancinha.jtd.jee.portugal.rest.def.scope.beans.HistoryStatefulDeliveryDefault"
             scope="session"/>
<jsp:useBean id="historyStatelessDeliveryDefault"
             class="org.jesperancinha.jtd.jee.portugal.rest.def.scope.beans.HistoryStatelessDeliveryDefault"
             scope="request"/>

<ul>
    <li><%=historySingletonDelivery.getLatestElementOfHistory()%>
    </li>
    <li><%=historyStatefulDelivery.getLatestElementOfHistory()%>
    </li>
    <li><%=historyStatelessDelivery.getLatestElementOfHistory()%>
    </li>
</ul>
<ul>
    <li><%=historySingletonDeliverDefault.getLatestElementOfHistory()%>
    </li>
    <li><%=historyStatefulDeliveryDefault.getLatestElementOfHistory()%>
    </li>
    <li><%=historyStatelessDeliveryDefault.getLatestElementOfHistory()%>
    </li>
</ul>

</body>
</html>
