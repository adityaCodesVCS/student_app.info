<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Login Here</h2>
	<form action="verifyLogin" method="post">
		<table> 
			<tr>
				<td>Email Id</td>
				<td><input type="text" name="email"/></td>			 
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"/></td>			 
			</tr>
			<tr>
				<td><input type="submit" value="Login"/></td>			 
			</tr>			
		</table>
	</form>
	<%
		if(request.getAttribute("errorMessage")!=null) {
			out.println(request.getAttribute("errorMessage"));
		}		
	%>
</body>
</html>