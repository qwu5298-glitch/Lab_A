<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<% String method=request.getMethod(); if (method.equals("GET")){ String max=request.getParameter("max"); if (max
		!=null){ out.print((int)(Math.random()*Integer.parseInt(max)+1)); }else{ out.print((int)(Math.random()*49+1)); }
		}else{ out.print("ERROR"); } %>