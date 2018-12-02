<%@ tag import="java.util.Date" %>
<%@ tag import="java.text.DateFormat" %>
<%@ variable name-given="longDate" %>
<%@ variable name-given="shortDate" %>
<%
    Date date = new Date(System.currentTimeMillis());
    DateFormat format = DateFormat.getDateInstance(DateFormat.LONG);
    DateFormat sformat = DateFormat.getDateInstance(DateFormat.SHORT);
    jspContext.setAttribute("longDate", format.format(date));
    jspContext.setAttribute("shortDate", sformat.format(date));
%>
<jsp:doBody />