<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board.jsp</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>

@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');

body {
	font-family: 'Noto Sans KR';
}

h1 {
	width: 900px;
	margin: 50px auto;
	text-align: center;
	background-color: #5CAB7D;
	color: white;
	padding-top: 20px;
	padding-bottom: 20px;
	border: 0;
	border-radius: 20px;
}

hr {
	color: #dddfe6;
}

#table_board {
	width: 900px;
	margin: 50px auto;
	text-align: center;
}

#line {
	height: 10px;
}

#subject {
	height: 40px;
}

#a_go_to_write {
	height: 70px;
}

#a_go_to_write a {
	padding: 10px;
	text-decoration: none;
	border: 0.5px solid #a3a1a1;
	color: #fc9d9a;
}

#a_go_to_write a:hover {
	padding: 10px;
	text-decoration: none;
	border: 0.5px solid #fc9d9a;
	color: #fc9d9a;
}

#keyfield {
	width: 100px;
	height: 30px;
}

#keyword {
	width: 250px;
	height: 30px;
}

#search {
	padding: 3px;
	text-decoration: none;
	color: gray;
	border: 0.5px solid gray;
}

#tr_target:hover {
	background-color: #FBFFB9;
}
</style>
</head>
<body>
	<h1>자유게시판</h1>
	<form action="/boardsearch.do">
		<table id='table_board'>
			<tr id='line'>
				<td colspan=4><hr></td>
			</tr>
			<tr id='subject'>
				<td>제목</td>
				<td>작성일</td>
				<td>추천</td>
				<td>조회</td>
			</tr>
			<tr id='line'>
				<td colspan=4><hr></td>
			</tr>
			<c:if test="${cheak eq 'X'}">
					<tr id='tr_target'>
				      <td>게시물이 없습니다</td>
				      <td></td>
				      <td></td>
				      <td></td>
				   </tr>
				   <tr id='line'>
				      <td colspan=4 ><hr></td>
				   </tr>
			</c:if>
			<c:if test="${cheak eq 'O'}">
				<c:forEach var="Board" items="${list}">
				   <tr id='tr_target'>
				      <td><a href='/bdetail.do?B_ID=${Board.b_ID}&B_TITLE=${Board.b_TITLE}&B_UPDATE=${Board.b_UPDATE}&B_UPTIME=${Board.b_UPTIME}'>${Board.title}</a></td>
				      <td>${Board.update}</td>
				      <td>${Board.likes}</td>
				      <td>${Board.hits}</td>
				   </tr>
				   <tr id='line'>
				      <td colspan=4 ><hr></td>
				   </tr>
				</c:forEach>
			</c:if>
	
			<tr id='a_go_to_write'>
				<td colspan=2 align='left'><a href='/boardwrite.do'>글쓰기</a></td>
				<td colspan=2 align='right'><a href='#'>내글보기</a></td>
			</tr>
			<tr>
				<td colspan=4>
					<select id='keyfield' name='keyfield'>
							<option>제목+내용</option>
							<option>글제목</option>
							<option>작성자</option>
					</select>
					 <input type="text" id='keyword' name='keyword' placeholder="검색어를 입력하세요"> 
					 <button type="submit" id='search'>검색</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>