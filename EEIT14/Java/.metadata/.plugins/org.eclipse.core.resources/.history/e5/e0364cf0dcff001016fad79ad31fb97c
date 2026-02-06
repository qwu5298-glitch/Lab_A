<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<c:if test="${empty member }">
	<c:redirect url="login.html"></c:redirect>
</c:if>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Brad Big Company</h1>
		<hr />
		<a href="logout.jsp">Logout</a>
		<hr />
		Welcome, ${member.name } (${member.email })<br />
		<img src="data:image/png; base64, ${member.iconBase64 }" />
	</body>
</html>