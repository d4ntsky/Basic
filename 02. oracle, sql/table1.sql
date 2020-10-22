/* 
    무결성 : COLUMN에 적용.                   
           COLUMN을 지정하는 성질. 설정. cf) model 가면 P,U,F 확인 가능
           
        Primary Key : 기본키
                      NULL을 허용하지 않는다.   중복을 허용하지 않는다.           
                      ex) ID, 주민등록번호     
                      
        Unique  Key : 고유키
                      NULL을 허용한다.         중복을 허용하지 않는다.           
                      ex) E-mail
                      
        Foreign Key : 외래키
                      테이블과 테이블을 연결하는 목적의 성질. JOIN의 목적이다.
                      NULL을 허용한다. JOIN된 테이블에 값이 있어야한다.
                      외래키로 설정된 컬럼은 연결된 테이블에서 PK나 UK로 설정되어 있어야 한다.
                      ex)e.department_id = d.department_id
                      
        CHECK       : 범위를 설정한다
                      NULL을 허용한다.          중복을 허용한다.
                      
        NO NULL     : NULL을 허용하지 않는다.
*/
-------------------------------------------------------------------------------------------------------

-- NOT NULL
CREATE TABLE TB_TEST(
    COL_01 VARCHAR2(10) NOT NULL,
    COL_02 VARCHAR2(20)
);
SELECT * FROM tb_test; -- 확인용

INSERT INTO tb_test(COL_01, COL_02)
VALUES('AAA', '111');                -- 처음 입력
INSERT INTO tb_test(COL_01, COL_02)
VALUES('', '222');                   -- 오류남
INSERT INTO tb_test(COL_01, COL_02)
VALUES('BBB', '');                   -- 오류 안 남
INSERT INTO tb_test(COL_01)
VALUES('CCC');                       -- 컬럼 하나만 입력 가능

--------------------------------------------------------------------------------------------
-- Primary Key = Unique + NOT NULL
-- 식별자, 한 테이블에서 최대 32개 컬럼까지 지정할 수 있다.
-- CONSTRAINT : 무결성
DROP TABLE TEST_01  --그냥 삭제하면 어떻게 되나? 스키마에 남는다....
CASCADE CONSTRAINTS;               --cf)위에 둬서 바로 삭제 만들고 할 수 있게

CREATE TABLE TEST_01(
    PKCOL VARCHAR2(10) CONSTRAINT PK_TEST_01 PRIMARY KEY, -- PRIMARY KEY의 ID는 PK_TEST_01
                    --(CONSTRAINT PK_TEST_01) 없으면 시스템이 알아서 이름을 정한다. 
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(30)
);

INSERT INTO test_01(PKCOL, COL1, COL2)
VALUES('AAA','aaa','111');              

INSERT INTO test_01(PKCOL, COL1, COL2)
VALUES('BBB','aaa','111');

INSERT INTO test_01(PKCOL)
VALUES('CCC');

INSERT INTO test_01(PKCOL, COL1, COL2)
VALUES('','bbb','111');                 --에러

-- 1. Primal Key가 설정이 안 되는 경우
CREATE TABLE TEST_01(
    PKCOL VARCHAR2(10) CONSTRAINT PK_TEST_01 PRIMARY KEY, 
    COL1 VARCHAR2(20) CONSTRAINT PK_TEST_02 PRIMARY KEY, --아이디 중복 안됨
    COL2 VARCHAR2(30)
);
-- 2. 두개의 PK를 정할 경우 다음과 같이 한다.
CREATE TABLE TEST_01(
    PKCOL VARCHAR2(10),
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(30),
    CONSTRAINT PK_TEST_01 PRIMARY KEY (PKCOL, COL1)
);
-- 3. 나중에 코드로 따로 입력하는 법
CREATE TABLE TEST_01(
    PKCOL VARCHAR2(10),
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(30)
);
-- PK 추가
ALTER TABLE TEST_01
ADD 
CONSTRAINT PK_TEST_01
PRIMARY KEY(PKCOL, COL1);
-- PK 삭제
ALTER TABLE TEST_01
DROP CONSTRAINT PK_TEST_01;

--------------------------------------------------------------------------------------------
-- UNIQUE : 고유키. 중복된 값은 입력불가. NULL은 허용
CREATE TABLE TEST_02(
    UKCOL VARCHAR2(10) CONSTRAINT UK_TEST_02 UNIQUE,
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(20)
);

INSERT INTO test_02(UKCOL, COL1, COL2)
VALUES('AAA','aaa', '111');

INSERT INTO test_02(UKCOL, COL1, COL2)
VALUES('','aaa', '111');

INSERT INTO test_02(COL1, COL2)
VALUES('aaa', '111');

ALTER TABLE TEST_02
DROP CONSTRAINT UK_TEST_02;

--------------------------------------------------------------------------------------------
-- FOREIGN KEY : 외래키
-- 테이블과 테이블을 연결하기 위한 무결성 제약조건이다.
-- 다른 테이블(부모)에서는 PK, UK로 컬럼이 설정되어 있어야 한다.
-- NULL 허용
DROP TABLE TB_CHILD
CASCADE CONSTRAINTS;
DROP TABLE TB_PARENT
CASCADE CONSTRAINTS;
--departments
CREATE TABLE TB_PARENT(
    PKCOL01 VARCHAR2(10),   --department_id
    COL_01 VARCHAR2(20),
    COL_02 VARCHAR2(30),
    CONSTRAINT PK_TB_PARENT PRIMARY KEY(PKCOL01) 
);
--employees           
CREATE TABLE TB_CHILD(
    KEY_01 VARCHAR2(10),  
    KEY_02 VARCHAR2(10),
    FKCOL01 VARCHAR2(10),    --department_id
                    --용량이 부모테이블의 PRIMARY KEY랑 같아야한다.
    CONSTRAINT FK_TB_CHILD FOREIGN KEY(FKCOL01)
    REFERENCES TB_PARENT(PKCOL01) -- 설정이 안되있으면 안 만들어진다.
);

INSERT INTO tb_parent(PKCOL01, COL_01, COL_02)
VALUES('AAA','aaa','가가가');

INSERT INTO tb_parent(PKCOL01, COL_01, COL_02)
VALUES('BBB','bbb','나나나');

INSERT INTO tb_parent(PKCOL01, COL_01, COL_02)
VALUES('CCC','ccc','다다다');

--외래키를 넣는 부분
INSERT INTO tb_child(KEY_01, KEY_02, FKCOL01)
VALUES('123','가나다','DDD');
--4가지 넣을수 있다 AAA, BBB, CCC, NULL 중 하나
INSERT INTO tb_child(KEY_01, KEY_02, FKCOL01)
VALUES('123','가나다','BBB');

INSERT INTO tb_child(KEY_01, KEY_02, FKCOL01)
VALUES('234','나다라','');

SELECT c.key_01, c.key_02,
        c.fkcol01, p.pkcol01,
         p.col_01, p.col_02
FROM tb_child C, tb_parent P
WHERE c.fkcol01 = p.pkcol01;

--------------------------------------------------------------------------------------------
-- CHECK : 지정된 값(범위/설정값)만 입력할 수 있고, NULL을 허용, 중복 허용
CREATE TABLE TB_CHECK(
    COL_01 VARCHAR2(10), -- 세개중 하나 입력하던지 NULL을 주던지
    KEY_01 VARCHAR2(10), -- 범위 안만 허용 아니면 NULL을 주던지
    CONSTRAINT CHK_TB_CHECK01 
    CHECK(COL_01 IN ('사과','배','바나나')),
    CONSTRAINT CHK_TB_CHECK02 
    CHECK(KEY_01 > 0 AND KEY_01 <= 100)
);
INSERT INTO TB_CHECK(COL_01, KEY_01)
VALUES('사과',50);
INSERT INTO TB_CHECK(COL_01, KEY_01)
VALUES('사과',0);                             --안됨
INSERT INTO TB_CHECK(COL_01, KEY_01)
VALUES('사과',10);
INSERT INTO TB_CHECK(COL_01, KEY_01)
VALUES('',25);
INSERT INTO TB_CHECK(COL_01, KEY_01)
VALUES('','');
INSERT INTO TB_CHECK(COL_01, KEY_01)
VALUES('오렌지','');                           --안됨
SELECT * FROM tb_check;