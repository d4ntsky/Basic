<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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


int seq = Integer.parseInt(request.getParameter("seq"));

BbsDto bdto = null;
BbsDao dao = BbsDao.getInstance();
bdto = dao.readBbs(seq);


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>	
</head>
<body>

<div align="center">
<form>
<table border="1">
	<tr>
		<th>번호</th>
		<td id="seq">
		<%=bdto.getSeq() %>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>
		<%=bdto.getId() %>
		</td>
	</tr>
	<tr>
		<th>작성시간</th>
		<td>
		<%=bdto.getWdate() %>
		</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>
		<%=bdto.getTitle() %>
		</td>
	</tr>
	<tr align="left">
		<th colspan="2">내용</th>
	</tr>
	<tr>
		
		<td colspan="2">
		<textarea rows="50" cols="100"><%=bdto.getContent() %></textarea>
		</td>
	</tr>
	
	<tr align="right">
		<td colspan="2">
			<button type="button" id="deleteBtn">삭제</button>
		</td>
	</tr>
	
</table>
</form>
</div>


<script type="text/javascript">

//삭제
$("#deleteBtn").click(function () {
	
		location.href = "bbsdelete.jsp?seq=" + $("#seq").text();
});

//수정


</script>
</body>
</html>