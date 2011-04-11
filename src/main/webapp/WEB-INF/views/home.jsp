<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<p>Auctions</p>
	<p>
		Welcome
		<sec:authentication property="name" />.
		<sec:authorize ifNotGranted="ROLE_USER">
			Please <a href="login.jsp">Log In</a>
		</sec:authorize>
	</p>
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
				<td><a href="auction/${auction.idAuction}">${auction.title}</a>
				</td>
				<td>${auction.description}</td>
				<td><img src="<c:url value="/image?id=${auction.idAuction}" />" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<sec:authorize ifAnyGranted="ROLE_USER">
			<a href="control/panel">My Account</a><br/>
			<a href="j_spring_security_logout">Logout</a>
		</sec:authorize>
	</p>
</body>
</html>
