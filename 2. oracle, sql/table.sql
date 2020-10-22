/*
확인해본 것..
시스템으로 접속해서 !

c:\test 폴더 만들고
메뉴에 보기->dba->저장영역->테이블스페이스 
우클릭->새로만들기 
파일 사양 디렉토리에 만들 곳 선택하고 
파일 크기 숫자 적고 KMGT 선택해서 만들고
속성에서 파일 유형 - 작은파일
로깅은 로깅 없음
확장영역 관리 유형 로컬 -> 자동할당 체크
ddl에서 만들어지는 과정 코드로 볼 수 있다.
*/
CREATE TABLESPACE TABLESPACE2
DATAFILE 'C:\TEST\TEST_TBS1_02.DBF' SIZE 10M
AUTOEXTEND ON NEXT 1M MAXSIZE UNLIMITED     -- 추가되는 용량
LOGGING                                     -- 로깅을 사용
EXTENT MANAGEMENT LOCAL AUTOALLOCATE        -- 로컬
BLOCKSIZE 8K                                -- BLOCK 크기 8K
SEGMENT SPACE MANAGEMENT AUTO
FLASHBACK ON;

-- TABLE SPACE 수정
-- 스페이스명을 수정
ALTER TABLESPACE TABLESPACE2
RENAME TO TB_TEST_NEW;

-- 데이터 파일의 용량을 수정
ALTER DATABASE
DATAFILE 'C:\TEST\TEST_TBS1_02.DBF' RESIZE 7M;

-- 테이블 스페이스 삭제 
-- 마우스 우클릭으로 테이블스페이스 지울땐 
-- 콘텐츠 포함/ 데이터 파일 포함/ 계단식 제약 조건 - 체크박스 다 선택해서 삭제
-- SQL > 삭제 코드
DROP TABLESPACE TB_TEST_NEW
INCLUDING CONTENTS AND DATAFILES
CASCADE CONSTRAINTS;

--따로 수행 ㄴ
---------------------------------------------------------------------------------------
--세로 COLUMN 영역에 관한 데이터
--가로 ROW 한명에 대한 데이터
-- 테이블 만드는 것은 스키마에서 SYSTEM 계정에서 쓰면 안됨
-- hr계정에서 만들기

-- TABLE CREATE
CREATE TABLE TB_TEST01(
    COL_01 VARCHAR2 (10),
    COL_02 VARCHAR2 (10),
    COL_03 VARCHAR2 (10),
    COL_04 VARCHAR2 (10)
);
--SQL을 확인하면 TABLESPACE "USERS"로 default 되어있음

/*
system으로 새로운 테이블 만들고 
툴에 접속에서 system의 다른 사용자에 hr 계정이 있다. 
사용자 편집으로 바꿀 수 있지만 에러날 확률이 높음
*/
--- TABLESPACE를 지정해서 생성 - 2번째 테이블 만듦
CREATE TABLE TB_TEST02(
    COL_01 VARCHAR2 (10),
    COL_02 VARCHAR2 (10),
    COL_03 VARCHAR2 (10),
    COL_04 VARCHAR2 (10)
)
TABLESPACE TABLESPACE2; --SYSTEM
--SQL에 TABLESPACE에서 다르게 확인할 수 있다. 공간을 지정해서 사용할 수 있기 때문이다.

-- TABLE COPY 1 : 데이터를 포함 - 전체 데이터를 가져옮 cf)데이터 베이스 복제해서 우리가 실수 없이 사용할 수 있게....
DROP TABLE TB_TEST03;

CREATE TABLE TB_TEST03
AS
SELECT *
FROM jobs;

-- TABLE COPY 2 : 데이터를 미포함(컬럼만 가져올때)
CREATE TABLE TB_TEST04
AS
SELECT *
FROM departments
WHERE 1 = 2; -- 말도 안되는 조건문
--cf)JOIN한 것을 TABLE로 만들기
DROP TABLE DEPT_INFO; -- 삭제
CREATE TABLE DEPT_INFO(EMPNO, SAL, DNAME, LOC) -- 여기 ()부분은 컬럼명 바꾸는 방법 / 안 붙이면 default값으로 들어간다.
AS
SELECT e.employee_id, e.salary, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- TABLE ALTER - 테이블 수정
/*
    Object  - create,   drop,             alter
    Data    - insert,   delete,  select,  update
*/
-- 테이블 수정 1 : 테이블명 변경
ALTER TABLE TB_TEST04
RENAME
TO
TB_TEST99;
-- 테이블 수정 2 : 단일 컬럼 추가
ALTER TABLE TB_TEST99
ADD
COL_NEW1 VARCHAR2(30);
-- 테이블 수정 3 : 다중 컬럼 추가
ALTER TABLE TB_TEST99
ADD
(COL_NEW2 NUMBER, COL_NEW3 DATE);
-- 테이블 수정 4 : 단일 컬럼 수정
ALTER TABLE TB_TEST99
MODIFY
COL_NEW1 VARCHAR2(20);
-- 테이블 수정 5 : 다중 컬럼 수정
ALTER TABLE TB_TEST99
MODIFY
(COL_NEW1 VARCHAR2(30), COL_NEW3 VARCHAR2(10));

-- 테이블 삭제 1 : 단일 컬럼 삭제
ALTER TABLE TB_TEST99
DROP
COLUMN
COL_NEW1;
-- 테이블 삭제 2 : 다중 컬럼 삭제
ALTER TABLE TB_TEST99
DROP
(COL_NEW2, COL_NEW3);
-- 컬럼 명 수정 - 필요할 때 있음
ALTER TABLE TB_TEST99
RENAME
COLUMN
DEPARTMENT_ID TO DEPTNO;

-- 테이블 삭제 
DROP TABLE TB_TEST01;
DROP TABLE TB_TEST02;
DROP TABLE TB_TEST03; -- 휴지통에 남아있어서 복원가능
--DROP TABLE TB_TEST03 PURGE; --완전 삭제
-- 휴지통 비우기
PURGE RECYCLEBIN;
/* cf)
툴에서 삭제할때 우클릭 테이블 삭제 체크박스는 다 하기 PURGE를 안 빼면 완전삭제
*/
------------------------------------------------------------------------------------------------

-- DATA INSERT
INSERT INTO TB_TEST99(DEPTNO, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
VALUES(100, '기획부', 20, 200);
    -- NULL로
INSERT INTO TB_TEST99(DEPTNO, DEPARTMENT_NAME)
VALUES(101, '관리부');
    -- 생략
INSERT INTO TB_TEST99
VALUES(102, '영업부', 45, 320);
    -- 컬럼 위치변경 - 헷갈림
INSERT INTO TB_TEST99(DEPTNO, MANAGER_ID, LOCATION_ID, DEPARTMENT_NAME)
VALUES(103, 65, 220, '인사부');
    --  '' 다 써도 상관없지만 
INSERT INTO TB_TEST99(DEPTNO, MANAGER_ID, LOCATION_ID, DEPARTMENT_NAME)
VALUES('103', '65', '220', '인사부');

-- DATA DELETE
    --1
DELETE FROM TB_TEST99
WHERE department_name = '인사부';
    --2 NULL삭제
DELETE FROM TB_TEST99
WHERE manager_id IS NULL;

-- DATA UPDATE
    --1
UPDATE tb_test99
SET manager_id = 70                     -- UPDATE 하려고 하는 값
WHERE department_name = '영업부';         -- 어디인지
    --2 한꺼번에 두개 이상 바꾸기 가능
UPDATE tb_test99
SET manager_id = 40, location_id = 200, department_name = '인사부'
WHERE deptno = 100;

                                                                    -- 확인
SELECT * FROM tb_test99;