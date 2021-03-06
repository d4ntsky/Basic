<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>

<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</head>
<body>

	<h1>회원가입</h1>


	<form>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" maxlength="20"> <input
					type="button" value="중복확인">
				</td>
			</tr>

			<tr>
				<td>비밀번호</td>
				<td>
				<input type="password" name="password" maxlength="15">
				</td>
			</tr>

			<tr>
				<td>비밀번호 확인</td>
				<td>
				<input type="password" name="password" maxlength="15">
				</td>
			</tr>

			<tr>
				<td>이름</td>
				<td><input type="text" name="name" maxlength="40"></td>
			</tr>

			<tr>
				<td>성별</td>
				<td><input type="radio" name="gender" value="남" checked>남
					<input type="radio" name="gender" value="여">여</td>
			</tr>

			<tr>
				<td>생일</td>
				<td>

				<input type="text" id="date">
				
				</td>
			</tr>

			<tr>
				<td>이메일</td>
				<td>
				<input type="text" name="email_1" maxlength="30">@
				<select name="email_2" id="emal">
						<option>naver.com</option>
						<option>daum.net</option>
						<option>gmail.com</option>
						<option>nate.com</option>
						<option value="etc"> 그외</option>
				</select>
				<div ><input type="hidden" class="etc2"></div>
				</td>
			</tr>

			<tr>
				<td>휴대전화</td>
				<td>
				<input type="text" name="phone">
				</td>
			</tr>

			<tr>
				<td id="title">주소</td>
				<td>
				
				
<input type="text" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
<input type="text" id="sample4_roadAddress" placeholder="도로명주소">
<input type="text" id="sample4_jibunAddress" placeholder="지번주소">
<span id="guide" style="color:#999;display:none"></span>
<input type="text" id="sample4_detailAddress" placeholder="상세주소">
<input type="text" id="sample4_extraAddress" placeholder="참고항목">

				
				
				
				</td>
			</tr>

		</table>
		<br> 
<input type="submit" value="가입" /> 
<input type="button" value="취소">
</form>

<script type="text/javascript">
$(function () {
	
	let week = ['일', '월', '화', '수', '목', '금', '토'];
	
	$('#date').datepicker({
		dateFormat: "yy/mm/dd",
		dayNamesMin: week,
		monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		onSelect: function ( d ) {
		//	alert(d); //연도 월 일이 들어옴
			let arr = d.split('/');
			
			$('#year').val( arr[0].trim() );
			$('#month').val( arr[1] );
			$('#day').val( arr[2] );
		
			//요일
			let weekday = new Date( $('#date').datepicker({ dateFomat:"yy/mm/dd"}).val() );
		//	alert(weekday);
		//	alert(weekday.getDay());
			$("#week").val(week[ weekday.getDay() ]);
			
		}
	
	});
	
	
	//e-mail 그외 구현?????????
	$('#emal').select(function() {
		let cho = $('#emal:selected').val();
		alert(cho);
		if (cho == 'etc') {
			$('.etc2').attr("type", "text")
		}else {
			$('.etc2').hide();
		}
	});
});


function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}
</script>

</body>
</html>
