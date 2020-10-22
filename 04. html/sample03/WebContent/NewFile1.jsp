<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
//자바영역
//값이 하나일 때
//String hob = request.getParameter("hobby");
//System.out.println("hobby : " + hob);

String hob[] = request.getParameterValues("hobby");
	if(hob != null && hob.length > 0){
		for(int i = 0; i < hob.length; i++){
			System.out.println(hob[i]);
		}
	}

String car = request.getParameter("car");
System.out.println("Car : " + car);
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