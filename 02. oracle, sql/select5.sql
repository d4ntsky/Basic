/*  SUB Query
 Query ���� Query
 �Ѱ��� ��(row)���� ��� ���� ��ȯ�Ǵ� Query
                                cf) SUB QUERY�� ���ϴ� ���� �����͸� ��� ��� ������ ������ �ִ�.

    SELECT  ���� ROW ���� COLUMN (����Ǵ� �����Ͱ� �ݵ�� �Ѱ�, �÷��� �Ѱ�) cf)�׷��Լ� �����Ͱ� �� ��
    FROM    ���� ROW ���� COLUMN 
    WHERE   ���� ROW ���� COLUMN (���� �� ���� ���Ǵ� ��)
*/

-- SELECT
SELECT employee_id, first_name,
        (SELECT salary
         FROM employees 
         WHERE employee_id = 100),          --<������ �ϳ�
     /* (SELECT salary, first_name          < ����(�÷��� �ϳ�)
         FROM employees 
         WHERE employee_id = 100) */
        (SELECT COUNT(*) FROM employees)
FROM employees;

-- FROM
SELECT employee_id, first_name                          -- 2
FROM (SELECT employee_id, first_name, last_name         -- 1   SUB QUERY 1 �� 2�� ã�� �� �ִ� ��������  
      FROM employees
      WHERE department_id = 20);
-- �μ���ȣ 50��, �޿��� 6000�̻��� ���
SELECT employee_id, salary                  
FROM employees
WHERE department_id = 50
      AND salary >= 6000;
--== �÷��� ������ �ٸ�
SELECT e.employee_id, e.salary
FROM (SELECT employee_id, salary
      FROM employees
      WHERE department_id = 50) e
WHERE salary >= 6000;
--ex) �޿��� �հ�, �ο���, �����, ���� --�ο����� �׷��Լ�����...
SELECT job_id, COUNT(*) --,first_name ������ �׷����� ������ұ� ������
FROM employees
GROUP BY job_id;
--ex) �����ϰ�
SELECT e.employee_id, e.salary,
        e.job_id, j.job_id,             -- Ȯ�� �۾�
         j."�޿��հ�", j."�ο���"
FROM employees e, (SELECT job_id, SUM(salary) AS "�޿��հ�", COUNT(*) AS "�ο���"
                   FROM employees
                   GROUP BY job_id) j   --��������� CROSS JOIN
WHERE e.job_id = j.job_id;              --INNER JOIN

-- WHERE
--��պ��� ���� �޴� ���
SELECT first_name, salary   
FROM employees
WHERE salary > (SELECT AVG(salary)
                FROM employees);   -- ���� ���� ����
--department_id 90�� job_id�� ����
SELECT job_id, first_name, department_id
FROM employees
WHERE job_id IN(SELECT job_id
                FROM employees
                WHERE department_id = 90);
--�μ��� ���� �޿��� ���� �޴� ����� ���� �޿��� �޴� ���     -- �μ����� �׷�ȭ�� �ּ� �޿��� SUB QUERY�� �޿��� �������� �����
SELECT first_name, salary, department_id
FROM employees
WHERE salary IN (SELECT MIN(salary)       -- IN =�� �ΰ� �̻�  
                 FROM employees
                 GROUP BY department_id) -- ���� row
ORDER BY department_id ASC;
--�μ��� ���� �޿��� ���� �޴� ����� �޿�                    -- �μ����� �׷�ȭ�� �μ��� �ּұ޿��� SUB QUERY�� �μ��� �޿��� �������� �����
SELECT department_id, first_name, salary
FROM employees
WHERE (department_id, salary) IN (SELECT department_id, MIN(salary)
                                  FROM employees
                                  GROUP BY department_id)
ORDER BY department_id ASC;