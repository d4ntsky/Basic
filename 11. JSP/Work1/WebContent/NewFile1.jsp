<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String str = "Hello World!";
%>
<h1><%=str %></h1>
<br>
<% 
out.println("<p>Hello World</p>");
%>
<br><hr><br>

-시간을 출력하는 예-<br>
현재 시간은 <%  %>입니다.
<br><hr><br>
 
현재는 <% %>시입니다.<br>
<%
/*
if(  ) {
	out.println("안녕히 주무셨어요");
}else if(  ) {
	out.println("안녕하세요");
}else {
	out.println("안녕히 주무세요");
}
*/
%>
<br><hr><br>

--입력 페이지--<br>
이름:	<input type="text"><br>
생년월일:	<input type="text"><br>
<button type="button">OK</button>
<br><hr><br>

--메소드를 사용하는 예--<br>
<%!

%>
<p style="color:#ff0000">빨간색 텍스트</p>
<p>파란색 텍스트</p>
<p>초록색 텍스트</p>
<br><hr><br>

</body>
</html>