<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<pre>
ID:  <input type="text" value="" placeholder="아이디">
PW:  <input type="text" value="" placeholder="비밀번호">

취미
<input type="checkbox" class="hobby" value="sleep">잠자기
<input type="checkbox" class="hobby" value="sing">노래하기
<input type="checkbox" class="hobby" value="playgame">게임하기

연령대
<input type="radio" name="age" value="10">10대
<input type="radio" name="age" value="20">20대
<input type="radio" name="age" value="30">30대
<input type="radio" name="age" value="40">40대
<input type="radio" name="age" value="50">50대
<input type="radio" name="age" value="60">60대 이상

기타 하고싶은 말

<textarea rows="5" cols="50" id="VOC"></textarea>
</pre>
<button type="button">전송</button>
<button type="button">취소</button>


</body>
</html>