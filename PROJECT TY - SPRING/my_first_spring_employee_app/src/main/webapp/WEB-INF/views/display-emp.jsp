<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Employee</title>
</head>
<body>
	<jsp:include page="home.jsp" />
	<c:choose>
		<c:when test="${ msg.getClass().getSimpleName().equals(\"String\")}">
			<h2>${msg }</h2>
		</c:when>
		<c:when
			test="${ msg.getClass().getSimpleName().equals(\"EmployeeDto\")}">
			<table border="1" align="center">
				<tr>
					<th>Employee Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>DOB</th>
					<th>Age</th>
					<th>Salary</th>
					<th>Status</th>
				</tr>
				<tr>
					<td>${ msg.id }</td>
					<td>${ msg.name }</td>
					<td>${ msg.email }</td>
					<td>${ msg.dob }</td>
					<td>${ msg.age }</td>
					<td>${ msg.salary }</td>
					<c:choose>
						<c:when test="${emp.statusType==true}">
							<td>Active</td>
						</c:when>
						<c:otherwise>
							<td>InActive</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</table>
		</c:when>
	</c:choose>

</body>
</html>