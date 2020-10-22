<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
    
<%
Object ologin = session.getAttribute("login");
MemberDto mem = null;
if(ologin == null) { //session이 끝나서 ... 
	%>
	<script type="text/javascript">
	alert("로그인 해 주십시오");
	location.href = "login.jsp";
	</script>
	<%
}
mem = (MemberDto)ologin;

BbsDao dao = BbsDao.getInstance();
List<BbsDto> list = dao.getBbsList();


%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbswrite.jsp</title>
</head>
<body>

<div align="center">
<form action="bbswriteAf.jsp?id=<%=mem.getId() %>" method="post">
<table border="1">

	<tr>
		<th>작성자</th>
		<td>
			<div id="id" name="id"><%=mem.getId() %></div>
		</td>
	</tr>
	
	<tr>
		<th>제목</th>
		<td>
			<input type="text" width="100" id="title" name="title">
		</td>
	</tr>
	<tr align="left">
		<th colspan="2">내용</th>
	</tr>
	<tr>
		<td colspan="2">
			<textarea rows="30" cols="100" id="content" name="content"></textarea>
		</td>
	</tr>
		<col width="100"><col width="100">
	<tr>
		
		<td align="left">
			<input type="button" value="목록으로 돌아가기" onclick="location.href='bbslist.jsp'">
			
		</td>
		<td align="right">
			<input type="submit" value="글 추가하기">
		</td>
	</tr>

</table>
</form>
</div>
 
</body>
</html>