<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="tw.brad.apis.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.jsp.jstl.sql.*" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>
<c:if test="${empty param.email }">
	<c:redirect url="login.html"></c:redirect>
</c:if>
<sql:query var="rs" dataSource="jdbc/mysql">
	SELECT * FROM member WHERE email = ?
	<sql:param>${param.email }</sql:param>
</sql:query>
<c:if test="${rs.rowCount == 0 }">
	<c:redirect url="login.html"></c:redirect>
</c:if>

<c:set var="row" value="${rs.rows[0] }"></c:set>
<c:choose>
	<c:when test="${BCrypt.checkpw(param.passwd, row['passwd']) }">
		<jsp:useBean id="member" class="tw.brad.apis.Member" scope="session"></jsp:useBean>
		<jsp:setProperty property="id" name="member" value="${row['id'] }" />
		<jsp:setProperty property="email" name="member" value="${row['email'] }" />
		<jsp:setProperty property="name" name="member" value="${row['name'] }" />
		
		<c:redirect url="main.jsp"></c:redirect>
	</c:when>
	<c:otherwise>
		<c:redirect url="login.html"></c:redirect>
	</c:otherwise>
</c:choose>