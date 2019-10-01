<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style type="text/css">
body{
	background-color: black;
}
p{
	color: lime;
	font-size: 30px;
	text-align: right;
}
</style>
</head>
<body>
<%@ include file="header.html" %>
<form action="checkuser" method="get">
	<p> <input type="text" name="username" placeholder="Enter UserName"> </p>
	<p> <input type="password" name="passwd" placeholder="Enter Password"> </p>
	<p> <input type="submit" value="Sign In"> </p>
	</form>
<%@ include file="footer.html" %>
</body>
</html>