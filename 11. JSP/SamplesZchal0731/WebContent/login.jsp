<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap Simple Login Form</title>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- w3school -->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>



<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
<!-- cookie -->



<style>
.login-form {
    width: 340px;
    margin: 50px auto;
  	font-size: 15px;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
}
</style>
</head>
<body>
<div class="login-form">
    <form id="frm" action="" method="post">			<!-- frm -->
        <h2 class="text-center">Log in</h2>       
        <div class="form-group">
            <input type="text" id="id" name="id" class="form-control" placeholder="Username" >			<!-- id --><!-- required="required" -->
        </div>
        <div class="form-group">
            <input type="password" id="pwd" name="pwd" class="form-control" placeholder="Password" >		<!-- type password로 pwd -->
        </div>
        <div class="form-group">
            <button type="button" class="btn btn-primary btn-block" id="_btnLogin">로그인</button>					<!-- id="_btnLogin" -->
        </div>
        <div class="clearfix">
            <label class="float-left form-check-label"><input type="checkbox" id="chk_save_id"> Save ID</label>		<!-- chk_save_id -->
            <a href="#" class="float-right">Forgot Password?</a>
        </div>        
    </form>
    <p class="text-center"><a href="regi.jsp">Create an Account</a></p>								<!-- 회원가입 -->
</div>
																						<!-- 뒤에 이미지 같이 늘어났다 줄게 포함해서 넣기!!-->
																						
																						
																						
																						
																						
																						
																						
<script type="text/javascript">
//비밀번호와 아이디 공백이나 문자 없음으로
$("#_btnLogin").click(function() {
	//alert("?");
	if( $("#id").val().trim() == "" ) {
		alert("id를 입력해주십시오");
		$("#id").focus();
	}
	else if( $("#pwd").val().trim() == "" ) {
		alert("password를 입력해주십시오");
		$("#pwd").focus();
	}
	else{
		$("#frm").attr("action", "loginAf.jsp").submit();	//model2라면 컨트롤러로
	}
	
});

//id 저장기능	//쿠키는 하드웨어 세션은 서버
//cookie : String	-> id
//session : Object	-> login 개인 정보
let user_id = $.cookie("user_id");			// cookie를 산출
if(user_id != null) {						// 저장된 cookie가 있을 때
	//alert("cookie 있음");
	$("#id").val( user_id );
	$("#chk_save_id").attr("checked", "checked");
}
//체크 기능
$("#chk_save_id").click(function() {
	
	if( $("#chk_save_id").is(":checked")) {	// 체크되었을 때 on 
		//alert("체크됨");
		// cookie 저장
		if( $("#id").val().trim() == "" ) {
			alert("id를 입력해주십시오");
			$("#chk_save_id").prop("checked", false);
		}else{
			//!!
			$.cookie("user_id", $("#id").val().trim(), { expires:7, path:'/' } );	//기한 저장
		}
	}else{
		//alert("체크 없어짐");
		// cookie 삭제
		$.removeCookie("user_id", { path:'/' });
	}
});

</script>

</body>
</html>