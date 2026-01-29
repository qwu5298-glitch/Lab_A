<%@tag import="org.apache.taglibs.standard.tag.common.xml.JSTLXPathNamespaceContext"%>
<%@ attribute name="pname" required="true" type="java.lang.String" %>
<%@ attribute name="price" required="false" type="java.lang.Double" %>
<%
	String pname = (String)jspContext.getAttribute("pname");
	Double price = (Double)jspContext.getAttribute("price");
	out.print(pname + ":" + price);
%>