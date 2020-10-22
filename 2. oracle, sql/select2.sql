 -- WHERE�� == if == ������
/*
    ǥ����
    �� ������ (>,<,>=,<=,=,!=,<>) !=�� <> ���� �ǹ�
    NULL, IS NULL, IS NOT NULL
    ( ), NOT, AND(&&), OR(||)
    
    Query
    
    SELECT
    FROM
    WHERE ����
*/
-- first_name = 'Julia';
SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'Julia'; --��ҹ��� ��Ȯ�� ����
--WHERE first_name = 'julia';

-- �޿��� $9000 �̻��� ���
SELECT first_name, salary
FROM employees
WHERE salary >= 9000;

-- �̸��� Shanta ���� ū �̸� (Ascii�ڵ� ����)
SELECT first_name
FROM employees
WHERE first_name >= 'Shanta';

SELECT first_name
FROM employees
WHERE first_name >= 'a'; --ASCII�ڵ尪 97
--�빮�ڷ� �̸����� �Ǿ��ֱ� ������ ���� ����
--------------------------------------------------------------------
SELECT first_name, last_name
FROM employees
WHERE manager_id = ''; --���� �ʴ´�.
--------------------------------------------------------------------
SELECT first_name, last_name
FROM employees
WHERE manager_id IS NULL;       --��Ƽ�� ŷ�� ����

SELECT first_name, last_name
FROM employees
WHERE manager_id IS NOT NULL;   --��Ƽ�� ŷ�� ������ ��� �� ����
--------------------------------------------------------------------
-- AND
SELECT first_name, last_name
FROM employees
WHERE first_name = 'Shanta'
    AND last_name = 'Vollman';
    
-- OR
SELECT first_name, last_name
FROM employees
WHERE first_name = 'Shanta'
    OR first_name = 'John';
    
--�̸� John, ���� 5000 �̻�
SELECT first_name, salary
FROM employees
WHERE first_name = 'John'   --3��
    AND salary >= 5000;     --2��

--2007�� 12�� 31�� ���Ŀ� �Ի��� ����� ���
SELECT first_name, hire_date
FROM employees
WHERE hire_date > '07/12/31';                       -- �̰� ����

SELECT first_name, hire_date
FROM employees
WHERE hire_date > TO_DATE('20071231' , 'YYYYMMDD'); 
--------------------------------------------------------------------
-- ALL(AND), ANY(OR)   -- �� �Ⱦ��� ��
SELECT *
FROM employees
WHERE first_name = ALL('Julia', 'John'); --AND������ ����
    -- WHERE first_name = 'Shanta' AND first_name = 'John';
SELECT *
FROM employees
WHERE first_name = ANY('Julia', 'John'); 
    -- WHERE first_name = 'Shanta' OR first_name = 'John';
--cf)Ȱ���
SELECT first_name, salary
FROM employees
WHERE salary = ANY(8000, 3200, 6000);
--------------------------------------------------------------------
-- IN, NOT IN  �� ������ �����
SELECT first_name, salary
FROM employees
WHERE salary IN(8000, 3200);     -- �� �ݾ׸�

SELECT first_name, salary
FROM employees
WHERE salary NOT IN(8000, 3200); -- �� �ݾ��� ������

SELECT *
FROM employees
WHERE first_name IN('Julia', 'John'); -- �� �̸���
--------------------------------------------------------------------
-- BETWEEN ���� ������
SELECT first_name, salary
FROM employees
    WHERE salary BETWEEN 3200 AND 9000;
--==WHERE salary >= 3200 AND salary <= 9000; 

SELECT first_name, salary
FROM employees
    WHERE salary NOT BETWEEN 3200 AND 9000;
--==WHERE salary < 3200 OR salary > 9000;
--------------------------------------------------------------------
--LIKE �߿䵵 ������ ex)�Խ��� �˻��� ��
SELECT first_name
FROM employees
WHERE first_name LIKE 'G_ra_d'; -- _ �ѱ��ڰ� �����̵��� ���

SELECT first_name
FROM employees
WHERE first_name LIKE 'K%y';    -- % ���� ���� ������� ��� ���
--Ȱ���
SELECT first_name
FROM employees
WHERE first_name LIKE 'A%';     -- A�� ����
--WHERE first_name LIKE '%y';     -- �ǵڰ� y 
--WHERE first_name LIKE '%e%';    -- e��� ���� ����

SELECT first_name, hire_date
FROM employees
  WHERE hire_date > '05/12/31' AND hire_date < '06/02/01'; 
--==
SELECT first_name, hire_date
FROM employees
  WHERE hire_date LIKE '06/01%'; 
  
SELECT first_name, phone_number
FROM employees
  WHERE phone_number LIKE '590%';  
  