<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Template 2</title>
<meta name="description" content="A description of your website">
<meta name="keywords" content="keyword1, keyword2, keyword3">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script type="text/javascript" src="js/LoginValidation.js"></script>
<script>

function initialize() {
	var mapProp = {
		center : new google.maps.LatLng(18.48693534562608,
				73.81954193115234),
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
 



 <%@ include file="header.jsp"%>
    



  <div id="page_content" align="center"> 

      
       <div class="top_content">
       <form name="form" action="AddProviderServlet" method="post" onsubmit="return validateProvider(form);">
	
		<table width="40%" border="0" cellspacing="2" 
			cellpadding="2" style="margin-top: 10px">
			<thead>
				<tr>
					<th colspan="2" style="font-size: 22px">Registration Form</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td align="left"><b>HotelName</b></td>
					<td><input type="text" name="firstName" id="firstName" /></td>
				</tr>
				
				
				<tr>
				
				<td align="left"><b>Address</b></td>
				<td><textarea id="address" name="address" rows="2" cols="22"></textarea></td>
				</tr>
			<tr>
				
				<tr>
					<td align="left"><b>ContactPerson</b></td>
					<td><input type="text" name="contactNo" id="contactNo" /></td>
				</tr>
				<tr>
					<td align="left"><b>ContactNo</b></td>
					<td><input type="text" name="contactNo" id="contactNo"  maxlength="12"/></td>
				</tr>
				<tr>
					<td align="left"><b>Latitude</b></td>
					<td><input type="text" name="Latitude" id="Latitude"  /></td>
				</tr>
					
				<tr>
					<td align="left"><b>Longitude</b></td>
					<td><input type="text" name="Longitude" id="Longitude"  /></td>
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


 <div class="common_content">
<div id="googleMap" style="width: 100%; height: 490px;"></div>
</div>
    
    
   
    <%@ include file="footer.jsp"%>
   

</body></html>