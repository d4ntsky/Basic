<%@page import="dto.CustUserDto"%>
<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String id = request.getParameter("id");
String name = request.getParameter("name");
String address = request.getParameter("address");
System.out.println(id+" "+name+" "+address);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 기능 두개? -->
<%

CustUserDao dao = CustUserDao.getInstance();
//보내줄 dto 설정
boolean isS = dao.delCustUser(id);

if(isS) {//삭제되지 않았습니다 하면서 삭제됨

}else {
%>	
	<script type="text/javascript">
	
	alert("정상적으로 삭제되었습니다.");
	location.href = "custuserlist.jsp";
	</script>
<%
}
%>

</head>
<body>

</body>
</html>