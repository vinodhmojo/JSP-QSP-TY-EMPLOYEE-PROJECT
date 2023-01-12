<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<body>
	<jsp:include page="home.jsp"/>
	<h1>Edit Page</h1>
	<hr><hr>
		<div class="container">
		<form action="/emp-app/update-emp" method="POST">
			<label>Employee Id</label><br>
			<input type="text" name="id" value="${emp.id}" readonly="readonly">
			<br><br>
			
			<label>Employee Name</label><br>
			<input type="text" name="name" value="${emp.name}">
			<br><br>
			
			<label>Employee Email</label><br>
			<input type="email" name="email" value="${emp.email}">
			<br><br>
			
			<label>DOB</label><br>
			<input type="date" name="dob" value="${emp.dob}">
			<br><br>
			
			<label>Salary</label><br>
			<input type="number" name="salary" value="${emp.salary}">
			<br><br>
	
			<label>Status</label><br>
			<c:choose>
				<c:when test="${emp.statusType==true }">
					<label for="active">Active</label><input type="radio" name="statusType" value=true checked="checked" id="active">
					<label for="Inactive">In Active</label><input type="radio" name="statusType" value=false id="Inactive">
				</c:when>
				<c:when test="${emp.statusType==false }">
					<label for="active">Active</label><input type="radio" name="statusType" value=true id="active">
					<label for="Inactive">In Active</label><input type="radio" name="statusType" value=false checked="checked" id="Inactive">
				</c:when>
			</c:choose>
			<br><br>
	
			<input type="submit" value="Update">
			
		</form>
	</div>

</body>
</html>