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
String num = request.getParameter("num");
System.out.println("num : " + num);

String day = request.getParameter("today");
System.out.println("today : " + day);

String clr = request.getParameter("Choice color");
System.out.println("color : " + clr);

String rnge = request.getParameter("LikeNum");
System.out.println("range : " + rnge);

String srch = request.getParameter("srch");
System.out.println("search : " + srch);
%>
</body>
</html>