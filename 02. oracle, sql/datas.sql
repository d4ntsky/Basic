SELECT * FROM employees;
select * from EMPLOYEES;

--한줄 주석문

/*
범위 
주석문
*/

-- table 생성
/*
CREATE TABLE 테이블명(
    컬럼명1 자료형,
    컬럼명2 자료형,
    컬럼명3 자료형
        :
);

DROP TABLE 테이블명;
*/

 --   자료형
 /*
    java        oracle
    int         Integer, NUMBER
    double      NUMBER(정수의 자리수, 소수의 자리수)
    String      VARCHAR2, CHAR
    Date        DATE
*/

-- 문자열
-- CHAR
CREATE TABLE TB_CHAR(
    COL_CHAR1 CHAR(10 BYTE),
    COL_CHAR2 CHAR(10 CHAR),
    COL_CHAR3 CHAR(10)
);

/*
    INSERT INTO 테이블명(컬럼명, 컬럼명, 컬럼명 ...)
    VALUES(값, 값, 값);
    
    String '문자열'
*/

INSERT INTO tb_char(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('ABC', 'ABC', 'ABC');    -- 영문자 1문자의 크기 1 BYTE

SELECT * FROM tb_char;

INSERT INTO tb_char(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('가', '나', '다');  -- 한글의 한문자의 크기 3 BYTE 

INSERT INTO tb_char(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('가나', '가나', '가나');

INSERT INTO tb_char(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('가나다', '가나다', '가나다');

SELECT col_char1, col_char2, col_char3, LENGTHB(col_char1), LENGTHB(col_char2), LENGTHB(col_char3)
FROM tb_char;

/*
CHAR : 10 BYTE  00000   00000
ABC ->          ABC00   00000

가(3BYTE) + 9 = 12
가나(6BYTE) + 8 = 14
가나다 (9BYTE) + 7 = 16
*/

-- VARCHAR2
CREATE TABLE TB_VARCHAR(
    COL1 VARCHAR2(10 BYTE),
    COL2 VARCHAR2(10 CHAR),
    COL3 VARCHAR2(10)
);

INSERT INTO TB_VARCHAR(COL1, COL2, COL3)
VALUES('ABC','ABC','ABC');

INSERT INTO TB_VARCHAR(COL1, COL2, COL3)
VALUES('가나다','가나다','가나다');

SELECT * FROM tb_varchar;

SELECT COL1, COL2, COL3, LENGTHB(COL1),  LENGTHB(COL2), LENGTHB(COL3)
FROM tb_varchar;

-- LONG
-- 최대 2GB까지 저장
-- TABLE당 1개만 사용가능.
CREATE TABLE TB_LONG(
    COL_LONG LONG
 -- COL_LONG1 LONG
);

INSERT INTO TB_LONG(COL_LONG)
VALUES('ABC');

SELECT * FROM tb_long;

--SELECT COL_LONG, LENGTHB(COL_LONG) FROM tb_long;
--에러남

--CF)90%이상이 VARCHAR

-- 숫자(정수, 실수)

-- INTEGER  정수만 가능
CREATE TABLE TB_INTEGER(
    COL1 INTEGER,
    COL2 INTEGER
);

INSERT INTO tb_integer(COL1, COL2)
VALUES(123, 789);
INSERT INTO tb_integer(COL1, COL2)
VALUES('456', '012');   --가능

SELECT * FROM tb_integer;

COMMIT; --DB에 저장?

-- NUMBER   정수,실수 둘 다 가능/자주 쓰임
CREATE TABLE TB_NUMBER(
    COL_NUM1 NUMBER,
    COL_NUM2 NUMBER(5),
    COL_NUM3 NUMBER(5,2),
    COL_NUM4 NUMBER(*,2)
);

INSERT INTO tb_number(col_num1, col_num2, col_num3, col_num4)
values(1234.5678, 12345, 123.456, 1234.56789);

select * from tb_number;

-- 날짜 DATE
-- 연도, 월, 일, 시, 분, 초
CREATE TABLE TB_DATE(
    COL_DATE1 DATE,
    COL_DATE2 DATE
);

-- SYSDATE
INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, SYSDATE - 1);

SELECT * FROM TB_DATE;

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, 
TO_DATE('2020-07-17 12:32:45','YYYY-MM-DD-HH:MI:SS')); --TO_DATE(날짜 값, 형식)

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, '2020-07-17');

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSTEM, '2020/08/27)');

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, 
TO_DATE('20200717123245','YYYY-MM-DD-HH:MI:SS')); --TO_DATE(날짜 값, 형식)

-- VARCHAR2(문자열) -> DATE(문자열, 날짜형태) -> TO_DATE
-- DATE(문자열, 날짜형태) -> VARCHAR2(문자열) -> TO_CHAR

DROP TABLE TB_CHAR;
DROP TABLE TB_VARCHAR;
DROP TABLE TB_LONG;
DROP TABLE TB_NUMBER;
DROP TABLE TB_INTEGER;
DROP TABLE TB_DATE;