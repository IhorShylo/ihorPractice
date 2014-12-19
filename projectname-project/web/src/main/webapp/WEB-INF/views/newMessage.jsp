<%--
  Created by IntelliJ IDEA.
  User: Яна
  Date: 19.12.14
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<h1>${customMessage}</h1><br>
<form action = "newMessage" method="GET">
  Enter your message: <input type="text" name = "SomeMessage"> <br>
  <input type="submit" name = "Submit" value="Enter"><br>
</form>
Date User Login: ${someNewMessage}<br>
</body>
</html>