<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome ${name}</title>
	
	<link rel="stylesheet" href="scripts/jquery-ui.css" />
	<script src="scripts/jquery-1.8.3.js"></script>
	<script src="scripts/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#tabs").tabs();
		});
	</script>
</head>
<body>
	<h2>Welcome, ${name} , ${cuId}</h2>
	
	
	<div id="tabs">    
		<ul>     
			<li><a href="#tabs-1" >Activate Users</a></li>        
			<li><a href="#tabs-2" >De-Activate Users</a></li>        
			<li><a href="#tabs-3" >BOT Tracker</a></li>
			<li><a href="#tabs-4">User Details</a></li>     
		</ul>    
		
		<!-- onClick="javascript:document.getElementById('myiframe1').contentWindow.location.reload(true)"
		onClick="javascript:document.getElementById('myiframe2').contentWindow.location.reload(true)"
		onClick="javascript:document.getElementById('myiframe3').contentWindow.location.reload(true)" -->
		
		<div id="tabs-1" >        
			<iframe id="myiframe1" src="getActiveUsers.action" width=100% height=600px frameBorder="0"></iframe>			
			
		</div>    
		
		<div id="tabs-2">
			<iframe id="myiframe2" src="getDeActiveUsers.action" width=100% height=600px frameBorder="0"></iframe>
			
		</div>
		   
		<div id="tabs-3">
			<iframe id="myiframe3" src="Bottracker.jsp" width=100% height=600px frameBorder="0"></iframe>
			
		</div>
		
		<div id="tabs-4">
			Name :  ${name}
		</div>
		
	</div>
	
	<%-- <table align="center">
	 <tr>
		<td>
			<h4>Choose from the below options:</h4><br>
		</td>
	</tr>
	<tr>
		<td>
			<s:url id="activateURL" value="getActiveUsers.action?userName=%{cuId}"></s:url>
			<s:a href="%{activateURL}">Activate Users </s:a>
		</td>
	</tr>
	
	<tr>
		<td>
			<s:url id="deActivateURL" value="getDeActiveUsers.action?userName=%{cuId}"></s:url>
			<s:a href="%{deActivateURL}">De-Activate Users </s:a>
		</td>
	</tr>
	
	<tr>
		<td>
			<s:url id="botTrackerURL" value="getBot.action?userName=%{cuId}"></s:url>
			<s:a href="%{botTrackerURL}">BOT Tracker</s:a>
		</td>
	</tr>
	</table> --%>
</body>
</html>