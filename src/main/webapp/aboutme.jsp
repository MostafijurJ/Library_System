<%--
  Created by IntelliJ IDEA.
  User: BS440
  Date: 10/6/2020
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details is not yet set here.. </title>
</head>
<body>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //http version 1.1
    response.setHeader("pragma", "no-cache"); //Http 1.0
    response.setHeader("Expires", "0"); // for proxy server


    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<h2>This is Mostafijur <br>

</h2>
</body>
</html>
