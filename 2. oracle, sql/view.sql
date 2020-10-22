/*
    View : ���� Table
        ��ü�� ���� ���̺�, �ٸ� ���̺��� �����ϱ� ���� ���̺�
             Table <------------------- View ------------------- User
        ����: 1. �� ���� ���̺�� ���� ���� Table�� �˻��� �� �ִ�.
             2. �ӵ��� ������
             3. ���� ������ �����ϴ�. --> Read Only
*/
--VIEW ����
CREATE VIEW UB_TEST_01(JOB_ID, JOB_TITLE, MIN_SALARY)
AS
SELECT job_id, job_title, min_salary 
FROM jobs;
--VIEW�� ����
SELECT * FROM ub_test_01;   --vie�� ���ؼ� �˻�
--������ �Է��غ���
INSERT INTO ub_test_01(JOB_ID, JOB_TITLE, MIN_SALARY) -- ���� () ��������
VALUES('DEVELOPER', '������', 10000);  -- 
--Ȯ��
SELECT * FROM jobs;

ROLLBACK;  -- �۾� �ǵ�����
COMMIT;    -- ���� : Ŀ�Ե� ���� �ѹ��� �ȵ�
----------------------------------------------------------------------------
--���̺� �����
CREATE TABLE TB_EMP
AS
SELECT employee_id, first_name, salary
FROM employees;
--�߰� â�� �����
CREATE VIEW UB_VIEW(employee_id, first_name, salary)
AS
SELECT employee_id, first_name, salary
FROM TB_EMP;
--������ �ֱ�
INSERT INTO ub_view
VALUES(100, 'ȫ�浿', 10000);   -- ���� ���� TB_EMP
INSERT INTO ub_view
VALUES(101, '������', 9000);

SELECT * FROM TB_EMP;
SELECT * FROM UB_VIEW;

--Read Only
CREATE OR REPLACE VIEW DEPTVIEW(
    "�μ���ȣ",
    "�μ���",
    "������"
    )
AS 
SELECT department_id, department_name, location_id
FROM departments
WITH READ ONLY; -- �б� ����
--�б� ���뿡 �� �־�� ��������
INSERT INTO DEPTVIEW("�μ���ȣ", "�μ���", "������")
VALUES(280, '��ȹ��', 1700);
SELECT * FROM deptview;
----------------------------------------------------------------------------
CREATE OR REPLACE VIEW DEPT_EMP_VIEW(empno, name, deptno, deptname, loc)
AS
SELECT e.employee_id, e.first_name, d.department_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id
WITH READ ONLY;

SELECT name, deptname
FROM dept_emp_view
WHERE name = 'Den';

SELECT
    *
FROM dept_tmp_view;
rollback;