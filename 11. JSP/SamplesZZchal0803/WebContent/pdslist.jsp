<%@page import="dto.MemberDto"%>
<%@page import="dto.PdsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.PdsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
PdsDao dao = PdsDao.getInstance();
List<PdsDto> list = dao.getPdsList();

MemberDto mem = (MemberDto)session.getAttribute("login");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pds list</title>
</head>
<body>

<h1>자료실</h1>
<hr>

<div align="center">
<table border="1">
<col width="70"><col width="100"><col width="400"><col width="100"><col width="80"><col width="120"><col width="120">

	<tr>
		<th>번호</th><th>작성자</th><th>제목</th><th>다운로드</th><th>조회수</th><th>다운로드수</th><th>작성일</th>
	</tr>
	
	<%
	if(list.size() == 0) {
	%>
		<tr>
			<td colspan="7">자료가 없습니다</td>
		</tr>
	<%
	}else{
		
		for(int i = 0; i < list.size(); i++) {
		PdsDto pds = list.get(i);
		%>
			<tr align="center" height="5">
			
				<th><%=i+1 %></th>
				
				<td><%=pds.getId() %></td>
				
				<td align="left">
					<a href="pdsdetail.jsp?seq=<%=pds.getSeq()%>">
						<%=pds.getTitle()%>
					</a>
				</td>
				
				<td>
					<input type="button" name="btndown" value="파일" onclick="location.href='filedown?filename=<%=pds.getFilename() %>&seq=<%=pds.getSeq() %>'">		
																			<!-- 작업용 a tag -->				<!-- servlet 자바코드  파일이름을 알아야 받고 seq를 다운로드 카운드 때문에 넣어줬다-->
				
				</td>
				
				<td><%=pds.getReadcount() %></td>	<!-- 빼는편  -->
				
				<td><%=pds.getDowncount() %></td>
				
				<td><%=pds.getRegdate() %></td>		<!-- 빼는편 -->
				
			</tr>
		<%
		}
	}
	%>	
</table>

<br>

<a href="pdswrite.jsp">자료 올리기</a>

</div>

<!-- 검색, 페이징 기능 -->

</body>
</html>