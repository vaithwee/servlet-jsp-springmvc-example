<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/7
  Time: 下午10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Employee Form</title>
    <style type="text/css">
        @import url("<c:url value="/css/main.css" />");
    </style>
</head>
<body>
<div id="global">
    <form:form modelAttribute="employee" action="employee_save" method="post">
        <fieldset>
            <legend>Add an employee</legend>
            <p>
                <label for="firstName">First Name:</label>
                <form:input path="firstName" tabindex="1" />
            </p>
            <p>
                <label for="lastName">First Name:</label>
                <form:input path="lastName" tabindex="2" />
            </p>
            <p>
                <form:errors path="birthDate" cssClass="error" />
            </p>
            <p>
                <label for="birthDate">Birthday</label>
                <form:input path="birthDate" tabindex="3" />
            </p>
            <p id="buttons">
                <input type="reset" id="reset" tabindex="4" />
                <input type="submit" id="submit" tabindex="5" value="Add Employee" />
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
