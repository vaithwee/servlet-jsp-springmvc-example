<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/2
  Time: 上午9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="easy" uri="http://vaith.xyz/tag" %>
<html>
<head>
    <title>Testing DataFormatterTag</title>
</head>
<body>
<easy:dataFormatter header="States" items="Alabama, Alaska, Geirgia, Florida" />
<br />
<easy:dataFormatter header="Countries">
    <jsp:attribute name="items">
        US,UK,Canada,Korea
    </jsp:attribute>
</easy:dataFormatter>
</body>
</html>
