<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/2
  Time: 下午10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Country List</title>
</head>
<body>
We operate in these countries:
<ul>
    <c:forEach items="${countries}" var="country">
        <li>${country.value}</li>
    </c:forEach>
</ul>
</body>
</html>
