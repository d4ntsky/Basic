<%@page import="dto.CustUserDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<%
List<CustUserDto> list = (List<CustUserDto>)request.getAttribute("custlist");
request.setAttribute("custlist", list);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custuserlist</title>
</head>
<body>

<h1>고객 목록(MVC Model2)</h1>

<form action="list?work=mulDel" method="post">

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
if(list.size() == 0){	// 하나도 없다
	%>
	<tr bgcolor="#f6f6f6">
		<td colspan="3" align="center">고객 리스트가 존재하지 않습니다</td>
	</tr>
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>
	<%
}
%>












<!-- size 0인경우 forEach문에선.... -->
<c:forEach begin="0" var="m" items="${custlist}" varStatus="i">
<tr bgcolor="#f6f6f6">
			<td align="center" bgcolor="yellow">
			
			<input type="checkbox" name="delck" value="${m.id }">
			</td>		
			<td>
				<c:out value="${m.id }"></c:out>
			</td>
			<td>
				<a href="detail?id=${m.id }">
					<c:out value="${m.name }"></c:out>
				</a>
			</td>
		</tr>
		<tr>
			<td height="2" bgcolor="#0000ff" colspan="3"></td>
		</tr>		
</c:forEach>
			
<%-- <c:forEach begin="1" var="m" items="${custlist}" varStatus="i">
	<p> index:	<c:out value="${i.index }"/> </p>
	<p> id:		<c:out value="${m.id }"/> </p>
	<p> name:	<c:out value="${m.name }"/> </p>
	<p> address:<c:out value="${m.address }"/> </p>
</c:forEach>
<br>  --%>










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

<br>





<script type="text/javascript">
function deletechecks( ch ) {
	
	let arrCheck = document.getElementsByName("delck");
	
	for(i = 0;i < arrCheck.length; i++){
		arrCheck[i].checked = ch;
	}
	
}


</script>



</body>
</html>






