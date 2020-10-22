--------------------------------------------------------------------SQL4 -hr
--����1) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� Cartesian Product
--      (��� ������ ����� Join)�Ͽ� �����ȣ,�̸�,����,�μ���ȣ,�μ���,�ٹ����� ����Ͽ���.
SELECT 
e.employee_id, e.first_name,
e.department_id, d.department_id,
d.department_name, d.location_id
FROM employees e, departments d;

--)ANSI
SELECT 
e.employee_id, e.first_name, e.job_id, 
e.department_id, d.department_id,
d.department_name, d.location_id
FROM employees e CROSS JOIN departments d;

--����2) EMPLOYEES ���̺��� �����ȣ,�̸�,����, EMPLOYEES ���̺��� 
--      �μ���ȣ, DEPARTMENTS ���̺��� �μ���ȣ,�μ���,�ٹ����� ����Ͽ���.
SELECT e.employee_id, e.first_name, e.job_id, 
         e.department_id, d.department_id,
           d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;

--cf) ANSI ǥ�� 
SELECT e.employee_id, e.first_name, e.job_id, 
         e.department_id, d.department_id,
           d.department_name, d.location_id
FROM employees e INNER JOIN departments d
    on e.department_id = d.department_id;

--cf)�� �� ���̺� ����
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    e.job_id, j.job_id,
    d.department_name, j.job_title
FROM employees e, departments d, jobs j
WHERE e.department_id = d.department_id
    AND e.job_id = j.job_id;

--����3) Alexander Hunold �� �μ����� ����϶�.
SELECT e.first_name, e.last_name,       
        e.department_id, d.department_id,              
         d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id   -- ���� ��Ű�� ��
    AND e.first_name = 'Alexander'          
    AND e.last_name = 'Hunold';   

--����4) ������ �μ����� �ٹ��ϰ� �ִ� ������� ����϶�.
SELECT e.first_name,       
        e.department_id, d.department_id,              
         d.department_name
FROM employees e, departments d
WHERE e.department_id  = d.department_id    
    AND d.department_name = 'Sales';
    
--����5) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� �μ���ȣ�� �����ϰ� 
--      SA_MAN ������� �����ȣ,�̸�,�޿�,�μ���,�ٹ����� ����϶�. (Alias�� ���) 
SELECT e.job_id, e.employee_id, e.first_name, e.salary,      
        e.department_id, d.department_id,              
         d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id 
    AND e.job_id = 'SA_MAN';
    
--����6) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� DEPARTMENTS 
--      ���̺� �ִ� ��� �ڷḦ �����ȣ,�̸�,����, EMPLOYEES ���̺��� �μ���ȣ, 
--      DEPARTMENTS ���̺��� �μ���ȣ,�μ���,�ٹ����� ����Ͽ��� (Outer Join) 
SELECT e.employee_id, e.last_name, e.job_id,
        e.department_id, d.department_id,
         d.department_name, d.location_id
FROM departments d, employees e -- ������ �߽�
WHERE d.department_id = e.department_id(+);


SELECT e.employee_id, e.last_name, e.job_id,
        e.department_id, d.department_id,
         d.department_name, d.location_id
FROM employees e Right OUTER JOIN departments d
    ON e.department_id = d.department_id;    
    
--����7) EMPLOYEES ���̺��� Self join�Ͽ� ������(�Ŵ���)�� ����Ͽ���
SELECT a.first_name || '�� ���� ' || b.first_name || '�Դϴ�'
FROM employees a, employees b    -- a: ��� b: ���(���)
WHERE a.manager_id = b.employee_id; 

--����8) EMPLOYEES ���̺��� left join�Ͽ� ������(�Ŵ���)�� ����ϰ� 
--      �Ŵ��� ���̵� ���� ����� �����ϰ� ��������� �ϸ�, 
--      �޿��� �������� ����϶�. 
SELECT a.employee_id, a.first_name, 
        a.manager_id, b.employee_id,
         b.first_name
FROM employees a, employees b
WHERE a.manager_id = b.employee_id(+)
CONNECT BY a.manager_id = PRIOR a.employee_id
ORDER BY a.salary DESC;

--cf)

SELECT a.employee_id, a.first_name AS "�����", a.salary, 
        a.manager_id, b.employee_id,
         b.first_name as "����"
FROM employees a, employees b
WHERE a.manager_id = b.employee_id(+)
START WITH a.manager_id is not null
CONNECT BY PRIOR a.manager_id = a.employee_id
ORDER BY a.salary DESC;

--����9) EMPLOYEES ���̺��� right join�Ͽ� 
--      ������(�Ŵ���)�� 108�� ��������� �޿��� �������� ����϶�. 
SELECT a.employee_id, a.first_name AS "�����", a.salary, 
        a.manager_id, b.employee_id,
         b.first_name as "����"
FROM employees a, employees b
WHERE a.manager_id(+) = b.employee_id
    AND a.manager_id = '108'
CONNECT BY PRIOR a.manager_id = a.employee_id
ORDER BY a.salary DESC;

--------------------------------------------------------------------scott4

-- 50) ��� ����� �̸�, �μ���ȣ, �μ��̸��� ǥ���Ͻÿ�.(emp,dept)
SELECT e.ename, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

SELECT e.ename, 
        e.deptno, d.deptno,
         d.dname
FROM emp e FULL OUTER JOIN dept d
    ON e.deptno = d.deptno;
    
--51) ������ MANAGER�� ����� ������ �̸�,����,�μ���,�ٹ��� ������
--    ����Ͻÿ�.(emp,dept)
SELECT 
e.ename, e.job,
e.deptno, d.deptno,
d.dname, d.loc
FROM emp e, dept d
WHERE e.job = 'MANAGER'
    AND e.deptno = d.deptno;     
    
-- 52) Ŀ�̼��� �ް� �޿��� 1,600�̻��� ����� ����̸�,�μ���,�ٹ����� ����Ͻÿ�
SELECT 
e.ename, e.deptno, d.deptno,
d.dname, d.loc
FROM emp e, dept d
WHERE e.comm IS NOT NULL 
    AND e.comm <> 0
    AND e.sal >= 1600
    AND e.deptno = d.deptno;
    
-- 53) �ٹ����� CHICAGO�� ��� ����� �̸�,����,�μ���ȣ �� �μ��̸��� ǥ���Ͻÿ�.
SELECT 
e.ename, e.job, d.deptno,
d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno   
    AND d.loc = 'CHICAGO';
    
-- 54) �ٹ������� �ٹ��ϴ� ����� ���� 5�� ������ ���, �ο��� ���� ���ü����� �����Ͻÿ�.
-- (�ٹ� �ο��� 0���� ���� ǥ��)
SELECT d.loc, COUNT(e.empno)
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
GROUP BY d.loc
HAVING COUNT(e.empno) <= 5
ORDER BY COUNT(e.empno) ASC;

SELECT d.loc, count(*)
FROM emp e FULL OUTER JOIN dept d
 ON e.deptno = d.deptno 
GROUP BY d.loc
HAVING count(d.loc) <= 5
ORDER BY d.loc;

-- 55) ����� �̸� �� ��� ��ȣ�� �������� �̸��� ������ ��ȣ�� �Բ� ǥ���ϰ� 
-- ������ �� ���̺��� employee, emp#, manager, mgr#�� �����Ͻÿ�.
SELECT 
a.ename,
a.empno,
b.ename,
b.empno
FROM emp a, emp b
WHERE a.mgr = b.empno;

SELECT 
a.ename as employee, 
a.empno as emp#, 
b.ename as manager,
b.empno as mgr#
FROM emp a, emp b
WHERE a.mgr = b.empno;

-- 56) �����ں��� ���� �Ի��� ��� ����� �̸� �� �Ի����� �������� �̸� �� �Ի��ϰ� �Բ� ǥ���ϰ� �����ں��� �Ի����� ���� ����� �����϶�.
-- �� ���̺��� ���� employee, emp hired, manager, mgr hired�� ����
SELECT 
a.ename as employee, 
a.empno as emp#, 
a.hiredate as "emp hired",
b.ename as manager,
b.empno as mgr#,
b.hiredate as "mgr hired"
FROM emp a, emp b
WHERE a.mgr = b.empno
 AND a.hiredate < b.hiredate;

-- 57) ����� �̸� �� �����ȣ�� �������� �̸��� ������ ��ȣ�� �Բ� ǥ���ϰ� 
-- ������ �� ���̺��� employee, emp#, manager, mgr#�� �����ϴµ� 
-- King�� �����Ͽ� �����ڰ� ���� ��� ����� ǥ���ϵ��� �ϰ� 
-- ����� �����ȣ�� �������� ����
SELECT 
a.empno as emp#, 
a.ename as employee, 
a.mgr,
b.empno as mgr#,
b.ename as manager
FROM emp a, emp b
WHERE a.mgr = b.empno(+)
ORDER BY a.empno ASC;

-- 58) ������ �μ���ȣ, ����̸� �� ������ ����� ������ �μ����� �ٹ��ϴ� 
-- ��� ����� ǥ���ϵ��� ���Ǹ� �ۼ��ϰ� 
-- �μ���ȣ�� department, ����̸��� employee, ������ �μ����� �ٹ��ϴ� ����� colleague�� ǥ���Ͻÿ�.
-- (�μ���ȣ, ����̸�,���� ������ �������� ����) 
SELECT a.empno, a.ename employee,a.deptno department, b.deptno, b.empno colleague, b.ename
FROM emp a, emp b
WHERE a.deptno = b.deptno
    AND a.empno != b.empno
ORDER BY a.deptno, a.ename, b.ename ASC;

-- 59)10�� �μ����� �ٹ��ϴ� ������� 
-- �μ���ȣ, �μ��̸�, ����̸�, ����, �޿������ ����Ͻÿ�.
SELECT d.deptno, d.dname, e.ename, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno
    AND e.deptno = 10
    AND (e.sal >= s.losal AND e.sal <= s.hisal);
--==AND (e.sal BETWEEN s.losal and s.hisal;
    