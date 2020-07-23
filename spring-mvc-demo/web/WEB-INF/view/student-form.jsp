<%--
  Created by IntelliJ IDEA.
  User: Lukasz
  Date: 23.07.2020
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Student Registration Form</title>
</head>
<body>

    <form:form action="processForm" modelAttribute="student">
        First name: <form:input path="firstName"/>
        <br><br>
        Last name: <form:input path="lastName"/>
        <br><br>
        Home country: <form:select path="country">
                        <form:option value="Brazil" label="Brazil"/>
                        <form:option value="Germany" label="Germany"/>
                        <form:option value="USA" label="USA"/>
                        <form:option value="Poland" label="Poland"/>
                    </form:select>
        <br><br>
        <input type="submit" value="submit"/>
    </form:form>

</body>
</html>