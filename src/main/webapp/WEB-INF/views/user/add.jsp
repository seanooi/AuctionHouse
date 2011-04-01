<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../resources/styles.css" type="text/css" />
<title>Add New User...</title>
</head>
<body>
<div id="register-form-container">
<h3>Image Here</h3>
<form:form method="post" modelAttribute="upi">
<form:errors path="*" cssClass="error" />
<p>
		<label id="username">Username<br />
		<form:input path="User.username" />
		<form:errors path="User.username" cssClass="error" />
		</label>
</p>
<p>
		<label id="password">Password<br />
		<form:input path="User.password" />
		<form:errors path="User.password" cssClass="error" />
		</label>
</p>
<p>
		<label id="firstName">First Name<br />
		<form:input path="PersonalInfo.firstName" />
		<form:errors path="PersonalInfo.firstName" cssClass="error" />
		</label>
</p>
<p>
		<label id="middleName">Middle Name<br />
		<form:input path="PersonalInfo.middleName" />
		<form:errors path="PersonalInfo.middleName" cssClass="error" />
		</label>
</p>
<p>
		<label id="lastName">Last Name<br />
		<form:input path="PersonalInfo.lastName" />
		<form:errors path="PersonalInfo.lastName" cssClass="error" />
		</label>
</p>
<p>
		<label id="address1">Address Line 1<br />
		<form:input path="PersonalInfo.address1" />
		<form:errors path="PersonalInfo.address1" cssClass="error" />
		</label>
</p>
<p>
		<label id="address2">Address Line 2<br />
		<form:input path="PersonalInfo.address2" />
		<form:errors path="PersonalInfo.address2" cssClass="error" />
		</label>
</p>
<p>
		<label id="city">City<br />
		<form:input path="PersonalInfo.city" />
		<form:errors path="PersonalInfo.city" cssClass="error" />
		</label>
</p>
<p>		
		<label id="state">State<br />
		<form:input path="PersonalInfo.state" />
		<form:errors path="PersonalInfo.state" cssClass="error" />
		</label>
</p>
<p>		
		<label id="country">Country<br />
		<form:input path="PersonalInfo.country" />
		<form:errors path="PersonalInfo.country" cssClass="error" />
		</label>
</p>
<p>
		<label id="zipcode">Zipcode<br />
		<form:input path="PersonalInfo.zipcode" />
		<form:errors path="PersonalInfo.zipcode" cssClass="error" />
		</label>
</p>
<p>
		<label id="phoneNumber">Phone Number<br />
		<form:input path="PersonalInfo.phoneNumber" />
		<form:errors path="PersonalInfo.phoneNumber" cssClass="error" />
		</label>
</p>
<p>
		<label id="email">Email Address<br />
		<form:input path="PersonalInfo.emailAddress" />
		<form:errors path="PersonalInfo.emailAddress" cssClass="error" />
		</label>
</p>

		<input id="submit" type="submit" name="submit" value="Register" />
</form:form>
<div class="clear"></div>
<a href="/AuctionHouse/login.jsp">Log In</a>
</div>
</body>
</html>