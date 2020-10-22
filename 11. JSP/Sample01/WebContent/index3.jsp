<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- request(요청) --%>
<% 
// = getParameter( name문자열 )

//setAttribute( 객체의 해당 문자열 , 객체 )
// = getAttribute( 객체의 해당 문자열 )

// [] =  getParameterValues

	// HttpServletRequest(request의 원본 이름)
	String name = request.getParameter("name");
	System.out.println("name: " + name);				//주소창에서 ?name=ㅁㅁㅁ 붙인다면?
			
	String age = request.getParameter("age");
	System.out.println("age: " + age);					//주소창에서 &age=33
			
	String hobby[] = request.getParameterValues("hobby");
	
	if(hobby != null && hobby.length > 0){
	for(int i = 0; i < hobby.length; i++) {	//500에러가 나는곳
		System.out.println("hobby: " + hobby[i]);		//주소창에서 &hobby=음악&hobby=독서	
		}
	}
%>

</body>
</html>