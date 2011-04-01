<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/styles.css" type="text/css" />
<title>Login</title>
</head>
<body>
<div id="login-form-container">
<h3>Image Here</h3>
<form id="login-form" name="f" action="j_spring_security_check" method="POST">
<p>
	<label id="username">Username<br />
	<input type="text" name="j_username" value="" size="20" tabindex="20"></label>
</p>
<p>
	<label id="password">Password<br />
	<input type="password" name="j_password" value="" size="20" tabindex="21"/></label>
</p>
<p>
	<label id="remember-me-label"><input id="remember-me" type="checkbox" name="_spring_security_remember_me"/>Remember Me</label>
	<input id="submit" type="submit" name="submit" value="Log In" />
</p>
</form>
<div class="clear"></div>
<a href="user/add">Register</a>
</div>
</body>
</html>