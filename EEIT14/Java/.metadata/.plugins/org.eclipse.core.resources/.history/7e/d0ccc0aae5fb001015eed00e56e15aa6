<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:set var="x" value="10"></c:set>
		${x }<br />
		<c:set var="x" value="123" scope="request"></c:set>
		${requestScope.x }<br />
		<c:set var="y">100</c:set>
		${y }<hr />
		<c:out value="Hello, World"></c:out><br />
		param.x : ${param.x }<br />
		param.x : <c:out value="${param.x }" default="0"></c:out><br />
		<jsp:useBean id="member" class="tw.brad.apis.Member"></jsp:useBean>
		<c:set property="id" target="${member }">1</c:set>
		<c:set property="email" target="${member }">brad@brad.tw</c:set>
		<c:set property="name" target="${member }">不來的</c:set>
		${member.id }:${member.email }:${member.name }<br />
		${member }
		<hr />
		<c:remove var="member"/>
		${member }
		
		
		
		
		
		
		
		
		
	</body>
</html>