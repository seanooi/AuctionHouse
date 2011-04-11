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
</head>
<body>
<p>
${auction.idAuction}
</p>
<p>
${auction.user.username}
</p>
<p>
${auction.category.name}
</p>
<p>
${auction.title}
</p>
<p>
${auction.description}
</p>
<p>
<img src="<c:url value="/image?id=${auction.idAuction}" />" />
</p>
<p>Bid History</p>
<table border="1">
	<tr>
		<th>ID</th>
		<th>User</th>
		<th>Amount</th>
		<th>Time</th>
	</tr>
	<c:forEach items="${auction.bids}" var="bid">
		<tr>
			<td>${bid.idBid}</td>
			<td>${bid.user.username}</td>
			<td>${bid.amount}</td>
			<td>${bid.time}</td>
		</tr>
	</c:forEach>
</table>
<p><a href="${auction.idAuction}/bid">Click to place bid.</a></p>
</body>
</html>