<%@page import="java.util.List"%>
<%@page import="com.ty.hospitalwebapp.dto.Hospital"%>
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
<th>WEBSITE</th>
<th>GST</th>
<th>CREATE_BRANCH</th>
<th>VIEW_BRANCH</th>
</thead>
<tbody>
<%
for(Hospital hospital:(List<Hospital>)session.getAttribute("hospitals"))
{
%>	
	<tr>
	<td><%=hospital.getId() %></td>
	<td><%=hospital.getName() %></td>
	<td><%=hospital.getWebsite() %></td>
	<td><%=hospital.getGst() %></td>
	<td><a href="create_branch.jsp?hospitalId=<%=hospital.getId() %>">create_branch</a></td>
	<td><a href="getallbranches?hospitalId=<%=hospital.getId() %>">view_branch</a></td>
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