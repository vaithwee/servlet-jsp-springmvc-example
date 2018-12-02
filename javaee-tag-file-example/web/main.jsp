<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/2
  Time: 下午9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
Your referer header: ${header.referer}
<br />
<tags:doBodyDemo>
    ${header.referer}
</tags:doBodyDemo>
<a href="viewReferer.jsp">View</a> the referer as a Session attribute.
</body>
</html>
