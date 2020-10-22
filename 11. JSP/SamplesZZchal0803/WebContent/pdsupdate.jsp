<%@page import="dao.PdsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
int seq = Integer.parseInt(request.getParameter("seq"));
String title = request.getParameter("title");
String content = request.getParameter("content");
System.out.println("seq:" + seq);

PdsDao dao = PdsDao.getInstance();
boolean isS = dao.updatePds(seq, title, content);

if(isS){
	%>
	<script type="text/javascript">
	alert("수정하였습니다");
	location.href = 'pdslist.jsp';
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert("수정되지 않았습니다");
	location.href = 'pdsdetail.jsp';
	</script>	
	<%
}
%>


</body>
</html>