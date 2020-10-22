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
</head>
<body>

<h1>선택한 고객 정보</h1>
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
			<td>
			 <button type="button" onclick="location.href='custuserupdate.jsp?id=<%=cut.getId() %>'">고객정보수정</button>
			</td>
			<td>
			<button type="button" onclick="location.href='custuserdelete.jsp?id=<%=cut.getId() %>'">고객정보삭제</button>
			</td>
		</tr>
		<%
			}
		}
		%>
	</table>
</body>
</html>