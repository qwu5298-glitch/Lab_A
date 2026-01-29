<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%
//	Locale locale = request.getLocale();
//	String lang = locale.getLanguage();
//	String country = locale.getCountry();
//	pageContext.setAttribute("locale", locale);
//	pageContext.setAttribute("lang", lang + "_" + country);

//	Date now = new Date();
//	pageContext.setAttribute("now", now);
%>    

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
		<fmt:setLocale value="${pageContext.request.locale }"/><fmt:setBundle basename="res"/>
		<h1><fmt:message key="companyName"/></h1>
		<hr />
		<div><fmt:message key="hello"/>, <fmt:message key="world"/></div>
		<hr />
		<fmt:setTimeZone value="Asia/Taipei"/>
		Taiwan: <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" /><br />
		<fmt:setTimeZone value="Asia/Tokyo"/>
		Japan: <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" /><br />
		<fmt:setTimeZone value="Africa/Cairo"/>
		Egypt: <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" /><br />
		<fmt:setTimeZone value="Europe/Berlin"/>
		Egypt: <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" /><br />
		
		
		
	</body>
</html>