--------------------------------------------------------------------SQL1 -hr
--문제1) EMPLOYEES Table의 모든 자료를 출력하여라.
SELECT * FROM employees;

--문제2) EMPLOYEES Table의 컬럼들을 모두 출력하라.
DESC employees;

--문제3) EMPLOYEES Table에서 사원 번호, 이름, 급여, 담당업무를 출력하여라.
SELECT employee_id, first_name, salary, job_id
FROM employees;

--문제4) 모든 종업원의 급여를 $300증가 시키기 위해서 
--      덧셈 연산자를 사용하고 결과에 SALARY+300을 디스플레이 합니다. 
SELECT first_name, salary, salary + 300
FROM employees;

--문제5) EMP 테이블에서 사원번호, 이름, 급여, 보너스, 보너스 금액을 출력하여라. 
--     (참고로 보너스는 월급 + (월급*커미션)) 
SELECT 
employee_id, first_name, salary, 
salary*commission_pct,
salary+(salary*commission_pct)
FROM employees;

--NVL(컬럼명, 원하는 값)
--    컬럼이 NULL이 아니면 칼럼의 값을 출력, null이면 원하는 값
--cf)--5)
SELECT 
employee_id, first_name, salary, 
NVL(commission_pct, 0), nvl(salary + (salary * commission_pct) , 0)
FROM employees;

--문제6) EMPLOYEES 테이블에서 LAST_NAME을 이름으로 SALARY을 급여로 출력하여라. 
SELECT last_name AS "이름", salary as 급여
FROM employees;

--문제7) EMPLOYEES 테이블에서 LAST_NAME을 Name으로  
--      SALARY *12를 Annual Salary(연봉)로 출력하여라 
SELECT last_name AS Name, salary * 12 as "Annual Salary"
FROM employees;

--문제9) EMPLOYEES 테이블에서 이름과 업무를 연결하여 출력하여라.
SELECT last_name ||' '|| job_id as Employees
FROM employees;

--문제10) EMPLOYEES 테이블에서 이름과 업무를
--       “KING is a PRESIDENT” 형식으로 출력하여라.
SELECT '"' || last_name ||' is a '|| job_id || '"' 
as "Employees Detail"
FROM employees;

--문제11) EMPLOYEES 테이블에서 이름과 연봉을  
--       “KING: 1 Year salary = 60000” 형식으로 출력하여라.
SELECT '"' || last_name ||': 1 Year Salary = '|| salary*12 || '"'
as "이름과 연봉"
FROM employees;

--문제12) EMPLOYEES 테이블에서 JOB을 모두 출력하라. 
SELECT DISTINCT job_id
FROM employees; 

--------------------------------------------------------------------scott0
--1)emp 테이블에서 사원번호, 사원이름, 월급을 출력하라
SELECT empno, ename, sal 
FROM emp;

--2)emp 테이블에서 사원이름과 월급을 출력하는데 칼럼명은 이 름, 월 급으로 바꿔서 출력하라
SELECT ename AS "이 름", sal AS "월 급"
FROM emp;

--3)emp 테이블에서 사원번호, 사원이름, 월급, 연봉을 구하고 
--각각 칼럼명은 사원번호, 사원이름, 월급, 연봉으로 출력하라
SELECT 
empno AS 사원번호, ename AS "사원이름", sal AS 월급, sal*12 as 연봉
FROM emp;

--4)emp 테이블의 업무(job)을 중복 되지않게 표시하라
SELECT DISTINCT job 
FROM emp;

--5)emp 테이블의 사원명과 업무로 연결(SMITH,CLERK)해서 표시하고
--컬럼명은 Employee and Job으로 표시하라
SELECT 
'('||ename||','||job||')' as "Employee and Job"
FROM emp;
