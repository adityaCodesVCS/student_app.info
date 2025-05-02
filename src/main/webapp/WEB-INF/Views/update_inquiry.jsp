<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Inquiry</title>
</head>
<body>
	<h2>Update Student Details</h2>
	<form action="updateInquiry" method="post">
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="<%=request.getAttribute("email")%>"></td>			
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"></td>			
			</tr>
			<tr>
				<td><input type="submit" value="Update"></td>			
			</tr>
		</table>
	</form>
</body>
</html>