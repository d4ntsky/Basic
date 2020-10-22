<%@page import="dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
MemberDao dao = MemberDao.getInstance();
List<MemberDto> list = dao.getMemberList();

//값이 NULL이 되면.........................

String json;

out.println("[");
for(int i = 0; i < list.size()-1; i++) {
	MemberDto mem = list.get(i);
	
	json = "{ \"id\":\"" + mem.getId() + "\", \"name\":\"" + mem.getName() + "\", \"address\":\"" + mem.getEmail() + "\" },";
	
	
	out.println(json);
}

for(int i = list.size()-1; i < list.size(); i++) {
	MemberDto mem = list.get(i);
	
	json = "{ \"id\":\"" + mem.getId() + "\", \"name\":\"" + mem.getName() + "\", \"address\":\"" + mem.getEmail() + "\" }";
	
	
	out.println(json);
}
out.println("]");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	//db넣어주는 작업 하는 곳

	//데이터 가져오기
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");
String email = request.getParameter("email");

System.out.println(id+" "+pwd+" "+name+" "+email);


boolean isS = dao.addMember(new MemberDto(id, pwd, email, name, 3) );

if(isS) {
%>
	<script type="text/javascript">
	alert("성공적으로 추가되었습니다.");
	location.href = "login.jsp";
	</script>
<%
}else {
%>	
	<script type="text/javascript">
	alert("추가되지 않았습니다.");
	location.href = "regi.jsp";
	</script>
<%
}
%>
</body>
</html>