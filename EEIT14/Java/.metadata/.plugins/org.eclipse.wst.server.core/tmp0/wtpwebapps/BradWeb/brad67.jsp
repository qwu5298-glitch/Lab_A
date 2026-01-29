<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.brad.apis.*" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>    
<c:catch var="err">
	<sql:query var="rs" dataSource="northwind">
		SELECT 
			o.OrderDate, e.LastName, c.CompanyName, c.ContactName,
		    od.ProductID, p.ProductName, od.UnitPrice, od.Quantity
		FROM `orders` o
		JOIN employees e ON o.EmployeeID = e.EmployeeID
		JOIN customers c ON o.CustomerID = c.CustomerID
		JOIN orderdetails od ON o.OrderID = od.OrderID
		JOIN products p ON od.ProductID = p.ProductID
		WHERE o.OrderID = ?	
		<sql:param>${param.orderId }</sql:param>
	</sql:query>
	${BradUtils.order2JSON(rs.rows) }
</c:catch>
${err }