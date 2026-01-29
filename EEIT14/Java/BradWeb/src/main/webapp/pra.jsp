<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>
<c:catch var="err">
	<c:set var="rpp">10</c:set>
	<c:set var="total">${rs.rowCount }</c:set>
	<c:set var="totalPages">${BradUtils.calcPage(total, rpp) }</c:set>
	<c:set var="page">${empty param.page?1:param.page }</c:set>
	<c:set var="start">${(page - 1) * rpp }</c:set>
	<c:set var="prev">${page == 1?1:page -1 }</c:set>
	<c:set var="next">${page + 1 }</c:set>
	<sql:query var="rs" dataSource="jdbc/mysql">
	SELECT * FROM brand LIMIT ${start }, ${rpp }
	</sql:query>
</c:catch>	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table {border-collapse: collapse; width: 100%; }
			th, td {border: 1px solid #ccc; padding: 8px;}
		</style>
	</head>
	<body>
		<h1>Brad Big Company</h1>
		<hr />
		<a href="?page=${prev }">Prev</a> | Page: <span>${page }</span> 
		| <a href="?page=${next }">Next</a>
		<hr />
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Star</th>
				<th>Feature</th>
			</tr>
			<c:forEach items="${rs.rows }" var="food">
				<tr>
					<td>${food.id }</td>
					<td>${food.name }</td>
					<td>${food.star }</td>
					<td>${food.feature }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>