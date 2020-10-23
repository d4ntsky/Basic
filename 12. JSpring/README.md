2020-09-25

servlet context - 
application context - mybatis jsp 설정
aop-context - 관점 지향 - 공통된 코드 작성

web.xml에서 읽어들이게 위의 3개 및 *.do 설정/ filter 한글 설정/dispatcher servlet

pom.xml - jar 파일 등록

처음 컨트롤러로 가서 @Controller @=주석문 //스프링 컨테이너가 일을 하기 위한
@autowired (객체 찾아주는 service로) 

view - controller - service - dao - db

뷰 부분을 짤라 jquery/vue/react로  Spring-boot 백/프론트 엔드 분리 목적


spell/workspace/web
eclipe Marketplace - Spring Tools 3 (Standalone Edition) 3.9.14.RELEASE
SprBootSample (spring starter로 생성)

general - web browser
cf) An error has occurred. See the log file D:내 경로\.metadata\.log. ??

스프링부트의 목적?
프론트와 백 엔드
application과 웹의 경계를 무너뜨리기위해


스프링 부트는 내장 톰캣 서버 이클립스에서 톰캣 서버


cf)
application.properties에서 확인 필
spring.datasource.username=hr
spring.datasource.password=hr
spring.datasource.data-username=hr
spring.datasource.data-password=hr

---------------------------------------------------------------------------------------------------------------

2020-09-28

스프링부트로 파일 업로드 다운로드
동적 서버 
정적 서버


https://victorydntmd.tistory.com/
---------------------------------------------------------------------------------------------------------------

2020-09-29

legacy는 고쳐야되는 부분이 많다..
spring mvc project 
sampleLegacy

다이나믹 웹 프로젝트에서 얻는 방식으로 함
webapp=webContents라고 보면....

web.xml/ dispatcherServlet(servlet-context) - get post

---------------------------------------------------------------------------------------------------------------

1. sampleDynamic (다이나믹)
2. pom.xml - configure       convert to maven
3. web.xml - java ee tools   generate deployment

4. pom에 추가
spring mvc
log4j - 프레임

5. spring/view 폴더 추가
web.xml 설정할 것은 spring 폴더의 xml을 읽어오게 해야한다. (ioc를 위해!!!!)

6. spring 폴더안 spring bean definition -> servlet-context파일 생성 후 namespace : bean / context / mvc 추가
bean은 객체/servlet-context에서 타일즈 설정!
7. web.xml 설정

8. 뷰에 hello 추가/ 컨트롤러 추가와 내용 추가/ log4j.xml 추가

9. index 파일로 확인
cf) web.xml이 처음/ 위치 항상 확인!
모델 추가하는 것 (mybatis) applicationContext(model)

10. DB를 하기위해서 dependency 추가/ properties 폴더 추가 jdbc
cf) Maven Dependencies 화살표가 없는건 파일이 없는 것

11. applicationContext.xml 추가(namespace - bean/context) - db 설정 내용 추가

12. applicationContext.xml 추가에 따른 web.xml 추가

13. sql 폴더과 sql 생성/DAO/DTO 생성../컨트롤러 추가
cf) ajax - servlet-context.xml 추가

---------------------------------------------------------------------------------------------------------------

2020-10-05

Spring Security - 인증(사용자가 맞는지)/ 보안
사용자가 관리자의 url에 접근하는 경우가 있으므로 
1. Credential 기반 인증 	: 로그인
2. 이중인증 		: atm에서의 카드 사용 
3. 하드웨어 인증 		: 자동차 키와 같은
권한에 따른 비회원(GUEST), 준회원(USER), 정회원(MEMBER), 관리자(ADMIN) 
cf) https://to-dy.tistory.com/75

시작 
https://offbyone.tistory.com/88  까지의 내용
(기본 세팅)
다이나믹 웹 프로젝트
Maven	https://mvnrepository.com/artifact/org.springframework.security/spring-security-core
pom.xml 내용 추가/src 파일 추가/web-inf 파일 및 폴더 추가/
-------
spring bean definition 파일 beans/security 선택
에러 403 접근 금지!!!!
cf) init이 뜨면 기본적인게 틀린것 initialize가 실패했단뜻

https://goddaehee.tistory.com/
security 계습 설정 순서 중요

db세팅 및 가져왔을때 연동까지 

---------------------------------------------------------------------------------------------------------------

2020-10-06

security 후반....

디버깅 관련 debugger나 크롬f8기능 확인