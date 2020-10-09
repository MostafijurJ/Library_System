<%--
  Created by IntelliJ IDEA.
  User: BS440
  Date: 10/9/2020
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <title>Successfully Deleted</title>
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

<div class="buymain" >
    <br>
    <h2  class = "sign" align="center"> Book is Successfully Deleted. </h2>
    <br> <br>
    <p align="center">Back to? <a href="welcome.jsp"> Dashboard</a></p>

</div>


</body>
</html>

