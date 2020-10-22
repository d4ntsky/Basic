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

<!-- id...부분 확인 -->

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
		<td id="id">
		<%=bbs.getId() %>
		</td>
	</tr>
	<tr>
		<th>작성시간</th>
		<td id="wdate">
		<%=bbs.getWdate() %>
		</td>
	</tr>
	<tr>
		<th>제목</th>
		<td id="title">
		<%=bbs.getTitle() %>
		</td>
	</tr>
	<tr align="left">
		<th colspan="2">내용</th>
	</tr>
	<tr>
		
		<td colspan="2">
		<textarea rows="25" cols="100" id="content"><%=bbs.getContent() %></textarea>
		</td>
	</tr>
	
	<tr>
		<td align="left">

			조회수:<%=bbs.getReadcount() %>
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
	<button type="button" id="btnUd" onclick="updateBbs(<%=bbs.getSeq() %>)">수정</button>		<!-- 수정화면?  -->
	<button type="button" id="btnDl" onclick="deleteBbs(<%=bbs.getSeq() %>)">삭제</button>		<!-- 기능 추가하기	링크 빼주면서 --이 글은 삭제된 글입니다 -->
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
	//수정누르면 값 그대로 가져가서 뿌리고 고칠수 있게 한다음 저장 누르면 update 되게
	
}

function deleteBbs(seq) {
	location.href = "bbsdelete.jsp?seq=" + seq;
}

</script>


</body>
</html>