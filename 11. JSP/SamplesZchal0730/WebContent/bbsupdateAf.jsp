<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<%
int seq = Integer.parseInt(request.getParameter("seq"));
String title = request.getParameter("title");
String content = request.getParameter("content");

System.out.println(seq);
System.out.println(title);
System.out.println(content);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
BbsDao dao = BbsDao.getInstance();
boolean isS = dao.updateBbs(seq, title, content);

if(isS){
	
%>	
	<script type="text/javascript">
	alert("정상적으로 수정되었습니다");
	location.href = "bbslist.jsp";
	
	</script>
<%
}else{
%>
	<script type="text/javascript">
	alert("수정되지 않았습니다");
	location.href = "bbsupdate.jsp";
	</script>
<%
}
%> 

</body>
</html>