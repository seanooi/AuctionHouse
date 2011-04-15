	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert new auction</title>
</head>
<body>
<p>Enter Auction details.</p>
<p>
<form:form method="post" modelAttribute="afd" enctype="multipart/form-data">
<form:errors path="*" cssClass="error"/>
	<p><label id="auction.category">Category:
		<form:select path="auction.category" items="${categories}" itemValue="idCategory" itemLabel="name" />
		<form:errors path="auction.category" cssClass="error" />
	</label></p>
	<p><label id="title">Title:
		<form:input path="auction.title" />
		<form:errors path="auction.title" cssClass="error"/>
	</label></p>
	<p><label id="description">Description:
		<form:textarea path="auction.description" rows="10" cols="80" />
		<form:errors path="auction.description" cssClass="error"/>
	</label></p>
	<p><label id="picture">Image file:
		<form:input type="file" path="file" />
		<form:errors path="file" cssClass="error"/>
	</label></p>
	<p><input id="submit" type="submit" name="submit" /></p>
</form:form>
</p>
</body>
</html>