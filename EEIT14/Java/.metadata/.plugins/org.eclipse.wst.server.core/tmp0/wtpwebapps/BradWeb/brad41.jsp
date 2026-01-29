<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.brad.apis.Member" %>
<%
	Member member1 = new Member();
	member1.setId(1L); 
	member1.setEmail("brad@brad.tw");
	member1.setName("Brad");
%>    
<jsp:useBean id="member2" class="tw.brad.apis.Member"></jsp:useBean>
<jsp:setProperty property="id" value="2" name="member2"/>
<jsp:setProperty property="email" value="alex@brad.tw" name="member2"/>
<jsp:setProperty property="name" value="Alex" name="member2"/>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Member1: <%= member1.getId() %> : <%= member1.getEmail() %> :　<%= member1.getName() %><br />
		Member2: <jsp:getProperty property="id" name="member2"/> :
		<jsp:getProperty property="email" name="member2"/> :
		<jsp:getProperty property="name" name="member2"/><br />
		<hr />
		Member2:  <%= member2.getId() %> : <%= member2.getEmail() %> :　<%= member2.getName() %><br />
		<hr />
		Member1 : <%= member1 %><br />
		Member2 : <%= member2 %><br />
		
		
	</body>
</html>