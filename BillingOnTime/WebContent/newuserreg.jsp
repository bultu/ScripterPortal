<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<script type="text/javascript">
	function validateForm()
	{
		var lname =document.forms["reg_form"]["lastName"].value;
		var fname =document.forms["reg_form"]["firstName"].value;
		var cuid =document.forms["reg_form"]["cuId"].value;
		var mailid =document.forms["reg_form"]["emailId"].value;
		var password =document.forms["reg_form"]["password"].value;
		var cpassword=document.forms["reg_form"]["confirmPassword"].value;
		
		if (lname==null || lname=="")
		   {
		   alert("Last name must be filled out");
		   lname.focus;
		   return false;
		   }
		
		if (fname==null || fname=="")
		   {
		   alert("First name must be filled out");
		   fname.focus;
		   return false;
		   }
		
		if (cuid==null || cuid=="")
		   {
		   alert("CuID must be filled out");
		   cuid.focus;
		   return false;
		   }
		
		if (mailid==null || mailid=="")
		   {
		   alert("Email ID must be filled out");
		   mailid.focus;
		   return false;
		   }
		if (password==null || password=="")
		   {
		   alert("Password must be filled out");
		   password.focus;
		   return false;
		   }
		if (password != cpassword)
		  {
		  alert("Passwords do not match");
		  cpassword.focus;
		  return false;
	  }
	}
</script>

</head>
<body>
		<h1>New User Registration</h1>
		

    <s:form name="reg_form" id="a01" method="Post" action="signup.action" onsubmit="return validateForm()" >


	
	<table border="3" cellspacing="1" cellpadding="2">
		<tr>
			<th>Personal Data</th>
			
			
		</tr>
		<tr>
			
			<td><s:textfield name="lastName"  size="50" label="LastName"/>
			</td>
		</tr>
		<tr>
			
			<td><s:textfield name="firstName"  size="50" label="FirstName"/>
			</td>
		</tr>
		
		<tr>
			
			<td><s:textfield name="cuId"  size="50" label ="CuID" />
			</td>
		</tr>
		<tr>
			
			<td>
			<s:select label="Select Group:" 
		   headerKey="-1" headerValue="Select Group"
			list="#{ '1':'Regular User', '2':'Administrator'}" 
			name="groupName"
			value="1" />			
			</td>
		</tr>
		
		<tr>
			
			<td><s:textfield name="emailId" label="Email Id" size="50" maxlength="50"/></td>
		</tr>
		
	   </table> <br>
	   
	   <tr>
			
			<td><%-- <s:textfield name="password"  size="50" label ="Password" /> --%>
			<s:password name="password" key="password" label="Password"/>
			<s:password name="confirmPassword" key="confirmPassword" label="Confirm Password" onblur=""/>
			
			</td>
		</tr>
	   <s:submit value="submit" name="submit"/>
	
	</s:form>
	${error}
</body>
</html>