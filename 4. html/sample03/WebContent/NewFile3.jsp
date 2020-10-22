<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	// Scriptlet
	//String fname = request.getParameter("fname");
	//System.out.println("선택 과일 : " + fname);
	String fArr[] = request.getParameterValues("fname");
	for(int i = 0; i < fArr.length; i++ ){
		System.out.println(fArr[i]);
	}
%>
</body>
</html>