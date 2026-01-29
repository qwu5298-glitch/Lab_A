<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	String op = request.getParameter("op");
	String result = "";
	int r = 0, r1 = 0;
	if (x != null){
		switch(op){
			case "1":
				r = Integer.parseInt(x) + Integer.parseInt(y);
				break;
			case "2":
				r = Integer.parseInt(x) - Integer.parseInt(y);
				break;
			case "3":
				r = Integer.parseInt(x) * Integer.parseInt(y);
				break;
			case "4":
				r = Integer.parseInt(x) / Integer.parseInt(y);
				r1 = Integer.parseInt(x) % Integer.parseInt(y);
				break;
		}
		
		result += r + (r1 == 0? "" : "......" + r1);
	}else{
		x = y = op = "";
	}

%>    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<form action="brad27.jsp">
			<input name="x" value="<%= x %>" />
			<select name="op">
				<option value="1" <%= op.equals("1")?"selected":"" %>>+</option>
				<option value="2" <%= op.equals("2")?"selected":"" %>>-</option>
				<option value="3" <%= op.equals("3")?"selected":"" %>>x</option>
				<option value="4" <%= op.equals("4")?"selected":"" %>>/</option>
			</select>
			<input name="y" value="<%= y %>" />
			<input type="submit" value="=" />
			<span><%= result %></span>
		</form>				
	</body>
</html>