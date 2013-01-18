<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

<body> 
	<div id="tabs">    
		<ul>        
			<li><a href="#tabs-1">New BOT Issues</a></li>        
			<li><a href="#tabs-2">BOT Issue History</a></li>        
			<li><a href="#tabs-3">User Details</a></li>    
		</ul>    
		<div id="tabs-1">        
			   No Pending Issues
		</div>    
		<div id="tabs-2">       
			   No Issue History  
		</div>   
		<div id="tabs-3">        
			   Name : ${name}
		</div>
	</div>  
</body>
</body>
</html>