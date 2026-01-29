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
	<sql:update var="num1">
		UPDATE cust
		SET tel = '123'
		WHERE id > 12
	</sql:update>
	<sql:update var="num2">
		DELETE FROM cust
		WHERE id  >= 14
	</sql:update>
	
</c:catch>
Update: ${num1 }<br />
Delete: ${num2 }<br />