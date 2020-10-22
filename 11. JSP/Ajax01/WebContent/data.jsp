<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//data를 받아서 뿌려주는 게 가능 (html은 안 됨)

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

t1=<%=request.getParameter("t1") %>

t2=<%=request.getParameter("t2") %>

</body>
</html>