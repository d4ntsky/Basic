<%@page import="dto.CustUserDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 
form 액션 post 다중 삭제

a 디테일로 이어지는 

a adduser	- 이것만 완료

 -->    
    
    
    
<%
//싱글턴이 아니다 컨트롤러에서 짐 받아줘야함

List<CustUserDto> list = (List<CustUserDto>)request.getAttribute("custlist");	//존재했었음
%>

 

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custuserlist</title>
</head>
<body>

<h1>고객 목록</h1>

<form action="muldel.jsp" method="post">
<!-- 한번에 삭제 multidelete -->

<table style="width: 700">
<col width="100"><col width="300"><col width="300">		

	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>	
	
	<tr>
		<th bgcolor="#ffff00">
			<input type="checkbox" name="alldel" onclick="deletechecks(this.checked)">
		</th>
		<th>ID</th>
		<th>Name</th>
	</tr>
	
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>	
	
<%
if(list.size() == 0) {	//데이터 하나도 없을때
	%>
	<tr bgcolor="#f3f3f3">
		<td colspan="3" align="center">고객 리스트가 존재하지 않습니다</td>
	</tr>
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>	
	<%
}else {					//데이터 있다
	for(int i = 0; i < list.size(); i++) {
		CustUserDto cust = list.get(i);
		%>
		<tr bgcolor="#f6f6f6">
			<td align="center" bgcolor="yellow">
				<input type="checkbox" name="delck" value="<%=cust.getId() %>">
			</td>
			<td>
				<%=cust.getId() %>
			</td>
			<td>
				<%-- <a href="custuserdetail.jsp?id=<%=cust.getId() %>"> --%>
				<a href="detail?work=detailView"><%=cust.getName() %></a>
					
				
			</td>
		</tr>
		<tr>
			<td height="2" bgcolor="#0000ff" colspan="3"></td>
		</tr>	
		<%
	}
}
%>

<tr>
	<td align="center" height="1" bgcolor="#c0c0c0" colspan="3">
		<!-- 다중 삭제 -->
		<input type="submit" value="고객정보 삭제">
	</td>
</tr>

<tr>
	<td height="2" bgcolor="#0000ff" colspan="3"></td>
</tr>

<tr bgcolor="#f6f6f6">
	<td colspan="3">
		<a href="adduser?work=addView">고객정보 추가</a>
	</td>
</tr>

</table>

</form>

<script type="text/javascript">
function deletechecks( ch ) {
	
	let arrCheck = document.getElementsByName("delck");
	
	for(i = 0; i <arrCheck.length; i++) {
		arrCheck[i].checked = ch;
	}
}
</script>

</body>
</html>