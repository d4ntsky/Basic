--------------------------------------------------------------------SQL6 -hr
--����1) EMPLOYEES ���̺��� �μ����� 
--      �ο���, ��� �޿�, �޿��� ��, �ּ� �޿�, �ִ� �޿��� �����ϴ� 
--      EMP_DEPTNO ���̺��� �����϶�.
--��:
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

--����2) EMP_DEPTNO ���̺� ETC COLUMN�� �߰��϶�. 
--      �� �ڷ����� VARCHAR2(50) ����϶�.
--��:
ALTER TABLE EMP_DEPTNO
ADD
(ETC VARCHAR2(50));

--����3) EMP_DEPTNO ���̺� ETC COLUMN�� �����϶�. 
--      �ڷ� ���� VARCHAR2(15)�� �϶�.
--��:
ALTER TABLE EMP_DEPTNO
MODIFY
(etc VARCHAR2(15));

--����4) EMP_DEPTNO ���̺� �ִ� ETC �� �����ϰ� Ȯ���϶�.
--��:
ALTER TABLE EMP_DEPTNO
DROP
--COLUMN ETC�� ()����?
(ETC);

--����5) ������ ������ EMP_DEPTNO ���̺��� �̸��� EMP_DEPT�� �����϶�.
--��:
RENAME emp_deptno to emp_dept;
--==ALTER TABLE EMP_DEPTNO
--RENAME TO EMP_DEPT;

--����6) EMP_DEPT ���̺��� �����϶�.
--��:
DROP TABLE EMP_DEPT
CASCADE CONSTRAINTS; -- ���⼱ ��� �ȴ�.

--����7) EMPLOYEES ���̺��� EMP ���̺��� �����ϰ� �����ϵ��� �϶�. (������ ����)
--��:
/*CREATE TABLE EMP
AS
SELECT * FROM employees;*/
CREATE TABLE EMP("�����ȣ","�̸�","����","�μ���ȣ","�μ���","�μ����޼���")
AS
SELECT e.employee_id, e.last_name, e.salary,
        d.department_id, d.department_name,
         COUNT(*)OVER(PARTITION BY d.department_id ORDER BY e.salary) -- �߿� �κ�
FROM employees e, departments d
WHERE e.department_id = d.department_id;

--����8) EMP ���̺� row�� �߰��� ���ϴ�. 
--      �ٸ�, �ݵ�� �����͸� ������ ���ص� �Ǹ�, NULL�� �����ϵ��� �Ѵ�.
--��:
INSERT INTO EMP
VALUES(1001, 'ȫ�浿', 15000, 10, '���ߺ�', 1);
/*
INSERT INTO emp
(employee_id, last_name, email, hire_date, job_id)
VALUES
(employees_seq.nextval, '��', 'ggg@NAVER.COM', '90/10/12', 'IT_PROG'); */

--����9) EMPLOYEES ���̺��� EMPNO,ENAME,SAL,HIREDATE�� COLUMN�� �����Ͽ� 
--       EMP_10 ���̺��� ����(������ ������)�� �� 10�� �μ��� �����Ͽ�
--       �̿� �����ϴ� ���� EMP_10���̺� �Է��϶�.
--��:
CREATE TABLE EMP_10(EMPNO, ENAME, SAL, HIREDATE)
AS
SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE 2 = 1;
-- cf)������ �ֱ�
INSERT INTO EMP_10
SELECT employee_id, last_name, salary, hire_date
FROM employees
WHERE department_id = 50;

--����10) ������ ���Ἲ ���� ������ ����� �����̴�. ������ �����ߴ��� �˾ƺ����� �սô�.
--��: ()�κ��� ����
INSERT INTO EMPLOYEES VALUES ((100), NULL, 'YOON', 'dbs', NULL, SYSDATE, 'ST_MAN', NULL, NULL, NULL, NULL);
--�Ǿ� 100, �⺻Ű/�̹� �����ϴ� PK = �ߺ�
INSERT INTO EMPLOYEES VALUES (98, NULL, 'YOON', ('dbs'), NULL, SYSDATE, 'ST_MAN', NULL, NULL, NULL, 100);
--unique//ù �ٰ� �ߺ�����
DELETE FROM employees WHERE last_name = 'YOON';
INSERT INTO EMPLOYEES VALUES (98, NULL, 'YOON', 'dbs2', NULL, SYSDATE, 'ST_MAN', NULL, NULL, NULL, (101));
--�ܷ�Ű JOIN���̺��� ���� DEPARTMENT ID�� 101�� ���� ����

--------------------------------------------------------------------SQL7 -hr
-- TABLE�� �ۼ��϶�. 
-- TEAM : �� ���̵�, ����, �� ��, ���� ��¥, ��ȭ��ȣ, Ȩ������ 
--��:


CREATE TABLE TB_TEAM(
    T_ID  VARCHAR2(20),
    T_LOC VARCHAR2(20),
    T_NAME VARCHAR2(20),
    T_DAY VARCHAR2(20),
    T_PHONE VARCHAR2(20),
    T_PAGE VARCHAR2(20),
    CONSTRAINT PK_TB_TEAM PRIMARY KEY(T_ID)
);

-- PLAYER : ������ȣ, ���� ��, �����, ������, Ű, �� ���̵�
--��:


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
-- �ܷ�Ű�� �����Ѵ�.
-- TEAM �ΰ��� ����϶�.
--��:


INSERT INTO TB_TEAM(T_ID, T_LOC, T_NAME, T_DAY, T_PHONE, T_PAGE)
VALUES('1','����','NC���̳뽺','1990/03/01','02-2226-3333','GOOGLE.COM');

INSERT INTO TB_TEAM(T_ID, T_LOC, T_NAME, T_DAY, T_PHONE, T_PAGE)
VALUES('2','����','��ȭ�̱۽�',SYSDATE,'041-333-1234','NAVER.COM');

-- �ΰ��� TEAM�� ������ ���� 3�� ����϶�.
INSERT INTO TB_T_PLAYER
(P_ID, P_NAME, P_DAY, P_POS, P_HEIGHT, T_ID)
VALUES('1000','������','2002/02/02','����','177','1');

INSERT INTO TB_T_PLAYER
(P_ID, P_NAME, P_DAY, P_POS, P_HEIGHT, T_ID)
VALUES('1001','������','2004/04/04','Ÿ��','173','1');

INSERT INTO TB_T_PLAYER
(P_ID, P_NAME, P_DAY, P_POS, P_HEIGHT, T_ID)
VALUES('1002','�ٴٴ�','2003/03/03','����','181','1');

INSERT INTO TB_T_PLAYER
(P_ID, P_NAME, P_DAY, P_POS, P_HEIGHT, T_ID)
VALUES('1003','����',SYSDATE,'����','177','2');

INSERT INTO TB_T_PLAYER
(P_ID, P_NAME, P_DAY, P_POS, P_HEIGHT, T_ID)
VALUES('1004','������','2005/05/06','Ÿ��','173','2');

INSERT INTO TB_T_PLAYER
(P_ID, P_NAME, P_DAY, P_POS, P_HEIGHT, T_ID)
VALUES('1005','�ٹٹ�','2004/04/04','Ÿ��','181','2');

--------------------------------------------------------------------
-- TABLE�� �ۼ��϶�. 
DROP TABLE Z_GOOD CASCADE CONSTRAINTS;
DROP TABLE Z_USER CASCADE CONSTRAINTS;
DROP TABLE Z_CART CASCADE CONSTRAINTS;
-- PRODUCT(��ǰ) : ��ǰ��ȣ, ��ǰ��, ��ǰ����, ��ǰ���� 
--��:


CREATE TABLE Z_GOOD(
    GOOD_NUM  VARCHAR2(20),
    GOOD_NAME VARCHAR2(20),
    GOOD_PRICE VARCHAR2(20),
    GOOD_ABOUT VARCHAR2(20),
    CONSTRAINT PK_Z_GO PRIMARY KEY(GOOD_NUM)
);
-- CONSUMER(�Һ���) : �Һ��� ID, �̸�, ���� 
--��:


CREATE TABLE Z_USER(
    U_ID  VARCHAR2(20),
    U_NAME VARCHAR2(20),
    U_AGE VARCHAR2(20),
    CONSTRAINT PK_Z_US PRIMARY KEY(U_ID)
);
-- CART(��ٱ���) : ��ٱ��� ��ȣ, �Һ��� ID, ��ǰ��ȣ, ����
--��:


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
-- �ܷ�Ű�� �����Ѵ�.
-- ��ǰ�� 5���� ��� �϶�.
--��:


INSERT INTO Z_GOOD(GOOD_NUM, GOOD_NAME, GOOD_PRICE, GOOD_ABOUT)
VALUES('1','����','10000','����');
INSERT INTO Z_GOOD(GOOD_NUM, GOOD_NAME, GOOD_PRICE, GOOD_ABOUT)
VALUES('2','����','5000','��');
INSERT INTO Z_GOOD(GOOD_NUM, GOOD_NAME, GOOD_PRICE, GOOD_ABOUT)
VALUES('3','�ٵ�','100000','��Ʈ');
INSERT INTO Z_GOOD(GOOD_NUM, GOOD_NAME, GOOD_PRICE, GOOD_ABOUT)
VALUES('4','���','1200','����');
INSERT INTO Z_GOOD(GOOD_NUM, GOOD_NAME, GOOD_PRICE, GOOD_ABOUT)
VALUES('5','����','1000','��ä');
-- �θ��� �Һ��ڸ� ����϶�. 
INSERT INTO Z_USER(U_ID, U_NAME, U_AGE)
VALUES('SKYSTYLE','ȫ�浿','48');
INSERT INTO Z_USER(U_ID, U_NAME, U_AGE)
VALUES('KDWSTYLE','������','20');
-- �Һ����� ��ٱ��Ͽ� ��ǰ �߰��϶�.
--��:


INSERT INTO Z_CART( C_NUM, U_ID, GOOD_NUM, C_QUAN)
VALUES('100','SKYSTYLE','3','2');

--------------------------------------------------------------------SQL7v2 -hr
-- EXERD (�𵨸��� �� �ִ� ��) -> �̹��� ����, �𵨸� ���� ���� cf)eXERD ER-WIN
CREATE TABLE Z_TEAM(
    TEAM_ID NUMBER(8) CONSTRAINT PK_TEAM_ID PRIMARY KEY,       --�����̵�
    REGION_NAME VARCHAR2(10),                                  --����
    TEAM_NAME VARCHAR2(50) NOT NULL,                           --����
    START_DATE DATE,                                           --������¥
    TEL VARCHAR2(20),                                          --��ȭ��ȣ
    HOMEPAGE VARCHAR2(20)                                      --Ȩ������
    );                                                             -- �� ���̺�
CREATE TABLE Z_PLAYER(
    PLAYER_ID NUMBER CONSTRAINT PK_PLAYER PRIMARY KEY,         --�������̵�
    PLAYER_NAME VARCHAR2(20),                                  --�����̸�
    JOIN_DATE DATE,                                            --�շ���¥
    POSITION VARCHAR2(20),                                     --������
    HEIGHT NUMBER(5, 1),                                       --Ű
    TEAM_ID NUMBER(8) -- ���Ⱑ �� ������ ���� �ȵ� cf)���ڰ� ©���ϲ� --�����̵�
    );                                                             -- ���� ���̺�
ALTER TABLE Z_PLAYER
ADD
CONSTRAINT FK_TEAM_ID FOREIGN KEY (TEAM_ID)
REFERENCES Z_TEAM(TEAM_ID);                                        -- �ܷ�Ű
--���Է�                   --50byte�� ��°� ����
INSERT INTO Z_TEAM(TEAM_ID, REGION_NAME, TEAM_NAME, START_DATE, TEL, HOMEPAGE)
VALUES(100, '����', 'Ʈ����', '02/10/23', '02-123-4567', 'http://www.twins.com');
INSERT INTO Z_TEAM(TEAM_ID, REGION_NAME, TEAM_NAME, START_DATE, TEL, HOMEPAGE)
VALUES(101, '����', 'Ÿ�̰���', '92/06/13', '034-112-537', 'http://www.tiger.com');
--�����Է�
INSERT INTO Z_PLAYER(PLAYER_ID, PLAYER_NAME, JOIN_DATE, POSITION, HEIGHT, TEAM_ID)
VALUES(1, 'ȫ�浿', SYSDATE, '����', 172.1, 100);
INSERT INTO Z_PLAYER(PLAYER_ID, PLAYER_NAME, JOIN_DATE, POSITION, HEIGHT, TEAM_ID)
VALUES(2, '������', SYSDATE, '2���', 179.2, 100);
INSERT INTO Z_PLAYER(PLAYER_ID, PLAYER_NAME, JOIN_DATE, POSITION, HEIGHT, TEAM_ID)
VALUES(3, '������', SYSDATE, '���ͼ�', 181.2, 101);
INSERT INTO Z_PLAYER(PLAYER_ID, PLAYER_NAME, JOIN_DATE, POSITION, HEIGHT, TEAM_ID)
VALUES(4, '������', SYSDATE, '����Ÿ��', 165.3, 101);
INSERT INTO Z_PLAYER(PLAYER_ID, PLAYER_NAME, JOIN_DATE, POSITION, HEIGHT, TEAM_ID)
VALUES(5, '�Ӳ���', SYSDATE, '���ݼ�', 182.7, NULL);
--Ȯ��
SELECT * FROM Z_TEAM;
SELECT * FROM Z_PLAYER;
--����
SELECT t.team_id, p.player_name, t.team_name
FROM z_team t, z_player p
WHERE t.team_id = p.team_id
    AND p.player_name = '������';

---------------------------------------------------------------------

CREATE TABLE Y_PRODUCT(
    PRODUCT_ID NUMBER CONSTRAINT PK_PRODUCT PRIMARY KEY,         --��ǰ��ȣ
    NAME VARCHAR2 (50),                                          --��ǰ��
    PRICE NUMBER,                                                --��ǰ����
    PRODUCT_DESC VARCHAR2(500)                                   --��ǰ����
);
CREATE TABLE Y_CONSUMER(
    USER_ID VARCHAR2(50) CONSTRAINT PK_USER PRIMARY KEY,         --ȸ�����̵�
    NAME VARCHAR2 (50) NOT NULL,                                 --ȸ���̸�
    AGE NUMBER                                                   --ȸ������
);
CREATE TABLE Y_CART(
    CART_ID NUMBER CONSTRAINT PK_CART PRIMARY KEY,               --īƮ���̵�
    USER_ID VARCHAR2(50),                      --FK 1            --ȸ�����̵�     
    PRODUCT_ID NUMBER,                         --FK 2            --��ǰ��ȣ      
    AMOUNT NUMBER                                                --����
);
--�ܷ�Ű1
ALTER TABLE Y_CART
ADD
CONSTRAINT FK_USER_ID FOREIGN KEY(USER_ID)
REFERENCES Y_CONSUMER(USER_ID);
--�ܷ�Ű2
ALTER TABLE Y_CART
ADD
CONSTRAINT FK_PRODUCT_ID FOREIGN KEY(PRODUCT_ID)
REFERENCES Y_PRODUCT(PRODUCT_ID);
--��ǰ���
INSERT INTO Y_PRODUCT(PRODUCT_ID, NAME, PRICE, PRODUCT_DESC)
VALUES(101, '�����', 1500, '��������� ���찡 �����ϴ�.');
INSERT INTO Y_PRODUCT(PRODUCT_ID, NAME, PRICE, PRODUCT_DESC)
VALUES(102, '��������Ĩ', 2300, '���ڷ� ����ϴ�.');
--�Һ��ڵ��
INSERT INTO Y_CONSUMER(USER_ID, NAME, AGE)
VALUES('HGD','ȫ�浿',24);
INSERT INTO Y_CONSUMER(USER_ID, NAME, AGE)
VALUES('IJM','������',22);
--īƮ���
INSERT INTO Y_CART(CART_ID, USER_ID, PRODUCT_ID, AMOUNT)
VALUES(1, 'HGD', 102, 2);

SELECT * FROM Y_CART;

------����
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