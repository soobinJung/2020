<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
table {
	border: 1px solid black;
	padding: 30px; width : 300px;
	margin: 50px auto;
	text-align: center;
	width: 300px;
}
h1 {
	text-align: center;
}
height:100%;

}
body {
	text-align: center;
	width: 400px;
	border: 1px;
	margin: 50px auto;
	text-align: center;
}
body:before {
	content: '';
	height: 100%;
	display: inline-block;
	vertical-align: middle;
}
button {
	background: #1AAB8A;
	color: #fff;
	border: none;
	position: relative;
	height: 60px;
	font-size: 1.6em;
	padding: 0 2em;
	cursor: pointer;
	transition: 800ms ease all;
	outline: none;
}
button:hover {
	background: #fff;
	color: #1AAB8A;
}
button:before, button:after {
	content: '';
	position: absolute;
	top: 0;
	right: 0;
	height: 2px;
	width: 0;
	background: #1AAB8A;
	transition: 400ms ease all;
}
button:after {
	right: inherit;
	top: inherit;
	left: 0;
	bottom: 0;
}
button:hover:before, button:hover:after {
	width: 100%;
	transition: 800ms ease all;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<h1>MAIN</h1>
	<form action="/login.do">
		<table>
			<tr>
				<td><h2>ID</h2></td>
				<td><input type="text" placeholder="username" id='id' name='id' /></td>
			</tr>
			<tr>
				<td><h2>PASS</h2></td>
				<td><input type="text" placeholder="password" id='pass' name='pass' /></td>
			</tr>
			<tr>	
				<td height="40"></td>
			</tr>
			<tr>
				<td><button type="button" onclick="location.href='/SignUp.jsp'">SIGN UP</button></td>
				<td><button type="submit">LOGIN</button></td>
			</tr>
		</table>
	</form>
</body>
</html>