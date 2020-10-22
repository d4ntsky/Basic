--  특수 Query

-- CASE = SWITCH
SELECT employee_id, first_name, phone_number,
    CASE SUBSTR(phone_number, 1, 3)
        WHEN '515' THEN '서울'
        WHEN '590' THEN '부산'
        WHEN '659' THEN '광주'
        WHEN '603' THEN '대전'
        ELSE '기타'
    END AS "지역"
FROM employees;
--==
SELECT employee_id, first_name, phone_number,
    CASE  
        WHEN SUBSTR(phone_number, 1, 3) = '515' THEN '서울'
        WHEN SUBSTR(phone_number, 1, 3) = '590' THEN '부산'
        WHEN SUBSTR(phone_number, 1, 3) = '659' THEN '광주'
        WHEN SUBSTR(phone_number, 1, 3) = '603' THEN '대전'
        ELSE '기타'
    END AS "지역"
FROM employees;

-- DECODE
SELECT employee_id, first_name, phone_number,
    DECODE( SUBSTR(phone_number, 1, 3),
            '515','서울',
            '590','부산',
            '659','광주',
            '603','대전',
            '기타') AS "지역"
FROM employees;

/*  집합
    합집합 : UNION
    교집합 : INTERSECT
    차집합 : MINUS         */

-- UNION
SELECT job_id
FROM employees
WHERE job_id IN ('AD_VP', 'FI_ACCOUNT')
UNION ALL -- ALL 빠지면?
SELECT job_id
FROM jobs
WHERE job_id IN ('AD_VP', 'FI_ACCOUNT');

-- INTERSECT
SELECT employee_id
FROM employees
INTERSECT
SELECT manager_id
FROM employees;
--비스무리한...
--JOIN self
SELECT DISTINCT b.employee_id
FROM employees a, employees b
WHERE a.manager_id = b.employee_id;

-- MINUS
--매니저가 아닌 사원
SELECT employee_id
FROM employees
MINUS
SELECT manager_id
FROM employees;
--차집합을 JOIN으로
SELECT e.first_name,
        e.department_id, d.department_id
FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
    AND e.department_id IS NULL;
    
/* OVER() 함수                빈도 높다
 SELECT 절에서만 사용!!
 GROUP BY를 보완/보강하기 위해서 나온 함수  */
/*
SELECT department_id, COUNT(*)
FROM employees;                   */         --에러남
--1)
SELECT department_id, COUNT(*)
FROM employees
GROUP BY department_id;
--2)
SELECT department_id, COUNT(*)OVER()
FROM employees; 
--3)
SELECT department_id, COUNT(department_id) OVER()
FROM employees; 
--4)
SELECT department_id, COUNT(DISTINCT department_id) OVER()
FROM employees; 
--5)
-- PARTITION BY == GROUP BY         제약
SELECT department_name,
    COUNT(*)OVER(PARTITION BY department_id)
FROM departments;
--6)
SELECT department_id, first_name, salary,
    COUNT(*)OVER(PARTITION BY department_id)
FROM employees;

-- COUNT(*)OVER()                 : 전체 행수를 반환
-- COUNT(*)OVER(PARTITION BY 컬럼) : 컬럼을 그룹으로 나눠 ROW의 수를 반환       --달력을 통한 일정관리에 사용  
    
-- 분석 함수 - 활용도 넓은
/*  순위 함수
    RANK()              1 2 3 3 5 6
    DENSE_RANK()        1 2 3 3 4 5
    ROW_NUMBER()        1 2 3 4 5 6
    ROWNUM                  cf) 함수가 아니다
    
    -- EMPLOYEES -> 월급 TOP10
*/
--cf)
SELECT employee_id, first_name
FROM employees
WHERE employee_id >= 100 and employee_id <= 109;

SELECT first_name, salary,
    RANK      ()OVER(ORDER BY salary DESC) AS RANK,         -- 
    DENSE_RANK()OVER(ORDER BY salary DESC) AS DENSE_RANK,   -- 
    ROW_NUMBER()OVER(ORDER BY salary DESC) AS ROW_NUMBER    --
FROM employees;

-- ROWNUM 단순 사용
SELECT ROWNUM, employee_id, first_name
FROM employees
WHERE ROWNUM <= 10; -- 이 부분이 가장 먼저 수행됨
--10보다 크고 20보다 작을 시
SELECT employee_id, first_name      --2
FROM employees
WHERE ROWNUM > 10 AND ROWNUM <= 20; --1 이건 수행 안됨
/*  1. DATA 선정      ex)(급여 순위) = 정렬
    2. ROWNUM 설정
    3. 범위를 설정   */
SELECT RNUM, employee_id, first_name, salary                   -- 3
FROM(SELECT ROWNUM AS RNUM, employee_id, first_name, salary    -- 2
     FROM(SELECT employee_id, first_name, salary               -- 1 소팅데이터 만들기
          FROM employees
          ORDER BY salary DESC)
     )
WHERE RNUM > 0 AND RNUM <= 10;

/*  SELECT절
        SELECT       컬럼, 표준함수, 그룹함수, SUB QUERY, OVER(), PARTITION BY
        FROM         테이블, SUB QUERY
        [WHERE]      조건 IN AND ANY ALL LIKE < > <> <= >< != = SUB QUERY
        [GROUP BY]   컬럼         --관리 목적으로 많이 사용
        [HAVING]     그룹핑의 조건
        [ORDER BY]   칼럼 ASC/DESC
        [START BY]   계층형
        [CONNECT BY] 연결형 PRIOR (상향, 하향)
    
    JOIN
        INNER,
        FULL OUTER
        CROSS
        OUTER (LEFT, RIGHT)
        SELF
*/