<%--
  Created by IntelliJ IDEA.
  User: LEGION
  Date: 5/6/2021
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="desc" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html>
<head>
    <jsp:include page="head.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="navigation.jsp"/>
<decorator:body/>
<jsp:include page="footer.jsp"/>
</body>
</html>
