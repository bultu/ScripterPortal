<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function validateForm()
	{
		var cuId =document.forms["reg_form"]["cuId"].value;
		if (cuId==null || cuId=="")
		   {
		   alert("CUID must be filled out");
		   cuId.focus;
		   return false;
		   }
	}
</script>
</head>
<body>
	<h1>Password Retrieval</h1>
		

    <form name="reg_form" id="a01" method="Post" action="forgotpassword.action" onsubmit="return validateForm()">

	
	
	
	<table border="3" cellspacing="1" cellpadding="2">
		<tr>
			<th>Recover Password for :</th>
		</tr>
		
		<tr>
			<td>CUID:</td>
			<td><input type="text" name="cuId" id="ao7" size="50"></td>
		</tr>
	   </table><br>
	   <input type="submit" name="set" value="RETRIEVE" id="a11">
	   </form><br>
	   
	   <font color="#FF0000">
		<%
		if(request.getAttribute("error")!=null){%>
		<%=request.getAttribute("error") %>
		
		<%}
		%>
		</font>
</body>
</html>