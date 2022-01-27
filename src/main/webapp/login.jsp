<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
    <style>
        body{
            background-color: rgb(150, 148, 148);
        }
        td{
            font-size: large;     
          }
        
    </style>
    <h2>ENTER CREDENTIALS</h2>
    <form action="login" method="post">
<table>
		<tr>
			<td>Email</td>
			<td><input type="text" placeholder="Enter Email" name="email" /></td>
		</tr>
        
		<tr>
			<td>Password</td>
			<td><input type="password" placeholder="Enter Password" name="password" /></td>
		</tr>
		</table>
        <br>
		<input type="submit" value="Login" />
	</form>
</body>
</body>
</html>