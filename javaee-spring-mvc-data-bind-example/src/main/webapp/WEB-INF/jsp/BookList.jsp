<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/6
  Time: 下午10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
    <style type="text/css">
        @import url("<c:url value="/css/main.css" />");
    </style>
</head>
<body>
<div id="global">
    <h1>Book List</h1>
    <a href="<c:url value="/book_input"/>">Add Book</a>
    <table>
        <tr>
            <th>Category</th>
            <th>Title</th>
            <th>ISBN</th>
            <th>Author</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${books}" var="book">
            <tr>
                <th>${book.category.name}</th>
                <th>${book.title}</th>
                <th>${book.isbn}</th>
                <th>${book.author}</th>
                <th><a href="book_edit/${book.id}">Edit</a> </th>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
