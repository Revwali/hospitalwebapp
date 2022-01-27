<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CREATE ORDERS</title>
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
	<h2>CREATE Order</h2>
	<form action="createorders" method="post">
		<table>
			<tr>
				<td><label for="encounterId">encounterId</label></td>
				<td><input type="number" id="encounterId" name="encounterId" value="<%=request.getParameter("encounterId")%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td><label for="dateandtime">Date And Time:</label></td>
				<td><input type="datetime-local" id="datetime" name="datetime"></td>
			</tr>

			<tr>
				<td><label for="name">Creator Name</label></td>
				<td><input type="text" id="name" name="name" value="<%=(String)session.getAttribute("userName")%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td><label for="message">message:</label></td>
				<td><input type="text" id="message" name="message"></td>
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