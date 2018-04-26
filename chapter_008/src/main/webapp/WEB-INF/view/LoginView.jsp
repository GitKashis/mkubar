<%--
  Created by IntelliJ IDEA.
  User: MKubar
  Date: 26.04.2018
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<c:if test="${error != ''}">
    <div style="background-color: #da2d13">
        <c:out value="${error}"/>
    </div>
</c:if>
<form action="${pageContext.servletContext.contextPatch}/signin" method="post">
    Name: <input type="text" name="login"><br/>
    Password: <input type="password" name="password"> <br/>
    <input type="submit">
</form>
</body>
</html>
