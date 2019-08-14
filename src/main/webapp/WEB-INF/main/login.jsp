<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆页面</title>
</head>
<body>
	<form action="checkLogin.do" method="post">
	账号:<input name="name" value="${name}"/></br>
	密码:<input type="password" name="password" value="${password}"></br>
	<span style="color: red;">${message}</span></br>
	<input type="submit" value="登陆">	
	</form>
</body>
</html>