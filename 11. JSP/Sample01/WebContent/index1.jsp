<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- Scriptlet의 종류 --%>

<%!
	 // 1. 선언부 선언의 영역 : 변수(global)를 선언, 함수, class
public void func() {
	System.out.println("func() 호출")	;
}
	int gl_num = 0;	//글로벌 변수
%>

<%
	 // 2. 구현부 소스부 : logic
	 func();

	int lc_num = 0;	//로컬 변수
	
	gl_num++;
	lc_num++;		//새로고침으로 비교
	
	out.println("gl_num = " + gl_num);
	out.println("<br>");
	out.println("lc_num = " + lc_num);
	out.println("<br>");
%>

<%-- // 3. 값 value --%>
<%=123 %>

</body>
</html>