<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.12.2014
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<h1>This is SignIn page</h1>
<br>
<form action = "signIn" method="GET">
  <input type="text" name = "Login"> <br>
  <input type="text" name = "Password"><br>
  <input type="submit" name = "Submit" value="LogIn"><br>
  <p>${login}</p><br>
  <p>${password}</p><br>
</form>
</body>
</html>
