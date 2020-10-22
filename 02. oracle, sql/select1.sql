-- DML 
-- INSERT/DELETE/SELECT(90%)/UPDATE
/*  Query
    Database : ������ ������ ���� -> Server�� ���������
               File -> ArrayList
               ex) ȫ�浿-24-181.2
               
    SELECT 
        (��, COLUMN(�׸�), �Լ�, SUB QUERY(������ ���� ����))
    FROM
        (TABLE��, SUB QUERY)
    cf)�˰����� �˱⺸��... ����� ������ ��
*/
SELECT 1 
FROM DUAL;         -- DUAL�� �������̺� - ���� Ȯ���غ� �� �ִ� ���̺�

SELECT * FROM EMP; -- * ��� �÷�

 -- ���� ������ ���̺��� ��� ��
SELECT * FROM TAB;

 -- ���̺��� ���ϴ� �÷��� ������ ��    -- scott ������ ���ε�
SELECT empno, ename, sal, hiredate
FROM emp;                 

SELECT empno, ename, sal, sal + 300 -- ����� �Բ� �����ϴ�
FROM emp;                   -- 300 �� �� ����

SELECT empno, ename, sal, sal * 12
FROM emp;                   -- ����

 -- alias   java���� int alias[] = array; alias[0] = 11;
SELECT empno AS �����ȣ, sal AS "����", sal * 12 ���� 
FROM emp;                           --AS��������/""�� ���°� ���⶧
            --������ Ȯ�� 1 7369 800 9600 2 7499 1600 19200

 -- ���� ������ ||   ������� ������ ?�Դϴ�
SELECT ename || '�� ������ ' || sal || '�Դϴ�' AS "�̸��� ����"
FROM emp;   --�ϳ��� �÷�����? ǥ���Ҷ��� ''

 -- distinct : �ߺ����� ���� -- group by
SELECT DISTINCT job 
FROM emp;   --������ ���� ������

 -- DESC : TABLE�� COLUMN���� �� / ���־������� �ƴ�
DESC emp;
desc dept;  --���̺� �տ� DESC / SORTING�� �� ����