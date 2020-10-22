/*
SELECT �÷�, Sub Query, �Լ�(ǥ��, �׷�) 
FROM ���̺��, Sub Query
WHERE 
    ����, AND, OR, JOIN, IN, ANY, ALL, 
    NOT, BETWEEN, LIKE, IS NULL, Sub Query
                            cf)IS NULL O
                               =  NULL X 
GROUP BY �÷�, �÷�
HAVING ������(GROUP BY ��������)
ORDER BY (�����ϰ����) �÷� ASC, �÷� DESC        
;
*/
--------------------------------------------------------------------SQL3 -hr
--�⺻ �Լ� �ǽ� ����
--����1) EMPLOYEES ���̺��� King�� ������ �ҹ��ڷ� �˻��ϰ� 
--      �����ȣ, ����, ������(�ҹ��ڷ�),�μ���ȣ�� ����϶�
SELECT employee_id, last_name, LOWER(job_id), department_id
FROM employees
WHERE LOWER(last_name) = 'king';

SELECT employee_id, last_name, LOWER(job_id), department_id
FROM employees
WHERE last_name = 'King' 
ORDER BY employee_id ASC;

--����2) EMPLOYEES ���̺��� King�� ������ �빮�ڷ� �˻��ϰ� 
--      �����ȣ, ����, ������(�빮�ڷ�),�μ���ȣ�� ����϶�. 
SELECT employee_id, last_name, UPPER(job_id), department_id
FROM employees
WHERE last_name = 'King' 
ORDER BY employee_id ASC;

SELECT employee_id, last_name, UPPER(job_id), department_id
FROM employees
WHERE UPPER(last_name) = 'KING';

--����3) DEPARTMENTS ���̺��� �μ���ȣ�� �μ��̸�,
--      �μ��̸��� ��ġ��ȣ�� ���Ͽ� ����ϵ��� �϶�. 
SELECT department_id || ' ' || department_name,
        department_name || ' ' || location_id
FROM departments;

--CONCAT(CONNECTION-CATCH) ���� ���� + ||
SELECT department_id, location_id, 
CONCAT(department_id, department_name),
CONCAT(department_name, location_id)
FROM departments;

--����4) EMPLOYEES ���̺��� �̸��� ù ���ڰ� ��K�� ���� ũ�� ��Y������ ���� ����� ������
--      �����ȣ, �̸�, ����, �޿�, �μ���ȣ�� ����϶�. �� �̸������� �����Ͽ���
SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE SUBSTR(first_name, 1, 1) > 'K' 
  AND SUBSTR(first_name, 1, 1) < 'Y' -- �ڿ��� ���ڼ��� ����
    --cf) �ڹٿ��� "hello" -> substring(1,2) - ��°� e �ڿ��ź��� ����������
ORDER BY first_name asc;
--Ʋ����
SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE first_name > 'K%' AND first_name < 'Y%'
--WHERE LAST_NAME between 'K%' and 'Y%'
ORDER BY fisrt_name asc;

--����5) EMPLOYEES ���̺��� 20�� �μ� �� �̸��� ���� �� �޿��� �ڸ�����
--      �����ȣ, �̸�, �̸��� �ڸ���, �޿�, �޿��� �ڸ����� ����϶�. 
SELECT 
employee_id, first_name, 
LENGTH(first_name), salary, LENGTH(salary)
FROM employees
WHERE department_id = 20;
--cf) �߰� JOIN
SELECT 
employee_id, first_name, 
LENGTH(first_name), salary, LENGTH(salary), department_name
FROM employees e, departments d
WHERE d.department_id = 20
    AND e.department_id = d.department_id;
    
--����6) EMPLOYEES ���̺��� �̸� �� ��e������ ��ġ�� ����϶�.
SELECT first_name, 
INSTR(first_name, 'e', 1, 1),
INSTR(first_name, 'e', 1, 2),
INSTR(first_name, 'e', 1, 3),
INSTR(first_name, 'e', 1, 4)
FROM employees;
-- INSTR = indexOf

--����7) ������ ������ �����ϰ� ����� �м��϶�. 
SELECT 
ROUND(4567.678), 
ROUND(4567.678, 0), -- ���� ����ϴ� ����
ROUND(4567.678, 2), -- ���� ����ϴ� ���� 
ROUND(4567.678,-2)
FROM dual;
--�ݿø� (�ݿø��� ����, �ݿø��� �ڸ���)

--����8) EMPLOYEES ���̺��� �μ���ȣ�� 80�� ����� �޿��� 
--      30���� ���� �������� ���Ͽ� ����϶�. 
SELECT first_name, salary, MOD(salary, 30), department_id
FROM employees
WHERE department_id = 80;
-- ���� ���� MOD ���� ��

--����9) EMPLOYEES ���̺��� 30�� �μ� �� �̸��� ��� ������ �����Ͽ� ����Ͽ���. 
--      �� ��� ������ �� �� �Ʒ��� ����϶�. 
--      ���̱⿣ ����ó�� �������� �׸��带 ���� Ŭ���ϸ� ����Ǿ��ٴ� ���� Ȯ���� �� �ִ�
SELECT 
first_name || CHR(10) || job_id
FROM employees
WHERE department_id = 30 ;
--CHR(10) = \n

--10)  EMPLOYEES ���̺��� ������� �ٹ��� ���� ���� ���� �ΰ��� ����Ͽ���. 
--     �� �ٹ� �ϼ��� ���� ��� ������ ����Ͽ���.          ���� ���Ǵ� ����!!!
SELECT first_name, hire_date,
    to_date('20/06/22') - hire_date AS "�� �ٹ� �ϼ�",                    -- �Ի��� �Ŀ� �� �ϰ� �ٹ� �ߴ���?
    TRUNC( (to_date('20/06/22') - hire_date) / 7)  AS "�� �ٹ� ���ϼ�",   -- �Ի��� �Ŀ� �� �ְ� �ٹ� �ߴ���?
    MOD( (to_date('20/06/22') - hire_date), 7) AS "���� �ϼ�" 
FROM employees
ORDER BY "�� �ٹ� �ϼ�" DESC;
--�� ���� ��... ������ ��
SELECT last_name, hire_date, sysdate, 
ROUND(sysdate - hire_date) as "Total Days"
FROM employees
ORDER BY "Total Days" DESC;

--����11) EMPLOYEES ���̺��� �μ� 50���� �޿� �տ� $�� �����ϰ� 3�ڸ� ���� ,�� ����϶� 
--�Ѿ ��
SELECT department_id, last_name, job_id, salary,
TO_CHAR(salary, '$999,999,999,999')
FROM employees
WHERE department_id = 50 
ORDER BY salary DESC;

--����12) ������ ����� �м��Ͽ� ���ƶ�.
SELECT EMPLOYEE_ID,LAST_NAME,JOB_ID,SALARY,
DECODE(JOB_ID,
    'IT_PROC',  SALARY*1.1, 
    'ST_MAN',   SALARY*1.15,
    'SA_MAN',   SALARY*1.2, SALARY) d_sal -- alias
FROM employees
WHERE job_id IN('IT_PROC', 'ST_MAN', 'SA_MAN')
ORDER BY SALARY DESC; 
-- �� ����� ���� ���ؼ�

--�׷� �Լ� �ǽ� ����
--����1) EMPLOYEES ���̺��� ��� SALESMAN(SA_MAN)�� ���Ͽ� 
--      �޿��� ���, �ְ��, ������, �հ踦 ���Ͽ� ����Ͽ���.
SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
WHERE job_id LIKE 'SA_%';

--??
SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
WHERE job_id = 'SA_MAN';

--����2) EMPLOYEES ���̺� ��ϵǾ� �ִ� �ο���, ���ʽ��� NULL�� �ƴ� 
--      �ο���, ���ʽ��� ���, ��ϵǾ� �ִ� �μ��� ���� ���Ͽ� ����϶�. 
SELECT 
COUNT(*) AS �ο�, COUNT(employee_id), 
TRUNC(AVG(commission_pct * salary)), 
COUNT(DISTINCT department_id),
COUNT(DISTINCT job_id)
FROM employees;
--��
SELECT 
COUNT(*) AS �ο�,
COUNT(commission_pct) AS "���ʽ� �ִ� ��� ��", 
AVG(commission_pct) AS "���ʽ����",
COUNT(DISTINCT department_id)
FROM employees;

--����3) EMPLOYEES ���̺��� �μ����� 
--      �ο���, ��� �޿�, �����޿�, �ְ� �޿�, �޿��� ���� ���Ͽ� ����϶�. 
-- ex) �μ�����, �������� - ~���� �� ��� group by
SELECT department_id, --GROUP BY�� ������ �� ���ΰ� ������ �� �ְ�,,
COUNT(*) AS �ο�, 
TRUNC(AVG(salary)), MIN(salary), MAX(salary), SUM(salary)
FROM employees
GROUP BY department_id 
ORDER BY department_id ASC;

--����4) EMPLOYEES ���̺��� �� �μ����� 
--      �ο���,�޿��� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���Ͽ� 
--      �޿��� ���� ���� ������ ����Ͽ���. 
SELECT department_id, COUNT(*) AS �ο�, 
ROUND(AVG(salary), 1), MIN(salary), MAX(salary), 
SUM(salary) AS "�޿��� ��"
FROM employees
GROUP BY department_id
ORDER BY SUM(salary) DESC;

--����5) EMPLOYEES ���̺��� �μ���, ������ �׷��Ͽ� ����� 
--       �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���Ͽ� ����Ͽ���.
SELECT department_id, job_id, 
COUNT(*), TRUNC(AVG(salary)), SUM(salary)
FROM employees
GROUP BY department_id, job_id;

--����6) EMPLOYEES ���̺��� �μ� �ο��� 4���� ���� �μ��� 
--      �μ���ȣ, �ο���, �޿��� ���� ���Ͽ� ����Ͽ���.(GROUP BY, HAVING)
SELECT department_id, COUNT(*), SUM(salary)
FROM employees
GROUP BY department_id
HAVING COUNT(*) > 4;

--����7) EMPLOYEES ���̺��� �޿��� �ִ� 10000�̻��� �μ��� ���ؼ� 
--      �μ���ȣ, ��� �޿�, �޿��� ���� ���Ͽ� ����Ͽ���.
SELECT department_id, ROUND(AVG(salary)), SUM(salary), MAX(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary) >= 10000;

--����8) EMPLOYEES ���̺��� ������ �޿��� ����� 10000 �̻��� ������ ���ؼ� 
--      ������, ��� �޿�, �޿��� ���� ���Ͽ� ����϶�. 
SELECT job_id, AVG(salary), SUM(salary)
FROM employees
GROUP BY job_id
HAVING AVG(salary) >= 10000;

--����9) EMPLOYEES ���̺��� ��ü ������ 10000�� �ʰ��ϴ� �� ������ ���ؼ� 
--      ������ ���޿� �հ踦 ����϶�. 
--      �� �Ǹſ��� �����ϰ� �� �޿� �հ�� ����(��������)�϶�.(SA_) 
SELECT job_id, SUM(salary) AS PAYROLL
FROM employees
WHERE job_id NOT LIKE 'SA_%'
GROUP BY job_id
HAVING SUM(salary) > 10000 
ORDER BY PAYROLL DESC;


--------------------------------------------------------------------scott2
--19) emp ���̺��� �����ȣ, ����̸�, �Ի����� ����ϴµ� 
--�Ի����� ���� ��������� �����Ͻÿ�.
SELECT empno, ename, hiredate
FROM emp
ORDER BY hiredate ASC;

--20) emp ���̺��� ����̸�, �޿�, ������ ���ϰ�
--������ ���� ������ �����Ͻÿ�.
SELECT ename, sal, sal * 12 
FROM emp
ORDER BY sal * 12 DESC;

--21)10�� �μ��� 20���μ����� �ٹ��ϰ� �ִ� 
--����� �̸��� �μ���ȣ�� ����ϴµ� 
--�̸��� �����ڼ����� ǥ���Ͻÿ�.
SELECT ename, deptno
FROM emp
WHERE deptno in(10,20)
--==WHERE deptno = 10 OR deptno = 20;
ORDER BY ename ASC;

--22) Ŀ�̼��� �޴� ��� ����� 
--�̸�,�޿� �� Ŀ�̼��� Ŀ�̼��� �������� 
--������������ �����Ͽ� ǥ���Ͻʽÿ�.
SELECT ename, sal, comm
FROM emp
WHERE comm IS NOT NULL AND comm <> 0
ORDER BY comm DESC;

--23) emp���̺��� ����(job)�� ù���ڴ� �빮�� �������� �ҹ��ڷ� ����Ͻÿ�.
--????????? Ȯ��
SELECT SUBSTR(job, 1, 1)|| LOWER(SUBSTR(job, 2))
FROM emp;
--
SELECT job, INITCAP(job)
FROM emp;

--24) emp���̺��� ����̸� �� A�� ���Ե� ����̸��� ���ϰ�
--�� �̸� �� �տ��� 3�ڸ� �����Ͽ� ���
SELECT ename, SUBSTR(ename, 1, 3)
FROM emp
WHERE ename LIKE '%A%';


--25) �̸��� ����° ���ڰ� A�� ��� ����� �̸��� ǥ���Ͻÿ�.
SELECT ename
FROM emp
WHERE SUBSTR(ename, 3, 1) = 'A';

--26) �̸��� J,A �Ǵ� M���� �����ϴ� ��� ����� �̸�
--ù ���ڴ� �빮�ڷ�, ������ ���ڴ� �ҹ��ڷ� ǥ���ϰ� �̸��� ���̸� ǥ���Ͻÿ�.
--�� ���̺��� name�� length�� ǥ��
SELECT 
UPPER(SUBSTR(ename, 1, 1)) || LOWER(SUBSTR(ename, 2)) AS name,
LENGTH(ename) AS length
FROM emp
WHERE (ename LIKE 'J%') OR (ename LIKE 'A%') OR (ename LIKE 'M%');

SELECT INITCAP(ename), LENGTH(ename)
FROM emp
WHERE ename LIKE 'J%' OR ename LIKE 'A%' OR SUBSTR(ename, 1, 1) = 'M';

--27) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �ҹ��ڷ� �̸��� ����Ͻÿ�
SELECT ename, LOWER(ename)
FROM emp
WHERE LENGTH(ename) >= 6;

--28) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� 
--�տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� ����Ͻÿ�.
SELECT ename, LOWER(SUBSTR(ename, 1, 3))
FROM emp
WHERE LENGTH(ename) >= 6;

SELECT ename, LOWER(SUBSTR(ename, 1, 3))
FROM emp
WHERE LENGTH(ename) >= 6;


--29) ��� ����� �̸��� �޿��� ǥ���Ͻÿ�.
--�޿��� 15�� ���̷� ���ʿ� $��ȣ�� ä���� ��������
--ǥ���ϰ� �����̺��� SALARY�� �����Ͻÿ�.
SELECT ename, sal, LPAD(sal, 15, '$')
FROM emp;

SELECT ename, TO_CHAR(sal, '$999,999,999,999') AS "SALARY"
FROM emp;

--30) ���ú��� �̹����� �������������� ���� �� ���� ���Ͻÿ�.
SELECT LAST_DAY(SYSDATE) - SYSDATE
FROM dual;
--��
SELECT SYSDATE, LAST_DAY(TO_DATE(SYSDATE)),
        CEIL(LAST_DAY(TO_DATE(SYSDATE)) - SYSDATE)
FROM dual;

--31) emp���̺��� �� ����� ���� 
--�����ȣ, �̸�, �޿� �� 15% �λ�� �޿��� ����(�ݿø�)�� ǥ���Ͻÿ�.
--�λ�� �޿����� ���̺��� New Salary�� �����Ͻÿ�.
SELECT empno, ename, sal, ROUND(sal*1.15) AS "New Salary"
FROM emp;

--32) emp���̺��� ������ 4�� ���(mod(sal,4)=0)�� 
--����� �̸��� ������ ����Ͻÿ�.(���ڸ� ���� ��ǥ ǥ��)
SELECT ename, TO_CHAR(sal, '99,999') AS "SAL"
FROM emp
WHERE MOD(sal,4) = 0;

--------------------------------------------------------------------scott3
--33) �� ����� �̸��� ǥ���ϰ� �ٹ� �� ��(�Ի��Ϸκ��� ��������� �޼�)�� ����Ͽ�
--�� ���̺��� MONTHS_WORKED�� �����Ͻÿ�. 
--����� ������ �ݿø��Ͽ� ǥ���ϰ� �ٹ��� ����
--�������� ������������ �����Ͻÿ�.
SELECT ename, hiredate, ROUND(MONTHS_BETWEEN(SYSDATE, hiredate)) AS "MONTHS_WORKED"
FROM emp
ORDER BY 'MONTHS_WORKED' ASC;

--34)emp���̺��� �̸�, ����, �ٹ������� ����Ͻÿ�.
SELECT ename, job, ROUND(MONTHS_BETWEEN(SYSDATE, hiredate)/12) AS "�ٹ�����"
FROM emp;

--35)emp���̺��� ����̸�, ����, ���ް� Ŀ�̼��� ���� ���� �÷��� �Ǳ޿���� �ؼ� ���.
--��, NULL���� ��Ÿ���� �ʰ� �ۼ��Ͻÿ�.
SELECT ename, sal, comm, sal + NVL(comm,0) AS �Ǳ޿�
FROM emp;

SELECT ename, sal, sal + comm AS �Ǳ޿�
FROM emp
WHERE comm IS NOT NULL AND comm != 0;

--36)���ް� Ŀ�̼��� ��ģ �ݾ��� 2,000�̻��� �޿��� �޴� ����� �̸�,����,����,Ŀ�̼�,��볯¥
--�� ����Ͻÿ�. ��, ��볯¥�� 1980-12-17 ���·� ����Ͻÿ�.
SELECT ename, job, sal, comm, hiredate, to_char(hiredate, 'YYYY-MM-DD') 
FROM emp
WHERE sal + comm >= 2000;

--38)��� ����� �޿��� �ְ��, ������, �Ѿ� �� ��վ��� ǥ���Ͻÿ�. �� ���̺��� ����
--   maximum,minimum,sum �� average�� �����ϰ� ����� ������ �ݿø��ϰ� ���ڸ� ������
--   ,�� ����Ͻÿ�.
SELECT  
to_char( MAX(sal), '999,999') as maximum,
to_char( MIN(sal), '999,999') as minimum,
to_char( SUM(sal), '999,999') as sum,
to_char( round( AVG(sal)), '999,999') as average
FROM emp;
--�ٽ� Ȯ��

--39) ������ ������ ��� ���� ǥ���ϴ� ���Ǹ� �ۼ��Ͻÿ�.
SELECT job, COUNT(*) 
FROM emp
GROUP BY job;

--40) emp���̺��� 30���μ��� ������� ���Ͻÿ�.
SELECT COUNT(*)
FROM emp
WHERE deptno = 30;

--41) emp���̺��� ������ �ְ� ������ ���ϰ� ����,�ְ� ������ ����Ͻÿ�.
SELECT job, MAX(sal)
FROM emp
GROUP BY job;

--42) emp���̺��� 20���μ��� �޿� �հ踦 ���ϰ� �޿� �հ� �ݾ��� ����Ͻÿ�.
SELECT SUM(sal)
FROM emp
WHERE deptno = 20;

--43) emp���̺��� �μ����� ���޵Ǵ� �ѿ��޿��� �ݾ��� 7,000�̻��� �μ���ȣ, �ѿ�����
--    ����Ͻÿ�.
SELECT deptno, SUM(sal)
FROM emp
GROUP BY deptno
HAVING SUM(SAL) >= 7000;

--????????????????????????????
--44) emp���̺��� �������� ����� ���� ���� ����� ���ϰ� �� ��� ������ ����� 79�� �����ϴ�
--    ����� �����ֽÿ�.
SELECT job, MAX(empno)
FROM emp
GROUP BY job
HAVING MAX(empno) LIKE '79%' ;

--45) emp���̺��� ������ �ѿ����� ����ϴµ� ������ 'MANAGER'�� ������� �����ϰ� 
--    �ѿ����� 5,000���� ū ������ �ѿ��޸� ����Ͻÿ�.
SELECT job, SUM(sal)
FROM emp
WHERE job != 'MANAGER'
GROUP BY job
HAVING  SUM(sal) > 5000;
--
SELECT job, SUM(sal)
FROM emp
GROUP BY job
HAVING (job <> 'MANAGER') AND (SUM(sal) > 5000);

--46)emp���̺��� �������� ������� 4�� �̻��� ������ �ο����� ����Ͻÿ�.
SELECT job, COUNT(*)
FROM emp
GROUP BY job
HAVING COUNT(*) >= 4;

--47)emp���̺��� ������� 5���� �Ѵ� �μ��� �μ���ȣ�� ������� ���Ͻÿ�.
SELECT deptno, COUNT(*)
FROM emp
GROUP BY deptno
HAVING COUNT(*) > 5;

--48)emp���̺��� �μ��� �޿������ ���� �� �Ҽ��� 3�ڸ����� �ݿø��ؼ� 2�ڸ�����
--   ���ϰ� �μ���ȣ, �޿������ ����Ͻÿ�.
SELECT deptno, ROUND(AVG(sal),2) 
FROM emp
GROUP BY deptno; 