<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CREATE PERSON</title>
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
	<h2>CREATE PERSON</h2>
	<form action="createperson" method="post">
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
				<td><input type="password" id="email" name="password"></td>
			</tr>
			<tr>
				<td><label for="phone">Contact Number:</label></td>
				<td><input type="number" id="phone" name="phone"></td>
			</tr>


			<tr>
				<td><label for="age"> Age:</label></td>
				<td><input type="number" id="age" name="age"></td>
			</tr>


			<tr>
				<td><label>Gender:</label></td>
				<td><input type="radio" name="gender" value="Male">Male
					<input type="radio" name="gender" value="Female">Female</td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="submit"></td>
			</tr>

		</table>

	</form>



</body>

<%} 
 else 
{ %>
<%@include file="login.jsp" %>
<%} %>
</body>
</html>