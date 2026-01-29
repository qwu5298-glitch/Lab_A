<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>
<c:catch var="err">
	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/iii"
		user="root"
		password="root"
	/>	
	<sql:update var="num">
		INSERT INTO cust
			(cname,tel,birthday)
		VALUES
			('AAAV','BBB','1999-01-02'),
			('AAAV','BBB','1999-01-02'),
			('AAAV','BBB','1999-01-02'),
			('AAAV','BBB','1999-01-02')
	</sql:update>
</c:catch>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${!empty err }">${err }</c:when>
			<c:otherwise>${num }</c:otherwise>
		</c:choose>
	</body>
</html>