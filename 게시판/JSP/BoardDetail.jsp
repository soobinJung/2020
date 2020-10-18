<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardDetail.jsp</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');

body {
	font-family: 'Noto Sans KR';
}
hr {
	color: #dddfe6;
}
#table_container {
	width: 750px;
	border: 1px solid black;
	border-radius: 10px;
	margin: 50px auto;
	padding: 5px;
}
#table {
	width: 700px;
	margin: 0 auto;
}
#title {
	height: 40px;
}
#CustName {
	font-size: 10pt;
}
#line {
	height: 2px;
}

#go_to_list {
	height: 70px;
}
#go_to_list a {
	padding: 10px;
	text-decoration: none;
	border: 0.5px solid #a3a1a1;
	color: #fc9d9a;
}
#go_to_list a:hover {
	padding: 10px;
	text-decoration: none;
	border: 0.5px solid #fc9d9a;
	color: #fc9d9a;
}
#reply_box1 {
	border: 2.5px solid black;		
	background-color: white;
	height: 30px;
	padding: 20px;
}
#reply_box2 {
	background-color: black;
	height: 90px;
	padding: 20px;
}
#reply_content {
	width: 600px;
	height: 80px;
}
#a_reply_Save {
	padding: 10px;
	text-decoration: none;
	border: 0.5px solid #a3a1a1;
	color: #fc9d9a;
}
</style>
</head>
<body>
	<form method='post' action="/boardreply.do?B_ID=${board.b_ID}&B_TITLE=${board.b_TITLE}&B_UPDATE=${board.b_UPDATE}&B_UPTIME=${board.b_UPTIME}">
		<div id='table_container'>
			<table id='table'>
				<tr id='line'>
					<td colspan=2><hr></td>
				</tr>
				<tr>
					<td id='title' colspan=2><h1>${board.title}</h1></td>
				</tr>
				<tr id='line'>
					<td colspan=2><hr></td>
				</tr>
				<tr>
					<td id='title' colspan=2>${board.content}</td>
				</tr>
				<tr id='line'>
					<td colspan=2><hr></td>
				</tr>
				<tr id='go_to_list'>
					<td colspan=2>
						<a href='/board.do'>목록</a> 
						<a href='/boardlike.do?B_ID=${board.b_ID}&B_UPDATE=${board.b_UPDATE}&B_UPTIME=${board.b_UPTIME}'>추천해요 <font style='color: red;'>${like}</font></a> 
						<a href='#'>댓글 <font style='color:red;'>${replycount}</font></a>
						<a href='#'>조회수 <font style='color:red;'>${count}</font></a>
					</td>
				</tr>
				<c:forEach var="Reply" items="${replylist}">
					<tr>
						<td colspan=2 id='reply_box1'>${Reply.replyid}  (${Reply.replydate})<br>${Reply.reply} </td>
					</tr>
					<br>
				</c:forEach>
				<tr>
					<td colspan=2 id='reply_box2'>
						<textarea id='reply_content' name="reply" maxlength='600' placeholder="댓글을 달아주세요"></textarea><br>
					    <input type='submit' value='등록' id='a_reply_Save'>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>