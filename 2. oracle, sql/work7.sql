--------------------------------------------------------------------SQL8 -hr
--문제1) EMPLOYEES 테이블에서 20번 부서의 세부 사항을 포함하는 
--      EMP_20 VIEW를 생성하라
CREATE VIEW EMP_20
AS
SELECT *
FROM employees
WHERE department_id = 20;
SELECT * FROM EMP_20;

--문제2) EMPLOYEES 테이블에서 30번 부서만 EMPLOYEE_ID 를 
--      emp_no 로 LAST_NAME을 name으로 SALARY를 sal로 바꾸어 
--      EMP_30 VIEW를 생성하라.
CREATE VIEW EMP_30(emp_no, name, sal)
AS
SELECT employee_id, last_name, salary
FROM employees
WHERE department_id = 30;
--
CREATE VIEW EMP_30
AS
SELECT employee_id AS emp_no, last_name AS name, salary AS sal
FROM employees; -- not null로 설정되어있는건 다 적어줘야함
SELECT * FROM EMP_30;

--문제3) 부서별로 부서명,최소 급여,최대 급여,부서의 평균급여를 포함하는 
--      DEPT_SUM VIEW을 생성하여라. -유용한 편
CREATE VIEW DEPT_SUM(dname, MINSAL, MAXSAL, AVGSAL)
AS
SELECT d.department_name, MIN(e.salary), MAX(e.salary), ROUND(AVG(e.salary))
FROM departments d, employees e
WHERE d.department_id = e.department_id
GROUP BY d.department_name; --묶는게 다름
SELECT * FROM DEPT_SUM;

--문제4) 앞에서 생성한 EMP_20,EMP_30 VIEW을 삭제하여라.
DROP VIEW EMP_20;
DROP VIEW EMP_30;