<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Employees</title>
</head>
<body>
	<jsp:include page="home.jsp"/>

	<h1>All Employees</h1>

	<table border="1" align="center">
	<tr>
		<th>Employee Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>DOB</th>
		<th>Age</th>
		<th>Salary</th>
		<th>Status</th>
		<th colspan="2">Action</th>
	</tr>
	<c:forEach var="emp" items="${emps}">
	<tr>
		<td>${ emp.id }</td>
		<td>${ emp.name }</td>
		<td>${ emp.email }</td>
		<td>${ emp.dob }</td>
		<td>${ emp.age }</td>
		<td>${ emp.salary }</td>
		<c:choose><c:when test="${emp.statusType==true}">
			<td>Active</td>
		</c:when><c:otherwise><td>InActive</td></c:otherwise></c:choose>
		<td><a href='./edit/${ emp.id }'>EDIT</a></td>
		<td><a href='./delete?id=${ emp.id }'>DELETE</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>