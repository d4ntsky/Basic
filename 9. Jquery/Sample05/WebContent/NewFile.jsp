<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 // index1과의 관계 있는 jsp
 
 // scriptlet == Java 영역(이 나왔다는 건 무조건 DB와 접근이 가능하다는 이야기) 여기서 DAO를 부를 수 있단 얘기
 String id = request.getParameter("id");	//getParameter는 무조건 문자열 String 
 System.out.println("id:" + id);
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>