<%@page import="java.util.List"%>
<%@page import="com.ty.hospitalwebapp.dto.Branch"%>
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
<%@ include file="adminnav.jsp"%>
<table border="2px">
<thead>
<th>ID</th>
<th>NAME</th>
<th>MAIL</th>
<th>PLACE</th>
<th>CREATE_ADRESS</th>
<th>VIEW_ADRESS</th>
</thead>
<tbody>
<%
for(Branch branch:(List<Branch>)session.getAttribute("branches"))
{
%>	
	<tr>
	<td><%=branch.getId() %></td>
	<td><%=branch.getName() %></td>
	<td><%=branch.getMail() %></td>
	<td><%=branch.getPlace() %></td>
	<td><a href="create_adress.jsp?branchId=<%=branch.getId() %>">create_adress</a></td>
	<td><a href="getallAdress?branchId=<%=branch.getId() %>">view_adress</a></td>
	</tr>
	
	<%
}
%>
</tbody>
</table>

<%} 
 else 
{ %>
<%@include file="login.jsp" %>
<%} %>
</body>
</html>