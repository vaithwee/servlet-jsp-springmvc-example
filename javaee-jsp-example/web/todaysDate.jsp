<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page contentType="text/html;utf-8" %>
<html>
    <head>
        <title>Today's date</title>
    </head>
    <body>
    <%
        response.setCharacterEncoding("utf-8");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
        String s = dateFormat.format(new Date());
        out.print("Today is " + s);
    %>
    </body>
</html>