<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>    
<sql:query var="rs" dataSource="northwind">
	SQL
	<sql:param>${param.orderId }</sql:param>
</sql:query>
<%
	/*
		1. param => orderId
		2. sql => ?
		3. rs => json (BradUtils)
	*/
%>