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
		MemberDto mem = (MemberDto) request.getSession().getAttribute("login");
	%>

	<%
		BbsDao dao = BbsDao.getInstance();
	BbsDto parentBbs = dao.getBbs(seq); //부모글 데이터 들어있음
	%>

	<div align="left">
	<h1>기본글</h1>
		<form>
			<table border="1">
				<tr>
					<th>작성자</th>
					<td><%=parentBbs.getId()%></td>
				</tr>

				<tr>
					<th>제목</th>
					<td><%=parentBbs.getTitle()%></td>
				</tr>

				<tr>
					<th>작성일</th>
					<td><%=parentBbs.getWdate()%></td>
				</tr>

				<tr>
					<th>조회수</th>
					<td><%=parentBbs.getReadcount()%></td>
				</tr>

				<!-- <tr>
	<th>정보</th>
	<td></td>
	</tr> -->

				<tr>
					<th colspan="2">내용</th>
				</tr>

				<tr>
					<td colspan="2"><textarea rows="25" cols="100"
							readonly="readonly"><%=parentBbs.getContent()%></textarea></td>
				</tr>
			</table>
		</form>
	</div>

	<br>
	<hr>
	<br>

	<div align="right">
	<h1>답글</h1>
		<form action="answerAf.jsp" method="post">
		<input type="hidden" name="seq" value="<%=parentBbs.getSeq()%>">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><input value="<%=mem.getId()%>" name="id"></td>
				</tr>

				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>

				<tr>
					<th colspan="2">내용</th>
				</tr>

				<tr>
					<td colspan="2"><textarea rows="10" cols="50" name="content"></textarea></td>
				</tr>

				<tr align="right">
					<td colspan="2">
						<button type="submit">답글</button>
					</td>
				</tr>
			</table>
		</form>
	</div>

<!-- 
ref		그룹번호==부모글 번호
step
depth
기본글은 ref 6 step 0 depth 0	하나씩 깊어지는
두번째댓글		611
첫댓글		611	두번째글이 들어온후 :	 621
첫댓글의 댓글									632
cf) 답글은 ref 유지 step은 그냥 일정한 순서로 depth는 답글의 답글
 -->

</body>
</html>