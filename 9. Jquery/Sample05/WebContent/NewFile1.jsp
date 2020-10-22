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
//가급적 위에서 받는 게 좋음
String name = request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age"));
String address = request.getParameter("address");

System.out.println(name + " " + age + " " + address);
%>

</body>
</html>