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


<script>

function initialize() {
	var mapProp = {
		center : new google.maps.LatLng(18.516726,
				73.856255),
		zoom : 15,
		mapTypeId : google.maps.MapTypeId.ROADMAP  /* ROADMAP (normal, default 2D map)
												   SATELLITE (photographic map)
												   HYBRID (photographic map + roads and city names)
												   TERRAIN (map with mountains, rivers, etc.) */
	};
	var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
	
	google.maps.event.addListener(map, 'click', function(event) {
		// alert( "Latitude: "+event.latLng.lat()+" "+", longitude: "+event.latLng.lng() ); 
		document.getElementById("Latitude").value = event.latLng.lat();
		document.getElementById("Longitude").value = event.latLng.lng();
	});
	
}
google.maps.event.addDomListener(window, 'load', initialize);


</script>
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
		  
		 
				
                <form name="form" action="viewHotelByCriteria.jsp" method="post" onsubmit="return validateHotel(form);">
	
		<table width="40%" border="0" cellspacing="2" 
			cellpadding="2" style="margin-top: 10px">
			<thead>
				
				<tr>
					<td align="left"><b>SwimmingPool</b></td>
					<td ><select name="swimmingPool" id="swimmingPool"  style="width: 100px">
							<option value="0" >Optional</option>
						<option value="1" >Required</option>
					</select></td>
					</tr>
					<tr>
					<td align="left"><b>Parking</b></td>
					<td ><select name="parking" id="parking"  style="width: 100px">
							<option value="0" >Optional</option>
						<option value="1" >Required</option>
					</select></td>
					</tr>
					<tr>
					<td align="left"><b>Loundry</b></td>
					<td ><select name="loundry" id="loundry"  style="width: 100px">
							<option value="0" >Optional</option>
						<option value="1" >Required</option>
					</select></td>
					</tr>
				
				<tr>
					<td align="left"><b>Latitude</b></td>
					<td><input type="text" name="Latitude" id="Latitude"  readonly/></td>
				</tr>
					
				<tr>
					<td align="left"><b>Longitude</b></td>
					<td><input type="text" name="Longitude" id="Longitude"  readonly/></td>
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
<div id="googleMap" style="width: 100%; height: 490px;"></div>
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