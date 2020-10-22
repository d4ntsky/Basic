<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>

<!-- 
	AJAX : Asynchronous JavaScript AND XML (Json) 
		목적 : 비동기 상태로 데이터의 송/수신을 처리하는 목적
			 cf) location.href를 보내는 건 용도가 틀린
		cf) Vue, reAct

		a, form, location.href -> link 이동
		synchronous : 동기
		
		JQuery 소속
		
	
 -->

<p id="demo"></p>
<br>
<button type="button">click</button>
 
<script type="text/javascript">
$(function () {
	
	$("button").click(function() {
		
		//$("#demo").load("data.html");	//비동기 처리지만 Ajax 아님 // div태그를 가장 많이씀
		
		//$("#demo").load("data.html #data1");
		
		//$("#demo").load("data.jsp", "t1=abc&t2=가나다"); //뒤에 값을 넘겨주고 앞 파일을 넘겨받음!!	//외부 파일에 소스를 다 넣어놓고 경로를 모르게 하면 보안
													
		//$("#demo").load("data.jsp", {t1:"ABC", t2:"라마바"});
		
		$("#demo").load(
			"data.jsp",								//행선지
			{t1:"load", t2:"보내자"},					//짐
			function (data, status, xhr) {			//data,status,xhr = 가변수
				//alert("success");					
				//alert(data);		
													//데이터를 풀어주는
				$("#demo").append("<br>data = " + data + "<br>");	//
				$("#demo").append("status = " + status + "<br>");	//
				$("#demo").append("xhr = " + xhr + "<br>");			//
																		//cf)onload
			}				
		);
	});
});
</script>
</body>
</html>