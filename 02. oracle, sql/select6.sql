--  Ư�� Query

-- CASE = SWITCH
SELECT employee_id, first_name, phone_number,
    CASE SUBSTR(phone_number, 1, 3)
        WHEN '515' THEN '����'
        WHEN '590' THEN '�λ�'
        WHEN '659' THEN '����'
        WHEN '603' THEN '����'
        ELSE '��Ÿ'
    END AS "����"
FROM employees;
--==
SELECT employee_id, first_name, phone_number,
    CASE  
        WHEN SUBSTR(phone_number, 1, 3) = '515' THEN '����'
        WHEN SUBSTR(phone_number, 1, 3) = '590' THEN '�λ�'
        WHEN SUBSTR(phone_number, 1, 3) = '659' THEN '����'
        WHEN SUBSTR(phone_number, 1, 3) = '603' THEN '����'
        ELSE '��Ÿ'
    END AS "����"
FROM employees;

-- DECODE
SELECT employee_id, first_name, phone_number,
    DECODE( SUBSTR(phone_number, 1, 3),
            '515','����',
            '590','�λ�',
            '659','����',
            '603','����',
            '��Ÿ') AS "����"
FROM employees;

/*  ����
    ������ : UNION
    ������ : INTERSECT
    ������ : MINUS         */

-- UNION
SELECT job_id
FROM employees
WHERE job_id IN ('AD_VP', 'FI_ACCOUNT')
UNION ALL -- ALL ������?
SELECT job_id
FROM jobs
WHERE job_id IN ('AD_VP', 'FI_ACCOUNT');

-- INTERSECT
SELECT employee_id
FROM employees
INTERSECT
SELECT manager_id
FROM employees;
--�񽺹�����...
--JOIN self
SELECT DISTINCT b.employee_id
FROM employees a, employees b
WHERE a.manager_id = b.employee_id;

-- MINUS
--�Ŵ����� �ƴ� ���
SELECT employee_id
FROM employees
MINUS
SELECT manager_id
FROM employees;
--�������� JOIN����
SELECT e.first_name,
        e.department_id, d.department_id
FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
    AND e.department_id IS NULL;
    
/* OVER() �Լ�                �� ����
 SELECT �������� ���!!
 GROUP BY�� ����/�����ϱ� ���ؼ� ���� �Լ�  */
/*
SELECT department_id, COUNT(*)
FROM employees;                   */         --������
--1)
SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id;
--2)
SELECT department_id, COUNT(*)OVER()
FROM employees; 
--3)
SELECT department_id, COUNT(department_id) OVER()
FROM employees; 
--4)
SELECT department_id, COUNT(DISTINCT department_id) OVER()
FROM employees; 
--5)
-- PARTITION BY == GROUP BY         ����
SELECT department_name,
    COUNT(*)OVER(PARTITION BY department_id)
FROM departments;
--6)
SELECT department_id, first_name, salary,
    COUNT(*)OVER(PARTITION BY department_id)
FROM employees;

-- COUNT(*)OVER()                 : ��ü ����� ��ȯ
-- COUNT(*)OVER(PARTITION BY �÷�) : �÷��� �׷����� ���� ROW�� ���� ��ȯ       --�޷��� ���� ���������� ���  
    
-- �м� �Լ� - Ȱ�뵵 ����
/*  ���� �Լ�
    RANK()              1 2 3 3 5 6
    DENSE_RANK()        1 2 3 3 4 5
    ROW_NUMBER()        1 2 3 4 5 6
    ROWNUM                  cf) �Լ��� �ƴϴ�
    
    -- EMPLOYEES -> ���� TOP10
*/
--cf)
SELECT employee_id, first_name
FROM employees
WHERE employee_id >= 100 and employee_id <= 109;

SELECT first_name, salary,
    RANK      ()OVER(ORDER BY salary DESC) AS RANK,         -- 
    DENSE_RANK()OVER(ORDER BY salary DESC) AS DENSE_RANK,   -- 
    ROW_NUMBER()OVER(ORDER BY salary DESC) AS ROW_NUMBER    --
FROM employees;

-- ROWNUM �ܼ� ���
SELECT ROWNUM, employee_id, first_name
FROM employees
WHERE ROWNUM <= 10; -- �� �κ��� ���� ���� �����
--10���� ũ�� 20���� ���� ��
SELECT employee_id, first_name      --2
FROM employees
WHERE ROWNUM > 10 AND ROWNUM <= 20; --1 �̰� ���� �ȵ�
/*  1. DATA ����      ex)(�޿� ����) = ����
    2. ROWNUM ����
    3. ������ ����   */
SELECT RNUM, employee_id, first_name, salary                   -- 3
FROM(SELECT ROWNUM AS RNUM, employee_id, first_name, salary    -- 2
     FROM(SELECT employee_id, first_name, salary               -- 1 ���õ����� �����
          FROM employees
          ORDER BY salary DESC)
     )
WHERE RNUM > 0 AND RNUM <= 10;

/*  SELECT��
        SELECT       �÷�, ǥ���Լ�, �׷��Լ�, SUB QUERY, OVER(), PARTITION BY
        FROM         ���̺�, SUB QUERY
        [WHERE]      ���� IN AND ANY ALL LIKE < > <> <= >< != = SUB QUERY
        [GROUP BY]   �÷�         --���� �������� ���� ���
        [HAVING]     �׷����� ����
        [ORDER BY]   Į�� ASC/DESC
        [START BY]   ������
        [CONNECT BY] ������ PRIOR (����, ����)
    
    JOIN
        INNER,
        FULL OUTER
        CROSS
        OUTER (LEFT, RIGHT)
        SELF
*/