<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%
	pageContext.setAttribute("ary", new String[]{"A","B","C","D"});
	pageContext.setAttribute("list", List.of("a","b","c","d"));
	pageContext.setAttribute("set", new HashSet(List.of("11","22","33","44")));
	pageContext.setAttribute("map", Map.of("k1","v1","k2","v2","k3","v3","k4","v4"));

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	${ary[0] }
	${ary[2] }<br />
	<c:forEach items="${ary }" var="v" varStatus="s">
		${s.index } ${v }<br />
	</c:forEach>
	<hr />
	${list[0] }
	${list[1] }<br />
	<c:forEach items="${list }" var="v" varStatus="s">
		${s.index } ${v }<br />
	</c:forEach>
	<hr />
	${map["k1"] }
	${map["k2"] }<br />
	${map.k1 }
	${map.k2 }<br />
	<c:forEach items="${map }" var="v" varStatus="s">
		${s.index } ${v.key } : ${v.value }<br />
	</c:forEach>
	<hr />
	<c:forEach items="${set }" var="v" varStatus="s">
		${s.index } ${v }<br />
	</c:forEach>
	
	</body>
</html>