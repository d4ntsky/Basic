--------------------------------------------------------------------SQL5 -hr
--1)EMPLOYEES ���̺��� (Kochhar�� �޿�)����
--  ���� ����� ������ ��� ��ȣ,�̸�,������,�޿��� ����϶�. 
SELECT employee_id, first_name, last_name, job_id, salary
FROM employees
WHERE salary > (SELECT salary
                FROM employees
                WHERE last_name = 'Kochhar');
                
--2)EMPLOYEES ���̺��� (�޿��� ���)���� ���� ����� ������
--  �����ȣ, �̸�,������,�޿�,�μ���ȣ�� ����Ͽ���. 
SELECT employee_id, first_name, last_name, job_id, salary, department_id
FROM employees
WHERE salary < (SELECT AVG(salary)
                FROM employees);

--3)EMPLOYEES ���̺��� (100�� �μ��� �ּ� �޿�)���� �ּ� �޿��� ���� �ٸ� ��� �μ��� ����϶� 
--  �� �μ��� �߰����� 100�� �ּұ޿��� �񱳵Ǽ� �� �� �ּҰ�
/*SELECT department_id, MIN(salary)
FROM employees
WHERE salary >
                      (SELECT MIN(salary)
                       FROM employees
                       WHERE department_id = 100)
GROUP BY department_id;
*/
--------------------------------------------------------------
-- �� �μ��� �ּҰ��� 100�� �ּұ޿��� �������� ū ���
SELECT department_id, MIN(salary) --���� �Ͱ� �׷� �Լ��� ǥ�� ����
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (SELECT MIN(salary)
                      FROM employees   
                      WHERE department_id = 100);
-- �ּұ޿�
/*SELECT department_id, MIN(salary)OVER()--department_id�� �����ٸ� MIN(salary)OVER()�� ���� OVER()�� ����Ʈ������ ����..
FROM employees   
WHERE department_id = 100; --==6900*/

--4) (�������� �ּ� �޿�)�� �޴� ����� ������ 
--   �����ȣ,�̸�,����,�μ���ȣ �� ����Ͽ���. �� �������� �����Ͽ���(���� ��� ASC).
SELECT employee_id, first_name, last_name, job_id, salary
FROM employees
WHERE (job_id, salary) IN (SELECT job_id, MIN(salary)     --�ּұ޿� �ܿ� ������ ���;���
                           FROM employees
                           GROUP BY job_id)
ORDER BY job_id ASC;
--���� �� �� �������� ����?
SELECT employee_id, first_name, last_name, job_id,
salary, department_id
FROM employees
WHERE salary > (SELECT MIN(salary)
                FROM employees)
ORDER BY job_id;

--5) EMPLOYEES �� DEPARTMENTS ���̺��� ������ 
--   ������� ����� �� ���� �̸�,����,�μ���,�ٹ����� ����϶�. 
--JOIN ����
SELECT e.first_name, e.job_id, e.department_id, d.department_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id
    AND e.job_id = 'SA_MAN';
--�ٸ� ��� FROM��
SELECT first_name, job_id, e.department_id, d.department_id, d.department_name
FROM (SELECT first_name, job_id, department_id -- �� ���������� sa_man�� ���Ѱ͸�
      FROM employees
      WHERE job_id = 'SA_MAN') e, departments d
WHERE e.department_id = d.department_id;

--6)EMPLOYEES ���̺��� (���� ���� ����� ���� MANAGER)�� �����ȣ�� ����϶�.
--���̺��� manager�� ���� ����� cf)����ȣ ����� ���� �Ŵ��� �μ� ���� ��찡  
SELECT manager_id, count(manager_id) --MAX�� ������ manager_id�� �ϳ��� ��������?
FROM employees
GROUP BY manager_id;
--��
SELECT manager_id, COUNT(*) --���� �͸� ���� �ִ�..
FROM employees
GROUP BY manager_id
HAVING COUNT(manager_id) = (SELECT MAX(COUNT(*))
                            FROM employees
                            GROUP BY manager_id);
                            
--7)EMPLOYEES  ���̺��� 
--  (���� ���� ���)�� �����ִ� �μ���ȣ�� ������� ����϶�. 
SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id
HAVING COUNT(department_id) = (SELECT MAX(COUNT(*))
                               FROM employees
                               GROUP BY department_id);

--8)EMPLOYEES���̺��� (�����ȣ�� 123�� ����� ������ ����)
--  (�����ȣ�� 192�� ����� �޿�(SAL)���� ����) ����� 
--  �����ȣ, �̸�, ����, �޿��� ����϶�. 
SELECT 
employee_id, first_name, last_name, job_id, salary
FROM employees
WHERE 
    (job_id = (SELECT job_id
               FROM employees
               WHERE employee_id = 123))        --ST_MAN
AND 
    ((salary > (SELECT salary
                FROM employees
                WHERE employee_id = 192)));     --4000

--9) ����(JOB)���� �ּ� �޿��� �޴� ����� ������ 
--   �����ȣ, �̸�, ����, �μ���!�� ����϶�. 
--   ����1 : �������� �������� ����
SELECT 
e.employee_id, e.first_name, e.last_name, e.job_id, e.salary, 
e.department_id, d.department_id,
d.department_name
FROM employees e, departments d
WHERE (job_id, salary) IN (SELECT job_id, MIN(salary)
                           FROM employees
                           GROUP BY job_id)
    AND e.department_id = d.department_id
ORDER BY e.job_id DESC;

--�������� �ּ� �޿��� �޴� ���
SELECT job_id, min(salary)
FROM employees
GROUP BY job_id;
--�μ��̸� �ȵǴ� ��
SELECT 
employee_id, first_name,  last_name,  job_id,  department_id
FROM employees
WHERE (job_id, salary) in 
                        (SELECT job_id, min(salary)
                         FROM employees
                         GROUP BY job_id)
order by job_id desc;

--??????????????����
--10)EMPLOYEES ���̺��� �������� �ּ� �޿��� �޴� 
--   ����� ������ �� ����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ��
--   ����϶�
-- �������� �ּ� �޿� �޴� ���
SELECT 
job_id, MIN(salary)
FROM employees
GROUP BY job_id;
--��
SELECT 
employee_id, first_name, last_name,
hire_date, salary, department_id
FROM employees
WHERE (job_id, salary) IN 
                   (SELECT job_id, MIN(salary)
                    FROM employees
                    GROUP BY job_id)
;

--11) EMPLOYEES ���̺��� (50�� �μ��� �ּ� �޿�)�� 
--    �޴� ������� ���� �޿��� �޴� ����� ������ 
--    �����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ�� ����϶�. 
--    �� 50���� ���� 
-- 50�� �μ��� �ּ� �޿��� �޴� ����� �޴� �� = TJ Olson 2100
SELECT MIN(salary)
FROM employees
WHERE department_id = 50;
--��
SELECT 
employee_id, first_name, last_name, job_id,
hire_date, salary, department_id
FROM employees
WHERE salary >  (SELECT MIN(salary)
                 FROM employees
                 WHERE department_id = 50)
    AND department_id <> 50;

--12)
SELECT 
employee_id, first_name, last_name, job_id,
hire_date, salary, department_id
FROM employees
WHERE salary >  (SELECT MAX(salary)
                 FROM employees
                 WHERE department_id = 50)
    AND department_id <> 50;

--13)??????����
SELECT RNUM, employee_id, first_name, hire_date                   -- 3
FROM(SELECT ROWNUM AS RNUM, employee_id, first_name, hire_date    -- 2
     FROM(SELECT employee_id, first_name, hire_date               -- 1 ���õ����� �����
          FROM employees
          ORDER BY hire_date DESC)
     )
WHERE RNUM > 0 AND RNUM <= 20;

/*cf) GROUP BY ���θ����� ��ǰ�̶�ġ�� ��� �� ��ǰ/��ǰ�� ���� �ȸ���(�Ҽ��� ��
               �ֽ� ������� ���� ���̳� IT�� �׷��ɷ� �Ҽ� ��                */
               
--------------------------------------------------------------------scott5 
/*
37)DECODE �Ǵ� CASE WHEN THEN �Լ��� ����Ͽ� ���� �����Ϳ� ���� JOB���� ���� ��������
��� ����� ����� ǥ���Ͻÿ�.

����        ���
PRESIDENT   A
ANALYST     B
MANAGER     C
SALESMAN    D
CLERK       E
��Ÿ         0
*/
SELECT ename, job,
    CASE SUBSTR(job,1)                  --== CASE job WHEN
        WHEN 'PRESIDENT'   THEN 'A'
        WHEN 'ANALYST'     THEN 'B'
        WHEN 'MANAGER'     THEN 'C'
        WHEN 'SALESMAN'    THEN 'D'
        WHEN 'CLERK'       THEN 'E'
        ELSE '��Ÿ'
    END AS "���"
FROM emp
ORDER BY "���";
--==
SELECT ename, job,
    DECODE( SUBSTR(job,1) , -- == DECODE(job, 'PRESI
    'PRESIDENT',   'A',
    'ANALYST',     'B',
    'MANAGER',     'C',
    'SALESMAN',    'D',
    'CLERK',       'E',
    '��Ÿ') AS "���"
FROM emp
ORDER BY "���";

-- 60) (BLAKE�� ���� �μ�)�� �ִ� ������� �̸��� �Ի����� ���ϴµ� 
-- BLAKE�� �����ϰ� ����Ͻÿ�.(BLAKE�� �������� �� ����)
SELECT ename, hiredate
FROM emp
WHERE deptno IN (SELECT deptno
                 FROM emp
                 WHERE ename = 'BLAKE')
    AND ename != 'BLAKE';

-- 61) ��ձ޿����� ���� �޿��� �޴� ������� �����ȣ, �̸�, ������ ����ϴµ� 
-- ������ ���� ��������� ����Ͻÿ�.
SELECT empno, ename, sal
FROM emp
WHERE sal >   (SELECT AVG(sal)
               FROM emp)
ORDER BY sal DESC;

-- 62) (10���μ����� �޿��� ���� ���� �޴� ����� ������ �޿�)�� �޴� ����� �̸��� ����Ͻÿ�.
SELECT *
FROM emp
WHERE sal = (SELECT MIN(sal)
             FROM emp
             WHERE deptno = 10);

-- 63) ������� 3���� �Ѵ� �μ��� �μ���� ������� ����Ͻÿ�.
SELECT d.dname, COUNT(e.empno)
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY d.dname
HAVING COUNT(e.empno) > 3;

-- 64) �����ȣ�� 7844�� ������� ���� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�.
SELECT ename, hiredate
FROM emp
WHERE hiredate < (SELECT hiredate
                  FROM emp
                  WHERE empno = 7844);

-- 65) (���ӻ��(mgr)�� KING)�� ��� ����� �̸��� �޿��� ����Ͻÿ�.
SELECT ename, sal, mgr
FROM emp
WHERE mgr = (SELECT empno
             FROM emp
             WHERE ename = 'KING');

-- 66) (20�� �μ����� ���� �޿��� ���� �޴� ����� ������ �޿�)�� �޴� 
-- ����� �̸��� �μ���,�޿�, �޿������ ����Ͻÿ�.(emp, dept, salgrade)  
-- JOIN emp�� dept (JOIN���̺�) / salgrade(�����̺�)
SELECT e.ename, d.dname, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE sal = (SELECT MAX(sal)
             FROM emp
             WHERE deptno = 20)
    AND e.deptno = d.deptno
    AND sal BETWEEN s.losal AND s.hisal;
--==AND sal >= s.losal AND sal <= s.hisal;

--67) (�ѱ޿�sal+comm�� ��� �޿�)���� ���� �޿��� �޴� ����� �μ���ȣ, �̸�, �ѱ޿�, 
--    Ŀ�̼��� ����Ͻÿ�.(Ŀ�̼��� ��(O),��(X)�� ǥ���ϰ� �÷����� "comm����" ���)
SELECT deptno, ename, sal+NVL(comm, 0), NVL(comm, 0), NVL2(comm, 'o', 'x'), NVL2(comm, '����', '����') 
FROM emp
WHERE sal + NVL(comm, 0) > (SELECT AVG(sal)
                            FROM emp);
/*
    NVL  (�÷�, �÷��� NULL�� ��� ������ ��)
    NVL2 (�÷�, �÷��� NULL�� �ƴ� ��� ������ ��, �÷��� NULL�� ��� ������ ��)      cf) ���� ������
*/                          

-- 68) (CHICAGO �������� �ٹ��ϴ� ����� ��� �޿�)���� ���� �޿��� �޴� ����� �̸��� �޿�,
--     �������� ����Ͻÿ�. ���� ����!
SELECT e.ename, sal, d.loc                             
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND sal > (SELECT AVG(sal)             --3. ��    --2. ��ձ޿�
               FROM emp
               WHERE deptno = (SELECT deptno           --1. ���� ��ȣ
                               FROM dept
                               WHERE loc = 'CHICAGO'));

-- Ȯ��???????????????
-- 69) (������ SALESMAN�� ������ 2�� �̻�)�� �μ��� �̸�, �ٹ��ϴ� ����� �̸�, ������ ���
--    �Ͻÿ�.(�÷����� �μ���, �����, ������ ���)
SELECT d.dname, e.ename, e.job
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND e.deptno IN (SELECT deptno
                    FROM emp
                    WHERE job = 'SALESMAN'
                    GROUP BY deptno
                    HAVING COUNT(job) >= 2);

-- 70) (Ŀ�̼��� ���� �����) �� ������ ���� ���� ����� �̸��� �޿������ ����Ͻÿ�.
SELECT e.ename, s.grade
FROM emp e, salgrade s
WHERE sal = (SELECT MAX(sal)
             FROM emp
             WHERE comm IS NULL 
                OR comm = 0)
    AND sal BETWEEN s.losal AND s.hisal;

-- 71) SMITH�� �������� �̸��� �μ���, �ٹ������� ����Ͻÿ�. 
SELECT e.ename, d.dname, d.loc
FROM  emp e, dept d
WHERE e.deptno = d.deptno
    AND e.empno = (SELECT mgr
                   FROM emp
                   WHERE ename = 'SMITH');
