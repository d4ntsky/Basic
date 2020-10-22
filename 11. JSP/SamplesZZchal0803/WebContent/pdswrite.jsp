<%@page import="java.util.Date"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
MemberDto mem = (MemberDto)session.getAttribute("login");

// 시간을 취득
String fname = (new Date().getTime()) + ""; //dto에 오리지날 파일네임으로 있어야함
System.out.println("fname : " + fname);										//Spring에서...
// ex) myfile.txt 										-> fname : 1596422048716.temp
// DB에는 두개다 올라가 있어야함 myfile.txt, tmp1596422048716.txt
// 다운로드를 받은 후에는 1596422048716.txt					-> myfile.txt
// 한글 파일로 하려면... 이 기능 사용해야한다.
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdswrite.jsp</title>
</head>
<body>

<!-- 
	자료실의 문제 발생하면
		똑같은 파일명으로 업로드할 경우(1)(2)
		충돌이 난다 (방법: 시스템타임을 얻어온 파일명으로 올림)
		다운을 완료하는 경우 원래 이름으로 바꿔주는
 -->

<h1>자료 올리기</h1>

<div align="center">

<!-- 
	form field data
		id		-> String
		title	-> String
		content	-> String
	
	file data
		file	-> byte
 -->

<form action="pdsupload.jsp" method="post" enctype="multipart/form-data">		<!-- 파트가 두가지다 form과 file -->

<table border="1">
<col width="200"><col width="500">
	
	<tr>
		<th>아이디</th>
		<td>
			<%-- <input type="text" name="id" value="<%=mem.getId() %>" readonly="readonly"> --%>
																				<!-- 인풋 텍스트 밸류=아이디 리드온리로 -->
			<%=mem.getId() %><input type="hidden" name="id" value ="<%=mem.getId() %>">
		</td>
	</tr>
	
	<tr>
		<th>제목</th>
		<td>
			<input type="text" name="title" size="50"> 							<!-- 파일명을 그대로 제목에 -->
		</td>
	</tr>
	
	<tr>
		<th>파일 업로드</th>
		<td>
			<input type="file" name="fileload" style="width: 400px"> 			<!-- 새로운 type / 한글 제목은 아직 -->
		</td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td>
			<textarea rows="20" cols="50" name="content"></textarea>
		</td>
	</tr>
	
	<tr align="center">
		<td colspan="2">
			<input type="submit" value="올리기">
		</td>
	</tr>
	
</table>
</form>
</div>

</body>
</html>