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
                        <form:options items="${student.countryOptions}"/>
                    </form:select>
        <br><br>
        Favorite Language:
        Java <form:radiobutton path="favoriteLanguage" value="Java"/>
        C# <form:radiobutton path="favoriteLanguage" value="C#"/>
        PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
        Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
        <br><br>
        Operating Systems:
        Linux <form:checkbox path="operatingSystem" value="Linux"/>
        MacOS <form:checkbox path="operatingSystem" value="MacOS"/>
        Windows <form:checkbox path="operatingSystem" value="Windows"/>
        <br><br>
        <input type="submit" value="submit"/>
    </form:form>

</body>
</html>
