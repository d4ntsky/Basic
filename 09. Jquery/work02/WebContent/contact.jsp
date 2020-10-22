<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
int adrNum1 = Integer.parseInt(request.getParameter("adrNum1"));	
int adrNum2 = Integer.parseInt(request.getParameter("adrNum2"));
String address = request.getParameter("address");
String tele1 = request.getParameter("tele1");	//0이 지워짐
String tele2 = request.getParameter("tele2");
String tele3 = request.getParameter("tele3");
String rece = request.getParameter("rece");
String email = request.getParameter("email");
String chotime = request.getParameter("chotime");

out.println("이름:" + name + "<br>");
out.println("우편번호:" + adrNum1+"-"+adrNum2 + "<br>");
out.println("주소:"+address);
out.println("전화번호:"+ tele1 +"-"+ tele2 +"-"+ tele3 + "<br>");
out.println("true면 영수증 받음/false면 영수증 안받음      " +  rece + "<br>");
out.println("메일 수신 : " + email + "<br>");
out.println("배달시간 :" + chotime + "<br>");

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