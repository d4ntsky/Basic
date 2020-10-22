-- ORDER BY : SORTING
/*
    SELECT *
    FROM TABLE��
    ORDER BY sal ASC        -- ��������  cf)ASC�� �������� �׷��� ���
    ORDER BY sal DESC       -- ��������  cf)�׳� DESC �÷� ��
cf)scott  emp
   hr     employees
*/
SELECT ename, sal -- cf)��ҹ��ڷ� ����
FROM emp 
ORDER BY sal ASC;

SELECT ename, sal
FROM emp
ORDER BY sal DESC;

-- alias �� sorting
SELECT empno, ename, sal * 12 AS annsal
FROM emp
ORDER BY annsal DESC;

SELECT ename, comm
FROM emp
ORDER BY comm NULLS FIRST; -- null���� ������ �ϰ������
             --�������� NULLS �տ� DESC NULLS FIRST

SELECT ename, comm
FROM emp
ORDER BY comm NULLS LAST;

SELECT employee_id, job_id, salary
FROM employees
ORDER BY job_id ASC, salary DESC;   -- �������� sorting ���� ���ʰͺ���

--------------------------------------------------------------------

-- MONTHS_BETWEEN   : �� ��¥ ���� �� �� (�� ����)
SELECT MONTHS_BETWEEN('2020-12-13','2020-05-04') -- ���� ������
FROM dual;

-- ADD_MONTHS       : Ư����¥ ���� ������ ���� �� �ش糯¥ ��ȯ
SELECT ADD_MONTHS('2020-06-19', 3)
FROM dual;

-- ��¥�������� Ư���� ��, ��, ��, ��, ��, �� (SYSDATE)
SELECT sysdate
FROM dual;

-- ��,��,�� /(��ū) �߶� ��������
SELECT EXTRACT(year FROM TO_DATE('19900619', 'YYMMDD')) AS ��,
        EXTRACT(month FROM TO_DATE('200319', 'YYMMDD')) AS ��,
         EXTRACT(day FROM TO_DATE('200601', 'YYMMDD')) AS ��1,
          EXTRACT(day FROM SYSDATE) AS ��2
FROM dual;
-- ��,��,��
SELECT 
EXTRACT(hour FROM CAST(TO_DATE(SYSDATE, 'YYYY-MM-DD HH:MI:SS')AS TIMESTAMP)) AS ��1,
EXTRACT(hour FROM SYSTIMESTAMP) AS ��2,
EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP)) AS ��3,   
EXTRACT(minute FROM CAST(SYSDATE AS TIMESTAMP)) AS ��,
EXTRACT(second FROM CAST(SYSDATE AS TIMESTAMP)) AS ��
FROM dual;

SELECT
EXTRACT(hour FROM CAST(datetime AS TIMESTAMP)) AS ��,   
EXTRACT(minute FROM CAST(datetime AS TIMESTAMP)) AS ��,
EXTRACT(second FROM CAST(datetime AS TIMESTAMP)) AS ��
FROM (SELECT 
        TO_DATE('2020-06-19 13:33:03', 'YYYY-MM-DD HH24:MI:SS')
        AS datetime FROM dual);                 --ex) ��Ż���Ʈ/����
        
--------------------------------------------------------------------

-- �׷����� ���� ���
-- DISTINCT ex)
--1)
SELECT DISTINCT department_id
FROM employees
ORDER BY department_id ASC;

-- GROUP BY  ���� ���̾���/DISTINCT���� �� ����
-- HAVING : ������ job_id,department_id cf)having�� group by�� �Բ�
--==1)
SELECT department_id
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;
-- ���������δ� ��������
/* ������,��¾ȵ� employee_id ������
SELECT department_id, employee_id 
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;*/

-- ���
-- GROUP�Լ�/COUNT/SUM/AVG/MAX/MIN
-- ex)�� �μ��� ���� �հ�   
SELECT 
COUNT(salary), COUNT(*),
SUM(salary), 
AVG(salary),
MAX(salary),
MIN(salary)
FROM employees
WHERE job_id = 'IT_PROG'; 

SELECT job_id,
COUNT(salary), COUNT(*),
SUM(salary), 
AVG(salary),
MAX(salary),
MIN(salary)
FROM employees
GROUP BY job_id;

-- HAVING - �ݵ�� GROUP BY�� ���� ���. �ܵ� ��� �Ұ�
SELECT job_id, SUM(salary)
FROM employees
GROUP BY job_id
HAVING SUM(salary) >= 100000;

-- ����) 
-- �޿��� 5000 �̻� �޴� ��������� �հ踦 ���� 
-- ����(job_id)�� �׷�ȭ�Ͽ� �޿��� �հ谡 20000�� �ʰ��ϴ� �������� ���϶�.
SELECT job_id, SUM(salary)
FROM employees
WHERE salary >= 5000
GROUP BY job_id  -- GROUP BY ������ SELECT�� ������(�����׷��̳� �׷��Լ���)
HAVING SUM(salary) > 20000;