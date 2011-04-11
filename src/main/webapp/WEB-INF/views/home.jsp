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
	<%@ include file="header.jsp" %>
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
<%@ include file="footer.jsp" %>
</body>
</html>
