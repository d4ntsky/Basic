0630
		open perpective
		db connection
		jar list
 		oracle11로 연결 ojdbc6.jar로 다시 바꾸기
		db는 하나로 몰아쓰기.
		서비스네임 xe
		schemas function 스키마
		sql 들어가서 빈칸 
		oracle11로 연결
		alt + c  실행 result 확인		
		프로젝트 프로퍼티스 java build path library
		add external jars ojdbc6 추가
		reference library엔 ojdbc6이 있어야
https://loy124.tistory.com/119?category=745585
https://all-record.tistory.com/69

	vscode 구경
	
	jdbc	
		1.JDBCConnection 
		2.InsertTest	executeUpdate!
		3.UpdateTest	
		4.DeleteTest - 혼자 해볼 건 prepareStatement();!
				
		5.SelectTest 	executeQuery()!
				prepareStatement()!
----------------------------------
과제 시작


0701
		AccountBook
		memberdto 회원가입

		cf) 저장 관련
		1src sql이 늘어나면 켜놓으면 바로 연결됨
		2dto는 찾기 좋은 장점이 있고 쿼리문 꺼내서 고쳐야됨.
		src나 1sql 저장하거나 2dto 위에 올려놈
		파일로 남겨두냐 글에 적어두냐
		D:\jdbc\0701_AccountBook\src

		ui - 찾아보면서

	(1)로그인 	끝
	(2)addview
	수입 지출을 받은것과 textfield안에 값을 버튼누를 때 되게
	(3)periview
	(4)contview		--마지막
	main에 view별로 
	cf) 비번 적을때 textfield가 하나 더 있다. jpasswordfield가 따로 있다.	
	
where wdate  between(to_date)

0702		
		https://jang8584.tistory.com/232
		https://raccoonjy.tistory.com/16
		https://www.youtube.com/watch?v=FjDkrGx4ECI

		samAccount - 항목별 빼고 끝남
		숙제 가계부 account
		
		제출용 과제 시작
		커피시작


at dao.CustomerDao.addCustomer(CustomerDao.java:89)
	at view.signView.actionPerformed(signView.java:107)



0703	
	메뉴에서 주문을 누르면? db에 주문이 추가되고

	주문내역 textarea에 db연동해서 db에 데이터를 가져오는건가?
	
	완성 안된곳
	menuview에 추가부분 콤보박스 cudao 추가부분 = 추가는 되고 값 입력 마무리 안됐고
	odlist부분 내역확인 받아오는 거.. !!!!!!!!!!!!!!!!!!!!!!!!

	
	//구글 드라이브 통합구현 -- 블랙잭
소스코드 제출 안해도 됨 
알고리즘ㅇ 자신의 이름 폴더에 
세네페이지?

http://blog.naver.com/PostView.nhn?blogId=blurzone&logNo=60017435787&widgetTypeCall=true
https://loy124.tistory.com/128
https://snowflower.tistory.com/125
https://npcore.tistory.com/20
http://blog.naver.com/PostView.nhn?blogId=hailey_jo&logNo=221156719906&categoryNo=8&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView



0706	
	web 
ex)커피 주문 프로그램 예로
login view에 아이디 비밀번호 - client - view라고 함
db와 클라이언트 사이에 dao가 존재 - 그 다오를 model이라고하고

View	- login화면 아이디와 비밀번호 clilent	화면단 html/javaScript/CSS/jquery/jqueryUI(이것들은 서버가 아님)
Class	- Controller			
Model	- DAO, Server
DB	- 

MVC모델

View     -Controller  -Model     -DB

 cf) jquery에 Ajax (비동기적 웹) 가 포함되어 있다.
 cf) node.js

제공하는 데이터를 던져주는 데 xml형식/json 걸러내는걸 파싱이라하고 파싱 후 사용
Jsoup 파싱. 크롤링. 빅데이터쪽 후 과제 하나
Servlet

JSP 게시판/멤버가입/자료실/
HTML 2 JAVASCRIPT 2 CSS 반나절
자기 포트폴리오 하나 만들기 (개인)

서버가 하는 역할은 데이터 받아서 던져주는
