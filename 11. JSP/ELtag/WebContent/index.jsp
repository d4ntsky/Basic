<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.List"%>
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
	
<%--
	JSP : Html, JavaScrpt, CSS, Java
	
	<%! 선언부(class, function, variable(global)) %>
	<%  코드부(제어문) %>
	<%=value %>
	 : front end에서 Java를 사용하지 않기 위해서
	 
	Expression	Language
	표현			언어
	
	EL 		tag -> value
	Core	tag -> 제어문.jar가 필요
	
	JSTL (Java server page Standard Tag Language)
	
	형식 
	${ 값, 연산식 }	//cf) NullPointException가 뜨지 않음...
					//cf) 웹 전용 tag
					
	cf) $ 사용 : JQuery 아니면 EL tag
--%>

<%
	//cf) parameter 문자열 attribute 오브젝트
	String str = "hello";
	request.setAttribute("str", str);
%>

<%
	String s = (String)request.getAttribute("str");
%>

<%
	out.println("s = " + s);
%>
<br><br>

s = <%=s %>
<br><br>

el s = ${str }
<br><br>

<%="scriptlet 값" %>
<br>
${'el tag 값' }
<br>

${2 + 3 }
<br><br>

${ 3>2?100:200 }	<!-- 삼항 연산 -->
<br><br>

<%
request.setAttribute("data", "안녕하세요");
%>
${data } <!-- 명칭으로 받을 수 있다(getattribute가 필요 없음) -->
<br><br>

Object가 할당되어 있는 지 확인
<%
Object obj = new String("hello");
obj = null;
	if(obj == null) {}
%>
<br>

object = ${ empty data } <!-- data에는 안녕하세요가 할당된 상태이기 때문에 비워져있지 않기 때문에 false -->
<br>
object = ${ not empty data }
<br><br>

1 < 9 : ${ 1 < 9 } <!-- 판별식(true/false) -->
<br>
2 + 3 : ${ 2 + 3 } <!-- 연산식(value) -->
<br><br>

<%
	Integer a, b;
	a = 10; //a = ${a } 바로 쓰면 x
	b = 3;
	
	request.setAttribute("a", a);
	request.setAttribute("b", b);
	
	Boolean c;
	c = false;
	
	request.setAttribute("c", c);
%>
<pre>
a: ${a }
b: ${b }
c: ${c }

a+b:${ a + b }

eq:${ a eq b }
eq:${ a == b }

ne:${ a ne b }
ne:${ a != b }

gt:${ a gt b }
gt:${ a > b }

lt:${ a lt b }
lt:${ a < b }

ge:${ a ge b }	<!-- >= -->
le:${a le b }	<!-- <= -->

div:${a div b }
div:${a / b }

mod:${a mod b }
mod:${a % b }

c:${ !c }

${ a==10 && !c }	<!-- 논리 연산자 -->

</pre>

<%
MemberDto dto = new MemberDto();
dto.setMessage("Hello EL");
%>

<%=dto.getMessage() %>
<br>
message:${dto.getMessage() } <!-- 접근 불가 -->
<br>

<%
request.setAttribute("dto", dto);
%>
message:${dto.message }
<br><br>

<%
String array[] = { "hello", "EL" };

request.setAttribute("array", array);
%>

<%=array[0] %>
<br>
${array[1] }
<br><br>

<%
	List<String> list = new ArrayList<>();
	list.add("world");
	list.add("el");
	
	request.setAttribute("list", list);
%>

<%=list.get(0) %>	<!-- scriptlet -->
<br>
${list[0] }			<!-- el -->
<br><br>

<%
	List<MemberDto> memlist = new ArrayList<>();
	
	MemberDto mem = new MemberDto();
	mem.setMessage("안녕하세요");
	memlist.add(mem);
	
	mem = new MemberDto();
	mem.setMessage("건강하세요");
	memlist.add(mem);

	request.setAttribute("memlist", memlist);
%>

<%=memlist.get(1).getMessage() %>	<!-- 일반자바 -->
<br>
${ memlist[1].message }				<!-- el tag -->
<br><br>

<%
	HashMap<String, String> map = new HashMap<>();
	
	map.put("apple", "사과");
	map.put("grape", "포도");
	
	request.setAttribute("map", map);
%>

<%=map.get("apple") %>	<!-- scriptlet -->
<br>
${map.apple }			<!-- el tag 1-->
<br>
${map["grape"] }		<!-- el tag 2-->
</body>
</html>