<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<title>Bootstrap Simple Registration Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	color: #fff;
	background: #63738a;
	font-family: 'Roboto', sans-serif;
}
.form-control {
	height: 40px;
	box-shadow: none;
	color: #969fa4;
}
.form-control:focus {
	border-color: #5cb85c;
}
.form-control, .btn {        
	border-radius: 3px;
}
.signup-form {
	width: 450px;
	margin: 0 auto;
	padding: 30px 0;
  	font-size: 15px;
}
.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	position: relative;
	text-align: center;
}
.signup-form h2:before, .signup-form h2:after {
	content: "";
	height: 2px;
	width: 30%;
	background: #d4d4d4;
	position: absolute;
	top: 50%;
	z-index: 2;
}	
.signup-form h2:before {
	left: 0;
}
.signup-form h2:after {
	right: 0;
}
.signup-form .hint-text {
	color: #999;
	margin-bottom: 30px;
	text-align: center;
}
.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	background: #f2f3f7;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}
.signup-form .form-group {
	margin-bottom: 20px;
}
.signup-form input[type="checkbox"] {
	margin-top: 3px;
}
.signup-form .btn {        
	font-size: 16px;
	font-weight: bold;		
	min-width: 140px;
	outline: none !important;
}
.signup-form .row div:first-child {
	padding-right: 10px;
}
.signup-form .row div:last-child {
	padding-left: 10px;
}    	
.signup-form a {
	color: #fff;
	text-decoration: underline;
}
.signup-form a:hover {
	text-decoration: none;
}
.signup-form form a {
	color: #5cb85c;
	text-decoration: none;
}	
.signup-form form a:hover {
	text-decoration: underline;
}  
</style>
</head>
<body>
<div class="signup-form">
    <form action="regiAf.jsp" method="post">
		<h2>회원 가입</h2>
		<p class="hint-text">Create your account. It's free and only takes a minute.</p>
		
        <div class="form-group">
        <table>
        <col width="300"><col width="300">
        <tr>
        <td colspan="2">
        	<input type="text" class="form-control" id="id" name="id" placeholder="ID">
        </td>
        </tr>
        <tr>
        	 <td><p id="idcheck">ID 확인</p></td>
        	 <td align="right"><button type="button" id="ckidBtn">Check ID</button></td>
        </tr>
      
        </table>	
        </div>
      
  
       
        <div class="form-group">
        	<input type="text" class="form-control" name="pwd" placeholder="Password" >
        </div>
        
		<div class="form-group">
            <input type="text" class="form-control" name="name" placeholder="Name">
        </div>
        
		<div class="form-group">
            <input type="text" class="form-control" name="email" placeholder="E-mail">
        </div>        
 
		<div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">가입하기</button>
        </div>
        
    </form>
 <!--    
	<div class="text-center">Already have an account? <a href="#">Sign in</a></div>
 -->	
</div>

<script type="text/javascript">
$(function () {
	
	$("#ckidBtn").click(function () {
	//	alert("btn click");
	
		$.ajax({
			type:"post",
			url:"idcheck.jsp",
		//	data:"id=" + $("#id").val(),
			data:{ "id":$("#id").val() },
			success:function( data ){
			//	alert("success");
			//	alert(data.trim());
				if(data.trim() == "YES"){
					
					$("#idcheck").css("color", "#0000ff");
					$("#idcheck").html('사용할 수 있는 id입니다');
				}else{
					
					$("#idcheck").css("color", "#ff0000");
					$("#idcheck").html('사용 중인 id입니다');
					$("#id").val("");
				}			
			},
			error:function(){
				alert("error");
			}
		});
		
	});
	
});
$("#regisBtn").click(function() {
	
});
</script>
</body>
</html>

