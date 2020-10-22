/*
    JOIN
    �� �� �̻��� ���̺��� �����ؼ� �����͸� �˻��ϴ� ����̴�.
    ���� �� �� �̻��� ��(row)���� ����� �� 
    Primary Key(�⺻ Ű),Foreign Key(�ܷ� Ű)���� ����ؼ� JOIN(����)�Ѵ�.
    
    Primary Key(�⺻ Ű): ���̺��� �ߺ����� �ʴ� Ű ex)ID,�ֹι�ȣ
    Foreign Key(�ܷ� Ű): �ٸ� ���̺��� PK,UK(Unique Key)�� ��찡 ����
    
    inner      JOIN : ������                  *****1
    full outer JOIN : ������
    cross      JOIN :
    outer - left/right outer JOIN              ***3
        left   JOIN :
        right  JOIN :
    self       JOIN : ���� ���̺��� �����͸� ���� *****2
*/
-- INNER JOIN (������)
 -- 1) Ansi SQL (�ٸ� ���� ���)
SELECT e.employee_id, e.first_name,       -- ���⼭ e. ��������
        e.department_id, d.department_id, -- �Ҽ��� ���� ��/������ �κ�                 
         d.department_name                -- �� ���� ���� JOIN
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id;
 -- 2) Oracle
SELECT employee_id, first_name,        -- e ���ʸ� �ֱ� ������ ����
        e.department_id, d.department_id, -- ȯ����                 
         department_name, location_id  -- d ���ʸ� �ֱ� ������ ����
FROM employees e, departments d
WHERE e.department_id = d.department_id    -- �������
    AND e.first_name = 'Adam';              -- �� Ȯ��
    
--------------------------------------------------------------------    
-- CROSS JOIN (�÷� �ϳ��ϳ��� �� ����) ��� �� ����
 -- 1) Ansi SQL 
SELECT e.employee_id, e.first_name,       
        e.department_id, d.department_id,                 
         d.department_name 
FROM employees e CROSS JOIN departments d;
 -- 2) Oracle
SELECT e.employee_id, e.first_name,       
         e.department_id, d.department_id,                 
          d.department_name 
FROM employees e, departments d;

--------------------------------------------------------------------

 -- FULL OUTER JOIN (������)
  -- Ansi SQL ��� �ۿ� ����  cf)oracle�� union?
SELECT e.employee_id, e.first_name,       
        e.department_id, d.department_id,                 
         d.department_name 
FROM employees e FULL OUTER JOIN departments d
    ON e.department_id = d.department_id;

--------------------------------------------------------------------

-- OUTER JOIN
 -- left, right
  -- 1) Ansi SQL
    -- 1 LEFT
SELECT e.employee_id, e.first_name,       
        e.department_id, d.department_id,                 
         d.department_name 
FROM employees e LEFT OUTER JOIN departments d
    ON e.department_id = d.department_id;
    -- 2 RIGHT
SELECT e.employee_id, e.first_name,       
        e.department_id, d.department_id,                 
         d.department_name 
FROM employees e Right OUTER JOIN departments d
    ON e.department_id = d.department_id;    
    
  -- 2) Oracle
    -- 1 LEFT
SELECT e.employee_id, e.first_name,       
        e.department_id, d.department_id,                 
         d.department_name 
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);     --(+)��ȣ ������ left outer
    -- 2 RIGHT
SELECT e.employee_id, e.first_name,       
        e.department_id, d.department_id,                 
         d.department_name 
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id;     --(+)��ȣ ���� right outer

--------------------------------------------------------------------

-- SELF JOIN : ������ ���̺��� JOIN
SELECT a.employee_id, a.first_name,  --a��� id, a����̸�
        a.manager_id, b.employee_id, --a����� ���, ����� �� ���� id
         b.first_name                --a����� ����̸� ã�ƺ� ��
FROM employees a, employees b   -- a : ���   b : ��� 
-- ���� ���̺������� �ٸ� ���̺�� ����
WHERE a.manager_id = b.employee_id; -- a����� ��� = ���� ���̺� ���

--------------------------------------------------------------------

-- ������ ���� ����, ���� (ORDER BY�� �ƴ� �����ؼ� Ȯ��)
--�����
SELECT a.employee_id, a.first_name AS "���",
        a.manager_id AS "����� ���", a.employee_id,
         b.first_name AS "���"
FROM employees a, employees b                   -- ���, ���
WHERE a.manager_id = b.employee_id(+)
CONNECT BY PRIOR a.manager_id = a.employee_id;   --�����
--�����
SELECT a.employee_id, a.first_name AS "���",
        a.manager_id AS "����� ���", a.employee_id,
         b.first_name AS "���"
FROM employees a, employees b                   -- ���, ���
WHERE a.manager_id = b.employee_id(+)
CONNECT BY a.manager_id = PRIOR a.employee_id;   --����� 
--PRIOR ��ġ�� ���� ��� ���� ������ �޶�����

--------------------------------------------------------------------