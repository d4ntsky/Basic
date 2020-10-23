HTML
웹서버 톰캣(tomcat) 9버젼 ZIP다운로드
https://tomcat.apache.org/download-90.cgi
c드라이브에 압축 풀어준 뒤
bin으로 startup.bat 실행...후 확인
html 폴더 생성 후 이클립스 기본 설정후 실행
PREFERENCE 서버에 Runtime environment 9.0 add
TOMCAT 9.0으로 들어가서 
TOMCAT installation directory - tomcat으로 잡아주기/ jre도 잡아주기
	   web에서 html file creating files encoding utf-8로잡기
		jsp css도...설정후
아파치 톰캣 폴더로 간 뒤 conf폴더 server.xml를 이클립스로 드래그
디자인 말고 소스로 들어가서 connect port 바꾸기
<Connector port="8080" protocol="HTTP/1.1"
		이 부분 바꿔주기 8090
               connectionTimeout="20000"
               redirectPort="8443" />
    <!-- A "Connector" using the shared thread pool-->
    <!--
    <Connector executor="tomcatThreadPool"
               port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
    -->
https://all-record.tistory.com/49
후 저장(웹서버를 동작하게끔 만들어 두는데 

dynamic web project
윈도우에 web browser chrome
				w3school.com 검색
				http://www.htmq.com/csskihon/004.shtml 일본 사이트

	캡처 요령
	이미지 저장이 없을 경우 개발자 도구로 


	test
	sample01
	work01			html연습문제1		
--------------------------------------------------------------------------------
0707
	javable 확인
	table plugin
	유튜브 iframe으로 넣어보기?
	https://www.youtube.com/watch?v=ySL7GwD6L2c
	
	사내구축
	https://insights.stackoverflow.com/survey/2019#overview

	sample02
	sample03			다시확인!!!
	work02			html연습문제2
	work03			html연습문제3

	옛날 목차 확인
