<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CREATE ENCOUNTER</title>
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
	<h2>CREATE Encounter</h2>
	<form action="createEncounter" method="post">
		<table>
			<tr>
				<td><label for="branchId">BranchId:</label></td>
				<td><input type="number" id="branchId" name="branchId"
					readonly="readonly" value="<%=session.getAttribute("branchId")%>"></td>
			</tr>
			<tr>
				<td><label for="dateandtime">Date:</label></td>
				<td><input type="datetime-local" id="date" name="date"></td>
			</tr>

			<tr>
				<td><label for="reason">Reason</label></td>
				<td><input type="text" id="reason" name="reason"></td>
			</tr>
			<tr>
				<td><label for="name">Creator Name:</label></td>
				<td><input type="text" id="name" name="name"></td>
			</tr>
			<tr>
				<td><label for="name">personId</label></td>
				<td><input type="number" id="personId" name="personId" readonly="readonly" value="<%=request.getParameter("personId") %>"></td>
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