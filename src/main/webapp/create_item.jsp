<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CREATE ITEm</title>
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
	<h2>CREATE Item</h2>
	<form action="createitem" method="post">
		<table>
			<tr>
				<td><label for="name">orderId</label></td>
				<td><input type="text" id="name" name="orderId" value="<%=request.getParameter("orderId") %>"></td>
			</tr>
			<tr>
				<td><label for="name">Name</label></td>
				<td><input type="text" id="name" name="name"></td>
			</tr>

			<tr>
				<td><label for="quantity">Quantity</label></td>
				<td><input type="number" id="quantity" name="quantity"></td>
			</tr>
			<tr>
				<td><label for="price">Price</label></td>
				<td><input type="number" id="price" name="price"></td>
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



</body>

<%} 
 else 
{ %>
<%@include file="login.jsp" %>
<%} %>
</body>
</html>