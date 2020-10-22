<%@page import="dto.MemberDto"%>
<%@page import="dao.PdsDao"%>
<%@page import="dto.PdsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
MemberDto mem = (MemberDto)request.getSession().getAttribute("login");

int seq = Integer.parseInt(request.getParameter("seq"));

PdsDao dao = PdsDao.getInstance();
dao.readcount(seq);
PdsDto dto = dao.getPds(seq);


System.out.println("seq = " + seq);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>	

</head>
<body>

<!-- 
	pdsdetail -> 다운로드
	pdsupdate
	pdsdelete 
	
 -->

<h1>자료 확인</h1>

<div align="center">
<form id="frm">
<table border="1">
<col width="200"><col width="500">
	
	<tr>
		<th>작성자</th>
		<td>
			<input type="text" value="<%=dto.getId() %>" readonly="readonly" name="id">
		</td>
	</tr>
	
	<tr>
		<th>제목</th>
		<td>
			<input type="text" value="<%=dto.getTitle() %>" name="title">
		</td>
	</tr>
	
	<tr>
		<th>조회수</th>
		<td>
			<%=dto.getReadcount() %>
		</td>
	</tr>

	<tr>
		<th>등록일</th>
		<td>
			<%=dto.getRegdate() %>
		</td>
	</tr>
	
	<tr>
		<th>다운로드</th>
		<td>
			<%=dto.getFilename() %>
			<button type="button" onclick="location.href='filedown?filename=<%=dto.getFilename() %>&seq=<%=dto.getSeq() %>'">다운받기</button>
			
			&nbsp;&nbsp;&nbsp;&nbsp;다운로드 수:&nbsp;&nbsp;<%=dto.getDowncount() %>
																														<!-- 수정할 때 파일도 바꿀 수 있어야 되나... -->
		</td>
	</tr>
	
	<tr>
		<th colspan="2">내용</th>
	</tr>
	
	<tr align="center">
		<td colspan="2">
			<textarea rows="20" cols="100" name="content"><%=dto.getContent() %></textarea>
		</td>
	</tr>
	
	
	
	<!-- 로그인한 아이디와 등록된 아이디가 같을 때만 -->
<%
if(dto.getId().equals(mem.getId())){
	%>	
	<tr align="center">
		<td colspan="2">
			<table>
			<tr>
			<td>
				<button type="submit" id="updBtn">수정하기</button>
			</td>

			<td>
				<button type="button" onclick="goDel()">삭제하기</button>
			</td>
			</tr>
			</table>
		</td>
	</tr>
	<%
}
%>
	
	
	<tr>
		<td colspan="2">
		<button type="button" onclick="location.href='pdslist.jsp'">돌아가기</button>
		</td>
	</tr>
	<tr>
		<th>확인용 sequence</th>
		<td><%=dto.getSeq() %></td>
	</tr>

<!-- 	
	SEQ, ID, TITLE, CONTENT, FILENAME, "
				   + " READCOUNT, DOWNCOUNT, REGDATE
	 -->
</table>
</form>
</div>

<script type="text/javascript">

$("#updBtn").click(function() {
	
	$("#frm").attr({ "action":"pdsupdate.jsp?seq=<%=seq %>", "method":"post"});
	$("#frm").submit();
});

function goDel() {
	location.href = "pdsdelete.jsp?seq=" + <%=seq %>;
}
</script>


</body>
</html>