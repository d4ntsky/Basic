<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String sseq = request.getParameter("seq");
int seq = Integer.parseInt(sseq);
%>        
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbsdetail.jsp</title>
</head>
<body>
<!-- 
	<table>
	작성자(id)	<td>
	제목
	작성일(wdate)
	조회수
	정보
	내용	textarea
 -->

<%
MemberDto mem = (MemberDto)request.getSession().getAttribute("login");
%>

<%
BbsDao dao = BbsDao.getInstance();

dao.readcount(seq);
BbsDto bbs = dao.getBbs(seq);
%>

<h1>상세 글 보기</h1>

<div align="center">

<table border="1">
<colgroup>
	<col style="width: 200px">
	<col style="width: 400px">
</colgroup>

<tr>
	<th>작성자</th>
	<td><%=bbs.getId() %></td>
</tr>

<tr>
	<th>제목</th>
	<td><%=bbs.getTitle() %></td>
</tr>

<tr>
	<th>작성일</th>
	<td><%=bbs.getWdate() %></td>
</tr>

<tr>
	<th>조회수</th>
	<td><%=bbs.getReadcount() %></td>
</tr>

<tr>
	<th>정보</th>
	<td><%=bbs.getRef() %>-<%=bbs.getStep() %>-<%=bbs.getDepth() %></td>
</tr>

<tr>
	<th>내용</th>
	<td align="center">
	<textarea rows="15" cols="90" readonly="readonly"><%=bbs.getContent() %></textarea>
	</td>
</tr>
</table>
<%
if(bbs.getId().equals(mem.getId())){
	%>	
	<button type="button" onclick="updateBbs(<%=bbs.getSeq() %>)">수정</button>
	<button type="button" onclick="deleteBbs(<%=bbs.getSeq() %>)">삭제</button>
	<%
}
%>
<%--  
<button type="button" onclick="answerBbs(<%=bbs.getSeq() %>)">댓글</button>
 --%> 
 
<form action="answer.jsp" method="get">
	<input type="hidden" name="seq" value="<%=bbs.getSeq() %>">
	<input type="submit" value="댓글">
</form> 

</div>

<script type="text/javascript">
function updateBbs(seq) {
	location.href = "bbsupdate.jsp?seq=" + seq;
}

function deleteBbs(seq) {
	location.href = "bbsdelete.jsp?seq=" + seq;
}



</script>



</body>
</html>











