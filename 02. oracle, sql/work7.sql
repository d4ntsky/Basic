--------------------------------------------------------------------SQL8 -hr
--����1) EMPLOYEES ���̺��� 20�� �μ��� ���� ������ �����ϴ� 
--      EMP_20 VIEW�� �����϶�
CREATE VIEW EMP_20
AS
SELECT *
FROM employees
WHERE department_id = 20;
SELECT * FROM EMP_20;

--����2) EMPLOYEES ���̺��� 30�� �μ��� EMPLOYEE_ID �� 
--      emp_no �� LAST_NAME�� name���� SALARY�� sal�� �ٲپ� 
--      EMP_30 VIEW�� �����϶�.
CREATE VIEW EMP_30(emp_no, name, sal)
AS
SELECT employee_id, last_name, salary
FROM employees
WHERE department_id = 30;
--
CREATE VIEW EMP_30
AS
SELECT employee_id AS emp_no, last_name AS name, salary AS sal
FROM employees; -- not null�� �����Ǿ��ִ°� �� ���������
SELECT * FROM EMP_30;

--����3) �μ����� �μ���,�ּ� �޿�,�ִ� �޿�,�μ��� ��ձ޿��� �����ϴ� 
--      DEPT_SUM VIEW�� �����Ͽ���. -������ ��
CREATE VIEW DEPT_SUM(dname, MINSAL, MAXSAL, AVGSAL)
AS
SELECT d.department_name, MIN(e.salary), MAX(e.salary), ROUND(AVG(e.salary))
FROM departments d, employees e
WHERE d.department_id = e.department_id
GROUP BY d.department_name; --���°� �ٸ�
SELECT * FROM DEPT_SUM;

--����4) �տ��� ������ EMP_20,EMP_30 VIEW�� �����Ͽ���.
DROP VIEW EMP_20;
DROP VIEW EMP_30;