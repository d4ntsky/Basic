<%@page import="dto.HumanDto"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% //위에서 dto들어오는 거 확인
	HumanDto dto = (HumanDto)request.getAttribute("dto");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>

<h1>detail.jsp</h1>

<%
	out.println("<b>" + dto.toString() + "</b>");
%>

</body>
</html>