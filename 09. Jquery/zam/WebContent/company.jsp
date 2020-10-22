<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
int adrNum1 = Integer.parseInt(request.getParameter("adrNum1"));	
int adrNum2 = Integer.parseInt(request.getParameter("adrNum2"));
String address = request.getParameter("address");
int tele1 = Integer.parseInt(request.getParameter("tele1"));	//0이 지워짐
int tele2 = Integer.parseInt(request.getParameter("tele2"));
int tele3 = Integer.parseInt(request.getParameter("tele3"));
String rece = request.getParameter("rece");
String email = request.getParameter("email");
String chotime = request.getParameter("chotime");

System.out.println("이름:" + name);
System.out.println("우편번호:" + adrNum1+"-"+adrNum2);
System.out.println("주소:"+address);
System.out.println("전화번호:"+ tele1 +"-"+ tele2 +"-"+ tele3);
System.out.println("true면 영수증 받음/false면 영수증 안받음      " +  rece);
System.out.println("메일 수신 : " + email);
System.out.println("배달시간 :" + chotime);

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