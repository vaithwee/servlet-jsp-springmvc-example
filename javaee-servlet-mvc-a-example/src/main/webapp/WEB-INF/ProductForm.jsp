<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/5
  Time: 下午8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
    <form action="product_save.action" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="name">Product Name:</label>
                <input type="text" name="name" id="name" tabindex="1"/>
            </p>
            <p>
                <label for="description">Description:</label>
                <input type="text" name="description" id="description" tabindex="2"/>
            </p>
            <p>
                <label for="price">Price:</label>
                <input type="text" name="price" id="price" tabindex="3"/>
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4" />
                <input id="submit" type="submit" tabindex="5" />
            </p>
        </fieldset>
    </form>
</div>
</body>
</html>
