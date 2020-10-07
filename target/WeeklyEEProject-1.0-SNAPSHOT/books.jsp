<%--
  Created by IntelliJ IDEA.
  User: BS440
  Date: 10/6/2020
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <title>purchase book</title>
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
    <p class="sign" align="center">Purchase Book</p>
    <p align="center">To Purchase a book you need to fill the required info. </p>

    <form class="buy" action="Book"  method="post">
        <input class="by" type="text" align="center" name ="bookname" placeholder="book name">
        <input class="by" type="text" align="center"  name="authorname" placeholder="author name">
        <input class="by" type="text" align="center"  name="version" placeholder="version">
        <input class="by" type="text" align="center"  name="price" placeholder="price">
        <input type="submit" class="submit" align="center" value= "BUY" >
    </form>
    <br>
    <p align="center">Back to? <a href="welcome.jsp"> Dashboard</a></p>

</div>


</body>
</html>
