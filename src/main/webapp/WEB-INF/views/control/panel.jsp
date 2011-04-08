<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Control Panel</title>
</head>
<body>
<h1> My House</h1>

<p>Current Bids</p> 
<table border="1">
		<tr>
			<th>ID</th>
			<th>User</th>
			<th>Category</th>
			<th>Title</th>
			<th>Description</th>
			<th>Image</th>
		</tr>
		<c:forEach items="${bids}" var="bid">
			<tr>
				<td>${bid.idAuction}</td>
				<td>${bid.user.username}</td>
				<td>${bid.category.name}</td>
				<td><a href="<c:url value="/auction?id=${bid.idAuction}" />" >${bid.title}</a>
				</td>
				<td>${bid.description}</td>
				<td><img src="<c:url value="/image?id=${bid.idAuction}" />" />
				</td>
			</tr>
		</c:forEach>
	</table>

<p>Current Sales </p>
<table border="1">
		<tr>
			<th>ID</th>
			<th>User</th>
			<th>Category</th>
			<th>Title</th>
			<th>Description</th>
			<th>Image</th>
		</tr>
		<c:forEach items="${auctions}" var="auction">
			<tr>
				<td>${auction.idAuction}</td>
				<td>${auction.user.username}</td>
				<td>${auction.category.name}</td>
				<td><a href="<c:url value="/auction?id=${auction.idAuction}" />" >${auction.title}</a>
				</td>
				<td>${auction.description}</td>
				<td><img src="<c:url value="/image?id=${auction.idAuction}" />" />
				</td>
			</tr>
		</c:forEach>
	</table>




<p> Won/Lost Bids </p>
<!--
past 
bid
info
-->

<p> Edit Account Details </p>

</body>
</html>