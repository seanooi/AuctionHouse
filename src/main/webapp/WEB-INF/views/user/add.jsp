<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<p>
		<label id="username">Username<br />
		<form:input path="user.username" />
		<form:errors path="user.username" cssClass="error" />
		</label>
</p>
<p>
		<label id="password">Password<br />
		<form:password path="user.password"/>
		<form:errors path="user.password" cssClass="error" />
		</label>
</p>
<p>
		<label id="password">Confirm Password<br />
		<form:password path="confirmPassword"/>
		<form:errors path="confirmPassword" cssClass="error" />
		</label>
</p>
<p>
		<label id="firstName">First Name<br />
		<form:input path="personalInfo.firstName" />
		<form:errors path="personalInfo.firstName" cssClass="error" />
		</label>
</p>
<p>
		<label id="middleName">Middle Name<br />
		<form:input path="personalInfo.middleName" />
		<form:errors path="personalInfo.middleName" cssClass="error" />
		</label>
</p>
<p>
		<label id="lastName">Last Name<br />
		<form:input path="personalInfo.lastName" />
		<form:errors path="personalInfo.lastName" cssClass="error" />
		</label>
</p>
<p>
		<label id="address1">Address Line 1<br />
		<form:input path="personalInfo.address1" />
		<form:errors path="personalInfo.address1" cssClass="error" />
		</label>
</p>
<p>
		<label id="address2">Address Line 2<br />
		<form:input path="personalInfo.address2" />
		<form:errors path="personalInfo.address2" cssClass="error" />
		</label>
</p>
<p>
		<label id="city">City<br />
		<form:input path="personalInfo.city" />
		<form:errors path="personalInfo.city" cssClass="error" />
		</label>
</p>
<p>		
		<label id="state">State<br />
		<form:input path="personalInfo.state" />
		<form:errors path="personalInfo.state" cssClass="error" />
		</label>
</p>
<p>		
		<label id="country">Country<br />
		<form:input path="personalInfo.country" />
		<form:errors path="personalInfo.country" cssClass="error" />
		</label>
</p>
<p>
		<label id="zipcode">Zipcode<br />
		<form:input path="personalInfo.zipcode" />
		<form:errors path="personalInfo.zipcode" cssClass="error" />
		</label>
</p>
<p>
		<label id="phoneNumber">Phone Number<br />
		<form:input path="personalInfo.phoneNumber" />
		<form:errors path="personalInfo.phoneNumber" cssClass="error" />
		</label>
</p>
<p>
		<label id="email">Email Address<br />
		<form:input path="personalInfo.emailAddress" />
		<form:errors path="personalInfo.emailAddress" cssClass="error" />
		</label>
</p>
		<div class="clear"></div>
		<input id="submit" type="submit" name="submit" value="Register" />
</form:form>
</div>
</body>
</html>