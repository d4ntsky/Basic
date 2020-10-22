<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<form id="frm" method="post">

<div style="padding: 200px 0px 0 400px;">
<div id="login-box">

<h2>Login Page</h2>
홍길동 홈페이지에 오신 것을 환영합니다 
<br>
<br>

<div id="login-box-name" style="margin-top:20px;">User Id:</div>
<div id="login-box-field" style="margin-top:20px;">
<input id="id" name="id" class="form-login" title="Username" size="30" maxlength="50" />
<input type="checkbox" id="chk_save_id">Save id 
</div>
<div id="login-box-name">Password:</div>
<div id="login-box-field">
<input id="pwd" name="pwd" type="password" class="form-login" title="Password" value="bbb" size="30" maxlength="48" />
</div>
<br>

<span class="login-box-options">
New User?  <a href="regi.jsp" style="margin-left:30px;">Register Here</a>
</span>
<br/>
<br/>
<!-- <input style="margin-left:100px;" type="submit" value="Login" /> -->
<input type="button" style="margin-left:100px;" id="_btnLogin" value="Login">
</div>
</div>

</form>

<script type="text/javascript">

$("#_btnLogin").click(function() {
//	alert('click');
	if( $("#id").val().trim() == "" ){
		alert("id를 입력해 주십시오");
		$("#id").focus();
	}
	else if( $("#pwd").val().trim() == "" ){
		alert("password를 입력해 주십시오");
		$("#pwd").focus();
	}
	else{
		$("#frm").attr("action", "loginAf.jsp").submit();
	}
	
});

// cookie : String		-> id
// session : Object		-> login 개인 정보

let user_id = $.cookie("user_id");	// cookie를 산출
if(user_id != null){				// 저장된 cookie가 있을 때
//	alert("cookie 있음");
	$("#id").val( user_id );
	$("#chk_save_id").attr("checked", "checked");
}

$("#chk_save_id").click(function () {
	
	if( $("#chk_save_id").is(":checked") ){	// 첵크되었을 때 on
	//	alert('첵크됨');
		// cookie 저장
		if( $("#id").val().trim() == "" ){
			alert('id를 입력해 주십시오');
			$("#chk_save_id").prop("checked", false);
		}else{
			$.cookie("user_id", $("#id").val().trim(), { expires:7, path:'/' } );
		}
	}
	else{
	//	alert('첵크없어짐');
		// cookie 삭제
		$.removeCookie("user_id", { path:'/' });
	}
	
	
});
</script>



</html>





