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
	<sql:query var="rs">
		SELECT * FROM gift LIMIT 10
	</sql:query>
</c:catch>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		資料筆數: ${rs.rowCount }<br />
		<!--  rs.rows => [Map,Map,Map,....]  -->
		<table border="1" width="100%">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Tel</th>
				<th>Address</th>
			</tr>
			
			<c:forEach items="${rs.rows }" var="gift">
				<tr>
					<td>${gift.id }</td>
					<td>${gift.name }</td>
					<td>${gift.tel }</td>
					<td>${gift.addr }</td>
					<td><img src="${gift.picurl }" width="160px" height="90px" /></td>
				</tr>
			</c:forEach>
			
		</table>
		
		
		
		
	</body>
</html>