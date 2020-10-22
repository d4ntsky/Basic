<%@page import="dto.MemberDto"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.BbsDto"%>
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
<title>answer.jsp</title>
</head>
<body>

<%
BbsDao dao = BbsDao.getInstance();
BbsDto parentBbs = dao.getBbs(seq);
%>

<%--
기본글 <table>
	작성자
	제목
	작성일
	조회수
	정보
	내용
	
답글	<table>
	아이디 login id <- session id	
	제목
	내용

 --%>
<h1>기본글</h1>

<div align="center">

<table border="2">
<col width="200"><col width="500">
<tr>
	<th>작성자</th>
	<td><%=parentBbs.getId() %></td>
</tr>
<tr>
	<th>제목</th>
	<td><%=parentBbs.getTitle() %></td>
</tr>
<tr>
	<th>작성일</th>
	<td><%=parentBbs.getWdate() %></td>
</tr>
<tr>
	<th>조회수</th>
	<td><%=parentBbs.getReadcount() %></td>
</tr>
<tr>
	<th>정보</th>
	<td></td>
</tr>
<tr>
	<th>내용</th>
	<td>
		<textarea rows="10" cols="70"><%=parentBbs.getContent() %></textarea>
	</td>
</tr>
</table>

<hr>

<%
MemberDto mem = (MemberDto)session.getAttribute("login");
%>

<h1 align="left">답글</h1>

<form action="answerAf.jsp" method="post">
<input type="hidden" name="seq" value="<%=parentBbs.getSeq() %>">

<table border="1">
<col width="200"><col width="500">

<tr>
	<th>아이디</th>
	<td>
		<input type="text" name="id" readonly="readonly" size="50"
			value="<%=mem.getId() %>">
	</td>
</tr>

<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" size="50">
	</td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<textarea rows="10" cols="70" name="content"></textarea>
	</td>
</tr>

<tr>
	<td colspan="2" align="center">
		<input type="submit" value="답글추가">
	</td>
</tr>

</table>
</form>

</div>

</body>
</html>



















