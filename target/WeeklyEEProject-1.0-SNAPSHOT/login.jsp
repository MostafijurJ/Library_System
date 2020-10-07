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
    <title>login</title>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //http version 1.1
    response.setHeader("pragma", "no-cache"); //Http 1.0
    response.setHeader("Expires", "0"); // for proxy server
%>

<div class="main" >
    <p class="sign" align="center">Sign in</p>
    <form class="form1" action="Login" method="post">
        <input class="un " type="text" align="center" name ="username" placeholder="Username">
        <input class="pass" type="password" align="center"  name="password" placeholder="Password">
        <input type="submit" class="submit" align="center" value= "Sign in" >
    </form>
    <br>
    <p align="center"> New to this System? <a href="register.jsp">Sign up</a></p>

</div>


</body>
</html>
