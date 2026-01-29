<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mesg = "";
	String err = request.getParameter("errType");
	if (err != null){
		switch(err){
			case "1": mesg = "Email EXIST!"; break;
			case "2": mesg = "Register Failure!"; break;
			case "3": mesg = "ERROR!"; break;
		}
	}
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script>
			function checkForm(){
				
				return true;
			}
		</script>
	</head>
	<body>
		<div><%= mesg %></div>
		<form action="Register" method="post" onsubmit="return checkForm();">
			Email: <input name="email" /><br />
			Password: <input name="passwd" type="password" /><br />
			Name: <input name="name" /><br />
			<input type="submit" value="Register" /><br />
		</form>	
	</body>
</html>