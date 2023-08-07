<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coustomer login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h2>Login to start shopping</h2>
<div class="login">
<form id="login "method="post" action="log">
<label><b>User Name</b>
</label>   <br>
<input type="text" name="uname" id="textBox" placeholder="username">
<br><br>
<label><b>Password</b>
</label>   <br>
<input type="text" name="pass" id="textBox" placeholder="password">
<br><br>
<input type="submit" id="sub" value="Login">
<br><br>
<a href="register.jsp">New user? Register here </a>
</form>
</div>

</body>
</html>