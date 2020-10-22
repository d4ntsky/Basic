/*
Ȯ���غ� ��..
�ý������� �����ؼ� !

c:\test ���� �����
�޴��� ����->dba->���念��->���̺����̽� 
��Ŭ��->���θ���� 
���� ��� ���丮�� ���� �� �����ϰ� 
���� ũ�� ���� ���� KMGT �����ؼ� �����
�Ӽ����� ���� ���� - ��������
�α��� �α� ����
Ȯ�念�� ���� ���� ���� -> �ڵ��Ҵ� üũ
ddl���� ��������� ���� �ڵ�� �� �� �ִ�.
*/
CREATE TABLESPACE TABLESPACE2
DATAFILE 'C:\TEST\TEST_TBS1_02.DBF' SIZE 10M
AUTOEXTEND ON NEXT 1M MAXSIZE UNLIMITED     -- �߰��Ǵ� �뷮
LOGGING                                     -- �α��� ���
EXTENT MANAGEMENT LOCAL AUTOALLOCATE        -- ����
BLOCKSIZE 8K                                -- BLOCK ũ�� 8K
SEGMENT SPACE MANAGEMENT AUTO
FLASHBACK ON;

-- TABLE SPACE ����
-- �����̽����� ����
ALTER TABLESPACE TABLESPACE2
RENAME TO TB_TEST_NEW;

-- ������ ������ �뷮�� ����
ALTER DATABASE
DATAFILE 'C:\TEST\TEST_TBS1_02.DBF' RESIZE 7M;

-- ���̺� �����̽� ���� 
-- ���콺 ��Ŭ������ ���̺����̽� ���ﶩ 
-- ������ ����/ ������ ���� ����/ ��ܽ� ���� ���� - üũ�ڽ� �� �����ؼ� ����
-- SQL > ���� �ڵ�
DROP TABLESPACE TB_TEST_NEW
INCLUDING CONTENTS AND DATAFILES
CASCADE CONSTRAINTS;

--���� ���� ��
---------------------------------------------------------------------------------------
--���� COLUMN ������ ���� ������
--���� ROW �Ѹ� ���� ������
-- ���̺� ����� ���� ��Ű������ SYSTEM �������� ���� �ȵ�
-- hr�������� �����

-- TABLE CREATE
CREATE TABLE TB_TEST01(
    COL_01 VARCHAR2 (10),
    COL_02 VARCHAR2 (10),
    COL_03 VARCHAR2 (10),
    COL_04 VARCHAR2 (10)
);
--SQL�� Ȯ���ϸ� TABLESPACE "USERS"�� default �Ǿ�����

/*
system���� ���ο� ���̺� ����� 
���� ���ӿ��� system�� �ٸ� ����ڿ� hr ������ �ִ�. 
����� �������� �ٲ� �� ������ ������ Ȯ���� ����
*/
--- TABLESPACE�� �����ؼ� ���� - 2��° ���̺� ����
CREATE TABLE TB_TEST02(
    COL_01 VARCHAR2 (10),
    COL_02 VARCHAR2 (10),
    COL_03 VARCHAR2 (10),
    COL_04 VARCHAR2 (10)
)
TABLESPACE TABLESPACE2; --SYSTEM
--SQL�� TABLESPACE���� �ٸ��� Ȯ���� �� �ִ�. ������ �����ؼ� ����� �� �ֱ� �����̴�.

-- TABLE COPY 1 : �����͸� ���� - ��ü �����͸� ������ cf)������ ���̽� �����ؼ� �츮�� �Ǽ� ���� ����� �� �ְ�....
DROP TABLE TB_TEST03;

CREATE TABLE TB_TEST03
AS
SELECT *
FROM jobs;

-- TABLE COPY 2 : �����͸� ������(�÷��� �����ö�)
CREATE TABLE TB_TEST04
AS
SELECT *
FROM departments
WHERE 1 = 2; -- ���� �ȵǴ� ���ǹ�
--cf)JOIN�� ���� TABLE�� �����
DROP TABLE DEPT_INFO; -- ����
CREATE TABLE DEPT_INFO(EMPNO, SAL, DNAME, LOC) -- ���� ()�κ��� �÷��� �ٲٴ� ��� / �� ���̸� default������ ����.
AS
SELECT e.employee_id, e.salary, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- TABLE ALTER - ���̺� ����
/*
    Object  - create,   drop,             alter
    Data    - insert,   delete,  select,  update
*/
-- ���̺� ���� 1 : ���̺�� ����
ALTER TABLE TB_TEST04
RENAME
TO
TB_TEST99;
-- ���̺� ���� 2 : ���� �÷� �߰�
ALTER TABLE TB_TEST99
ADD
COL_NEW1 VARCHAR2(30);
-- ���̺� ���� 3 : ���� �÷� �߰�
ALTER TABLE TB_TEST99
ADD
(COL_NEW2 NUMBER, COL_NEW3 DATE);
-- ���̺� ���� 4 : ���� �÷� ����
ALTER TABLE TB_TEST99
MODIFY
COL_NEW1 VARCHAR2(20);
-- ���̺� ���� 5 : ���� �÷� ����
ALTER TABLE TB_TEST99
MODIFY
(COL_NEW1 VARCHAR2(30), COL_NEW3 VARCHAR2(10));

-- ���̺� ���� 1 : ���� �÷� ����
ALTER TABLE TB_TEST99
DROP
COLUMN
COL_NEW1;
-- ���̺� ���� 2 : ���� �÷� ����
ALTER TABLE TB_TEST99
DROP
(COL_NEW2, COL_NEW3);
-- �÷� �� ���� - �ʿ��� �� ����
ALTER TABLE TB_TEST99
RENAME
COLUMN
DEPARTMENT_ID TO DEPTNO;

-- ���̺� ���� 
DROP TABLE TB_TEST01;
DROP TABLE TB_TEST02;
DROP TABLE TB_TEST03; -- �����뿡 �����־ ��������
--DROP TABLE TB_TEST03 PURGE; --���� ����
-- ������ ����
PURGE RECYCLEBIN;
/* cf)
������ �����Ҷ� ��Ŭ�� ���̺� ���� üũ�ڽ��� �� �ϱ� PURGE�� �� ���� ��������
*/
------------------------------------------------------------------------------------------------

-- DATA INSERT
INSERT INTO TB_TEST99(DEPTNO, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
VALUES(100, '��ȹ��', 20, 200);
    -- NULL��
INSERT INTO TB_TEST99(DEPTNO, DEPARTMENT_NAME)
VALUES(101, '������');
    -- ����
INSERT INTO TB_TEST99
VALUES(102, '������', 45, 320);
    -- �÷� ��ġ���� - �򰥸�
INSERT INTO TB_TEST99(DEPTNO, MANAGER_ID, LOCATION_ID, DEPARTMENT_NAME)
VALUES(103, 65, 220, '�λ��');
    --  '' �� �ᵵ ��������� 
INSERT INTO TB_TEST99(DEPTNO, MANAGER_ID, LOCATION_ID, DEPARTMENT_NAME)
VALUES('103', '65', '220', '�λ��');

-- DATA DELETE
    --1
DELETE FROM TB_TEST99
WHERE department_name = '�λ��';
    --2 NULL����
DELETE FROM TB_TEST99
WHERE manager_id IS NULL;

-- DATA UPDATE
    --1
UPDATE tb_test99
SET manager_id = 70                     -- UPDATE �Ϸ��� �ϴ� ��
WHERE department_name = '������';         -- �������
    --2 �Ѳ����� �ΰ� �̻� �ٲٱ� ����
UPDATE tb_test99
SET manager_id = 40, location_id = 200, department_name = '�λ��'
WHERE deptno = 100;

                                                                    -- Ȯ��
SELECT * FROM tb_test99;