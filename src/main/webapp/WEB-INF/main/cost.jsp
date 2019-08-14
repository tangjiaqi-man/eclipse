<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人流水资费</title>
</head>
<body>
	<table border="10"  >
	<tr>
	<td>资费序号</td>
	<td>资费名称</td>
	<td>资费状态</td>
	<td>创建时间</td>
	<td>生效时间</td>
	<td>业务类型</td>
	</tr>
	<c:forEach items="${costs}" var="cost">
	<tr>
	<td>${cost.id}</td>
	<td>${cost.name}</td>
	<td>
	<c:if test="${cost.status==0 }">暂停</c:if>
	<c:if test="${cost.status==1 }">开通</c:if>
	</td>
	<td>${cost.createtime}</td>
	<td>${cost.starttime}</td>
	<td>
	<c:if test="${cost.type==2 }">临时套餐</c:if>
	<c:if test="${cost.type==3 }">月套餐</c:if>
	</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>