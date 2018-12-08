<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/8
  Time: 下午6:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <p>${username}</p>
  <form action="/get" method="get">
    <input type="text" name="username" />
    <input type="submit" value="Get" />
  </form>
  <form action="/post" method="post">
    <input type="text" name="username" />
    <input type="submit" value="Post" />
  </form>

  </body>
</html>
