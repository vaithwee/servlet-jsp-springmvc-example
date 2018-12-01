<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/1
  Time: 下午10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
accept-language:${header['accept-language']}<br />
session id:${pageContext.session.id}<br />
employee:${requestScope.employee.name}, ${employee.address.city}<br />
capital:${capitals[employee.address.country]}
</body>
</html>
