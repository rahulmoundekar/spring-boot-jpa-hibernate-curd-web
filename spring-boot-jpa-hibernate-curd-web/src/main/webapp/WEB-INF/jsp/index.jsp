<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<font color="red">${errorMessage}</font>
	<form:form method="post" action="save" commandName="user">
		Name : <form:input path="name" />
		<br>Password : <form:input path="email" />
		<input type="submit" />
	</form:form>
	<hr>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
		</tr>
		<tr>
			<c:forEach items="${list}" var="user">
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>