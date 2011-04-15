<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auction view</title>
<link rel="stylesheet" href="../resources/styles.css" type="text/css" />
</head>
<body>
<%@ include file="../header.jsp" %>
<div id="mainPage-auctions">
<div id="auctionImage">
	<p><label id="aImage"><img src="<c:url value="/image?id=${auction.idAuction}" />" /></label></p>
</div><!-- auctionImage -->

<div id="auctionDetails">
<p>Title: <label id="aTitle">${auction.title}</label></p>
		<p>Category: <label id="aCategory">${auction.category.name}</label></p>
		<p>Description: <label id="aDescription">${auction.description}</label></p>
		<p>User: <label id="aUsername">${auction.user.username}</label></p>
		<p>Bid: <label id="aBid">${auction.bids[0].amount}</label></p>
		<sec:authorize ifNotGranted="ROLE_USER">
		<p id="login-msg">Please <a href="/AuctionHouse/login.jsp">login</a> to place a new bid</p>
		</sec:authorize>
		<sec:authorize ifAnyGranted="ROLE_USER">
		<p>
			<form:form method="post" modelAttribute="bid">
			<form:errors path="*" cssClass="error"/>
				<p><label id="amount">Amount:
			<form:input path="amount" />
			<form:errors path = "amount" cssClass="error"/>
				</label></p>
				<p><input id="submit" type="submit" name="submit" value="Place Bid" /></p>
			</form:form>
		</p>
		</sec:authorize>
		<div class="clear"></div>
		<hr />
<div id="bid-history">
<p>Bid History</p>
<table border="1">
	<tr>
		<th>User</th>
		<th>Amount</th>
		<th>Time</th>
	</tr>
	<c:forEach items="${auction.bids}" var="bid">
		<tr>
			<td>${bid.user.username}</td>
			<td>${bid.amount}</td>
			<td>${bid.time}</td>
		</tr>
	</c:forEach>
</table>
</div>
</div><!-- auctionDetails -->
</div><!--  mainPage=auctions -->
<%@ include file="../footer.jsp" %>
</body>
</html>