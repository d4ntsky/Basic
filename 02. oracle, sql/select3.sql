-- ORDER BY : SORTING
/*
    SELECT *
    FROM TABLE명
    ORDER BY sal ASC        -- 오름차순  cf)ASC는 생략가능 그러나 명시
    ORDER BY sal DESC       -- 내림차순  cf)그냥 DESC 컬럼 상세
cf)scott  emp
   hr     employees
*/
SELECT ename, sal -- cf)대소문자로 구분
FROM emp 
ORDER BY sal ASC;

SELECT ename, sal
FROM emp
ORDER BY sal DESC;

-- alias 로 sorting
SELECT empno, ename, sal * 12 AS annsal
FROM emp
ORDER BY annsal DESC;

SELECT ename, comm
FROM emp
ORDER BY comm NULLS FIRST; -- null값을 맨위로 하고싶을때
             --내림차순 NULLS 앞에 DESC NULLS FIRST

SELECT ename, comm
FROM emp
ORDER BY comm NULLS LAST;

SELECT employee_id, job_id, salary
FROM employees
ORDER BY job_id ASC, salary DESC;   -- 여러차례 sorting 가능 왼쪽것부터

--------------------------------------------------------------------

-- MONTHS_BETWEEN   : 두 날짜 간의 월 수 (월 간격)
SELECT MONTHS_BETWEEN('2020-12-13','2020-05-04') -- 앞이 기준점
FROM dual;

-- ADD_MONTHS       : 특정날짜 월에 정수를 더한 후 해당날짜 반환
SELECT ADD_MONTHS('2020-06-19', 3)
FROM dual;

-- 날짜정보에서 특정한 년, 월, 일, 시, 분, 초 (SYSDATE)
SELECT sysdate
FROM dual;

-- 년,월,일 /(토큰) 잘라서 가져오는
SELECT EXTRACT(year FROM TO_DATE('19900619', 'YYMMDD')) AS 년,
        EXTRACT(month FROM TO_DATE('200319', 'YYMMDD')) AS 월,
         EXTRACT(day FROM TO_DATE('200601', 'YYMMDD')) AS 일1,
          EXTRACT(day FROM SYSDATE) AS 일2
FROM dual;
-- 시,분,초
SELECT 
EXTRACT(hour FROM CAST(TO_DATE(SYSDATE, 'YYYY-MM-DD HH:MI:SS')AS TIMESTAMP)) AS 시1,
EXTRACT(hour FROM SYSTIMESTAMP) AS 시2,
EXTRACT(hour FROM CAST(SYSDATE AS TIMESTAMP)) AS 시3,   
EXTRACT(minute FROM CAST(SYSDATE AS TIMESTAMP)) AS 분,
EXTRACT(second FROM CAST(SYSDATE AS TIMESTAMP)) AS 초
FROM dual;

SELECT
EXTRACT(hour FROM CAST(datetime AS TIMESTAMP)) AS 시,   
EXTRACT(minute FROM CAST(datetime AS TIMESTAMP)) AS 분,
EXTRACT(second FROM CAST(datetime AS TIMESTAMP)) AS 초
FROM (SELECT 
        TO_DATE('2020-06-19 13:33:03', 'YYYY-MM-DD HH24:MI:SS')
        AS datetime FROM dual);                 --ex) 경매사이트/예매
        
--------------------------------------------------------------------

-- 그룹으로 묶는 기능
-- DISTINCT ex)
--1)
SELECT DISTINCT department_id
FROM employees
ORDER BY department_id ASC;

-- GROUP BY  통계로 많이쓰임/DISTINCT보다 빈도 높음
-- HAVING : 조건절 job_id,department_id cf)having은 group by와 함께
--==1)
SELECT department_id
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;
-- 개개인으로는 묶지못함
/* 오류남,출력안됨 employee_id 때문에
SELECT department_id, employee_id 
FROM employees
GROUP BY department_id
ORDER BY department_id ASC;*/

-- 통계
-- GROUP함수/COUNT/SUM/AVG/MAX/MIN
-- ex)이 부서의 월급 합계   
SELECT 
COUNT(salary), COUNT(*),
SUM(salary), 
AVG(salary),
MAX(salary),
MIN(salary)
FROM employees
WHERE job_id = 'IT_PROG'; 

SELECT job_id,
COUNT(salary), COUNT(*),
SUM(salary), 
AVG(salary),
MAX(salary),
MIN(salary)
FROM employees
GROUP BY job_id;

-- HAVING - 반드시 GROUP BY와 같이 사용. 단독 사용 불가
SELECT job_id, SUM(salary)
FROM employees
GROUP BY job_id
HAVING SUM(salary) >= 100000;

-- 예제) 
-- 급여가 5000 이상 받는 사원만으로 합계를 내서 
-- 업무(job_id)로 그룹화하여 급여의 합계가 20000을 초과하는 업무명을 구하라.
SELECT job_id, SUM(salary)
FROM employees
WHERE salary >= 5000
GROUP BY job_id  -- GROUP BY 때문에 SELECT가 한정적(묶은그룹이나 그룹함수만)
HAVING SUM(salary) > 20000;