<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆首页</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>序列名</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>电话</th>
		</tr>
		<c:forEach var="lists" items="${list}">
			<tr>
				<td>${lists.id}</td>
				<td>${lists.name}</td>
				<td>${lists.age}</td>
				<td>${lists.phone}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>