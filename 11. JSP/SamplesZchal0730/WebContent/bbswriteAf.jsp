
<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<%
String id = request.getParameter("id");
String title = request.getParameter("title");
String content = request.getParameter("content");

System.out.println("id:" + id);
System.out.println("title:" + title);
System.out.println("content:" + content);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
BbsDao bdao = BbsDao.getInstance();

boolean isS = bdao.writeBbs(new BbsDto(id, title, content));

if(isS){
%>
	<script type="text/javascript">
	alert("글이 성공적으로 등록 되었습니다");
	location.href = "bbslist.jsp";
	</script>
<%
}else{	//시퀀스 번호 초기화 안되는데?
%>
	<script type="text/javascript">
	alert("다시 기입해 주십시오");
	location.href = "bbswrite.jsp";
	</script>
<%
}
%>



</body>
</html>