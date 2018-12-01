<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/1
  Time: 下午8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String tip = request.getParameter("text");
    out.println(tip);
%>
</body>
</html>
