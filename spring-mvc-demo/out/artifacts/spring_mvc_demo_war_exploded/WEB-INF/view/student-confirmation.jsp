<%--
  Created by IntelliJ IDEA.
  User: Lukasz
  Date: 23.07.2020
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
The student is confirmed: ${student.firstName} ${student.lastName} <br>
Country: ${student.country}<br>
Favourite Language: ${student.favoriteLanguage}<br>
Operating system:
    <c:forEach var="temp" items="${student.operatingSystem}">
            <li>${temp}</li>
        </c:forEach>
<br>
</body>
</html>
