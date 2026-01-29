<%@page import="org.json.*"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    
    String params = request.getParameter("params");
    System.out.print(params);
    
    JSONObject obj = new JSONObject();
	obj.put("x", 100).put("y", 33);
	
	JSONArray ary = new JSONArray();
	ary.put("Brad").put("Alex").put("Tony");
	
	obj.put("names", ary);
	out.print(obj);
%>