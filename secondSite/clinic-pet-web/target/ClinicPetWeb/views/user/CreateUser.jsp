<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title></title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/user/create" method="POST">
	<table>
		<tr>
			<td align="right" >FIO : </td>
			<td>
				<input type="text" name="fio">
			</td>
		</tr>
		<tr>
		<td align="right" >login  : </td>
		<td>
			<input type="text" name="login">
		</td>
	</tr>
		<tr>
			<td align="right" >password  : </td>
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