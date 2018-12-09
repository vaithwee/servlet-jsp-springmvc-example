<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/9
  Time: 上午9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/mail" method="post">
    From:<input type="text" name="from" /><br />
    Password:<input type="text" name="password" /><br />
    To:<input type="text" name="to" /><br />
    Object:<input type="text" name="object" /><br />
    Content:<input type="text" name="content" /><br />
    <input type="submit" value="Post">
</form>
</body>
</html>
