<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- <a href="custuserlist.jsp">고객목록</a> -->
<%
	response.sendRedirect("custuserlist.html");
%>

<!-- 
인덱스에서 두갈래 custuserlist	고객 정보 custuserdetail  고객수정      custuserupdate -> custuserupdateAf 다음 리스트
												     고객삭제 -> custuserlist로
							
							고객 추가 custuseradd- > custuseraddAf 다음 custuserlist


중심은 리스트로


 -->

</body>
</html>