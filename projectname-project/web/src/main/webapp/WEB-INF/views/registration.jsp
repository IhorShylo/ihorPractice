<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.12.2014
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1><p>This is registration page</p></h1>
<form action = "registration" method="POST">
  Login: <input type="text" name = "Login"> <br>
  Password: <input type="text" name = "Password"><br>
  Confirm password <input type="text" name = "PasswordConfirm"><br>
  <input type="submit" name = "Submit" value="Registration"><br>
  <p>${login}</p><br>
  <p>${password}</p><br>
  <p>${passwordConfirm}</p><br>
</form>
</body>
</html>
