<%@ tag body-content="scriptless" %>
<%@ attribute name="title" required="false" type="java.lang.String" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<div style="border:1px solid #ccc; padding:10px; margin:10px 0">
	<c:if test="${!empty title }">
		<div style="font-weight: bold; margin-bottom:6px;">${title }</div>
	</c:if>
	<jsp:doBody />
</div>