<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/1
  Time: 下午8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="employee" class="xyz.vatih.bean.Emplotee" />
<jsp:setProperty name="employee" property="firstName" value="Abigail" />
First Name: <jsp:getProperty name="employee" property="firstName" />
</body>
</html>
