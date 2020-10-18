<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write.jsp</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');
body{
    font-family: 'Noto Sans KR';
}
h1{
   width:900px;
   margin:50px auto;
   text-align:center;
}
#table_write{
   width:720px;
   margin:50px auto;
   text-align:center;
}
#a_go_to_write{
   height:70px;
}
#a_go_to_write a{
   padding:10px;
   text-decoration:none;
   border:0.5px solid #a3a1a1;
   color:#fc9d9a;
}
#a_go_to_write a:hover{
   padding:10px;
   text-decoration:none;
   border:0.5px solid #fc9d9a;
   color:#fc9d9a;
   
}
#a_go_to_write input{
   padding:10px;
   text-decoration:none;
   border:0.5px solid #a3a1a1;
   color:#fc9d9a;
}
#a_go_to_write input:hover{
   padding:10px;
   text-decoration:none;
   border:0.5px solid #fc9d9a;
   color:#fc9d9a;
   
}
#title{
   width:720px;
   height:30px;
}
</style>
</head>
<body>
<h1>글쓰기</h1>
<form method='post' action='boardsave.do' name='writeForm'>
<table id='table_write'>
   <tr>
      <td colspan=2>
         <input type='text' name='title' id='title' placeholder='제목'>
         <input type='hidden' name='titleVal' value='0'>
      </td>
      
   </tr>
   <tr>
      <td colspan=2>
         <textarea rows="30" cols="100" name='content' placeholder='1000자 이내로 작성해주세요.'></textarea>
         <input type='hidden' name='ContentVal' value='0'>
         </td>
   </tr>
   <tr id='a_go_to_write'>
      <td align='left'><a href='/bselect.do'>취소</a></td>
      <td align='right'><input type='submit' value='발행'></td>
   </tr>
</table>
</form>
</body>
</html>