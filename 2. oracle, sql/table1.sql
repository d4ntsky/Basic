/* 
    ���Ἲ : COLUMN�� ����.                   
           COLUMN�� �����ϴ� ����. ����. cf) model ���� P,U,F Ȯ�� ����
           
        Primary Key : �⺻Ű
                      NULL�� ������� �ʴ´�.   �ߺ��� ������� �ʴ´�.           
                      ex) ID, �ֹε�Ϲ�ȣ     
                      
        Unique  Key : ����Ű
                      NULL�� ����Ѵ�.         �ߺ��� ������� �ʴ´�.           
                      ex) E-mail
                      
        Foreign Key : �ܷ�Ű
                      ���̺�� ���̺��� �����ϴ� ������ ����. JOIN�� �����̴�.
                      NULL�� ����Ѵ�. JOIN�� ���̺� ���� �־���Ѵ�.
                      �ܷ�Ű�� ������ �÷��� ����� ���̺��� PK�� UK�� �����Ǿ� �־�� �Ѵ�.
                      ex)e.department_id = d.department_id
                      
        CHECK       : ������ �����Ѵ�
                      NULL�� ����Ѵ�.          �ߺ��� ����Ѵ�.
                      
        NO NULL     : NULL�� ������� �ʴ´�.
*/
-------------------------------------------------------------------------------------------------------

-- NOT NULL
CREATE TABLE TB_TEST(
    COL_01 VARCHAR2(10) NOT NULL,
    COL_02 VARCHAR2(20)
);
SELECT * FROM tb_test; -- Ȯ�ο�

INSERT INTO tb_test(COL_01, COL_02)
VALUES('AAA', '111');                -- ó�� �Է�
INSERT INTO tb_test(COL_01, COL_02)
VALUES('', '222');                   -- ������
INSERT INTO tb_test(COL_01, COL_02)
VALUES('BBB', '');                   -- ���� �� ��
INSERT INTO tb_test(COL_01)
VALUES('CCC');                       -- �÷� �ϳ��� �Է� ����

--------------------------------------------------------------------------------------------
-- Primary Key = Unique + NOT NULL
-- �ĺ���, �� ���̺��� �ִ� 32�� �÷����� ������ �� �ִ�.
-- CONSTRAINT : ���Ἲ
DROP TABLE TEST_01  --�׳� �����ϸ� ��� �ǳ�? ��Ű���� ���´�....
CASCADE CONSTRAINTS;               --cf)���� �ּ� �ٷ� ���� ����� �� �� �ְ�

CREATE TABLE TEST_01(
    PKCOL VARCHAR2(10) CONSTRAINT PK_TEST_01 PRIMARY KEY, -- PRIMARY KEY�� ID�� PK_TEST_01
                    --(CONSTRAINT PK_TEST_01) ������ �ý����� �˾Ƽ� �̸��� ���Ѵ�. 
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
VALUES('','bbb','111');                 --����

-- 1. Primal Key�� ������ �� �Ǵ� ���
CREATE TABLE TEST_01(
    PKCOL VARCHAR2(10) CONSTRAINT PK_TEST_01 PRIMARY KEY, 
    COL1 VARCHAR2(20) CONSTRAINT PK_TEST_02 PRIMARY KEY, --���̵� �ߺ� �ȵ�
    COL2 VARCHAR2(30)
);
-- 2. �ΰ��� PK�� ���� ��� ������ ���� �Ѵ�.
CREATE TABLE TEST_01(
    PKCOL VARCHAR2(10),
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(30),
    CONSTRAINT PK_TEST_01 PRIMARY KEY (PKCOL, COL1)
);
-- 3. ���߿� �ڵ�� ���� �Է��ϴ� ��
CREATE TABLE TEST_01(
    PKCOL VARCHAR2(10),
    COL1 VARCHAR2(20),
    COL2 VARCHAR2(30)
);
-- PK �߰�
ALTER TABLE TEST_01
ADD 
CONSTRAINT PK_TEST_01
PRIMARY KEY(PKCOL, COL1);
-- PK ����
ALTER TABLE TEST_01
DROP CONSTRAINT PK_TEST_01;

--------------------------------------------------------------------------------------------
-- UNIQUE : ����Ű. �ߺ��� ���� �ԷºҰ�. NULL�� ���
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
-- FOREIGN KEY : �ܷ�Ű
-- ���̺�� ���̺��� �����ϱ� ���� ���Ἲ ���������̴�.
-- �ٸ� ���̺�(�θ�)������ PK, UK�� �÷��� �����Ǿ� �־�� �Ѵ�.
-- NULL ���
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
                    --�뷮�� �θ����̺��� PRIMARY KEY�� ���ƾ��Ѵ�.
    CONSTRAINT FK_TB_CHILD FOREIGN KEY(FKCOL01)
    REFERENCES TB_PARENT(PKCOL01) -- ������ �ȵ������� �� ���������.
);

INSERT INTO tb_parent(PKCOL01, COL_01, COL_02)
VALUES('AAA','aaa','������');

INSERT INTO tb_parent(PKCOL01, COL_01, COL_02)
VALUES('BBB','bbb','������');

INSERT INTO tb_parent(PKCOL01, COL_01, COL_02)
VALUES('CCC','ccc','�ٴٴ�');

--�ܷ�Ű�� �ִ� �κ�
INSERT INTO tb_child(KEY_01, KEY_02, FKCOL01)
VALUES('123','������','DDD');
--4���� ������ �ִ� AAA, BBB, CCC, NULL �� �ϳ�
INSERT INTO tb_child(KEY_01, KEY_02, FKCOL01)
VALUES('123','������','BBB');

INSERT INTO tb_child(KEY_01, KEY_02, FKCOL01)
VALUES('234','���ٶ�','');

SELECT c.key_01, c.key_02,
        c.fkcol01, p.pkcol01,
         p.col_01, p.col_02
FROM tb_child C, tb_parent P
WHERE c.fkcol01 = p.pkcol01;

--------------------------------------------------------------------------------------------
-- CHECK : ������ ��(����/������)�� �Է��� �� �ְ�, NULL�� ���, �ߺ� ���
CREATE TABLE TB_CHECK(
    COL_01 VARCHAR2(10), -- ������ �ϳ� �Է��ϴ��� NULL�� �ִ���
    KEY_01 VARCHAR2(10), -- ���� �ȸ� ��� �ƴϸ� NULL�� �ִ���
    CONSTRAINT CHK_TB_CHECK01 
    CHECK(COL_01 IN ('���','��','�ٳ���')),
    CONSTRAINT CHK_TB_CHECK02 
    CHECK(KEY_01 > 0 AND KEY_01 <= 100)
);
INSERT INTO TB_CHECK(COL_01, KEY_01)
VALUES('���',50);
INSERT INTO TB_CHECK(COL_01, KEY_01)
VALUES('���',0);                             --�ȵ�
INSERT INTO TB_CHECK(COL_01, KEY_01)
VALUES('���',10);
INSERT INTO TB_CHECK(COL_01, KEY_01)
VALUES('',25);
INSERT INTO TB_CHECK(COL_01, KEY_01)
VALUES('','');
INSERT INTO TB_CHECK(COL_01, KEY_01)
VALUES('������','');                           --�ȵ�
SELECT * FROM tb_check;