<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/2
  Time: 下午9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="easy" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Today's date
<br />
<easy:varDemo>
    In long format : ${longDate}
    <br />
    In short format : ${shortDate}
</easy:varDemo>

</body>
</html>
