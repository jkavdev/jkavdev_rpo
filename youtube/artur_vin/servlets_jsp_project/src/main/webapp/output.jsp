<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>

	<h1>Your first and last name is:</h1>

	<%
		//recebendo parametros da servlet
		String firstName = (String) request.getAttribute("firstname");
		String lastName = (String) request.getAttribute("lastname");
	%>

	<table>
		<tr>
			<td>First name:</td> <td><%= firstName %></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><%= lastName %></td>
		</tr>
	</table>

</body>
</html>