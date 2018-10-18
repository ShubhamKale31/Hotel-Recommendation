<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>HotelRecommendation</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script src="http://maps.googleapis.com/maps/api/js"></script>
<link href="styles.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/HotelValidation.js"></script>

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
		  
		 
				
                <form name="form" action="AddUserServlet" method="post" onsubmit="return validateHotel(form);">
	
		<table width="40%" border="0" cellspacing="2" 
			cellpadding="2" style="margin-top: 10px">
			<thead>
				<tr>
					<th colspan="2" style="font-size: 22px">User register</th> 
				</tr>
			</thead>
			<tbody>
				<tr>
					<td align="left"><b>FirstName</b></td>
					<td><input type="text" name="firstname" id="firstname" /></td>
				</tr>
				<tr>
					<td align="left"><b>LastName</b></td>
					<td><input type="text" name="lastname" id="lastname" /></td>
				</tr>
				
				<tr>
				
				<td align="left"><b>Address</b></td>
				<td><textarea id="address" name="address" rows="2" cols="22"></textarea></td>
				</tr>
				<tr>
					<td align="left"><b>EmailId</b></td>
					<td><input type="text" name="emailId" id="emailId" /></td>
				</tr>
				<tr>
					<td align="left"><b>MobileNo</b></td>
					<td><input type="text" name="mobileNo" id="mobileNo"  maxlength="12"/></td>
				</tr>
				<tr>
					<td align="left"><b>UserName</b></td>
					<td><input type="text" name="username" id="username"  maxlength="12"/></td>
				</tr>
			
				<tr>
					<td align="left"><b>Password</b></td>
					<td><input type="text" name="passWord" id="passWord"  maxlength="12"/></td>
				</tr>
			
				<tr>
					<td></td>
					<td><input type="submit" name="submit" id="submit"
						value="Register" />&nbsp;&nbsp; <input type="reset"
						name="reset" id="reset" value="Reset" /></td>
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
		<div class="common_content">

</div>
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