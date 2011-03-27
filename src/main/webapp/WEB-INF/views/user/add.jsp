<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New User...</title>
</head>
<body>
<form:form method="post" modelAttribute="upi">
<form:errors path="*" cssClass="error" />
<table>
	<tr>
		<td>Username</td>
		<td><form:input path="User.username" /></td>
		<td><form:errors path="User.username" cssClass="error" /></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><form:input path="User.password" /></td>
		<td><form:errors path="User.password" cssClass="error" /></td>
	</tr>
	<tr>
		<td>First Name</td>
		<td><form:input path="PersonalInfo.firstName" /></td>
		<td><form:errors path="PersonalInfo.firstName" cssClass="error" /></td>
	</tr>
	<tr>
		<td>Middle Name</td>
		<td><form:input path="PersonalInfo.middleName" /></td>
		<td><form:errors path="PersonalInfo.middleName" cssClass="error" /></td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td><form:input path="PersonalInfo.lastName" /></td>
		<td><form:errors path="PersonalInfo.lastName" cssClass="error" /></td>
	</tr>
	<tr>
		<td>Address Line 1</td>
		<td><form:input path="PersonalInfo.address1" /></td>
		<td><form:errors path="PersonalInfo.address1" cssClass="error" /></td>
	</tr>
	<tr>
		<td>Address Line 2</td>
		<td><form:input path="PersonalInfo.address2" /></td>
		<td><form:errors path="PersonalInfo.address2" cssClass="error" /></td>
	</tr>
	<tr>
		<td>City</td>
		<td><form:input path="PersonalInfo.city" /></td>
		<td><form:errors path="PersonalInfo.city" cssClass="error" /></td>
	</tr>
	<tr>
		<td>State</td>
		<td><form:input path="PersonalInfo.state" /></td>
		<td><form:errors path="PersonalInfo.state" cssClass="error" /></td>
	</tr>
	<tr>
		<td>Country</td>
		<td><form:input path="PersonalInfo.country" /></td>
		<td><form:errors path="PersonalInfo.country" cssClass="error" /></td>
	</tr>
	<tr>
		<td>Zipcode</td>
		<td><form:input path="PersonalInfo.zipcode" /></td>
		<td><form:errors path="PersonalInfo.zipcode" cssClass="error" /></td>
	</tr>
	<tr>
		<td>Phone Number</td>
		<td><form:input path="PersonalInfo.phoneNumber" /></td>
		<td><form:errors path="PersonalInfo.phoneNumber" cssClass="error" /></td>
	</tr>
	<tr>
		<td>Email Address</td>
		<td><form:input path="PersonalInfo.emailAddress" /></td>
		<td><form:errors path="PersonalInfo.emailAddress" cssClass="error" /></td>
	</tr>
	<tr>
		<td colspan="3"><input type="submit" /></td>
	</tr>
</table>
</form:form>
</body>
</html>