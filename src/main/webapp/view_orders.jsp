<%@page import="java.util.List"%>
<%@page import="com.ty.hospitalwebapp.dto.Orders"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="nav.jsp" %>
<%  String status=(String)session.getAttribute("status");
if(status == null){ %>
<table border="2px">
<th>ID</th>
<th>DATE_TIME</th>
<th>CREATOR_NAME</th>
<th>MESSAGE</th>
<th>ENCOUNTER</th>
<th>VIEW_ITEMS</th>
<th>CREATE_ITEMS</th>

<%
for(Orders orders:(List<Orders>)session.getAttribute("orders"))
{
%>
<tr>
<td><%=orders.getId() %></td>
<td><%=orders.getDateTime() %></td>
<td><%=orders.getMessage() %></td>
<td><%=orders.getCreatorName() %></td>
<td><%=request.getParameter("encounterId") %></td>
<td><a href="getallItems?orderId=<%=orders.getId() %>">view</a></td>
<%
String role=(String)session.getAttribute("role");
if(!role.equals("user"))
{
%>
<td><a href="create_item.jsp?orderId=<%=orders.getId() %>">create</a></td>
<%} %>
</tr>

<%
}
%>
</table>

<%} 
 else 
{ %>
<%@include file="login.jsp" %>
<%} %>
</body>
</html>