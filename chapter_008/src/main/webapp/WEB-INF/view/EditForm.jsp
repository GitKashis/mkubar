<%--
  Created by IntelliJ IDEA.
  User: MKubar
  Date: 22.04.2018
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user in DB</title>
</head>
<body>
<h1>Edit user</h1>
<form action="${pageContext.servletContext.contextPatch}/" method="post">
    <input type="hidden" name="id" value="${user.id}">
    Name: <input type="text" name="name" value="${user.name}"><br/>
    Login: <input type="text" name="login" value="${user.login}"><br/>
    Email: <input type="text" name="email" value="${user.email}"><br/>

    <input name="getpage" value="false" type="hidden">
    <input type="submit" value="Update">

</form>
</body>
</html>
