<%@page import="dto.CustUserDto"%>
<%@page import="java.util.List"%>
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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>

	<h1>고객 정보 수정</h1>
	<table border="1">
		<tr>

			<%
				String userId = request.getParameter("id");
			for (int i = 0; i < list.size(); i++) {
				CustUserDto cut = list.get(i);
				if (userId.equals(cut.getId())) {
			%>
		
		<tr>
			<th>ID</th>
			<td><%=cut.getId()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=cut.getName()%></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=cut.getAddress()%></td>
		</tr>
		<tr>
			<th>바뀐 주소</th>
			<td><input type="text" id="chanAdr" placeholder="바뀐 주소를 입력해주세요"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="udBtn">수정하기</button>
			</td>
		</tr>

	</table>

	<script type="text/javascript">

$(document).ready(function() {


	$("#udBtn").click(function() {
		let pigon = document.querySelector("#chanAdr").value;
		
		//?
		location.href =  "custuserupdateAf.jsp?id=<%=cut.getId()%>&newAdr=" + pigon;
		
		
	});
});
	</script>

	<%
		}
	}
	%>
</body>
</html>