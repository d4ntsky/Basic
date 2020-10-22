<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
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
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>	
</head>
<body>

<%
MemberDto mem = (MemberDto)request.getSession().getAttribute("login");
%>

<%
BbsDao dao = BbsDao.getInstance();

dao.readcount(seq);
BbsDto bbs = dao.getBbs(seq);
%>

<div align="center">
<form>
<table border="1">
	<tr>
		<th>번호</th>
		<td id="seq">
		<%=bbs.getSeq() %>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>
		<%=bbs.getId() %>
		</td>
	</tr>
	<tr>
		<th>작성시간</th>
		<td>
		<%=bbs.getWdate() %>
		</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>
		<%=bbs.getTitle() %>
		</td>
	</tr>
	<tr align="left">
		<th colspan="2">내용</th>
	</tr>
	<tr>
		
		<td colspan="2">
		<textarea rows="25" cols="100"><%=bbs.getContent() %></textarea>
		</td>
	</tr>
	
	<tr>
		<td align="left">

			조회수:<%=bbs.getReadcount() %>
		</td>
		<td align="right">
			<button type="button" id="deleteBtn">삭제</button>
		</td>
	</tr>
	<tr>
		<th>정보</th> 																	<!-- 개발자 확인용 -->
		<td><%=bbs.getRef() %>-<%=bbs.getStep() %>-<%=bbs.getDepth() %></td>
	</tr>
	
</table>
</form>

<%
if(bbs.getId().equals(mem.getId())) {	//로그인한 사람이 자기 글일 경우에만	//자기 글일 때만 보임
	%>
	<button type="button" onclick="updateBbs(<%=bbs.getSeq() %>)">수정</button>		<!-- 수정화면?  -->
	<button type="button" onclick="deleteBbs(<%=bbs.getSeq() %>)">삭제</button>		<!-- 기능 추가하기	링크 빼주면서 --이 글은 삭제된 글입니다 -->
	<%
}
//리스트로 돌아가는 버튼
%>

<%-- <button type="button" onclick="answerBbs(<%=bbs.getSeq() %>)">댓글</button> --%>

 <form action="answer.jsp" method="get">	<!-- 노출시켜도 상관없는 부분 -->
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