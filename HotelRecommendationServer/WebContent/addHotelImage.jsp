<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>HotelRecommendation</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script src="http://maps.googleapis.com/maps/api/js"></script>
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
			<h1 class="title"><a href="#">Add Hotel Image</a></h1>
			
		  <div class="entry">
				
                <form name="form" enctype="multipart/form-data"  action="AddHotelImage" method="post">
				<table align="center">
				<tr>
					<td><input type="file" name="image"/></td>
					<td><input type="submit"  value="Upload"/></td>
				</tr>
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