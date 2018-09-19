<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Subscription Details</title>
</head>
<body>
	<form action="/remove" method="post" target="_self">
	
		<div>
			<label>Customer Subscription ID :  </label>
			<input type = "text"   name = "subscriber_id"/>
		</div>
		<br>
		<br>
		<div>
		
		<label>Channels				 :	</label>
			<select name="channels">
			<option value="--Select--">--Select--</option>	
			<c:forEach var="channel" items="${lists}">
				<option>${channel.name}</option>		
			</c:forEach>		
			</select>
		</div>
		<br>
		<br>
		
		<div>
			<input type="button" name="cancel" value="Cancel"/>
			<input type="Submit" name="submit" value="Unsubscribe"/>
		
		</div>
		</form>
		</body>
		</html>
				