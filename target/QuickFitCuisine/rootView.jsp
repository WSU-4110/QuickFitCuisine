<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Root page</title>
</head>
<body>

	<div align="center">

		<form action="initialize">
			<input type="submit" value="Initialize the Database" />
		</form>
		<form action="logout" method="post">
			<input type="submit" name="logout" value="Logout">
		</form>

		<h1>List all users</h1>
		<div align="center">
			<table border="1" cellpadding="6">
				<caption>List of Users</caption>
				<tr>
					<th>Email</th>
					<th>Password</th>
				</tr>
				<c:forEach var="users" items="${listUser}">
					<tr style="text-align: center">
						<td><c:out value="${users.email}" /></td>
						<td><c:out value="${users.password}" /></td>
				</c:forEach>

			</table>
		</div>
	</div>

</body>
</html>