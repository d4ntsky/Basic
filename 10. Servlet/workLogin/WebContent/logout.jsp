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
	HttpSession useSession = request.getSession();
	useSession.invalidate();
	out.println("<h1>로그아웃 되었습니다.</h1>");
%>

</body>
</html>