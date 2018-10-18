
<div id="menu">

	<ul>

		<%
		try {

		String user = (String) session.getAttribute("role");
		if (user == null) {
				%>
		<li><a href="index.jsp">Home</a></li>
		<li><a href="login.jsp">Login</a></li>
		<li><a href="addUser.jsp">SignUp</a></li>

		<%}
			else if(user.equals("ADMIN"))
		{%>
		<li><a href="admin.jsp">Home</a></li>
		<li><a href="addhotel.jsp">Hotel</a></li>
		<li><a href="addHotelRoom.jsp">Room</a></li>
		<li><a href="logout.jsp">Logout</a></li>

		<%
		} else{%>
		<li><a href="viewHotelforUser.jsp">Hotel</a></li>
		<li><a href="criteriaSearch.jsp">CriteriaSearch</a></li>
		<li><a href="logout.jsp">Logout</a></li>
		<%}
			
		} 
			catch (Exception e) {
			System.out.println(e);
		}
		
	%>

	</ul>
	</div>
</div>
