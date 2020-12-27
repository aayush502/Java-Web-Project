<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel = "stylesheet" href = "resources/css/style.css">
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Welcome!!!!!</h1>
<a href = "LoginController">logout</a>
<a href = "StudentController"></a>
<div class="wrapper">
			<nav class="navbar">
				<img class="logo" src = "resources/img/logo.png">
				<ul>
					<li> <a class = "active" href="#">Home</a></li>
					<li> <a href="#">Contact</a></li>
					<li> <a href="#">Login</a></li>
					<li> <a href="#">About us</a></li>
				</ul>
				</nav>
				<div class="center">
					<h1>Welcome Programmers</h1>
					<h2>Take a next step</h2>
					<div class="buttons">
						<button>Explore More</button>
						<button class="btn">View Us</button>
					</div>
				</div>
			</div>
</body>
</html>