--------------------------------------------------------------------SQL6 -hr
--문제1) EMPLOYEES 테이블에서 부서별로 
--      인원수, 평균 급여, 급여의 합, 최소 급여, 최대 급여를 포함하는 
--      EMP_DEPTNO 테이블을 생성하라.
--답:
CREATE TABLE EMP_DEPTNO
(deptno, e_count, e_avg, e_sum, e_min, e_max)
AS
SELECT 
department_id, COUNT(*), 
ROUND(AVG(salary), 1), SUM(salary), MIN(salary), MAX(salary)
FROM employees
GROUP BY department_id;
/*
CREATE TABLE EMP_DEPTNO(
    NUM_PP  VARCHAR2(20),  
    AVG_SAL VARCHAR2(20),  
    SUM_SAL VARCHAR2(20),  
    MIN_SAL VARCHAR2(20),  
    MAX_SAL VARCHAR2(20)
); */

--문제2) EMP_DEPTNO 테이블에 ETC COLUMN을 추가하라. 
--      단 자료형은 VARCHAR2(50) 사용하라.
--답:
ALTER TABLE EMP_DEPTNO
ADD
(ETC VARCHAR2(50));

--문제3) EMP_DEPTNO 테이블에 ETC COLUMN을 수정하라. 
--      자료 형은 VARCHAR2(15)로 하라.
--답:
ALTER TABLE EMP_DEPTNO
MODIFY
(etc VARCHAR2(15));

--문제4) EMP_DEPTNO 테이블에 있는 ETC 을 삭제하고 확인하라.
--답:
ALTER TABLE EMP_DEPTNO
DROP
--COLUMN ETC나 ()형태?
(ETC);

--문제5) 이전에 생성한 EMP_DEPTNO 테이블의 이름을 EMP_DEPT로 변경하라.
--답:
RENAME emp_deptno to emp_dept;
--==ALTER TABLE EMP_DEPTNO
--RENAME TO EMP_DEPT;

--문제6) EMP_DEPT 테이블을 삭제하라.
--답:
DROP TABLE EMP_DEPT
CASCADE CONSTRAINTS; -- 여기선 없어도 된다.

--문제7) EMPLOYEES 테이블을 EMP 테이블을 생성하고 복제하도록 하라. (데이터 포함)
--답:
/*CREATE TABLE EMP
AS
SELECT * FROM employees;*/
CREATE TABLE EMP("사원번호","이름","월급","부서번호","부서명","부서월급순위")
AS
SELECT e.employee_id, e.last_name, e.salary,
        d.department_id, d.department_name,
         COUNT(*)OVER(PARTITION BY d.department_id ORDER BY e.salary) -- 중요 부분
FROM employees e, departments d
WHERE e.department_id = d.department_id;

--문제8) EMP 테이블에 row를 추가해 봅니다. 
--      다만, 반드시 데이터를 기입을 안해도 되면, NULL로 설정하도록 한다.
--답:
INSERT INTO EMP
VALUES(1001, '홍길동', 15000, 10, '개발부', 1);
/*
INSERT INTO emp
(employee_id, last_name, email, hire_date, job_id)
VALUES
(employees_seq.nextval, '감', 'ggg@NAVER.COM', '90/10/12', 'IT_PROG'); */

--문제9) EMPLOYEES 테이블에서 EMPNO,ENAME,SAL,HIREDATE의 COLUMN만 선택하여 
--       EMP_10 테이블을 생성(데이터 미포함)한 후 10번 부서만 선택하여
--       이에 대응하는 값을 EMP_10테이블에 입력하라.
--답:
CREATE TABLE EMP_10(EMPNO, ENAME, SAL, HIREDATE)
AS
SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE 2 = 1;
-- cf)데이터 넣기
INSERT INTO EMP_10
SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE department_id = 50;

--문제10) 다음은 무결성 제약 조건이 위배된 쿼리이다. 무엇을 위배했는지 알아보도록 합시다.
--답: ()부분이 정답
INSERT INTO EMPLOYEES VALUES ((100), NULL, 'YOON', 'dbs', NULL, SYSDATE, 'ST_MAN', NULL, NULL, NULL, NULL);
--맨앞 100, 기본키/이미 존재하는 PK = 중복
INSERT INTO EMPLOYEES VALUES (98, NULL, 'YOON', ('dbs'), NULL, SYSDATE, 'ST_MAN', NULL, NULL, NULL, 100);
--unique//첫 줄과 중복됐음
DELETE FROM employees WHERE last_name = 'YOON';
INSERT INTO EMPLOYEES VALUES (98, NULL, 'YOON', 'dbs2', NULL, SYSDATE, 'ST_MAN', NULL, NULL, NULL, (101));
--외래키 JOIN테이블의 오류 DEPARTMENT ID에 101이 존재 안함

--------------------------------------------------------------------SQL7 -hr
-- TABLE을 작성하라. 
-- TEAM : 팀 아이디, 지역, 팀 명, 개설 날짜, 전화번호, 홈페이지 
--답:


CREATE TABLE TB_TEAM(
    T_ID  VARCHAR2(20),
    T_LOC VARCHAR2(20),
    T_NAME VARCHAR2(20),
    T_DAY VARCHAR2(20),
    T_PHONE VARCHAR2(20),
    T_PAGE VARCHAR2(20),
    CONSTRAINT PK_TB_TEAM PRIMARY KEY(T_ID)
);

-- PLAYER : 선수번호, 선수 명, 등록일, 포지션, 키, 팀 아이디
--답:


CREATE TABLE TB_T_PLAYER(
    P_ID  VARCHAR2(20),
    P_NAME VARCHAR2(20),
    P_DAY VARCHAR2(20),
    P_POS VARCHAR2(20),
    P_HEIGHT VARCHAR2(20),
    T_ID VARCHAR2(20),
    CONSTRAINT FK_TB_T_TEAM FOREIGN KEY(T_ID)
    REFERENCES TB_TEAM(T_ID)
);
-- 외래키로 연결한다.
-- TEAM 두개만 등록하라.
--답:


INSERT INTO TB_TEAM(T_ID, T_LOC, T_NAME, T_DAY, T_PHONE, T_PAGE)
VALUES('1','서울','NC다이노스','1990/03/01','02-2226-3333','GOOGLE.COM');

INSERT INTO TB_TEAM(T_ID, T_LOC, T_NAME, T_DAY, T_PHONE, T_PAGE)
VALUES('2','예산','한화이글스',SYSDATE,'041-333-1234','NAVER.COM');

-- 두개의 TEAM에 선수를 각각 3명씩 등록하라.
INSERT INTO TB_T_PLAYER
(P_ID, P_NAME, P_DAY, P_POS, P_HEIGHT, T_ID)
VALUES('1000','가가가','2002/02/02','투수','177','1');

INSERT INTO TB_T_PLAYER
(P_ID, P_NAME, P_DAY, P_POS, P_HEIGHT, T_ID)
VALUES('1001','나나나','2004/04/04','타자','173','1');

INSERT INTO TB_T_PLAYER
(P_ID, P_NAME, P_DAY, P_POS, P_HEIGHT, T_ID)
VALUES('1002','다다다','2003/03/03','투수','181','1');

INSERT INTO TB_T_PLAYER
(P_ID, P_NAME, P_DAY, P_POS, P_HEIGHT, T_ID)
VALUES('1003','라라라',SYSDATE,'투수','177','2');

INSERT INTO TB_T_PLAYER
(P_ID, P_NAME, P_DAY, P_POS, P_HEIGHT, T_ID)
VALUES('1004','마마마','2005/05/06','타자','173','2');

INSERT INTO TB_T_PLAYER
(P_ID, P_NAME, P_DAY, P_POS, P_HEIGHT, T_ID)
VALUES('1005','바바바','2004/04/04','타자','181','2');

--------------------------------------------------------------------
-- TABLE을 작성하라. 
DROP TABLE Z_GOOD CASCADE CONSTRAINTS;
DROP TABLE Z_USER CASCADE CONSTRAINTS;
DROP TABLE Z_CART CASCADE CONSTRAINTS;
-- PRODUCT(상품) : 상품번호, 상품명, 상품가격, 상품설명 
--답:


CREATE TABLE Z_GOOD(
    GOOD_NUM  VARCHAR2(20),
    GOOD_NAME VARCHAR2(20),
    GOOD_PRICE VARCHAR2(20),
    GOOD_ABOUT VARCHAR2(20),
    CONSTRAINT PK_Z_GO PRIMARY KEY(GOOD_NUM)
);
-- CONSUMER(소비자) : 소비자 ID, 이름, 나이 
--답:


CREATE TABLE Z_USER(
    U_ID  VARCHAR2(20),
    U_NAME VARCHAR2(20),
    U_AGE VARCHAR2(20),
    CONSTRAINT PK_Z_US PRIMARY KEY(U_ID)
);
-- CART(장바구니) : 장바구니 번호, 소비자 ID, 상품번호, 수량
--답:


CREATE TABLE Z_CART(
    C_NUM  VARCHAR2(20),
    U_ID VARCHAR2(20),
    GOOD_NUM VARCHAR2(20),
    C_QUAN VARCHAR2(20),
    CONSTRAINT FK_GO FOREIGN KEY(GOOD_NUM)
    REFERENCES Z_GOOD(GOOD_NUM),
    CONSTRAINT FK_US FOREIGN KEY(U_ID)
    REFERENCES Z_USER(U_ID)
);
-- 외래키로 연결한다.
-- 상품을 5개만 등록 하라.
--답:


INSERT INTO Z_GOOD(GOOD_NUM, GOOD_NAME, GOOD_PRICE, GOOD_ABOUT)
VALUES('1','가방','10000','가방');
INSERT INTO Z_GOOD(GOOD_NUM, GOOD_NAME, GOOD_PRICE, GOOD_ABOUT)
VALUES('2','나시','5000','옷');
INSERT INTO Z_GOOD(GOOD_NUM, GOOD_NAME, GOOD_PRICE, GOOD_ABOUT)
VALUES('3','다도','100000','세트');
INSERT INTO Z_GOOD(GOOD_NUM, GOOD_NAME, GOOD_PRICE, GOOD_ABOUT)
VALUES('4','라면','1200','음식');
INSERT INTO Z_GOOD(GOOD_NUM, GOOD_NAME, GOOD_PRICE, GOOD_ABOUT)
VALUES('5','마늘','1000','야채');
-- 두명의 소비자를 등록하라. 
INSERT INTO Z_USER(U_ID, U_NAME, U_AGE)
VALUES('SKYSTYLE','홍길동','48');
INSERT INTO Z_USER(U_ID, U_NAME, U_AGE)
VALUES('KDWSTYLE','일지매','20');
-- 소비자의 장바구니에 상품 추가하라.
--답:


INSERT INTO Z_CART( C_NUM, U_ID, GOOD_NUM, C_QUAN)
VALUES('100','SKYSTYLE','3','2');

--------------------------------------------------------------------SQL7v2 -hr
-- EXERD (모델링할 수 있는 툴) -> 이미지 저장, 모델링 파일 저장 cf)eXERD ER-WIN
CREATE TABLE Z_TEAM(
    TEAM_ID NUMBER(8) CONSTRAINT PK_TEAM_ID PRIMARY KEY,       --팀아이디
    REGION_NAME VARCHAR2(10),                                  --지역
    TEAM_NAME VARCHAR2(50) NOT NULL,                           --팀명
    START_DATE DATE,                                           --개설날짜
    TEL VARCHAR2(20),                                          --전화번호
    HOMEPAGE VARCHAR2(20)                                      --홈페이지
    );                                                             -- 팀 테이블
CREATE TABLE Z_PLAYER(
    PLAYER_ID NUMBER CONSTRAINT PK_PLAYER PRIMARY KEY,         --선수아이디
    PLAYER_NAME VARCHAR2(20),                                  --선수이름
    JOIN_DATE DATE,                                            --합류날짜
    POSITION VARCHAR2(20),                                     --포지션
    HEIGHT NUMBER(5, 1),                                       --키
    TEAM_ID NUMBER(8) -- 여기가 더 컸을땐 문자 안됨 cf)문자가 짤리니께 --팀아이디
    );                                                             -- 선수 테이블
ALTER TABLE Z_PLAYER
ADD
CONSTRAINT FK_TEAM_ID FOREIGN KEY (TEAM_ID)
REFERENCES Z_TEAM(TEAM_ID);                                        -- 외래키
--팀입력                   --50byte로 잡는게 좋음
INSERT INTO Z_TEAM(TEAM_ID, REGION_NAME, TEAM_NAME, START_DATE, TEL, HOMEPAGE)
VALUES(100, '서울', '트윈즈', '02/10/23', '02-123-4567', 'http://www.twins.com');
INSERT INTO Z_TEAM(TEAM_ID, REGION_NAME, TEAM_NAME, START_DATE, TEL, HOMEPAGE)
VALUES(101, '광주', '타이거즈', '92/06/13', '034-112-537', 'http://www.tiger.com');
--선수입력
INSERT INTO Z_PLAYER(PLAYER_ID, PLAYER_NAME, JOIN_DATE, POSITION, HEIGHT, TEAM_ID)
VALUES(1, '홍길동', SYSDATE, '투수', 172.1, 100);
INSERT INTO Z_PLAYER(PLAYER_ID, PLAYER_NAME, JOIN_DATE, POSITION, HEIGHT, TEAM_ID)
VALUES(2, '일지매', SYSDATE, '2루수', 179.2, 100);
INSERT INTO Z_PLAYER(PLAYER_ID, PLAYER_NAME, JOIN_DATE, POSITION, HEIGHT, TEAM_ID)
VALUES(3, '정수동', SYSDATE, '좌익수', 181.2, 101);
INSERT INTO Z_PLAYER(PLAYER_ID, PLAYER_NAME, JOIN_DATE, POSITION, HEIGHT, TEAM_ID)
VALUES(4, '성춘향', SYSDATE, '지명타자', 165.3, 101);
INSERT INTO Z_PLAYER(PLAYER_ID, PLAYER_NAME, JOIN_DATE, POSITION, HEIGHT, TEAM_ID)
VALUES(5, '임꺽정', SYSDATE, '유격수', 182.7, NULL);
--확인
SELECT * FROM Z_TEAM;
SELECT * FROM Z_PLAYER;
--조인
SELECT t.team_id, p.player_name, t.team_name
FROM z_team t, z_player p
WHERE t.team_id = p.team_id
    AND p.player_name = '성춘향';

---------------------------------------------------------------------

CREATE TABLE Y_PRODUCT(
    PRODUCT_ID NUMBER CONSTRAINT PK_PRODUCT PRIMARY KEY,         --상품번호
    NAME VARCHAR2 (50),                                          --상품명
    PRICE NUMBER,                                                --상품가격
    PRODUCT_DESC VARCHAR2(500)                                   --상품설명
);
CREATE TABLE Y_CONSUMER(
    USER_ID VARCHAR2(50) CONSTRAINT PK_USER PRIMARY KEY,         --회원아이디
    NAME VARCHAR2 (50) NOT NULL,                                 --회원이름
    AGE NUMBER                                                   --회원나이
);
CREATE TABLE Y_CART(
    CART_ID NUMBER CONSTRAINT PK_CART PRIMARY KEY,               --카트아이드
    USER_ID VARCHAR2(50),                      --FK 1            --회원아이디     
    PRODUCT_ID NUMBER,                         --FK 2            --상품번호      
    AMOUNT NUMBER                                                --수량
);
--외래키1
ALTER TABLE Y_CART
ADD
CONSTRAINT FK_USER_ID FOREIGN KEY(USER_ID)
REFERENCES Y_CONSUMER(USER_ID);
--외래키2
ALTER TABLE Y_CART
ADD
CONSTRAINT FK_PRODUCT_ID FOREIGN KEY(PRODUCT_ID)
REFERENCES Y_PRODUCT(PRODUCT_ID);
--상품등록
INSERT INTO Y_PRODUCT(PRODUCT_ID, NAME, PRICE, PRODUCT_DESC)
VALUES(101, '새우깡', 1500, '새우깡에는 새우가 없습니다.');
INSERT INTO Y_PRODUCT(PRODUCT_ID, NAME, PRICE, PRODUCT_DESC)
VALUES(102, '포테이토칩', 2300, '감자로 만듭니다.');
--소비자등록
INSERT INTO Y_CONSUMER(USER_ID, NAME, AGE)
VALUES('HGD','홍길동',24);
INSERT INTO Y_CONSUMER(USER_ID, NAME, AGE)
VALUES('IJM','일지매',22);
--카트등록
INSERT INTO Y_CART(CART_ID, USER_ID, PRODUCT_ID, AMOUNT)
VALUES(1, 'HGD', 102, 2);

SELECT * FROM Y_CART;

------정리
DROP TABLE emp CASCADE CONSTRAINTS;
DROP TABLE emp_10 CASCADE CONSTRAINTS;
DROP TABLE TB_TEAM CASCADE CONSTRAINTS;
DROP TABLE TB_T_PLAYER CASCADE CONSTRAINTS;
DROP TABLE Z_GOOD CASCADE CONSTRAINTS;
DROP TABLE Z_USER CASCADE CONSTRAINTS;
DROP TABLE Z_CART CASCADE CONSTRAINTS;
DROP TABLE Z_TEAM CASCADE CONSTRAINTS;
DROP TABLE Z_PLAYER CASCADE CONSTRAINTS;
DROP TABLE Y_PRODUCT CASCADE CONSTRAINTS;
DROP TABLE Y_CONSUMER CASCADE CONSTRAINTS;
DROP TABLE Y_CART CASCADE CONSTRAINTS;