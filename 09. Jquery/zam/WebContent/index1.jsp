<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");

String pnum1 = request.getParameter("postNum1");
String pnum2 = request.getParameter("postNum2");

String address = request.getParameter("address");

String trans[] = request.getParameterValues("trans");

String money = request.getParameter("money");

String maga = request.getParameter("maga");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	//새로운 방법 //web으로 내보내줌
out.println("이름: " + name + "<br>");	
out.println("우편번호: " + pnum1 + "-" + pnum2 + "<br>");	
out.println("주소: " + address + "<br>");	

for(int i = 0; i < trans.length; i++) {
	out.println("배달시간: " + trans[i] + "<br>");	
}

out.println("영수증: " + money + "<br>");	
out.println("매거진 신청 여부: " + maga + "<br>");

%>

</body>
</html>