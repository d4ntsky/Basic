--------------------------------------------------------------------SQL5 -hr
--1)EMPLOYEES 테이블에서 (Kochhar의 급여)보다
--  많은 사원의 정보를 사원 번호,이름,담당업무,급여를 출력하라. 
SELECT employee_id, first_name, last_name, job_id, salary
FROM employees
WHERE salary > (SELECT salary
                FROM employees
                WHERE last_name = 'Kochhar');
                
--2)EMPLOYEES 테이블에서 (급여의 평균)보다 적은 사원의 정보를
--  사원번호, 이름,담당업무,급여,부서번호를 출력하여라. 
SELECT employee_id, first_name, last_name, job_id, salary, department_id
FROM employees
WHERE salary < (SELECT AVG(salary)
                FROM employees);

--3)EMPLOYEES 테이블에서 (100번 부서의 최소 급여)보다 최소 급여가 많은 다른 모든 부서를 출력하라 
--  각 부서의 중간값이 100의 최소급여와 비교되서 그 중 최소값
/*SELECT department_id, MIN(salary)
FROM employees
WHERE salary >
                      (SELECT MIN(salary)
                       FROM employees
                       WHERE department_id = 100)
GROUP BY department_id;
*/
--------------------------------------------------------------
-- 각 부서의 최소값과 100의 최소급여와 비교했을때 큰 경우
SELECT department_id, MIN(salary) --묶은 것과 그룹 함수만 표현 가능
FROM employees
GROUP BY department_id
HAVING MIN(salary) > (SELECT MIN(salary)
                      FROM employees   
                      WHERE department_id = 100);
-- 최소급여
/*SELECT department_id, MIN(salary)OVER()--department_id를 적었다면 MIN(salary)OVER()라 쓰고 OVER()는 셀렉트에서만 쓴다..
FROM employees   
WHERE department_id = 100; --==6900*/

--4) (업무별로 최소 급여)를 받는 사원의 정보를 
--   사원번호,이름,업무,부서번호 를 출력하여라. 단 업무별로 정렬하여라(별말 없어서 ASC).
SELECT employee_id, first_name, last_name, job_id, salary
FROM employees
WHERE (job_id, salary) IN (SELECT job_id, MIN(salary)     --최소급여 외에 업무도 나와야함
                           FROM employees
                           GROUP BY job_id)
ORDER BY job_id ASC;
--값이 왜 더 나오는지 생각?
SELECT employee_id, first_name, last_name, job_id,
salary, department_id
FROM employees
WHERE salary > (SELECT MIN(salary)
                FROM employees)
ORDER BY job_id;

--5) EMPLOYEES 과 DEPARTMENTS 테이블에서 업무가 
--   세일즈맨 사원의 정 보를 이름,업무,부서명,근무지를 출력하라. 
--JOIN 문제
SELECT e.first_name, e.job_id, e.department_id, d.department_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id
    AND e.job_id = 'SA_MAN';
--다른 방법 FROM절
SELECT first_name, job_id, e.department_id, d.department_id, d.department_name
FROM (SELECT first_name, job_id, department_id -- 이 서브쿼리는 sa_man에 관한것만
      FROM employees
      WHERE job_id = 'SA_MAN') e, departments d
WHERE e.department_id = d.department_id;

--6)EMPLOYEES 테이블에서 (가장 많은 사원을 갖는 MANAGER)의 사원번호를 출력하라.
--테이블에서 manager가 갖는 사원수 cf)폰번호 고용일 업무 매니저 부서 묶는 경우가  
SELECT manager_id, count(manager_id) --MAX로 잡으면 manager_id가 하나라 에러난다?
FROM employees
GROUP BY manager_id;
--답
SELECT manager_id, COUNT(*) --묶은 것만 볼수 있다..
FROM employees
GROUP BY manager_id
HAVING COUNT(manager_id) = (SELECT MAX(COUNT(*))
                            FROM employees
                            GROUP BY manager_id);
                            
--7)EMPLOYEES  테이블에서 
--  (가장 많은 사원)이 속해있는 부서번호와 사원수를 출력하라. 
SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id
HAVING COUNT(department_id) = (SELECT MAX(COUNT(*))
                               FROM employees
                               GROUP BY department_id);

--8)EMPLOYEES테이블에서 (사원번호가 123인 사원의 직업과 같고)
--  (사원번호가 192인 사원의 급여(SAL)보다 많은) 사원의 
--  사원번호, 이름, 직업, 급여를 출력하라. 
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

--9) 직업(JOB)별로 최소 급여를 받는 사원의 정보를 
--   사원번호, 이름, 업무, 부서명!을 출력하라. 
--   조건1 : 직업별로 내림차순 정렬
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

--직업별로 최소 급여를 받는 사원
SELECT job_id, min(salary)
FROM employees
GROUP BY job_id;
--부서이름 안되는 것
SELECT 
employee_id, first_name,  last_name,  job_id,  department_id
FROM employees
WHERE (job_id, salary) in 
                        (SELECT job_id, min(salary)
                         FROM employees
                         GROUP BY job_id)
order by job_id desc;

--??????????????안한
--10)EMPLOYEES 테이블에서 업무별로 최소 급여를 받는 
--   사원의 정보를 사 원번호,이름,업무,입사일자,급여,부서번호를
--   출력하라
-- 업무별로 최소 급여 받는 사람
SELECT 
job_id, MIN(salary)
FROM employees
GROUP BY job_id;
--답
SELECT 
employee_id, first_name, last_name,
hire_date, salary, department_id
FROM employees
WHERE (job_id, salary) IN 
                   (SELECT job_id, MIN(salary)
                    FROM employees
                    GROUP BY job_id)
;

--11) EMPLOYEES 테이블에서 (50번 부서의 최소 급여)를 
--    받는 사원보다 많은 급여를 받는 사원의 정보를 
--    사원번호,이름,업무,입사일자,급여,부서번호를 출력하라. 
--    단 50번은 제외 
-- 50번 부서의 최소 급여를 받는 사원이 받는 돈 = TJ Olson 2100
SELECT MIN(salary)
FROM employees
WHERE department_id = 50;
--답
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

--13)??????안한
SELECT RNUM, employee_id, first_name, hire_date                   -- 3
FROM(SELECT ROWNUM AS RNUM, employee_id, first_name, hire_date    -- 2
     FROM(SELECT employee_id, first_name, hire_date               -- 1 소팅데이터 만들기
          FROM employees
          ORDER BY hire_date DESC)
     )
WHERE RNUM > 0 AND RNUM <= 20;

/*cf) GROUP BY 쇼핑몰에서 상품이라치면 어느 쪽 용품/상품이 많이 팔리나(소속을 묶
               주식 종목들이 선박 쪽이냐 IT냐 그런걸로 소속 묶                */
               
--------------------------------------------------------------------scott5 
/*
37)DECODE 또는 CASE WHEN THEN 함수를 사용하여 다음 데이터에 따라 JOB열의 값을 기준으로
모든 사원의 등급을 표시하시오.

업무        등급
PRESIDENT   A
ANALYST     B
MANAGER     C
SALESMAN    D
CLERK       E
기타         0
*/
SELECT ename, job,
    CASE SUBSTR(job,1)                  --== CASE job WHEN
        WHEN 'PRESIDENT'   THEN 'A'
        WHEN 'ANALYST'     THEN 'B'
        WHEN 'MANAGER'     THEN 'C'
        WHEN 'SALESMAN'    THEN 'D'
        WHEN 'CLERK'       THEN 'E'
        ELSE '기타'
    END AS "등급"
FROM emp
ORDER BY "등급";
--==
SELECT ename, job,
    DECODE( SUBSTR(job,1) , -- == DECODE(job, 'PRESI
    'PRESIDENT',   'A',
    'ANALYST',     'B',
    'MANAGER',     'C',
    'SALESMAN',    'D',
    'CLERK',       'E',
    '기타') AS "등급"
FROM emp
ORDER BY "등급";

-- 60) (BLAKE와 같은 부서)에 있는 사원들의 이름과 입사일을 구하는데 
-- BLAKE는 제외하고 출력하시오.(BLAKE가 여러명일 수 있음)
SELECT ename, hiredate
FROM emp
WHERE deptno IN (SELECT deptno
                 FROM emp
                 WHERE ename = 'BLAKE')
    AND ename != 'BLAKE';

-- 61) 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을 출력하는데 
-- 월급이 높은 사람순으로 출력하시오.
SELECT empno, ename, sal
FROM emp
WHERE sal >   (SELECT AVG(sal)
               FROM emp)
ORDER BY sal DESC;

-- 62) (10번부서에서 급여를 가장 적게 받는 사원과 동일한 급여)를 받는 사원의 이름을 출력하시오.
SELECT *
FROM emp
WHERE sal = (SELECT MIN(sal)
             FROM emp
             WHERE deptno = 10);

-- 63) 사원수가 3명이 넘는 부서의 부서명과 사원수를 출력하시오.
SELECT d.dname, COUNT(e.empno)
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY d.dname
HAVING COUNT(e.empno) > 3;

-- 64) 사원번호가 7844인 사원보다 빨리 입사한 사원의 이름과 입사일을 출력하시오.
SELECT ename, hiredate
FROM emp
WHERE hiredate < (SELECT hiredate
                  FROM emp
                  WHERE empno = 7844);

-- 65) (직속상사(mgr)가 KING)인 모든 사원의 이름과 급여를 출력하시오.
SELECT ename, sal, mgr
FROM emp
WHERE mgr = (SELECT empno
             FROM emp
             WHERE ename = 'KING');

-- 66) (20번 부서에서 가장 급여를 많이 받는 사원과 동일한 급여)를 받는 
-- 사원의 이름과 부서명,급여, 급여등급을 출력하시오.(emp, dept, salgrade)  
-- JOIN emp와 dept (JOIN테이블) / salgrade(비교테이블)
SELECT e.ename, d.dname, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE sal = (SELECT MAX(sal)
             FROM emp
             WHERE deptno = 20)
    AND e.deptno = d.deptno
    AND sal BETWEEN s.losal AND s.hisal;
--==AND sal >= s.losal AND sal <= s.hisal;

--67) (총급여sal+comm가 평균 급여)보다 많은 급여를 받는 사람의 부서번호, 이름, 총급여, 
--    커미션을 출력하시오.(커미션은 유(O),무(X)로 표시하고 컬럼명은 "comm유무" 출력)
SELECT deptno, ename, sal+NVL(comm, 0), NVL(comm, 0), NVL2(comm, 'o', 'x'), NVL2(comm, '있음', '없음') 
FROM emp
WHERE sal + NVL(comm, 0) > (SELECT AVG(sal)
                            FROM emp);
/*
    NVL  (컬럼, 컬럼이 NULL인 경우 설정할 값)
    NVL2 (컬럼, 컬럼이 NULL인 아닐 경우 설정할 값, 컬럼이 NULL인 경우 설정할 값)      cf) 삼항 연산자
*/                          

-- 68) (CHICAGO 지역에서 근무하는 사원의 평균 급여)보다 높은 급여를 받는 사원의 이름과 급여,
--     지역명을 출력하시오. 좋은 문제!
SELECT e.ename, sal, d.loc                             
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND sal > (SELECT AVG(sal)             --3. 비교    --2. 평균급여
               FROM emp
               WHERE deptno = (SELECT deptno           --1. 지역 번호
                               FROM dept
                               WHERE loc = 'CHICAGO'));

-- 확인???????????????
-- 69) (업무가 SALESMAN인 직원이 2명 이상)인 부서의 이름, 근무하는 사원의 이름, 업무를 출력
--    하시오.(컬럼명은 부서명, 사원명, 업무로 출력)
SELECT d.dname, e.ename, e.job
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND e.deptno IN (SELECT deptno
                    FROM emp
                    WHERE job = 'SALESMAN'
                    GROUP BY deptno
                    HAVING COUNT(job) >= 2);

-- 70) (커미션이 없는 사원들) 중 월급이 가장 높은 사원의 이름과 급여등급을 출력하시오.
SELECT e.ename, s.grade
FROM emp e, salgrade s
WHERE sal = (SELECT MAX(sal)
             FROM emp
             WHERE comm IS NULL 
                OR comm = 0)
    AND sal BETWEEN s.losal AND s.hisal;

-- 71) SMITH의 관리자의 이름과 부서명, 근무지역을 출력하시오. 
SELECT e.ename, d.dname, d.loc
FROM  emp e, dept d
WHERE e.deptno = d.deptno
    AND e.empno = (SELECT mgr
                   FROM emp
                   WHERE ename = 'SMITH');
