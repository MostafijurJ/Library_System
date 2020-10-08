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
    <title>dashboard</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">

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

<div class="main">
    <p class="sign" align="center">Welcome to Dashboard</p>

    <div class="form1">
        <br><br><br>
        <a href="books.jsp" class=" form1 submit"> Buy Book</a> <br><br><br>

        <form action="View_BookServlet" class="form1" method="post">
            <input type="submit" class="submit" value="View Book">
        </form>

        <form action="Logout" class="form1" method="post">
            <input type="submit" class="submit" value="Sign Out">
        </form>

    </div>
</div>

</body>
</html>
