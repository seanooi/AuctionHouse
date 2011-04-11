<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="./resources/styles.css" type="text/css" />
</head>
<body>
<div id="wrapper">
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
			<div id="guest">
				<p><a href="login.jsp">Log In</a></p>
				<p><a href="user/add">Register</a></p>
			</div>
			</sec:authorize>
		</div>
	</div>
	<div class="clear"></div>
		<hr />
	<div id="nav-bar">
		<ul id="nav">
		<li>
			<a href="/AuctionHouse" title="Return home">Home</a>
		</li>
		<li>
			<a href="#" title="About the company">About</a>
			<ul>
				<li><a href="#">The product</a></li>
				<li><a href="#">Meet the team</a></li>
			</ul>
		</li>
		<li>
			<a href="#" title="The services we offer">Services</a>
			<ul>
				<li><a href="#">Sevice one</a></li>
				<li><a href="#">Sevice two</a></li>
				<li><a href="#">Sevice three</a></li>
				<li><a href="#">Sevice four</a></li>
			</ul>
		</li>
		<li>
			<a href="#" title="Our product range">Product</a>
			<ul>
				<li><a href="#">Small product (one)</a></li>
				<li><a href="#">Small product (two)</a></li>
				<li><a href="#">Small product (three)</a></li>
				<li><a href="#">Small product (four)</a></li>
				<li><a href="#">Big product (five)</a></li>
				<li><a href="#">Big product (six)</a></li>
				<li><a href="#">Big product (seven)</a></li>
				<li><a href="#">Big product (eight)</a></li>
				<li><a href="#">Enourmous product (nine)</a></li>
				<li><a href="#">Enourmous product (ten)</a></li>
				<li><a href="#">Enourmous product (eleven)</a></li>
			</ul>
		</li>
		<li>
			<a href="#" title="Get in touch with us">Contact</a>
			<ul>
				<li><a href="#">Out-of-hours</a></li>
				<li><a href="#">Directions</a></li>
			</ul>
		</li>
	</ul>
	</div>
	<hr />
	<div class="clear"></div>
		<div id="mainPage-auctions">
			<c:forEach items="${auctions}" var="auction">
					<div id="auctionImage">
					<p><label id="aImage"><img src="<c:url value="/image?id=${auction.idAuction}" />" /></label></p>
					</div><!-- auctionImage -->
					
					<div id="auctionDetails">
					<p>Title: <label id="aTitle"><a href="auction/${auction.idAuction}">${auction.title}</a>
					</label></p>
					<p>Category: <label id="aCategory">${auction.category.name}</label></p>
					<p>Description: <label id="aDescription">${auction.description}</label></p>
					<p>User: <label id="aUsername">${auction.user.username}</label></p>
					<p>Bid: <label id="aBid">${auction.bids[0].amount}</label></p>
					</div><!-- auctionDetails -->
					
					<div class="clear"></div>
					<hr />
			</c:forEach>
		</div><!--  mainPage=auctions -->
		</div><!-- wrapper -->
</body>
</html>
