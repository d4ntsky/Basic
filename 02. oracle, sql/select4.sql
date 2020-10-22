/*
    JOIN
    두 개 이상의 테이블을 연결해서 데이터를 검색하는 방법이다.
    보통 두 개 이상의 행(row)들의 공통된 값 
    Primary Key(기본 키),Foreign Key(외래 키)값을 사용해서 JOIN(조인)한다.
    
    Primary Key(기본 키): 테이블에서 중복되지 않는 키 ex)ID,주민번호
    Foreign Key(외래 키): 다른 테이블에서 PK,UK(Unique Key)인 경우가 많다
    
    inner      JOIN : 교집합                  *****1
    full outer JOIN : 합집합
    cross      JOIN :
    outer - left/right outer JOIN              ***3
        left   JOIN :
        right  JOIN :
    self       JOIN : 같은 테이블의 데이터를 산출 *****2
*/
-- INNER JOIN (교집합)
 -- 1) Ansi SQL (다른 언어들 통용)
SELECT e.employee_id, e.first_name,       -- 여기서 e. 생략가능
        e.department_id, d.department_id, -- 소속을 맞춘 것/교집합 부분                 
         d.department_name                -- 이 값을 위해 JOIN
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id;
 -- 2) Oracle
SELECT employee_id, first_name,        -- e 한쪽만 있기 떄문에 생략
        e.department_id, d.department_id, -- 환영명                 
         department_name, location_id  -- d 한쪽만 있기 떄문에 생략
FROM employees e, departments d
WHERE e.department_id = d.department_id    -- 여기까지
    AND e.first_name = 'Adam';              -- 값 확인
    
--------------------------------------------------------------------    
-- CROSS JOIN (컬럼 하나하나씩 다 보는) 사용 잘 안함
 -- 1) Ansi SQL 
SELECT e.employee_id, e.first_name,       
        e.department_id, d.department_id,                 
         d.department_name 
FROM employees e CROSS JOIN departments d;
 -- 2) Oracle
SELECT e.employee_id, e.first_name,       
         e.department_id, d.department_id,                 
          d.department_name 
FROM employees e, departments d;

--------------------------------------------------------------------

 -- FULL OUTER JOIN (합집합)
  -- Ansi SQL 방법 밖에 없음  cf)oracle은 union?
SELECT e.employee_id, e.first_name,       
        e.department_id, d.department_id,                 
         d.department_name 
FROM employees e FULL OUTER JOIN departments d
    ON e.department_id = d.department_id;

--------------------------------------------------------------------

-- OUTER JOIN
 -- left, right
  -- 1) Ansi SQL
    -- 1 LEFT
SELECT e.employee_id, e.first_name,       
        e.department_id, d.department_id,                 
         d.department_name 
FROM employees e LEFT OUTER JOIN departments d
    ON e.department_id = d.department_id;
    -- 2 RIGHT
SELECT e.employee_id, e.first_name,       
        e.department_id, d.department_id,                 
         d.department_name 
FROM employees e Right OUTER JOIN departments d
    ON e.department_id = d.department_id;    
    
  -- 2) Oracle
    -- 1 LEFT
SELECT e.employee_id, e.first_name,       
        e.department_id, d.department_id,                 
         d.department_name 
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);     --(+)기호 오른쪽 left outer
    -- 2 RIGHT
SELECT e.employee_id, e.first_name,       
        e.department_id, d.department_id,                 
         d.department_name 
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id;     --(+)기호 왼쪽 right outer

--------------------------------------------------------------------

-- SELF JOIN : 동일한 테이블을 JOIN
SELECT a.employee_id, a.first_name,  --a사원 id, a사원이름
        a.manager_id, b.employee_id, --a사원의 상사, 사원들 중 같은 id
         b.first_name                --a사원의 상사이며 찾아본 것
FROM employees a, employees b   -- a : 사원   b : 상사 
-- 같은 테이블이지만 다른 테이블로 생각
WHERE a.manager_id = b.employee_id; -- a사원의 상사 = 같은 테이블 사원

--------------------------------------------------------------------

-- 계층형 구조 오름, 내림 (ORDER BY가 아닌 연결해서 확인)
--상향식
SELECT a.employee_id, a.first_name AS "사원",
        a.manager_id AS "사원의 상사", a.employee_id,
         b.first_name AS "상사"
FROM employees a, employees b                   -- 사원, 상사
WHERE a.manager_id = b.employee_id(+)
CONNECT BY PRIOR a.manager_id = a.employee_id;   --상향식
--하향식
SELECT a.employee_id, a.first_name AS "사원",
        a.manager_id AS "사원의 상사", a.employee_id,
         b.first_name AS "상사"
FROM employees a, employees b                   -- 사원, 상사
WHERE a.manager_id = b.employee_id(+)
CONNECT BY a.manager_id = PRIOR a.employee_id;   --하향식 
--PRIOR 위치를 통해 어떻게 연결 방향이 달라지나

--------------------------------------------------------------------