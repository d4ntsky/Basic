<%@page import="dao.BbsDao"%>
<%@page import="dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
/*
String id = request.
String wdate = request.getParameter("wdate");
String title = request.getParameter("title");
String content = request.getParameter("content");

System.out.println(title);
System.out.println(content);
*/
int seq = Integer.parseInt(request.getParameter("seq"));

BbsDao dao = BbsDao.getInstance();
BbsDto bbs = dao.getBbs(seq);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<div align="center">

<form action="bbsupdateAf.jsp?seq=<%=bbs.getSeq() %>" method="post">
	<table border="1">
	
	<caption style="font-size: 60px;">내용 수정</caption>
		
		
		<tr>
			<th>작성자</th>
			<td>
			<%=bbs.getId() %>
			</td>
			
		</tr>
		
		<tr>
			<th>작성했던 시간</th>
			<td><%=bbs.getWdate() %> (수정한 시간으로 안바뀐다)</td>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="<%=bbs.getTitle() %>"></td>
		</tr>
		<tr>
			<th colspan="2">내용</th>
		</tr>
		<tr>
			<td colspan="2"><textarea rows="30" cols="100" name="content"><%=bbs.getContent() %></textarea></td>
		</tr>
		
		
		<tr>
		
			<td align="left"><button>돌아가기</button></td>
			<td align="right"><button type="submit">수정</button></td>
		</tr>
	</table>
</form>
</div>

</body>
</html>