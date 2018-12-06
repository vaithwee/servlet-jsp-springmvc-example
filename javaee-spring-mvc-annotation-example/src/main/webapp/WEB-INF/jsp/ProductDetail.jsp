<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/5
  Time: 下午8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <style type="text/css">
        @import url("<c:url value="/css/main.css" />");
    </style>
</head>
<body>
<div id="global">
    <h4>The products has been saved.</h4>
    <p>
        <h5>Details:</h5>
        Product Name: ${product.name} <br />
        Description: ${product.description} <br />
        Price: ${product.price}
    </p>
</div>
</body>
</html>
