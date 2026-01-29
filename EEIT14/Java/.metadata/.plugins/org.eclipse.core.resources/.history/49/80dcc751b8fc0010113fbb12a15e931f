<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<jsp:useBean id="key" class="java.lang.String" scope="request"></jsp:useBean>
<jsp:useBean id="results" class="java.util.ArrayList" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Brad Big Company</h1>
		<form action="GiftSearch">
			Keyword: <input name="key" value="${param.key }" />
			<button type="submit">Search</button>
		</form>
		<hr />
		<c:choose>
			<c:when test="${empty results }">
				<div>沒有資料</div>
			</c:when>
			<c:otherwise>
				<div>共有 ${results.size() } 筆資料</div>
			</c:otherwise>
		
		</c:choose>
	</body>
</html>