<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <meta charset="utf-8">
    <title>Sign in &middot; Ensemble CSM Noida</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
    <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="bootstrap/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="bootstrap/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="bootstrap/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="bootstrap/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="bootstrap/ico/favicon.png">
  </head>

<body>
	

	
		<h3 class="form-signin-heading" style="left: 40%; top: 30px; position: absolute; " >ENSEMBLE CSM - NOIDA</h3>

		<div class="container" style=" position: absolute; top: 10%;">

			<form class="form-signin" name="jsscall" id="011" method="post"
				action="login.action"
				>


				<%-- <s:textfield class="input-block-level" id="username" name="username"
					label="CUID" />
				
				<br>
				<br>
				<s:password class="input-block-level" name="password" id="Password"
					label="Password" /> --%>
					
					<input type="text" class="input-block-level" placeholder="cuid" id="username" name="username">
        			<input type="password" class="input-block-level" placeholder="Password"  name="password" id="Password">
       			    <label class="checkbox">
         		    <input type="checkbox" value="remember-me"> Remember me
                    </label>
                    <button class=" btn btn-large btn-primary" type="submit">Sign in</button>
        			

			</form>

		<br>
		<s:a href="newuserreg.jsp"
			cssStyle="left:450px;top:40px;position:relative;font-size:15px">New User Login</s:a>
		<s:a href="forgotpassword.jsp"
			cssStyle="left:500px;top:40px;position:relative;font-size:15px">Forgot Password?</s:a>
		<br> <font color="#FF0000"> ${error} </font>



		<!-- Le javascript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
	<script src="bootstrap/js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap-transition.js"></script>
    <script src="bootstrap/js/bootstrap-alert.js"></script>
    <script src="bootstrap/js/bootstrap-modal.js"></script>
    <script src="bootstrap/js/bootstrap-dropdown.js"></script>
    <script src="bootstrap/js/bootstrap-scrollspy.js"></script>
    <script src="bootstrap/js/bootstrap-tab.js"></script>
    <script src="bootstrap/js/bootstrap-tooltip.js"></script>
    <script src="bootstrap/js/bootstrap-popover.js"></script>
    <script src="bootstrap/js/bootstrap-button.js"></script>
    <script src="bootstrap/js/bootstrap-collapse.js"></script>
    <script src="bootstrap/js/bootstrap-carousel.js"></script>
    <script src="bootstrap/js/bootstrap-typeahead.js"></script>

	</div>
	
	<!-- <h1 style="left: 30% ;top: 80% ; position: absolute ;" >ENSEMBLE CSM - NOIDA</h1>
	<br> -->
</body>