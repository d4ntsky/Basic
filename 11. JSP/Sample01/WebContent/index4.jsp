<%@page import="sample01.YouClass"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- response(응답): sendRedirect() -> HttpServletResponse --%>
<%--
//1
String name = "홍길동";
name = URLEncoder.encode(name); //???바꿔줌
response.sendRedirect("NewFile.jsp?name=" + name);
--%>

<%--
//2
String name = "일지매";
request.setAttribute("name", name); //짐싸
pageContext.forward("NewFile.jsp"); //잘가
--%>

<%--
//3
YouClass cls = new YouClass(1, "성춘향");
request.setAttribute("cls", cls);
pageContext.forward("NewFile1.jsp");
--%>

<%
//4 HttpSession == JSP에선 session
YouClass cls = new YouClass(2, "정수동");

//session.setAttribute("ycls", cls); //어제 숙제와 비슷
//==
request.getSession().setAttribute("ycls", cls);

response.sendRedirect("NewFile2.jsp");
%>

</body>
</html>