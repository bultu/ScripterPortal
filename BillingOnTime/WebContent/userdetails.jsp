<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:set name="pageval" value="page"/>
<s:if test="%{#pageval=='forgotpassword'}">
<pre>
	UserName/CUID 		: ${cuId}<br>
	Password		: ${passWord}<br>
	Group 			: ${group}<br>
	EmailID 		: ${emailId}<br>
</pre>
</s:if>
<s:elseif test="%{#pageval=='newuser'}">
<pre>
    Last Name 		: ${lastName}<br>
	First Name 		: ${firstName}<br>
	Group			: ${groupName}<br>
	CuID/UserName	: ${cuId}<br>
	EmailID 		: ${emailId}<br>
</pre>
</s:elseif>



	
</body>
</html>