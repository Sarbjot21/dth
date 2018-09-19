<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
div {
    width: 30%;
    background-color: white;
}
table{
 width: 100%;
 background-color: white;
 
 }
</style>
<title>Success</title>
</head>
<body>
<h2>Customer Details</h2>

<c:if test="${not empty lists}">

		
				<div style="border:thin solid black" >
				<c:forEach var="customer" items="${customers}">
					<label> Subscriber ID: ${customer.subscriberID}</label>
					<br><br>
					<label>Customer Name : ${customer.firstName} ${customer.lastName}</label>
					<br><br>
					<label>Total Susbcription Cost :${cost}</label>
					<br><br>
					<label>Channel Subscribed For :</label>
					<br><br>
				</c:forEach>
					
				<br><br>
					<table border="2">
						<tr>
							<th>Channel Name</th>
							<th>Cost Per Month</th>
						</tr>
					<c:forEach var="listValue" items="${lists}">
						<tr>
							<td>${listValue.CHANNEL_NAME}</td>
							<td>${listValue.COST_PER_MONTH}</td>
						</tr>
					</c:forEach>
					</table>
					</div>
								
					
			
</c:if>
<c:if test="${empty lists}">
	<h2> No data to Display</h2>
</c:if>
</body>
</html>