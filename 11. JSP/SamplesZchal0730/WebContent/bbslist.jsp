<%@page import="java.util.ArrayList"%>
<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.MemberDto"%>
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
//로그인 정보를 얻어오는 곳
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
%>

<%
//검색 부분 밑에 searchword랑 choice가 올라옴
String searchWord = request.getParameter("searchWord");
String choice = request.getParameter("choice");

if(choice == null || choice.equals("")) {	//처음 bbslist로 들어왔을 때가 choice==null
	choice = "sel";//밑에 선택
}
// 검색어를 지정하지 않고 Choice가 넘어왔을 때
if(choice.equals("sel")) {
	searchWord = "";	//null과 빈문자열은 다름!!
}
if(searchWord == null) {
	searchWord = "";
	choice = "sel";
}
%>

<%
BbsDao dao = BbsDao.getInstance();
//List<BbsDto> list = dao.getBbsList();	//검색기능 추가전
List<BbsDto> list = dao.getBbsList(choice, searchWord);
%>


<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->

<%-- <%!
public static bbslist(){
	String choice = "";
	String srchword = "";
	String abc = "";
}
%>
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbslist.jsp</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>	
</head>
<body>

<h4 align="right" style="background-color: #f0f0f0">
	환영합니다 <%=mem.getId() %>님
</h4>

<h1>게시판</h1>

<div align="center">
<table border="1">
<col width="70"><col width="600"><col width="150">
	<tr>
		<th>번호</th><th>제목</th><th>작성자</th>
	</tr>
	<%
	if(list == null || list.size() == 0) {
		%>
		<tr>
			<td colspan="3">작성된 글이 없습니다</td>
		</tr>
		<%
	}else{
		for(int i = 0; i < list.size(); i++) {
			BbsDto bbs = list.get(i);
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
	<tr align="right">
	<td colspan="3">
	<a href="bbswrite.jsp">글 쓰기</a>
	</td>
	</tr>
</table>
</div>
<br>
<br>
<br>

<div align="center">
	<table>
		<col width="30"><col width="50"><col width="50">
		<tr>
		<td>
			<select id="cho">
				<option value="sel">선택</option>
				<option value="wrt">작성자</option>
				<option value="sub">제목</option>
				<option value="ctt">내용</option>
			</select>
		</td>
		<td><input type="text" id="srch"></td>
		<td><button type="button" id="srchBtn" onclick="searchBbs()">검색</button></td>
		</tr>
	</table>
</div>


<script type="text/javascript">

//jquery로 document selected랑 input 받아서 검색 버튼 누르면 select로 sql dao 해서 ....

	//let choice	= document.querySelectorAll(#srch).value;
	//let choice = getSelection(cho).innerHTML;
	//let go = document.querySelector('input[name="animal"]:checked').value;
//alert(choice);

/*
//이전 버젼
$("#srchBtn").on("click", function () {
	
	let cho	 = $("#cho").val();
	let srchwor = $("#srch").val();
	alert(cho + " " + srchwor);
	
	location.href = "bbslistAf.jsp?choice="+cho+"&srchword="+srchwor;
	
});
*/

function searchBbs() {	//빈문자열로 검색버튼 누르면 초기화면으로 돌아감
	let choice = document.getElementById("cho").value;
	let word = document.getElementById("srch").value;
	/*
	if(word == "") {
		document.getElementById("srch").value = "";
		
	}
	*/
	location.href = "bbslist.jsp?searchWord=" + word + "&choice="+choice;	
	//model1은 여기서 맨위로 model2는 컨트롤러(f5하면 ajax로 이 곳에 list만 다시 뿌리기/처리속도가 빠르니까) 

}
</script>


</body>
</html>