<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="com.hotelRecommendation.database.*"%>
<%@page import="com.hotelRecommendation.bean.*"%>
<%@page import="java.util.ArrayList"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>HotelRecommendation</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script src="http://maps.googleapis.com/maps/api/js"></script>
<link href="styles.css" rel="stylesheet" type="text/css" />


<script>




</script>
</head>
<body>
<div id="main">

<%@ include file="header.jsp"%>

        <%HotelDataBaseHelper hotelHelper=new HotelDataBaseHelper();
        ArrayList<HotelBean> hotelBeanList=hotelHelper.fetchAllHotelInfo();
        %>

</div>
<hr />
<!-- start page -->
<div id="page" align="center">
	<!-- start content -->
	<div id="content">
		<div class="post">
		
		  <div class="entry">
				<a href="viewHotelRoom.jsp">View Room</a>
                <form name="form" action="AddHotelRoomServlet" method="post" onsubmit="return validateHotel(form);">
	
		<table width="40%" border="0" cellspacing="2" 
			cellpadding="2" style="margin-top: 10px">
			<thead>
				<tr>
					<th colspan="2" style="font-size: 22px">Add Room</th>
				</tr>
			</thead>
			<tbody>
			
			<tr>
					<td align="left"><b>Hotel Name</b></td>
					<td ><select name="hotelname" id="hotelname"  style="width: 100px">
							<option value="0" >Select</option>
							<%
								for (int i = 0; i < hotelBeanList.size(); i++) 
								{%>
								<option value=<%=hotelBeanList.get(i).getHotelid()%>><%=hotelBeanList.get(i).getHotelname() %></option>
								<%} %>
					</select></td>
					</tr>
			
			<tr>
					<td align="left"><b>Room Type</b></td>
					<td ><select name="roomType" id="roomType"  style="width: 100px">
							<option value="0" >Select</option>
							<option value="SingleRoom" >SingleRoom</option>
							<option value="DoubleRoom" >DoubleRoom</option>
						<option value="Duplex" >Duplex</option>
					</select></td>
					</tr>
				<tr>
					<td align="left"><b>NumberOfRoom</b></td>
					<td><input type="text" name="numberOfRoom" id="numberOfRoom"  /></td>
				</tr>
				<tr>
					<td align="left"><b>Prize</b></td>
					<td><input type="text" name="prize" id="prize"  /></td>
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