<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	int c;

	//if(request.getSession())
	if(session.getAttribute("count") != null) {
		c = (Integer)session.getAttribute("count");
	}else{
		c = 0;
	}
	
	c++;
%>

방문 횟수:<input type="text" value="<%=c %>" size="20">회

<%
//session.setAttribute("count", c + "");
session.setAttribute("count", new Integer(c));
%>

</body>
</html>