<%@page import="java.util.List"%>
<%@page import="dto.CustUserDto"%>
<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 
script에 버튼 두개 확인
수정하는 곳으로 옮기는 버튼

삭제부분으로 가는 버튼은 없고 custuserlist로 삭제해서 바로 넘어감

둘다 아이디 끌고감

 -->
 
<%
CustUserDto dto = (CustUserDto)request.getAttribute("cust");
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custuserdetail</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<h1>고객정보</h1>

<table style="width: 600">
<col width="200"><col width="400">

<tr>
	<td height="2" bgcolor="#00ff00" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<th>ID</th>
	<td id="id"><%=dto.getId() %></td> 	
</tr>

<tr>
	<td height="2" bgcolor="#00ff00" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<th>이름</th>
	<td><%=dto.getName() %></td> 	
</tr>

<tr>
	<td height="2" bgcolor="#00ff00" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<th>주소</th>
	<td><%=dto.getAddress() %></td> 	
</tr>

<tr>
	<td height="2" bgcolor="#00ff00" colspan="3"></td>
</tr>

<tr>
	<td colspan="2" align="center">
		<button type="button" id="updateBtn">수정</button>
		
		<%-- 
		<form action="custuserupdate.jsp">
			<input type="hidden" name="id" value="<%=dto.getId() %>">			
			<input type="submit" value="수정">
		</form>
		 --%>
		
		<button type="button" id="deleteBtn">삭제</button>
	</td>
</tr>

<tr>
	<td height="2" bgcolor="#00ff00" colspan="3"></td>
</tr>

</table>



<script type="text/javascript">

$(document).ready(function () {
	
	$("#updateBtn").click(function () {
//		alert('updateBtn');
		//location.href = "custuserupdate.jsp?id=" + $("#id").text();
//		location.href = "custuserupdate.jsp?id=" + $("#id").text();
	
	//	let id = $("#id").text();
	//	alert(id);
	
//	//	let id = "<%=dto.getId() %>";
	//	alert(id);
		
	});
	
	$("#deleteBtn").click(function () {
//		location.href = "custuserdelete.jsp?id=" + $("#id").text();
	});
	
});

</script>



</body>
</html>