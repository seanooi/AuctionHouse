<div id="header">
	<div id="header-img">
		<a href="/AuctionHouse"><img src="./resources/images/AuctionBanner2.png" width=300 height=85 /></a>
	</div>
	<div id="header-login">
		<sec:authorize ifAnyGranted="ROLE_USER">
		<p>Welcome 
		<sec:authentication property="name" />!</p>
			<p><a href="control/panel">My Account</a></p>
			<p><a href="j_spring_security_logout">Logout</a></p>
		</sec:authorize>
		<sec:authorize ifAnyGranted="ROLE_GUEST">
		<p>Welcome!</p>
			<p><a href="login.jsp">Log In</a></p>
			<p><a href="user/add">Register</a></p>
		</sec:authorize>
	</div>
</div>