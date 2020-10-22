<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
		Core Tag 사용 전 필요한 jar 파일 : jstl.jar, standard.jar
--%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
	EL		: 표현식 (값, 판별)
	Core	: 제어문 (for, if) + EL
-->

<%
	request.setAttribute("data", "JSTL입니다");
%> 
${ data }
<br>

<%--
String cdata = "core JSTL입니다";
request.setAttribute("cdata", cdata);	//== 앞의 cdata가 core tag의 var과 같다
--%>
<%-- 
out(내장객체)
<%
	out.println(cdata); //core tag와 매칭 x
%>
 --%>

<!-- Core tag -->
<c:set var="cdata" value="core JSTL입니다" />
${cdata }
<br><br>

<%
	session.setAttribute("sessionData", "저장된 데이터");
%>
<c:set var="sdata" value="${ sessionData }" />
<c:out value="${sdata }" />
<br><br>

<!-- if -->
<%
	request.setAttribute("count", "10");
%>

<%
String scount = (String)request.getAttribute("count");
int count = Integer.parseInt(scount);
if(count >= 10) {
	%>
	<p>count: <%=count %></p>
	<% 
}
%>

<c:if test="${count >= 10}">
	<p>core count: <c:out value="${count }"></c:out></p>
</c:if>
<br>

<%
	request.setAttribute("name", "홍길동");
%>

<c:if test="${name eq '홍길동' }">
	<p>이름은 홍길동입니다.</p>
</c:if>

<%
	request.setAttribute("name", "일지매");
%>

<c:if test="${name == '일지매' }" var="flg" />

<c:if test="${flg }">
	<p>이름은 일지매입니다.</p>
</c:if>

<br>

<!-- for -->
<% 
	for(int i = 0; i < 10; i++) {
		%>
		<%=i %>
		<%
		}
%>
<br>
<c:forEach begin="0" end="9" step="1" varStatus="i">	<!-- begin 빠지면 에러 -->
	<c:out value="${ i.index }"></c:out>
</c:forEach>
<br><br>

<% 
	List<MemberDto> list = new ArrayList<>();
	MemberDto mem = new MemberDto();
	mem.setMessage("안녕하세요");
	list.add(mem);
	
	mem = new MemberDto();
	mem.setMessage("건강하세요");
	list.add(mem);
		
	mem = new MemberDto();
	mem.setMessage("성공하세요");
	list.add(mem);
	
	request.setAttribute("list", list);
%>

<%
	for(int i = 0; i < list.size(); i++) {
		MemberDto m = list.get(i);
	}
	for(MemberDto m : list) {
		
	}
%>

<c:forEach begin="0" end="2" var="m" items="${list}" varStatus="i">
	<p> index:<c:out value="${i.index }"/> </p>
	<p> data:<c:out value="${m.message }"/> </p>
</c:forEach>
<br>

<!-- Map -->
<% 
	HashMap<String, String> map = new HashMap<>();

	map.put("apple", "사과");
	map.put("grape", "포도");
	map.put("melon", "멜론");
	
	request.setAttribute("map",	map);
%>
<c:forEach var="obj" items="${map}">
	key:<c:out value="${obj.key }" />
	value:<c:out value="${obj.value }" />
</c:forEach>
</body>
</html>