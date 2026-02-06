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
<c:choose>
	<c:when test="${BCrypt.checkpw(param.passwd, rs.rows[0].passwd) }">
		<%
			Result result = (Result)pageContext.getAttribute("rs");
			SortedMap[] data = result.getRows();
			SortedMap memberMap = data[0];
			String name = (String)memberMap.get("name");
			System.out.print(name);
			
			Member member = new Member();
			member.setId((Long)memberMap.get("id"));
			member.setEmail((String)memberMap.get("email"));
			member.setName((String)memberMap.get("name"));
			
			byte[] icon = (byte[])memberMap.get("icon");
			String base64 = Base64.getEncoder().encodeToString(icon);
			member.setIconBase64(base64);
			
			session.setAttribute("member", member);
		%>
		<c:redirect url="main.jsp"></c:redirect>
	</c:when>
	<c:otherwise>
		<c:redirect url="login.html"></c:redirect>
	</c:otherwise>
</c:choose>