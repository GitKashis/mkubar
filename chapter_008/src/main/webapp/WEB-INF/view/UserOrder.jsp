<%--
  Created by IntelliJ IDEA.
  User: MKubar
  Date: 22.04.2018
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Store in Database</title>
</head>
<body>
<div style="height: 800px; position: relative;">
    <div style="width: 800px; position: relative;">
        <div style="position: absolute; left: 2px; width: 400px">
                <p>Add new User</p>
                <form action="${pageContext.servletContext.contextPatch}/" method="post">
                    <p style="margin: 0">Name:</p> <input type="text" name="name"> <br>
                    <p style="margin: 0">Login:</p> <input type="text" name="login"> <br>
                    <p style="margin: 0">Email:</p> <input type="email" name="email"> <br>
                    <input type="submit" value="ADD in DB">
                </form>
        </div>
    </div>

        <div style="position: absolute; top: 190px; left: auto">
            <h4>All User in Database</h4>
            <table border="1" cellspacing="0" bordercolor="black">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Login</th>
                    <th>Email</th>
                    <th>Create date</th>
                    <th>Delete user</th>
                    <th>Edit user</th>
                </tr>

                <c:forEach items="${alluser}" var="user">
                        <tr>
                            <td><c:out value="${user.id}"></c:out></td>
                            <td><c:out value="${user.name}"></c:out></td>
                            <td><c:out value="${user.login}"></c:out></td>
                            <td><c:out value="${user.email}"></c:out></td>
                            <td><c:out value="${user.createDate}"></c:out></td>

                                <td align="center" valign="middle">
                                    <form action="/deluser" method="post">
                                        <input type="hidden" name="id" value="${user.id}"/>
                                        <input type="submit" value="Delete user" style="margin: 0;">
                                    </form>
                                </td>


                                <td align="center" valign="middle">
                                    <form action="/WEB-INF/view/EditForm.jsp" method="post">
                                        <input type="hidden" name="id" value="${user.id}"/>
                                        <input type="hidden" name="name" value="${user.name}"/>
                                        <input type="hidden" name="login" value="${user.login}"/>
                                        <input type="hidden" name="email" value="${user.email}"/>
                                        <input type="hidden" name="getpage" value="true" hidden>
                                        <input type="submit" value="Edit user">
                                    </form>
                                </td>
                        </tr>
                </c:forEach>
            </table>
        </div>
</div>
</body>
</html>
