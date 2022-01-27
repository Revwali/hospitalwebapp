<%@page import="java.util.List"%>
<%@page import="com.ty.hospitalwebapp.dto.Adress"%>
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
<th>ADRESS</th>
<th>STATR</th>
<th>PIN</th>
<th>BRANCH</th>
</thead>
<tbody>
<%
for(Adress adress:(List<Adress>)session.getAttribute("adresses"))
{
%>	
	<tr>
	<td><%=adress.getId() %></td>
	<td><%=adress.getAdress() %></td>
	<td><%=adress.getState() %></td>
	<td><%=adress.getPin() %></td>
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