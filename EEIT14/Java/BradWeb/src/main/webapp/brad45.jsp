<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.brad.apis.*" %>
<%
	Member member1 = new Member();
	member1.setId(1L); 
	member1.setEmail("brad@brad.tw");
	member1.setName("Brad");
	pageContext.setAttribute("member1", member1);
	
	Bike bike = new Bike();
	bike.upSpeed().upSpeed().upSpeed().upSpeed();
	pageContext.setAttribute("b1", bike);
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
	${Math.random() }<br />
	${Math.PI }<br />
	${member2 }<br />
	${member1 }<br />
	${b1 }
	</body>
</html>