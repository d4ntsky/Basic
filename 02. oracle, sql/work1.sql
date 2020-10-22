--------------------------------------------------------------------SQL1 -hr
--����1) EMPLOYEES Table�� ��� �ڷḦ ����Ͽ���.
SELECT * FROM employees;

--����2) EMPLOYEES Table�� �÷����� ��� ����϶�.
DESC employees;

--����3) EMPLOYEES Table���� ��� ��ȣ, �̸�, �޿�, �������� ����Ͽ���.
SELECT employee_id, first_name, salary, job_id
FROM employees;

--����4) ��� �������� �޿��� $300���� ��Ű�� ���ؼ� 
--      ���� �����ڸ� ����ϰ� ����� SALARY+300�� ���÷��� �մϴ�. 
SELECT first_name, salary, salary + 300
FROM employees;

--����5) EMP ���̺��� �����ȣ, �̸�, �޿�, ���ʽ�, ���ʽ� �ݾ��� ����Ͽ���. 
--     (����� ���ʽ��� ���� + (����*Ŀ�̼�)) 
SELECT 
employee_id, first_name, salary, 
salary*commission_pct,
salary+(salary*commission_pct)
FROM employees;

--NVL(�÷���, ���ϴ� ��)
--    �÷��� NULL�� �ƴϸ� Į���� ���� ���, null�̸� ���ϴ� ��
--cf)--5)
SELECT 
employee_id, first_name, salary, 
NVL(commission_pct, 0), nvl(salary + (salary * commission_pct) , 0)
FROM employees;

--����6) EMPLOYEES ���̺��� LAST_NAME�� �̸����� SALARY�� �޿��� ����Ͽ���. 
SELECT last_name AS "�̸�", salary as �޿�
FROM employees;

--����7) EMPLOYEES ���̺��� LAST_NAME�� Name����  
--      SALARY *12�� Annual Salary(����)�� ����Ͽ��� 
SELECT last_name AS Name, salary * 12 as "Annual Salary"
FROM employees;

--����9) EMPLOYEES ���̺��� �̸��� ������ �����Ͽ� ����Ͽ���.
SELECT last_name ||' '|| job_id as Employees
FROM employees;

--����10) EMPLOYEES ���̺��� �̸��� ������
--       ��KING is a PRESIDENT�� �������� ����Ͽ���.
SELECT '"' || last_name ||' is a '|| job_id || '"' 
as "Employees Detail"
FROM employees;

--����11) EMPLOYEES ���̺��� �̸��� ������  
--       ��KING: 1 Year salary = 60000�� �������� ����Ͽ���.
SELECT '"' || last_name ||': 1 Year Salary = '|| salary*12 || '"'
as "�̸��� ����"
FROM employees;

--����12) EMPLOYEES ���̺��� JOB�� ��� ����϶�. 
SELECT DISTINCT job_id
FROM employees; 

--------------------------------------------------------------------scott0
--1)emp ���̺��� �����ȣ, ����̸�, ������ ����϶�
SELECT empno, ename, sal 
FROM emp;

--2)emp ���̺��� ����̸��� ������ ����ϴµ� Į������ �� ��, �� ������ �ٲ㼭 ����϶�
SELECT ename AS "�� ��", sal AS "�� ��"
FROM emp;

--3)emp ���̺��� �����ȣ, ����̸�, ����, ������ ���ϰ� 
--���� Į������ �����ȣ, ����̸�, ����, �������� ����϶�
SELECT 
empno AS �����ȣ, ename AS "����̸�", sal AS ����, sal*12 as ����
FROM emp;

--4)emp ���̺��� ����(job)�� �ߺ� �����ʰ� ǥ���϶�
SELECT DISTINCT job 
FROM emp;

--5)emp ���̺��� ������ ������ ����(SMITH,CLERK)�ؼ� ǥ���ϰ�
--�÷����� Employee and Job���� ǥ���϶�
SELECT 
'('||ename||','||job||')' as "Employee and Job"
FROM emp;
