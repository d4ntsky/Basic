-- DML 
-- INSERT/DELETE/SELECT(90%)/UPDATE
/*  Query
    Database : 데이터 관리의 목적 -> Server로 돌려줘야함
               File -> ArrayList
               ex) 홍길동-24-181.2
               
    SELECT 
        (값, COLUMN(항목), 함수, SUB QUERY(쿼리문 안의 쿼리))
    FROM
        (TABLE명, SUB QUERY)
    cf)알고리즘을 알기보단... 명령을 내리는 법
*/
SELECT 1 
FROM DUAL;         -- DUAL은 가상테이블 - 값만 확인해볼 수 있는 테이블

SELECT * FROM EMP; -- * 모든 컬럼

 -- 현재 계정의 테이블을 모두 명세
SELECT * FROM TAB;

 -- 테이블에서 원하는 컬럼의 값만을 명세    -- scott 계정을 예로듬
SELECT empno, ename, sal, hiredate
FROM emp;                 

SELECT empno, ename, sal, sal + 300 -- 연산과 함께 가능하다
FROM emp;                   -- 300 더 준 월급

SELECT empno, ename, sal, sal * 12
FROM emp;                   -- 연봉

 -- alias   java에선 int alias[] = array; alias[0] = 11;
SELECT empno AS 사원번호, sal AS "월급", sal * 12 연봉 
FROM emp;                           --AS생략가능/""를 쓰는건 띄어쓰기때
            --집에서 확인 1 7369 800 9600 2 7499 1600 19200

 -- 연결 연산자 ||   사원명의 월급은 ?입니다
SELECT ename || '의 월급은 ' || sal || '입니다' AS "이름과 월급"
FROM emp;   --하나의 컬럼으로? 표현할때는 ''

 -- distinct : 중복행의 삭제 -- group by
SELECT DISTINCT job 
FROM emp;   --업무만 보고 싶을때

 -- DESC : TABLE의 COLUMN들을 명세 / 자주쓰는편은 아님
DESC emp;
desc dept;  --테이블 앞에 DESC / SORTING할 때 쓰임