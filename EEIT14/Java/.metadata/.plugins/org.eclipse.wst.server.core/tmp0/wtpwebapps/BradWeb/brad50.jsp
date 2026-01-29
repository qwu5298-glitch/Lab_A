<%@page import="tw.brad.apis.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "Brad";
	pageContext.setAttribute("myName", name);
	
	Bike bike = new Bike();
	pageContext.setAttribute("bike", bike);
	
	Student s1 = new Student();
	s1.setName("Brad");
	s1.getBike().upSpeed().upSpeed();
	pageContext.setAttribute("student", s1);
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		MyName: ${myName }<br />
		Bike: ${bike }<hr />
		${student }<br />
		${student.name }<br />
		${student.bike }<br />
		${student.bike.speed }<br />
	</body>
</html>