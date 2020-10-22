--------------------------------------------------------------------SQL2 -hr
--����1) EMPLOYEES ���̺��� �޿��� 3000�̻��� ����� ������ �����ȣ, �̸�, ������, �޿��� ����϶�. 
SELECT employee_id, last_name, job_id, salary 
FROM employees
WHERE salary >= 3000;

--����2) EMPLOYEES ���̺��� ��� ������ Manager�� ����� ������   
--      �����ȣ, ����, ������, �޿�, �μ���ȣ�� ����϶�. (Manager == ST_MAN) 
SELECT employee_id, last_name, job_id, salary, department_id
FROM employees
WHERE job_id = 'ST_MAN';

--����3) EMPLOYEES ���̺��� �Ի����ڰ� 
--      1982�� 1�� 1�� ���Ŀ� �Ի��� ����� ������  
--      �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����� ��.
SELECT employee_id, first_name, job_id, salary, hire_date, department_id
FROM employees
WHERE hire_date >= '82/01/01';

SELECT employee_id, first_name, job_id, salary, hire_date, department_id
FROM employees
WHERE hire_date > to_date('19820101', 'YYYYMMDD');

--����4) EMPLOYEES ���̺��� �޿��� 3000���� 5000������ ������  
--      ����, ������, �޿�, �μ���ȣ�� ����϶�.  
--      (AND�� ���, BETWEEN�� �Բ� ���) 
SELECT last_name, job_id, salary, department_id
FROM employees
    WHERE salary BETWEEN 3000 AND 5000;
--==WHERE salary >= 3000 AND salary <= 5000;

--����5) EMPLOYEES ���̺��� �����ȣ�� 145,152,203�� ����� ������
--      �����ȣ, ����, ������, �޿�, �Ի����ڸ� ����϶� (IN�� ���, OR�� ���) 
SELECT employee_id, last_name, job_id, salary, hire_date
FROM employees
    WHERE employee_id IN(145,152,203);
--==WHERE employee_id = 145 OR employee_id = 152 OR employee_id = 203;

--����6) EMPLOYEES ���̺��� �Ի����ڰ� 05�⵵�� �Ի��� ����� ������  
--      �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����϶�. (LIKE ���) 
SELECT employee_id, last_name, job_id, salary, hire_date, department_id
FROM employees
    WHERE hire_date LIKE '05%';
--==WHERE hire_date >= '05/01/01' AND hire_date <= '05/12/31';

--����7) EMPLOYEES ���̺��� ���ʽ��� NULL�� ����� ������  
--      �����ȣ, ����, ������, �޿�, �Ի�����, ���ʽ�, �μ���ȣ�� ����϶�. (IS ���) 
SELECT employee_id, last_name, job_id, salary, hire_date, NVL(commission_pct, 0.0), department_id
FROM employees
WHERE commission_pct IS NULL;

--����8) EMPLOYEES ���̺��� �޿��� 1100�̻��̰� JOB�� Manager��  
--      ����� ������ �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ��
--      ����϶� (AND���, ST_MAN)
SELECT employee_id, last_name, job_id, salary, hire_date, department_id
FROM employees
WHERE salary >= 1100 AND job_id = 'ST_MAN';

--����9) EMPLOYEES ���̺��� �޿��� 10000�̻��̰ų� JOB�� Manager�� ����� ������
--      �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����� �� (OR���, ST_MAN) 
SELECT employee_id, last_name, job_id, salary, hire_date, department_id
FROM employees
WHERE salary >= 10000 OR job_id = 'ST_MAN';

--����10) EMPLOYEES ���̺��� �޿��� JOB�� ST_MAN, SA_MAN, SA_REP �� �ƴ� ����� ������  
--       �����ȣ, ����, ������, �޿�, �μ���ȣ�� ����϶� (NOT IN ���) 
SELECT employee_id, last_name, job_id, salary, hire_date, department_id
FROM employees
WHERE job_id NOT IN('ST_MAN','SA_MAN','SA_REP');

--����11) ������ PRESIDENT�̰� �޿��� 12000�̻��̰ų� ������  
--       SALESMAN�� ����� ������ �����ȣ, �̸�, ����, �޿��� ����϶�.
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE job_id = 'AD_PRES' 
    AND salary >= 12000 
        OR  job_id = 'SA_MAN' ;

--����12) ������ PRESIDENT�Ǵ� SALESMAN�̰� �޿��� 12000�̻��̰ų�  
--       ����� ������ �����ȣ, �̸�, ����, �޿��� ����϶�.
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE job_id = 'AD_PRES' 
    OR  job_id = 'SA_MAN' 
        AND salary >= 12000 ;

--------------------------------------------------------------------scott1
--6) emp ���̺��� �����ȣ�� 7698 �� ����� �̸�, ����, �޿��� ����Ͻÿ�.
SELECT ename, job, sal
FROM emp
WHERE empno = 7698;

-- 7) emp ���̺��� ����̸��� SMITH�� ����� �̸��� ����, �μ���ȣ�� ���Ͻÿ�.
SELECT ename, sal, deptno
FROM emp
WHERE ename = 'SMITH';

-- 8) ������ 2500�̻� 3500�̸��� ����� �̸�, �Ի���, ������ ���Ͻÿ�.
SELECT ename, hiredate, sal
FROM emp
WHERE sal >= 2500 and sal < 3500;

-- 9) �޿��� 2000���� 3000���̿� ���Ե��� �ʴ� ����� �̸�, ����, �޿��� ����Ͻÿ�.
SELECT ename, job, sal
FROM emp
WHERE sal NOT BETWEEN 2000 AND 3000;

-- 10) 81��05��01�ϰ� 81��12��03�� ���̿� �Ի��� ����� �̸�, �޿�, �Ի����� ����Ͻÿ�.
SELECT ename, job, hiredate
FROM emp
WHERE hiredate >= '81/05/01' and hiredate <= '81/12/03';
-- == hiredate BETWEEN '81/05/01' AND '81/12/03';

-- 11) emp���̺��� �����ȣ�� 7566,7782,7934�� ����� ������ ������� �����ȣ,�̸�,
--    ������ ����Ͻÿ�.
SELECT empno, ename, sal
FROM emp
WHERE empno NOT IN(7566,7782,7934);

-- 12) �μ���ȣ 30(deptno)���� �ٹ��ϸ� 
-- �� 2,000�޷� ���ϸ� �޴� 
-- 81��05��01�� ������ �Ի��� 
-- ����� �̸�, �޿�, �μ���ȣ, �Ի����� ����Ͻÿ�.        //�߶󺸴� ����
SELECT ename, sal, deptno, hiredate
FROM emp
WHERE deptno = 30 
    and sal <= 2000 
        and hiredate <= '81/05/01' ;

-- 13) emp���̺��� �޿��� 2,000�� 5,000 ���̰�
-- �μ���ȣ�� 10 �Ǵ� 30�� ����� �̸��� �޿�,�μ���ȣ�� �����Ͻÿ�.
SELECT ename, sal, deptno
FROM emp
WHERE (sal BETWEEN 2000 AND 5000) --BETWEEN�� ������ 
    AND (deptno = 10 OR deptno = 30);
--==AND (deptno in(10, 30));
--==SUB QUERY - �������� ���� ���� ���� 
SELECT ename, sal, deptno
FROM (SELECT ename, sal, deptno 
      FROM emp  
      WHERE sal BETWEEN 2000 AND 5000)
WHERE deptno = 10 OR deptno = 30;
--  SELECT �κ��� �ٸ��� ������

-- 14) ������ SALESMAN �Ǵ� MANAGER�̸鼭 �޿��� 1,600, 2,975 �Ǵ� 2,850�� �ƴ� ��� ����� �̸�, ���� �� �޿��� ǥ���Ͻÿ�.
SELECT ename, job, sal
FROM emp
WHERE (job = 'SALESMAN' OR job = 'MANAGER')
        AND (sal NOT IN(1600,2975,2850));       --��������Ʈ ���鶧 ������ �����Ƿ� ()�� ���� ����� ����

-- 15) emp���̺��� ����̸� �� S�� ���Ե��� ���� ����� �� 
-- �μ���ȣ�� 20�� ������� �̸��� �μ���ȣ�� ����Ͻÿ�.
SELECT ename, deptno
FROM emp
WHERE ename NOT LIKE '%S%' 
    AND deptno = 20 ;

-- 16) emp���̺��� �̸��� A�� E�� �ִ� ��� ����� �̸��� ǥ���Ͻÿ�.
SELECT ename
FROM emp
WHERE ename LIKE '%A%' 
    AND ename LIKE '%E%' ;

-- 17) emp���̺��� �����ڰ� ���� ��� ����� �̸��� ������ ǥ���Ͻÿ�.
SELECT ename, job
FROM emp
WHERE mgr IS NULL;

-- 18) emp���̺��� Ŀ�̼� �׸��� �Էµ� ������� �̸��� �޿�, Ŀ�̼��� ���Ͻÿ�.
SELECT ename, sal, comm 
FROM emp
WHERE comm IS NOT NULL --���⼭ Ŀ�̼��� 0�� TURNER�� ����
    AND comm <> 0;     --���⼭ 0�� ��� �����������.
--==AND comm != 0;