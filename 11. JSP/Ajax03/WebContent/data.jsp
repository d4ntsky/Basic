<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// MVC model 1

// DB 접근 - 가정
int userNumber = 2002;
String userName = "홍길동";

String json = "{ \"num\":" + userNumber + ", \"name\":\"" + userName + "\" }";
System.out.println(json);

	out.println(json);	//model 1일 경우!! json화 해서 사용한 거라 보면 되려나...
%>