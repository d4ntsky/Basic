<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>NewFile.jsp</h3>

<%-- cf)JSP주석문  
	
	Java Server Page = html + java	
--%>

<%
// Java 영역
// -> Dao(Singleton) 호출

String id = request.getParameter("id");		//index에 요청해서 name을 가져오는 곳
System.out.println("id : " + id);

String pwd = request.getParameter("pwd");
System.out.println("pw : " + pwd);
%>

Html 영역

<%--
입력을 받아서 받은 값을 index에 넘겨주는
--%>


</body>
</html>