<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

//System.out.println("id and pwd = " + id + " " + pwd);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginAf.jsp</title>

<!-- 
	 model1의 경우고
	 model2의 경우는 controller로
 -->
</head>
<body>

<%
MemberDao dao = MemberDao.getInstance();

MemberDto mem = dao.login(id, pwd);

if(mem != null && !mem.getId().equals("")) {	//!mem 확인
	// login 정보 저장 - 그 사람이 게시글 남기면 그 사람 이름이 남아야 하기 때문에
	session.setAttribute("login", mem); //pwd 제외한 나머지 정보
	session.setMaxInactiveInterval(30 * 60 * 60);	//세션 유지 시간
													//세션에 저장되는 시간!! 실무에선1시에서 2시간 사이
	%> 
	<script type="text/javascript">
	alert("안녕하세요 <%=mem.getName() %>님");
	location.href = "bbslist.jsp";
	</script>
	<%
}else{	//ajax로 만들면 화면이 변경되지 않고 확인한다.!!
	%>
	<script type="text/javascript">
	alert("id나 password를 확인하십시오");
	location.href = "login.jsp";
	</script>
	<%
}
%>
</body>
</html>