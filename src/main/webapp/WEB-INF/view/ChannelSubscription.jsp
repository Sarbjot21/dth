<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
$(function() {
	  var $dp1 = $("#date");
	  $dp1.datepicker({
	    changeYear: true,
	    changeMonth: true,
	      minDate:0,
	    dateFormat: "yy-m-dd",
	    yearRange: "-100:+20",
});
</script>
 
<title>Edit Subscription Details</title>
</head>
<body>
<h1>DTH Subcription</h1><br>
<div>
	<form action="save" method="post" target="_self">
	
		<div>
			<label>Customer Subscription ID :  </label>
			<input type = "text"  name = "subscription_id"/>
		</div>
		
		<div><br>
		<br>
		
		<label>Channels				 :	</label>
			<select name="channels">
				<option value="--Select--">--Select--</option>	
				<c:forEach var="channel" items="${lists}">
					<option value="${channel.name}">${channel.name}</option>		
				</c:forEach>	
				
		</select>
		</div>
		<br>
		<br>
		<div>
	        <label>Start</label>
	        <input type="date"  name="date" id="date" value=""/>
    	</div>
    	<br>
    	<br>
    	<div>
    		<input type="submit" 	name="clear" value="Clear"/>
    		<input type="submit" 	name = "submit" value ="Submit"/>
    		
    	</div> 
	</form>
</div>
</body>
</html>