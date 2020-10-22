 -- WHERE절 == if == 조건절
/*
    표현식
    비교 연산자 (>,<,>=,<=,=,!=,<>) !=와 <> 같은 의미
    NULL, IS NULL, IS NOT NULL
    ( ), NOT, AND(&&), OR(||)
    
    Query
    
    SELECT
    FROM
    WHERE 조건
*/
-- first_name = 'Julia';
SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'Julia'; --대소문자 명확히 가림
--WHERE first_name = 'julia';

-- 급여가 $9000 이상인 사원
SELECT first_name, salary
FROM employees
WHERE salary >= 9000;

-- 이름이 Shanta 보다 큰 이름 (Ascii코드 기준)
SELECT first_name
FROM employees
WHERE first_name >= 'Shanta';

SELECT first_name
FROM employees
WHERE first_name >= 'a'; --ASCII코드값 97
--대문자로 이름들이 되어있기 때문에 값은 없다
--------------------------------------------------------------------
SELECT first_name, last_name
FROM employees
WHERE manager_id = ''; --되지 않는다.
--------------------------------------------------------------------
SELECT first_name, last_name
FROM employees
WHERE manager_id IS NULL;       --스티븐 킹만 나옴

SELECT first_name, last_name
FROM employees
WHERE manager_id IS NOT NULL;   --스티븐 킹을 제외한 모든 게 나옴
--------------------------------------------------------------------
-- AND
SELECT first_name, last_name
FROM employees
WHERE first_name = 'Shanta'
    AND last_name = 'Vollman';
    
-- OR
SELECT first_name, last_name
FROM employees
WHERE first_name = 'Shanta'
    OR first_name = 'John';
    
--이름 John, 월급 5000 이상
SELECT first_name, salary
FROM employees
WHERE first_name = 'John'   --3명
    AND salary >= 5000;     --2명

--2007년 12월 31일 이후에 입사한 사원을 출력
SELECT first_name, hire_date
FROM employees
WHERE hire_date > '07/12/31';                       -- 이게 정석

SELECT first_name, hire_date
FROM employees
WHERE hire_date > TO_DATE('20071231' , 'YYYYMMDD'); 
--------------------------------------------------------------------
-- ALL(AND), ANY(OR)   -- 잘 안쓰는 편
SELECT *
FROM employees
WHERE first_name = ALL('Julia', 'John'); --AND절보다 간결
    -- WHERE first_name = 'Shanta' AND first_name = 'John';
SELECT *
FROM employees
WHERE first_name = ANY('Julia', 'John'); 
    -- WHERE first_name = 'Shanta' OR first_name = 'John';
--cf)활용법
SELECT first_name, salary
FROM employees
WHERE salary = ANY(8000, 3200, 6000);
--------------------------------------------------------------------
-- IN, NOT IN  딱 정해진 상수값
SELECT first_name, salary
FROM employees
WHERE salary IN(8000, 3200);     -- 이 금액만

SELECT first_name, salary
FROM employees
WHERE salary NOT IN(8000, 3200); -- 이 금액을 제외한

SELECT *
FROM employees
WHERE first_name IN('Julia', 'John'); -- 이 이름만
--------------------------------------------------------------------
-- BETWEEN 범위 연산자
SELECT first_name, salary
FROM employees
    WHERE salary BETWEEN 3200 AND 9000;
--==WHERE salary >= 3200 AND salary <= 9000; 

SELECT first_name, salary
FROM employees
    WHERE salary NOT BETWEEN 3200 AND 9000;
--==WHERE salary < 3200 OR salary > 9000;
--------------------------------------------------------------------
--LIKE 중요도 높은편 ex)게시판 검색할 떄
SELECT first_name
FROM employees
WHERE first_name LIKE 'G_ra_d'; -- _ 한글자가 무엇이든지 허용

SELECT first_name
FROM employees
WHERE first_name LIKE 'K%y';    -- % 글자 수에 관계없이 모두 사용
--활용법
SELECT first_name
FROM employees
WHERE first_name LIKE 'A%';     -- A로 시작
--WHERE first_name LIKE '%y';     -- 맨뒤가 y 
--WHERE first_name LIKE '%e%';    -- e라는 문자 포함

SELECT first_name, hire_date
FROM employees
  WHERE hire_date > '05/12/31' AND hire_date < '06/02/01'; 
--==
SELECT first_name, hire_date
FROM employees
  WHERE hire_date LIKE '06/01%'; 
  
SELECT first_name, phone_number
FROM employees
  WHERE phone_number LIKE '590%';  
  