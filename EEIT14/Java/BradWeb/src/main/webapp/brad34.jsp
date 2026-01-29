<%@page import="org.json.*"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    
   	String data = request.getParameter("data");
    System.out.println(data);  
    
    JSONObject root = new JSONObject(data);
    JSONObject params = root.getJSONObject("params");
    
    String op = root.getString("op");
    String x = params.getString("x");
    String y = params.getString("y");
    
	//-----------------------------    
    int result = 0, mod = 0;
    switch(op){
    	case "1":
    		result = Integer.parseInt(x) + Integer.parseInt(y);
    		break;
    	case "2":
    		result = Integer.parseInt(x) - Integer.parseInt(y);
    		break;
    	case "3":
    		result = Integer.parseInt(x) * Integer.parseInt(y);
    		break;
    	case "4":
    		result = Integer.parseInt(x) / Integer.parseInt(y);
    		mod = Integer.parseInt(x) % Integer.parseInt(y);
    		break;
    }
    
    
    JSONObject obj = new JSONObject();
	obj.put("result", result + (mod == 0?"":" ...... " + mod));
	
	out.print(obj);
%>