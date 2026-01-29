<%@page import="tw.brad.apis.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//String method = request.getMethod();
	//request.getLocale().getDisplayCountry()
	
	
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Method : ${pageContext.request.method }<br />
		${pageContext.request.locale }<br />
		${pageContext.request.locale.displayCountry }<br />
	</body>
</html>