<%--
  Created by IntelliJ IDEA.
  User: ainur
  Date: 08.11.16
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/style.css" type="text/css" media="all">
    <title>Title</title>

</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/user/UserCreate.jsp">Добавить пользователя</a>
<table border="1">
    <tr>

        <td>ФИО</td>
        <td>Логин</td>

    </tr>


    <c:forEach items="${users}" var="user" varStatus="status">
        <tr valign="top">
            <td class = "myclass"> ${user.fio}</td>
            <td>
              ${user.login}
                <a href="${pageContext.servletContext.contextPath}/user/update?id=${user.id}">Редактировать</a>
                <a href="${pageContext.servletContext.contextPath}/user/delete?id=${user.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
  ${count}
</body>
</html>
