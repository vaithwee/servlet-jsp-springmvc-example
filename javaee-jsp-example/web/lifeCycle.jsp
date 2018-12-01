<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/1
  Time: 下午8:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public void jspInit() {
        System.out.println("jspInit ...");
    }
    public void jspDestroy() {
        System.out.println("jspDestroy ...");
    }
%>
<html>
<head>
    <title>jspInit and jspDestroy</title>
</head>
<body>
Overriding jspInit and jspDestroy
</body>
</html>
