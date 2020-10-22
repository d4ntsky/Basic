<%@page import="java.util.List"%>
<%@page import="dto.CustUserDto"%>
<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	CustUserDao dao = CustUserDao.getInstance();
List<CustUserDto> list = dao.getCustUserList();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 값 가져와서 db에서 주소 바꾸는  -->

	<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String oldAdr = request.getParameter("address");
	String newAdr = request.getParameter("newAdr");

	int count = dao.updateCustUser(id, newAdr);

	if (count > 0) {
	%>
	<script type="text/javascript">
		alert("정상적으로 수정되었습니다");
		location.href = "custuserlist.jsp";
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert("수정되지 않았습니다");
		location.href = "custuserlist.jsp";
	</script>
	<%
		}
	%>



</body>
</html>