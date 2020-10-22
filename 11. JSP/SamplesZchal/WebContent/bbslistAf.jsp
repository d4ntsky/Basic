<%@page import="dto.MemberDto"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
// 댓글의 depth와 image를 추가하는 함수		ex) depth = 1 이면 ' '  - >
								//	ex) depth = 2 이면 '  ' - >
								//					 &nbsp
								
								
public String arrow(int depth) {
	String rs = "<img src='./image/arrow.png' width='20px' height='20px' />";
	String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
	
	String ts = "";
	for(int i = 0; i < depth; i++) {
		ts += nbsp;
	}
		   //1 == 0?"":ts
	return depth==0?"":ts+rs;	//삼항 연산자
}
%>   

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

String choice = request.getParameter("choice");
String srchword = request.getParameter("srchword");

System.out.println(choice + " " + srchword);

BbsDao dao = BbsDao.getInstance();
List<BbsDto> sclist = dao.searchList(choice, srchword);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>	

<body>

<div align="center">
<table border="1">
<col width="70"><col width="600"><col width="150">
	<tr>
		<th>번호</th><th>제목</th><th>작성자</th>
	</tr>
	<%
	if(sclist == null || sclist.size() == 0) {
		%>
		<tr>
			<td colspan="3">작성된 글이 없습니다</td>
		</tr>
		<%
	}else{
		for(int i = 0; i < sclist.size(); i++) {
			BbsDto bbs = sclist.get(i);
		%>
		<tr>
			<th><%=i+1 %></th>
			<td>
				<%=arrow(bbs.getDepth()) %>								<!-- 여백 이미지 추가, 확인!  -->
				
				
				
				<% 
				if(bbs.getDel() == 0) { 
				%>
					<a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>">
					<%=bbs.getTitle() %>
				</a>
				<% 
				}else{
				%>
					이 글은 요청에 의해 삭제 되었습니다.
				<% 
				}
				%>
				
				<%-- 
				del만 바뀌고 제목표시는 
				<a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>">
					<%=bbs.getTitle() %>
				</a>
				 --%>
					
					
					
					
								
			</td>
			<td align="center"><%=bbs.getId() %></td>
		</tr>

		<%
		}
	}
	%>
</table>
</div>

</body>
</html>