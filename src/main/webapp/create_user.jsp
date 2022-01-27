<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER</title>
</head>
<body>
<body>
<body>

	<style>
body {
	background-color: rgb(191, 226, 226);
}

table, th, td {
	border-collapse: collapse;
}

th, td {
	padding: 15px;
}
</style>
</head>

<body>

<%  String status=(String)session.getAttribute("status");
if(status == null){ %>
<%@ include file="nav.jsp"%>
	<h2>CREATE USER</h2>
	<form action="createuser" method="post">
		<table>

			<tr>
				<td><label for="name">Name:</label></td>
				<td><input type="text" id="name" name="name"></td>
			</tr>

			<tr>
				<td><label for="email">Email:</label></td>
				<td><input type="email" id="email" name="email"></td>
			</tr>
			<tr>
				<td><label for="email">Password:</label></td>
				<td><input type="password" id="password" name="password"></td>
			</tr>
			<tr>
				<td><label for="role">role:</label></td>
				<td><input type="text" id="role" name="role"></td>
			</tr>
<tr>
				<td><label for="phone">Phone:</label></td>
				<td><input type="number" id="phone" name="phone"></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="submit"></td>
			</tr>

		</table>

	</form>


<%} 
 else 
{ %>
<%@include file="login.jsp" %>
<%} %>

</body>
</body>
</html>