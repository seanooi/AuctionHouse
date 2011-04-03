<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<p>Auctions</p>
<table border="1">
	<tr>
		<th>ID</th>
		<th>User</th>
		<th>Category</th>
		<th>Title</th>
		<th>Description</th>
		<th>Image</th>
	</tr>
<c:forEach items="${auctions}" var = "auction">
	<tr>
		<td>${auction.idAuction}</td>
		<td>${auction.user.username}</td>
		<td>${auction.category.name}</td>
		<td><a href="auction?id=${auction.idAuction}">${auction.title}</a></td>
		<td>${auction.description}</td>
		<td><img src="<c:url value="/image?id=${auction.idAuction}" />" /></td>
	</tr>
</c:forEach>
</table>
<p><a href="j_spring_security_logout">Logout</a></p>
</body>
</html>
