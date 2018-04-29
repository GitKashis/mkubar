<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Please enter for in:</h2>
<c:if test="${error != ''}">
    <div style="background-color: #da2d13">
        <c:out value="${error}"/>
    </div>
</c:if>
<form method="post"
      action="${pageContext.servletContext.contextPath}/signin">
    <span>Login:</span><input type="text" name="login"> <br> <br>
    <c:if test="${incpas == 'IncorPass'}"><h4>Incorrect password!</h4></c:if>
    <span>Password:</span><input type="password" name="password"><br> <br>
    <input type="submit" value="Sign in">
</form>
</body>
</html>