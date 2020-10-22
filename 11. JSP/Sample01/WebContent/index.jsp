<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//java 영역
	//<head>부분에 사용하면 안 된다!!
	String str = "Hello JSP";

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- HTML 주석문 -->

<%-- JSP 주석문 --%>

<%-- 
	JSP : Java Server Page
	
										Web Application Server - 
					request				
	Client			----- >		Web Server		----- >		Container 		----- >		DB(Server)
	HTML						thread가 돌며 대기				Servlet	공간(Get, Post)
	Java Script													java(html)
	CSS								해석				< --	JSP 	공간(공간 통합되어)
	JQeury(Ajax)							
	Vue, React					
					< -----										
					response
	cf) WAS 검색하면 같은 그림
	cf) Server는 계속 켜져있고 Client의 url 줘서 켜는게 보통...
	cf) Java EE tools로 web.xml를 만들면 나오는 welcome-file로 default 되어있음
 --%>
 
<h1>Hello JSP</h1>
 
<% 
 	// java 영역
 	// Scriptlet = script + applet
 	System.out.println("console 출력");

	/*
		내장(암시) 객체 : new를 통해서 생성하지 않고 바로 사용할 수 있는 class
			out			: Scriptlet(java)에서 Web으로 출력해 주는 객체
			request		: 매개변수의 값을 취득하는 경우 사용하는 객체, 객체를 저장 시에도 사용. 
			response	: 이동(응답)을 실시하는 객체. sendRedirect
			session		: 개체를 저장 시 사용
			pageContext	: forward의 소속
	*/
%>

<%
out.println("<h3>Hello Jsp</h3>");
%>

<%
System.out.println("str = " + str);
out.println("str = " + str);
%>
<br>
<%=str %>

<%	//1
for(int i = 0; i < 3; i++) {
%>
	<p class="demo1">p tag 1 <%=i %></p>
<%
}
%>

<%	//2
for(int i = 0; i < 3; i++) {
	out.println("<p class='demo2'>p tag 2 " + i + "</p>");
}
%>
	<%-- 2번보다는 1번을 실무에서 더 많이 사용한다. --%>

<%--
	JSP, HTML 차이점
		1. jsp = java + html 코드를 사용가능 
		2. html은 입력받고 넘겨주는 처리가 가능. 넘겨 받은 값을 출력해 주는 것은 어렵다. (Ajax가 할 수 있다.) 
 --%>
 
str:	<input type="text" value="<%=str %>">
<br>
<p><%=str %></p>
<br>
<textarea rows="10" cols="20"><%=str %></textarea>

</body>
</html>