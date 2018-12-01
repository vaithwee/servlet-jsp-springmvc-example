<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/1
  Time: 下午8:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Enumeration" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<b>Http Header:</b><br />
<%--first scriptlet--%>
<%
    for (Enumeration<String> e = request.getHeaderNames(); e.hasMoreElements();) {
        String header = e.nextElement();
        out.println(header + ": " + request.getHeader(header) + "<br />");
    }
    String message = "Thank you.";
%>
<%--second scriptlet--%>
<%
    out.println(message);
%>
</body>
</html>
