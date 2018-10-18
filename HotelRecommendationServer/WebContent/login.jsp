<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>HotelRecommendation</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="main">

<%@ include file="header.jsp"%>

</div>
<hr />
<!-- start page -->
<div id="page" align="center">
	<!-- start content -->
	<div id="content">
		<div class="post">
			
		  <div class="entry">
				
                 <form name="form" action="LoginServlet" method="post" onsubmit="return validateLogin(form);">
	
				<table width="200" border="0" cellspacing="5" 
					cellpadding="5" style="margin-top: 10px" align="center">
					<thead>
						<tr>
							<th colspan="2" style="font-size: 22px">Login Form</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>UserName</td>
							<td><input type="text" name="userName" id="userName" /></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" name="passWord" id="passWord" /></td>
						</tr>

						<tr>
							<td></td>
							<td><input type="submit" name="submit" id="submit"
								value="Login" />&nbsp;&nbsp; <input type="reset" name="reset"
								id="reset" value="Reset" /></td>
						</tr>
					</tbody>
				
				</table>
					</form>
      
			    
						 
			</div>
			</div>
	</div>
	<!-- end content -->
	<!-- start sidebar two -->
	<div id="sidebar2" class="sidebar">
		
	</div>
	<!-- end sidebar two -->
	<div style="clear: both;">&nbsp;</div>
</div>
<!-- end page -->
<hr />
<!-- start footer -->
<%@ include file="footer.jsp"%>
<!-- end footer -->
</body>
</html>