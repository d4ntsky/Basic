/*
SELECT 컬럼, Sub Query, 함수(표준, 그룹) 
FROM 테이블명, Sub Query
WHERE 
    조건, AND, OR, JOIN, IN, ANY, ALL, 
    NOT, BETWEEN, LIKE, IS NULL, Sub Query
                            cf)IS NULL O
                               =  NULL X 
GROUP BY 컬럼, 컬럼
HAVING 조건절(GROUP BY 있을때만)
ORDER BY (정렬하고싶은) 컬럼 ASC, 컬럼 DESC        
;
*/
--------------------------------------------------------------------SQL3 -hr
--기본 함수 실습 과제
--문제1) EMPLOYEES 테이블에서 King의 정보를 소문자로 검색하고 
--      사원번호, 성명, 담당업무(소문자로),부서번호를 출력하라
SELECT employee_id, last_name, LOWER(job_id), department_id
FROM employees
WHERE LOWER(last_name) = 'king';

SELECT employee_id, last_name, LOWER(job_id), department_id
FROM employees
WHERE last_name = 'King' 
ORDER BY employee_id ASC;

--문제2) EMPLOYEES 테이블에서 King의 정보를 대문자로 검색하고 
--      사원번호, 성명, 담당업무(대문자로),부서번호를 출력하라. 
SELECT employee_id, last_name, UPPER(job_id), department_id
FROM employees
WHERE last_name = 'King' 
ORDER BY employee_id ASC;

SELECT employee_id, last_name, UPPER(job_id), department_id
FROM employees
WHERE UPPER(last_name) = 'KING';

--문제3) DEPARTMENTS 테이블에서 부서번호와 부서이름,
--      부서이름과 위치번호를 합하여 출력하도록 하라. 
SELECT department_id || ' ' || department_name,
        department_name || ' ' || location_id
FROM departments;

--CONCAT(CONNECTION-CATCH) 문자 연결 + ||
SELECT department_id, location_id, 
CONCAT(department_id, department_name),
CONCAT(department_name, location_id)
FROM departments;

--문제4) EMPLOYEES 테이블에서 이름의 첫 글자가 ‘K’ 보다 크고 ‘Y’보다 적은 사원의 정보를
--      사원번호, 이름, 업무, 급여, 부서번호를 출력하라. 단 이름순으로 정렬하여라
SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE SUBSTR(first_name, 1, 1) > 'K' 
  AND SUBSTR(first_name, 1, 1) < 'Y' -- 뒤에는 글자수를 뜻함
    --cf) 자바에서 "hello" -> substring(1,2) - 출력값 e 뒤에거보다 작을때까지
ORDER BY first_name asc;
--틀린거
SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE first_name > 'K%' AND first_name < 'Y%'
--WHERE LAST_NAME between 'K%' and 'Y%'
ORDER BY fisrt_name asc;

--문제5) EMPLOYEES 테이블에서 20번 부서 중 이름의 길이 및 급여의 자릿수를
--      사원번호, 이름, 이름의 자릿수, 급여, 급여의 자릿수를 출력하라. 
SELECT 
employee_id, first_name, 
LENGTH(first_name), salary, LENGTH(salary)
FROM employees
WHERE department_id = 20;
--cf) 추가 JOIN
SELECT 
employee_id, first_name, 
LENGTH(first_name), salary, LENGTH(salary), department_name
FROM employees e, departments d
WHERE d.department_id = 20
    AND e.department_id = d.department_id;
    
--문제6) EMPLOYEES 테이블에서 이름 중 ‘e’자의 위치를 출력하라.
SELECT first_name, 
INSTR(first_name, 'e', 1, 1),
INSTR(first_name, 'e', 1, 2),
INSTR(first_name, 'e', 1, 3),
INSTR(first_name, 'e', 1, 4)
FROM employees;
-- INSTR = indexOf

--문제7) 다음의 쿼리를 실행하고 결과를 분석하라. 
SELECT 
ROUND(4567.678), 
ROUND(4567.678, 0), -- 많이 사용하는 형태
ROUND(4567.678, 2), -- 많이 사용하는 형태 
ROUND(4567.678,-2)
FROM dual;
--반올림 (반올림할 숫자, 반올림할 자릿수)

--문제8) EMPLOYEES 테이블에서 부서번호가 80인 사람의 급여를 
--      30으로 나눈 나머지를 구하여 출력하라. 
SELECT first_name, salary, MOD(salary, 30), department_id
FROM employees
WHERE department_id = 80;
-- 세금 계산시 MOD 쓰는 편

--문제9) EMPLOYEES 테이블에서 30번 부서 중 이름과 담당 업무를 연결하여 출력하여라. 
--      단 담당 업무를 한 줄 아래로 출력하라. 
--      보이기엔 한줄처럼 보이지만 그리드를 더블 클릭하면 개행되었다는 것을 확인할 수 있다
SELECT 
first_name || CHR(10) || job_id
FROM employees
WHERE department_id = 30 ;
--CHR(10) = \n

--10)  EMPLOYEES 테이블에서 현재까지 근무일 수가 몇주 몇일 인가를 출력하여라. 
--     단 근무 일수가 많은 사람 순으로 출력하여라.          자주 사용되는 쿼리!!!
SELECT first_name, hire_date,
    to_date('20/06/22') - hire_date AS "총 근무 일수",                    -- 입사한 후에 몇 일간 근무 했는지?
    TRUNC( (to_date('20/06/22') - hire_date) / 7)  AS "총 근무 주일수",   -- 입사한 후에 몇 주간 근무 했는지?
    MOD( (to_date('20/06/22') - hire_date), 7) AS "남은 일수" 
FROM employees
ORDER BY "총 근무 일수" DESC;
--잘 못된 거... 위꺼와 비교
SELECT last_name, hire_date, sysdate, 
ROUND(sysdate - hire_date) as "Total Days"
FROM employees
ORDER BY "Total Days" DESC;

--문제11) EMPLOYEES 테이블에서 부서 50에서 급여 앞에 $를 삽입하고 3자리 마다 ,를 출력하라 
--넘어간 것
SELECT department_id, last_name, job_id, salary,
TO_CHAR(salary, '$999,999,999,999')
FROM employees
WHERE department_id = 50 
ORDER BY salary DESC;

--문제12) 다음의 결과를 분석하여 보아라.
SELECT EMPLOYEE_ID,LAST_NAME,JOB_ID,SALARY,
DECODE(JOB_ID,
    'IT_PROC',  SALARY*1.1, 
    'ST_MAN',   SALARY*1.15,
    'SA_MAN',   SALARY*1.2, SALARY) d_sal -- alias
FROM employees
WHERE job_id IN('IT_PROC', 'ST_MAN', 'SA_MAN')
ORDER BY SALARY DESC; 
-- 세 사람만 각각 곱해서

--그룹 함수 실습 과제
--문제1) EMPLOYEES 테이블에서 모든 SALESMAN(SA_MAN)에 대하여 
--      급여의 평균, 최고액, 최저액, 합계를 구하여 출력하여라.
SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
WHERE job_id LIKE 'SA_%';

--??
SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
WHERE job_id = 'SA_MAN';

--문제2) EMPLOYEES 테이블에 등록되어 있는 인원수, 보너스가 NULL이 아닌 
--      인원수, 보너스의 평균, 등록되어 있는 부서의 수를 구하여 출력하라. 
SELECT 
COUNT(*) AS 인원, COUNT(employee_id), 
TRUNC(AVG(commission_pct * salary)), 
COUNT(DISTINCT department_id),
COUNT(DISTINCT job_id)
FROM employees;
--비교
SELECT 
COUNT(*) AS 인원,
COUNT(commission_pct) AS "보너스 있는 사람 수", 
AVG(commission_pct) AS "보너스평균",
COUNT(DISTINCT department_id)
FROM employees;

--문제3) EMPLOYEES 테이블에서 부서별로 
--      인원수, 평균 급여, 최저급여, 최고 급여, 급여의 합을 구하여 출력하라. 
-- ex) 부서별로, 업무별로 - ~별로 는 대게 group by
SELECT department_id, --GROUP BY로 묶었을 땐 묶인거 구별할 수 있게,,
COUNT(*) AS 인원, 
TRUNC(AVG(salary)), MIN(salary), MAX(salary), SUM(salary)
FROM employees
GROUP BY department_id 
ORDER BY department_id ASC;

--문제4) EMPLOYEES 테이블에서 각 부서별로 
--      인원수,급여의 평균, 최저 급여, 최고 급여, 급여의 합을 구하여 
--      급여의 합이 많은 순으로 출력하여라. 
SELECT department_id, COUNT(*) AS 인원, 
ROUND(AVG(salary), 1), MIN(salary), MAX(salary), 
SUM(salary) AS "급여의 합"
FROM employees
GROUP BY department_id
ORDER BY SUM(salary) DESC;

--문제5) EMPLOYEES 테이블에서 부서별, 업무별 그룹하여 결과를 
--       부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하여라.
SELECT department_id, job_id, 
COUNT(*), TRUNC(AVG(salary)), SUM(salary)
FROM employees
GROUP BY department_id, job_id;

--문제6) EMPLOYEES 테이블에서 부서 인원이 4명보다 많은 부서의 
--      부서번호, 인원수, 급여의 합을 구하여 출력하여라.(GROUP BY, HAVING)
SELECT department_id, COUNT(*), SUM(salary)
FROM employees
GROUP BY department_id
HAVING COUNT(*) > 4;

--문제7) EMPLOYEES 테이블에서 급여가 최대 10000이상인 부서에 대해서 
--      부서번호, 평균 급여, 급여의 합을 구하여 출력하여라.
SELECT department_id, ROUND(AVG(salary)), SUM(salary), MAX(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary) >= 10000;

--문제8) EMPLOYEES 테이블에서 업무별 급여의 평균이 10000 이상인 업무에 대해서 
--      업무명, 평균 급여, 급여의 합을 구하여 출력하라. 
SELECT job_id, AVG(salary), SUM(salary)
FROM employees
GROUP BY job_id
HAVING AVG(salary) >= 10000;

--문제9) EMPLOYEES 테이블에서 전체 월급이 10000을 초과하는 각 업무에 대해서 
--      업무와 월급여 합계를 출력하라. 
--      단 판매원은 제외하고 월 급여 합계로 정렬(내림차순)하라.(SA_) 
SELECT job_id, SUM(salary) AS PAYROLL
FROM employees
WHERE job_id NOT LIKE 'SA_%'
GROUP BY job_id
HAVING SUM(salary) > 10000 
ORDER BY PAYROLL DESC;


--------------------------------------------------------------------scott2
--19) emp 테이블에서 사원번호, 사원이름, 입사일을 출력하는데 
--입사일이 빠른 사람순으로 정렬하시오.
SELECT empno, ename, hiredate
FROM emp
ORDER BY hiredate ASC;

--20) emp 테이블에서 사원이름, 급여, 연봉을 구하고
--연봉이 많은 순으로 정렬하시오.
SELECT ename, sal, sal * 12 
FROM emp
ORDER BY sal * 12 DESC;

--21)10번 부서와 20번부서에서 근무하고 있는 
--사원의 이름과 부서번호를 출력하는데 
--이름을 영문자순으로 표시하시오.
SELECT ename, deptno
FROM emp
WHERE deptno in(10,20)
--==WHERE deptno = 10 OR deptno = 20;
ORDER BY ename ASC;

--22) 커미션을 받는 모든 사원의 
--이름,급여 및 커미션을 커미션을 기준으로 
--내림차순으로 정렬하여 표시하십시오.
SELECT ename, sal, comm
FROM emp
WHERE comm IS NOT NULL AND comm <> 0
ORDER BY comm DESC;

--23) emp테이블의 업무(job)을 첫글자는 대문자 나머지는 소문자로 출력하시오.
--????????? 확인
SELECT SUBSTR(job, 1, 1)|| LOWER(SUBSTR(job, 2))
FROM emp;
--
SELECT job, INITCAP(job)
FROM emp;

--24) emp테이블에서 사원이름 중 A가 포함된 사원이름을 구하고
--그 이름 중 앞에서 3자만 추출하여 출력
SELECT ename, SUBSTR(ename, 1, 3)
FROM emp
WHERE ename LIKE '%A%';


--25) 이름의 세번째 문자가 A인 모든 사원의 이름을 표시하시오.
SELECT ename
FROM emp
WHERE SUBSTR(ename, 3, 1) = 'A';

--26) 이름이 J,A 또는 M으로 시작하는 모든 사원의 이름
--첫 글자는 대문자로, 나머지 글자는 소문자로 표시하고 이름의 길이를 표시하시오.
--열 레이블은 name과 length로 표시
SELECT 
UPPER(SUBSTR(ename, 1, 1)) || LOWER(SUBSTR(ename, 2)) AS name,
LENGTH(ename) AS length
FROM emp
WHERE (ename LIKE 'J%') OR (ename LIKE 'A%') OR (ename LIKE 'M%');

SELECT INITCAP(ename), LENGTH(ename)
FROM emp
WHERE ename LIKE 'J%' OR ename LIKE 'A%' OR SUBSTR(ename, 1, 1) = 'M';

--27) 이름의 글자수가 6자 이상인 사원의 이름을 소문자로 이름만 출력하시오
SELECT ename, LOWER(ename)
FROM emp
WHERE LENGTH(ename) >= 6;

--28) 이름의 글자수가 6자 이상인 사람의 이름을 
--앞에서 3자만 구하여 소문자로 출력하시오.
SELECT ename, LOWER(SUBSTR(ename, 1, 3))
FROM emp
WHERE LENGTH(ename) >= 6;

SELECT ename, LOWER(SUBSTR(ename, 1, 3))
FROM emp
WHERE LENGTH(ename) >= 6;


--29) 모든 사원의 이름과 급여를 표시하시오.
--급여는 15자 길이로 왼쪽에 $기호가 채워진 형식으로
--표기하고 열레이블을 SALARY로 지정하시오.
SELECT ename, sal, LPAD(sal, 15, '$')
FROM emp;

SELECT ename, TO_CHAR(sal, '$999,999,999,999') AS "SALARY"
FROM emp;

--30) 오늘부터 이번달의 마지막날까지의 남은 날 수를 구하시오.
SELECT LAST_DAY(SYSDATE) - SYSDATE
FROM dual;
--비교
SELECT SYSDATE, LAST_DAY(TO_DATE(SYSDATE)),
        CEIL(LAST_DAY(TO_DATE(SYSDATE)) - SYSDATE)
FROM dual;

--31) emp테이블에서 각 사원에 대해 
--사원번호, 이름, 급여 및 15% 인상된 급여를 정수(반올림)로 표시하시오.
--인상된 급여열의 레이블을 New Salary로 지정하시오.
SELECT empno, ename, sal, ROUND(sal*1.15) AS "New Salary"
FROM emp;

--32) emp테이블에서 월급의 4의 배수(mod(sal,4)=0)인 
--사원의 이름과 월급을 출력하시오.(세자리 단위 쉼표 표시)
SELECT ename, TO_CHAR(sal, '99,999') AS "SAL"
FROM emp
WHERE MOD(sal,4) = 0;

--------------------------------------------------------------------scott3
--33) 각 사원의 이름을 표시하고 근무 달 수(입사일로부터 현재까지의 달수)를 계산하여
--열 레이블을 MONTHS_WORKED로 지정하시오. 
--결과는 정수로 반올림하여 표시하고 근무달 수를
--기준으로 오름차순으로 정렬하시오.
SELECT ename, hiredate, ROUND(MONTHS_BETWEEN(SYSDATE, hiredate)) AS "MONTHS_WORKED"
FROM emp
ORDER BY 'MONTHS_WORKED' ASC;

--34)emp테이블에서 이름, 업무, 근무연차를 출력하시오.
SELECT ename, job, ROUND(MONTHS_BETWEEN(SYSDATE, hiredate)/12) AS "근무연차"
FROM emp;

--35)emp테이블에서 사원이름, 월급, 월급과 커미션을 더한 값을 컬럼명 실급여라고 해서 출력.
--단, NULL값은 나타나지 않게 작성하시오.
SELECT ename, sal, comm, sal + NVL(comm,0) AS 실급여
FROM emp;

SELECT ename, sal, sal + comm AS 실급여
FROM emp
WHERE comm IS NOT NULL AND comm != 0;

--36)월급과 커미션을 합친 금액이 2,000이상인 급여를 받는 사원의 이름,업무,월급,커미션,고용날짜
--를 출력하시오. 단, 고용날짜는 1980-12-17 형태로 출력하시오.
SELECT ename, job, sal, comm, hiredate, to_char(hiredate, 'YYYY-MM-DD') 
FROM emp
WHERE sal + comm >= 2000;

--38)모든 사원의 급여의 최고액, 최저액, 총액 및 평균액을 표시하시오. 열 레이블을 각각
--   maximum,minimum,sum 및 average로 지정하고 결과를 정수로 반올림하고 세자리 단위로
--   ,를 명시하시오.
SELECT  
to_char( MAX(sal), '999,999') as maximum,
to_char( MIN(sal), '999,999') as minimum,
to_char( SUM(sal), '999,999') as sum,
to_char( round( AVG(sal)), '999,999') as average
FROM emp;
--다시 확인

--39) 업무가 동일한 사원 수를 표시하는 질의를 작성하시오.
SELECT job, COUNT(*) 
FROM emp
GROUP BY job;

--40) emp테이블에서 30번부서의 사원수를 구하시오.
SELECT COUNT(*)
FROM emp
WHERE deptno = 30;

--41) emp테이블에서 업무별 최고 월급을 구하고 업무,최고 월급을 출력하시오.
SELECT job, MAX(sal)
FROM emp
GROUP BY job;

--42) emp테이블에서 20번부서의 급여 합계를 구하고 급여 합계 금액을 출력하시오.
SELECT SUM(sal)
FROM emp
WHERE deptno = 20;

--43) emp테이블에서 부서별로 지급되는 총월급에서 금액이 7,000이상인 부서번호, 총월급을
--    출력하시오.
SELECT deptno, SUM(sal)
FROM emp
GROUP BY deptno
HAVING SUM(SAL) >= 7000;

--????????????????????????????
--44) emp테이블에서 업무별로 사번이 제일 늦은 사람을 구하고 그 결과 내에서 사번이 79로 시작하는
--    결과만 보여주시오.
SELECT job, MAX(empno)
FROM emp
GROUP BY job
HAVING MAX(empno) LIKE '79%' ;

--45) emp테이블에서 업무별 총월급을 출력하는데 업무가 'MANAGER'인 사원들은 제외하고 
--    총월급이 5,000보다 큰 업무와 총월급만 출력하시오.
SELECT job, SUM(sal)
FROM emp
WHERE job != 'MANAGER'
GROUP BY job
HAVING  SUM(sal) > 5000;
--
SELECT job, SUM(sal)
FROM emp
GROUP BY job
HAVING (job <> 'MANAGER') AND (SUM(sal) > 5000);

--46)emp테이블에서 업무별로 사원수가 4명 이상인 업무와 인원수를 출력하시오.
SELECT job, COUNT(*)
FROM emp
GROUP BY job
HAVING COUNT(*) >= 4;

--47)emp테이블에서 사원수가 5명이 넘는 부서의 부서번호와 사원수를 구하시오.
SELECT deptno, COUNT(*)
FROM emp
GROUP BY deptno
HAVING COUNT(*) > 5;

--48)emp테이블에서 부서별 급여평균을 구할 때 소수점 3자리에서 반올림해서 2자리까지
--   구하고 부서번호, 급여평균을 출력하시오.
SELECT deptno, ROUND(AVG(sal),2) 
FROM emp
GROUP BY deptno; 