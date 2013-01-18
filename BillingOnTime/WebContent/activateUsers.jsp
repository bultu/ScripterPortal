<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Activate Users</title>
<link rel="stylesheet" href="scripts/jquery-ui.css" />
<script src="scripts/jquery-1.8.3.js"></script>
<script src="scripts/jquery-ui.js"></script>
	
	
<style>    
  #draggable { width: 100%; height: 50px; padding: 0.5em; }    
</style>    
<script>    
$(
    function() 
    {        
      $( "#draggable" ).draggable();    
    }
  );    
</script>


<style>    
	#sortable { list-style-type: none; margin: 0; padding: 0; width: 600px; }    
	#sortable li { margin: 0 3px 3px 3px; padding: 0.2em; padding-left: 1.5em; font-size: 1em; height: 12px; }    
	#sortable li span { position: absolute; margin-left: -.7em; }    
</style>    
<script>    
$(
    function() 
    {        
      $( "#sortable" ).sortable();        
      $( "#sortable" ).disableSelection();    
    }
  );    
</script>




</head>
<body>


	<s:if test="#error==null || #error==''">
		${error}
	</s:if>
	
	<%-- <table align="center" border="5px" bordercolor="#3579DC" >
	<s:iterator value="userDataArray" >
  
  
		<!-- <div id="draggable" class="ui-widget-content">    <p>Drag me around</p> </div> -->
		<tr >
			<td><s:property value="lastName"/></td>
			<td><s:property value="firstName"/></td>
			<td><s:property value="cuId"/></td>
			<td><s:property value="emailId"/></td>
			<td>
				<s:url id="activateURL" value="activeUsers.action?username=%{cuId}"></s:url>
				<s:a href="%{activateURL}">Activate User </s:a>
			</td>
			
		</tr>		
	</s:iterator>
	</table>
	 --%>
	
	<ul>
		<s:iterator value="userDataArray" >
			<li  id="draggable" class="ui-widget-content">
				<s:property value="lastName"/>
				<s:property value="firstName"/>
				<s:property value="cuId"/>
				<s:property value="emailId"/>
				<s:url id="activateURL" value="activeUsers.action?username=%{cuId}"></s:url>
				<s:a href="%{activateURL}">Activate User </s:a>
			</li>    
		</s:iterator>
	
	</ul> 
	
	<s:form id="myform2" action="getActiveUsers.action">
	<s:submit  value="Refresh" type="button"/>
	</s:form>

</body>
</html>