<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
forward(전진), include(불러오기) 
-->

<h3>index.jsp start</h3>
<jsp:include page="NewFile.jsp" flush="false"></jsp:include>	<!-- 불러올 외부 파일 -->
<h3>index.jsp end</h3>

<%-- <jsp:forward page="NewFile.jsp"></jsp:forward> --%>		<!-- 바로 이동 / 사용 빈도 낮음 -->
<!-- 
EL, Core 가 부족한 면은 객체를 생성하지 못한다
Object 생성법
-->

<%-- 
<%
	MemberDto dto = new MemberDto();			--1
	dto.setMessage("안녕하세요1");					--2
	String msg = dto.getMessage();				--
	
	request.setAttribute("mem", dto);			--scriptlet에선 반드시 넣어줘야함
%>  								
--%>
<%--
 ${mem.message } 								
--%>

<jsp:useBean id="dto" class="dto.MemberDto">	<!-- 객체 dto가 생성됨  -->
</jsp:useBean>
<jsp:setProperty property="message" name="dto" value="안녕하세요2"/>
<jsp:getProperty property="message" name="dto"/>	<!-- 바로 접근 가능 -->

 ${dto.message } 									<!-- 바로 접근 가능 -->
 
<!-- 
	고급 tag
	el/core/jsp 
-->
</body>
</html>