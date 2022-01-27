<%@page import="com.ty.hospitalwebapp.dto.Branch"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.usertype.LoggableUserType"%>
<%@page import="com.ty.hospitalwebapp.dao.Encounterdao"%>
<%@page import="com.ty.hospitalwebapp.dto.Encounter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%  String status=(String)session.getAttribute("status");
if(status == null){ %>
<table border="2px">
<thead>
<th>ID</th>
<th>date</th>
<th>reason</th>
<th>creator_name</th>
<th>person_id</th>
<th>branch_id</th>
<th>Orders_create</th>
<th>Orders_view</th>
</thead>
<tbody>
<%@ include file="nav.jsp" %>
<%
    int branchId=(Integer)session.getAttribute("branchId");
    String personId=request.getParameter("personId");
for(Encounter encounter: (List<Encounter>)session.getAttribute("encounters")){
	%>
	
	<tr>
	<td><%=encounter.getId() %></td>
	<td><%=encounter.getDate() %></td>
	<td><%=encounter.getReason() %></td>
	<td><%=encounter.getCreatorName() %></td>
	<td><%=personId %></td>
	<td><%=branchId %></td>
	<%
	String role=(String)session.getAttribute("role");
	if(!role.equals("user"))
	{
	%>
	<td><a href="create_order.jsp?encounterId=<%=encounter.getId() %>">create</a></td>
	<%} %>
	<td><a href="getallorders?encounterId=<%=encounter.getId() %>">view</a></td>
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