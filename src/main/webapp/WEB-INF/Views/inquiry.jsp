<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student Details</title>
</head>
<body>
	<h2>Add Student Details</h2>
	<form action="addInquiry" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>			
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"></td>			
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><input type="text" name="mobile"></td>			
			</tr>
			<tr>
				<td><input type="submit" value="Add"></td>			
			</tr>
		</table>
	</form>
	<%
		if(request.getAttribute("message")!=null) {
			out.println(request.getAttribute("message"));		
		}
	%>
</body>
</html>