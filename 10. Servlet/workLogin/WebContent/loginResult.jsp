<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	private boolean isEmpty(String str) {
		if( str == null || str.trim().equals("") ) {
			return true;
		}
			return false;
	}
	private final String successHtml = "<h1>로그인 상태입니다</h1> \n"
									  +"<a href=\"logout.jsp\">로그아웃</a>";	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	Boolean isLogined = (Boolean) session.getAttribute("isLogined");
	
	//로그인 상태인지 여부 확인
	if(isLogined != null && isLogined) {
		out.println(successHtml);
	}else{
		//로그인 상태가 아닌 경우
		//id와 비밀번호를 모두 입력했는지 여부 확인
		if(id.equals(password)) {
			session.setAttribute("isLogined", true);
			out.println(successHtml);
		}else {
			//id와 password가 같은 값이 아니면 로그인 실패로 간주
			response.sendRedirect("/login.html");
		}
	}
		
%>

</body>
</html>