/*  SUB Query
 Query 안의 Query
 한개의 행(row)에서 결과 값이 반환되는 Query
                                cf) SUB QUERY는 원하는 값에 데이터를 모두 출력 가능한 장점이 있다.

    SELECT  단일 ROW 단일 COLUMN (산출되는 데이터가 반드시 한개, 컬럼도 한개) cf)그룹함수 데이터가 한 개
    FROM    다중 ROW 다중 COLUMN 
    WHERE   다중 ROW 다중 COLUMN (가장 빈도 높이 사용되는 곳)
*/

-- SELECT
SELECT employee_id, first_name,
        (SELECT salary
         FROM employees 
         WHERE employee_id = 100),          --<데이터 하나
     /* (SELECT salary, first_name          < 오류(컬럼이 하나)
         FROM employees 
         WHERE employee_id = 100) */
        (SELECT COUNT(*) FROM employees)
FROM employees;

-- FROM
SELECT employee_id, first_name                          -- 2
FROM (SELECT employee_id, first_name, last_name         -- 1   SUB QUERY 1 중 2를 찾을 수 있는 범위여야  
      FROM employees
      WHERE department_id = 20);
-- 부서번호 50번, 급여가 6000이상인 사원
SELECT employee_id, salary                  
FROM employees
WHERE department_id = 50
      AND salary >= 6000;
--== 컬럼이 종류가 다름
SELECT e.employee_id, e.salary
FROM (SELECT employee_id, salary
      FROM employees
      WHERE department_id = 50) e
WHERE salary >= 6000;
--ex) 급여의 합계, 인원수, 사원명, 월급 --인원수는 그룹함수여야...
SELECT job_id, COUNT(*) --,first_name 에러남 그룹으로 묶어놓았기 때문에
FROM employees
GROUP BY job_id;
--ex) 가능하게
SELECT e.employee_id, e.salary,
        e.job_id, j.job_id,             -- 확인 작업
         j."급여합계", j."인원수"
FROM employees e, (SELECT job_id, SUM(salary) AS "급여합계", COUNT(*) AS "인원수"
                   FROM employees
                   GROUP BY job_id) j   --여기까지면 CROSS JOIN
WHERE e.job_id = j.job_id;              --INNER JOIN

-- WHERE
--평균보다 많이 받는 사람
SELECT first_name, salary   
FROM employees
WHERE salary > (SELECT AVG(salary)
                FROM employees);   -- 조건 안의 조건
--department_id 90의 job_id만 산출
SELECT job_id, first_name, department_id
FROM employees
WHERE job_id IN(SELECT job_id
                FROM employees
                WHERE department_id = 90);
--부서별 가장 급여를 적게 받는 사원과 같은 급여를 받는 사원     -- 부서별로 그룹화한 최소 급여를 SUB QUERY로 급여를 기준으로 사원을
SELECT first_name, salary, department_id
FROM employees
WHERE salary IN (SELECT MIN(salary)       -- IN =가 두개 이상  
                 FROM employees
                 GROUP BY department_id) -- 다중 row
ORDER BY department_id ASC;
--부서별 가장 급여를 적게 받는 사원과 급여                    -- 부서별로 그룹화한 부서와 최소급여를 SUB QUERY로 부서와 급여를 기준으로 사원을
SELECT department_id, first_name, salary
FROM employees
WHERE (department_id, salary) IN (SELECT department_id, MIN(salary)
                                  FROM employees
                                  GROUP BY department_id)
ORDER BY department_id ASC;