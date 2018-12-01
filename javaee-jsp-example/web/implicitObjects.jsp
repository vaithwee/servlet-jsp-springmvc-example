<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/1
  Time: 下午6:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Enumeration" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<b>Http Header:</b><br />
<%
    for (Enumeration<String> e = request.getHeaderNames(); e.hasMoreElements();) {
        String header = e.nextElement();
        out.println(header + ": " + request.getHeader(header) + "<br />" );
    }
%>
<hr />
<%
    out.println("Buffer size: " + response.getBufferSize() );
    out.println("Session id: " + session.getId());
    out.println("Servlet name: " + config.getServletName());
    out.println("Server info" + application.getServerInfo());
%>
</body>
</html>
