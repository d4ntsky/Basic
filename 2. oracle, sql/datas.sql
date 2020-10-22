SELECT * FROM employees;
select * from EMPLOYEES;

--���� �ּ���

/*
���� 
�ּ���
*/

-- table ����
/*
CREATE TABLE ���̺��(
    �÷���1 �ڷ���,
    �÷���2 �ڷ���,
    �÷���3 �ڷ���
        :
);

DROP TABLE ���̺��;
*/

 --   �ڷ���
 /*
    java        oracle
    int         Integer, NUMBER
    double      NUMBER(������ �ڸ���, �Ҽ��� �ڸ���)
    String      VARCHAR2, CHAR
    Date        DATE
*/

-- ���ڿ�
-- CHAR
CREATE TABLE TB_CHAR(
    COL_CHAR1 CHAR(10 BYTE),
    COL_CHAR2 CHAR(10 CHAR),
    COL_CHAR3 CHAR(10)
);

/*
    INSERT INTO ���̺��(�÷���, �÷���, �÷��� ...)
    VALUES(��, ��, ��);
    
    String '���ڿ�'
*/

INSERT INTO tb_char(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('ABC', 'ABC', 'ABC');    -- ������ 1������ ũ�� 1 BYTE

SELECT * FROM tb_char;

INSERT INTO tb_char(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('��', '��', '��');  -- �ѱ��� �ѹ����� ũ�� 3 BYTE 

INSERT INTO tb_char(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('����', '����', '����');

INSERT INTO tb_char(COL_CHAR1, COL_CHAR2, COL_CHAR3)
VALUES('������', '������', '������');

SELECT col_char1, col_char2, col_char3, LENGTHB(col_char1), LENGTHB(col_char2), LENGTHB(col_char3)
FROM tb_char;

/*
CHAR : 10 BYTE  00000   00000
ABC ->          ABC00   00000

��(3BYTE) + 9 = 12
����(6BYTE) + 8 = 14
������ (9BYTE) + 7 = 16
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
VALUES('������','������','������');

SELECT * FROM tb_varchar;

SELECT COL1, COL2, COL3, LENGTHB(COL1),  LENGTHB(COL2), LENGTHB(COL3)
FROM tb_varchar;

-- LONG
-- �ִ� 2GB���� ����
-- TABLE�� 1���� ��밡��.
CREATE TABLE TB_LONG(
    COL_LONG LONG
 -- COL_LONG1 LONG
);

INSERT INTO TB_LONG(COL_LONG)
VALUES('ABC');

SELECT * FROM tb_long;

--SELECT COL_LONG, LENGTHB(COL_LONG) FROM tb_long;
--������

--CF)90%�̻��� VARCHAR

-- ����(����, �Ǽ�)

-- INTEGER  ������ ����
CREATE TABLE TB_INTEGER(
    COL1 INTEGER,
    COL2 INTEGER
);

INSERT INTO tb_integer(COL1, COL2)
VALUES(123, 789);
INSERT INTO tb_integer(COL1, COL2)
VALUES('456', '012');   --����

SELECT * FROM tb_integer;

COMMIT; --DB�� ����?

-- NUMBER   ����,�Ǽ� �� �� ����/���� ����
CREATE TABLE TB_NUMBER(
    COL_NUM1 NUMBER,
    COL_NUM2 NUMBER(5),
    COL_NUM3 NUMBER(5,2),
    COL_NUM4 NUMBER(*,2)
);

INSERT INTO tb_number(col_num1, col_num2, col_num3, col_num4)
values(1234.5678, 12345, 123.456, 1234.56789);

select * from tb_number;

-- ��¥ DATE
-- ����, ��, ��, ��, ��, ��
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
TO_DATE('2020-07-17 12:32:45','YYYY-MM-DD-HH:MI:SS')); --TO_DATE(��¥ ��, ����)

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, '2020-07-17');

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSTEM, '2020/08/27)');

INSERT INTO TB_DATE(COL_DATE1, COL_DATE2)
VALUES(SYSDATE, 
TO_DATE('20200717123245','YYYY-MM-DD-HH:MI:SS')); --TO_DATE(��¥ ��, ����)

-- VARCHAR2(���ڿ�) -> DATE(���ڿ�, ��¥����) -> TO_DATE
-- DATE(���ڿ�, ��¥����) -> VARCHAR2(���ڿ�) -> TO_CHAR

DROP TABLE TB_CHAR;
DROP TABLE TB_VARCHAR;
DROP TABLE TB_LONG;
DROP TABLE TB_NUMBER;
DROP TABLE TB_INTEGER;
DROP TABLE TB_DATE;