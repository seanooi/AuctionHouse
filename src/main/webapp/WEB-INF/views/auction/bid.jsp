<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Place new bid</title>
</head>
<body>
<p>Enter bid details.</p>
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
</body>
</html>