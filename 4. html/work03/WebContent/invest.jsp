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
String name = request.getParameter("name");
System.out.println("이름 : " + name);

String conv = request.getParameter("conv");
System.out.println("영어대화 가능합니까? " + conv);

String lang[] = request.getParameterValues("lang");
	if(lang != null && lang.length > 0) {
		for(int i = 0; i < lang.length; i++) {
			System.out.println(lang[i]);
		}
	}
	
String opin = request.getParameter("opin");
				System.out.println(opin);

String age = request.getParameter("age");
System.out.println("연령대 : " + age);

/*
<br><br>
[질문1]<br>
영어로 대화할 수 있습니까?<br>
<input type="checkbox" name="conv" value="예">예
<input type="checkbox" name="conv" value="모르겠다">모르겠다
<input type="checkbox" name="conv" value="아니오">아니오<br>

<br>
[질문2]<br>
영어 외에 관심있는 언어가 있으면 선택 (복수 선택 가능)<br>
<input type="radio" name="lang" value="현대">독일어
<input type="radio" name="lang" value="현대">중국어
<input type="radio" name="lang" value="현대">프랑스어<br>

<br>
[질문3]<br>
영어 수업에 대한 의견이 있으시면 기입해 주십시오.<br>
 <textarea rows="5" cols="60"></textarea>


*/
%>

</body>
</html>