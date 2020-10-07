<%--
  Created by IntelliJ IDEA.
  User: BS440
  Date: 10/7/2020
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">

    <title>Register</title>
</head>
<body>

<div class="signmain" >
    <p class="sign" align="center">Sign Up</p>
    <form class="form2" action="Register" method="post">
        <input class="un " type="text" align="center" name ="username" placeholder="username">
        <input class="un " type="text" align="center" name ="email" placeholder="email">
        <input class="pass" type="password" align="center"  name="password" placeholder="password">
        <input type="submit" class="submit" align="center" value= "Register" >
    </form>
    <p align="center"> Already Have an Account? <a href="login.jsp">Sign In</a></p>
</div>

</body>
</html>
