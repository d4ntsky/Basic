<%@page import="dto.CustUserDto"%>
<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
System.out.println("update id = " + id);

CustUserDao dao = CustUserDao.getInstance();
CustUserDto cust = dao.getCustuser(id);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custuserupdate</title>
</head>
<body>


<h1>고객정보 수정</h1>

<form action="custuserupdateAf.jsp">

<table style="width: 600">
<col width="200"><col width="400">

<tr>
	<td height="2" bgcolor="#0000ff" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<td>아이디</td>
	<td><input type="text" size="30" name='id' value="<%=cust.getId() %>" readonly="readonly"></td>
</tr>

<tr>
	<td height="2" bgcolor="#0000ff" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<td>이름</td>
	<td><input type="text" size="30" name="name" value="<%=cust.getName() %>"> </td>
</tr>

<tr>
	<td height="2" bgcolor="#0000ff" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<td>주소</td>
	<td><input type="text" size="30" name="address" value="<%=cust.getAddress() %>"> </td>
</tr>

<tr>
	<td height="2" bgcolor="#0000ff" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<td colspan="2" align="center">
		<input type="submit" value="고객정보변경">
	</td>
</tr>

</table>
</form>


</body>
</html>