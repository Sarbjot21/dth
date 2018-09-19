<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
div {
    width: 30%;
    background-color: white;
}

</style>
<meta charset="ISO-8859-1">
<title>Error </title>
</head>
<body>
<div >
		<h2>Error Details Are as below: </h2>
		
		
		<label>Error Message :</label><br> ${message}
		<br>
		<br>
		<label>URL which failed : </label><br>${url}
		<br>
		



</div>

</body>
</html>