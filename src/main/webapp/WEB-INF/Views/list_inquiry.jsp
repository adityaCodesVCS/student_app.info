<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Inquiry</title>
</head>
<body>
	<h2>Inquiries</h2>
	<table>
		<tr>
			<th>
				Name
			</th>
			<th>
				Email
			</th>
			<th>
				Mobile
			</th>
			<th>
				Delete
			</th>
			<th>
				Update
			</th>
		</tr>
		<%
			ResultSet result = (ResultSet)request.getAttribute("result"); //Class Downcasting
			while(result.next()){
		%>
		<tr>
			<td>
				<%=result.getString(1) %>
			</td>
			<td>
				<%=result.getString(2) %>
			</td>
			<td>
				<%=result.getString(3) %>
			</td>
			<td>
				<a href="deleteInquiry?emailId=<%=result.getString(2)%>">Delete</a>
			</td>
			<td>
				<a href="updateInquiry?emailId=<%=result.getString(2)%>&mobile=<%=result.getString(3)%>">Update</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>