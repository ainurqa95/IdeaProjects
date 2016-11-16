<%--
  Created by IntelliJ IDEA.
  User: ainur
  Date: 07.11.16
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Удаление </title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/user/update" method ="post">
    <table>
        <tr>
            <td align="right" >Login : </td>
            <td>
                <input type="text" name="login" value="${user.login}">
            </td>
        </tr>
        <tr>
            <td align="right" >FIO : </td>
            <td>
                <input type="text" name="fio">
            </td>
        </tr>
        <tr>
            <td align="right" >password : </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
    </table>

</form>
</body>
</html>
