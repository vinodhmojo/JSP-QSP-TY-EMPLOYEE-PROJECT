<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Employee</title>
</head>
<body>
	<jsp:include page="home.jsp"/>
	
	<div class="container">
		<form action="search-emp">
			<label>Employee Id</label><br>
			<input type="text" name="id">
			
			<input type="submit" value="SEARCH">
		</form>
	</div>

</body>
</html>