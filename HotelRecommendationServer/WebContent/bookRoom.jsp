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
<%String prize=request.getParameter("prize");
String hotelId=request.getParameter("hotelId");
String roomId=request.getParameter("roomid");
int userId=(Integer)session.getAttribute("userId");


%>

</div>
<hr />
<!-- start page -->
<div id="page" align="center">
	<!-- start content -->
	<div id="content">
		<div class="post">
						
		  <div class="entry">
		  
		 
				
                <form name="form" action="BookingRoomServlet" method="post" onsubmit="return validateHotel(form);">
	
		<table width="40%" border="0" cellspacing="2" 
			cellpadding="2" style="margin-top: 10px">
			<thead>
				<tr>
					<th colspan="2" style="font-size: 22px">User register</th> 
				</tr>
			</thead>
			<tbody>
				<tr>
					<td align="left"><b>CheckInDate</b></td>
					<td><input type="date" name="checkInDate" id="checkInDate" /></td>
				</tr>
				<tr>
					<td align="left"><b>CheckOutDate</b></td>
					<td><input type="date" name="checkOutDate" id="checkOutDate" /></td>
				</tr>
				
				<tr>
					<td align="left"><b>TotalAmount</b></td>
					<td><input type="text" name="totalAmount" id="totalAmount" value=<%=prize %> readonly/></td>
				</tr>
				<tr>
					
					<td><input type="hidden" name="hotelId" id="hotelId" value=<%=hotelId %> readonly/></td>
				</tr>
				<tr>
					
					<td><input type="hidden" name="roomId" id="roomId" value=<%=roomId %> readonly/></td>
				</tr>
				<tr>
					
					<td><input type="hidden" name="userId" id="userId" value=<%=userId %> readonly/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="submit" id="submit"
						value="Book" />&nbsp;&nbsp; <input type="reset"
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