<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD EMPLOYEE</title>
</head>
<body>
	<jsp:include page="home.jsp"/>
	
	<div class="container">
		<form action="employee" method="POST">
			<label>Employee Name</label><br>
			<input type="text" name="name">
			<br><br>
			
			<label>Employee Email</label><br>
			<input type="email" name="email">
			<br><br>
			
			<label>DOB</label><br>
			<input type="date" name="dob">
			<br><br>
			
			<label>Salary</label><br>
			<input type="number" name="salary">
			<br><br>
	
			<label>Status</label><br>
			<label for="active">Active</label>
			<input type="radio" name="statusType" value=true id="active">
			<label for="Inactive">In Active</label>
			<input type="radio" name="statusType" value=false id="Inactive">
			<br><br>
			
			
			<input type="submit" value="ADD EMPLOYEE">
			
		</form>
	</div>

</body>
</html>