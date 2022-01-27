<%@page import="com.ty.hospitalwebapp.dto.Person"%>
<%@page import="com.ty.hospitalwebapp.dto.User"%>
<%@page import="java.util.List"%>
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
<thead>
<th>ID</th>
<th>NAME</td>
<th>Email</th>
<th>phone</th>
<th>gender</th>
<th>encounter</th>
<th>encounter</th>
</thead>

<%
List<Person> list=(List<Person>)request.getAttribute("list");
for(Person user: list){
	%>
	<tr>
	<td><%=user.getId() %></td>
	<td><%=user.getName() %></td>
	<td><%=user.getMail() %></td>
	<td><%=user.getPhone() %></td>
	<td><%=user.getGender() %></td>
	<% 
	String role=(String)session.getAttribute("role");
	if(!role.equals("user")) {
	%>
	<td><a href="create_encounter.jsp?personId=<%=user.getId()%>">create</a></td>
	<%} %>
	<td><a href="getallencounters?personId=<%=user.getId()%>">view</a></td>
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