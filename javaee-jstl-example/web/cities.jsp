<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/2
  Time: 上午12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, td, tr {
            border: 1px solid #aaee77;
            padding: 3px;
        }
    </style>
</head>
<body>
Capitals
<table>
    <tr style="background: #448755;color: white;font-weight: bold;">
        <td>Country</td>
        <td>Capitals</td>
    </tr>
    <c:forEach items="${requestScope.capitals}" var="cap">
        <tr>
            <td>${cap.key}</td>
            <td>${cap.value}</td>
        </tr>
    </c:forEach>
</table>

Big Cities
<table>
    <tr style="background: #448744;color: white;font-weight: bold;">
        <td>Country</td>
        <td>Cities</td>
    </tr>
    <c:forEach items="${requestScope.bigCities}" var="cities">
        <tr>
            <td>${cities.key}</td>
            <td>
                <c:forEach items="${cities.value}" var="city" varStatus="status">
                    ${city}<c:if test="${!status.last}">,</c:if>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
