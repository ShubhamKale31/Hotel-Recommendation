<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>HotelRecommendation</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="styles.css" rel="stylesheet" type="text/css" />
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script>

function initialize() {
	google.maps.event.addDomListener(window, 'load', initialize);
}
</script>
</head>
<body>
	<div id="main">


		<table border="1" align="center">

			<% for(int i=0; i<10; i++)
           		{ %>

				<tr>
					<td align="center">
						<div id="<%=i%>" style="width: 250px; height: 250px;"></div>
						<script>
						var mapProp = {
								center : new google.maps.LatLng(18.6500,
										72.8800),
								zoom : 15,
								mapTypeId : google.maps.MapTypeId.ROADMAP  
							};
							var map = new google.maps.Map(document.getElementById(<%=i%>),mapProp);
						</script>
						
					</td>
				</tr>
			<%}%>	
		</table>
		

		
	</div>

</body>
</html>
