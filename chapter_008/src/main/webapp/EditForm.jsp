<%--
  Created by IntelliJ IDEA.
  User: MKubar
  Date: 22.04.2018
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="users.User" %>
<%@ page import="users.UserStorage" %>
<%@ page import="javafx.beans.property.MapPropertyBase" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user in DB</title>
</head>
<body>
<h1>Edit user</h1>
<form action="<%=request.getContextPath()%>/edituser" method="post">
    <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
    Name: <input type="text" name="name" value="<%=request.getParameter("name")%>"><br/>
    Login: <input type="text" name="login" value="<%=request.getParameter("login")%>"><br/>
    Email: <input type="text" name="email" value="<%=request.getParameter("email")%>"><br/>

    <input name="getpage" value="false" type="hidden">
    <input type="submit" value="Update">

</form>
</body>
</html>
