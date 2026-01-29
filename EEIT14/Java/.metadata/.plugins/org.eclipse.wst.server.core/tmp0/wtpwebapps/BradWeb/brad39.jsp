<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String x = request.getParameter("x");
	int lottery = (Integer)request.getAttribute("lottery");
%>    
<div>I am brad39</div>
<div>x = <%= x %></div>
<div>lottery = <%= lottery %></div>