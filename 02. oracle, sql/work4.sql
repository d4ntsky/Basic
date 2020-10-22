--------------------------------------------------------------------SQL4 -hr
--문제1) EMPLOYEES 테이블과 DEPARTMENTS 테이블을 Cartesian Product
--      (모든 가능한 행들의 Join)하여 사원번호,이름,업무,부서번호,부서명,근무지를 출력하여라.
SELECT 
e.employee_id, e.first_name,
e.department_id, d.department_id,
d.department_name, d.location_id
FROM employees e, departments d;

--)ANSI
SELECT 
e.employee_id, e.first_name, e.job_id, 
e.department_id, d.department_id,
d.department_name, d.location_id
FROM employees e CROSS JOIN departments d;

--문제2) EMPLOYEES 테이블에서 사원번호,이름,업무, EMPLOYEES 테이블의 
--      부서번호, DEPARTMENTS 테이블의 부서번호,부서명,근무지를 출력하여라.
SELECT e.employee_id, e.first_name, e.job_id, 
         e.department_id, d.department_id,
           d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;

--cf) ANSI 표준 
SELECT e.employee_id, e.first_name, e.job_id, 
         e.department_id, d.department_id,
           d.department_name, d.location_id
FROM employees e INNER JOIN departments d
    on e.department_id = d.department_id;

--cf)세 개 테이블 조인
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    e.job_id, j.job_id,
    d.department_name, j.job_title
FROM employees e, departments d, jobs j
WHERE e.department_id = d.department_id
    AND e.job_id = j.job_id;

--문제3) Alexander Hunold 의 부서명을 출력하라.
SELECT e.first_name, e.last_name,       
        e.department_id, d.department_id,              
         d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id   -- 조인 시키는 곳
    AND e.first_name = 'Alexander'          
    AND e.last_name = 'Hunold';   

--문제4) 세일즈 부서에서 근무하고 있는 사람들을 출력하라.
SELECT e.first_name,       
        e.department_id, d.department_id,              
         d.department_name
FROM employees e, departments d
WHERE e.department_id  = d.department_id    
    AND d.department_name = 'Sales';
    
--문제5) EMPLOYEES 테이블과 DEPARTMENTS 테이블의 부서번호를 조인하고 
--      SA_MAN 사원만의 사원번호,이름,급여,부서명,근무지를 출력하라. (Alias를 사용) 
SELECT e.job_id, e.employee_id, e.first_name, e.salary,      
        e.department_id, d.department_id,              
         d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id 
    AND e.job_id = 'SA_MAN';
    
--문제6) EMPLOYEES 테이블과 DEPARTMENTS 테이블에서 DEPARTMENTS 
--      테이블에 있는 모든 자료를 사원번호,이름,업무, EMPLOYEES 테이블의 부서번호, 
--      DEPARTMENTS 테이블의 부서번호,부서명,근무지를 출력하여라 (Outer Join) 
SELECT e.employee_id, e.last_name, e.job_id,
        e.department_id, d.department_id,
         d.department_name, d.location_id
FROM departments d, employees e -- 왼쪽이 중심
WHERE d.department_id = e.department_id(+);


SELECT e.employee_id, e.last_name, e.job_id,
        e.department_id, d.department_id,
         d.department_name, d.location_id
FROM employees e Right OUTER JOIN departments d
    ON e.department_id = d.department_id;    
    
--문제7) EMPLOYEES 테이블에서 Self join하여 관리자(매니저)를 출력하여라
SELECT a.first_name || '의 상사는 ' || b.first_name || '입니다'
FROM employees a, employees b    -- a: 사원 b: 상사(사원)
WHERE a.manager_id = b.employee_id; 

--문제8) EMPLOYEES 테이블에서 left join하여 관리자(매니저)를 출력하고 
--      매니저 아이디가 없는 사람은 배제하고 하향식으로 하며, 
--      급여는 역순으로 출력하라. 
SELECT a.employee_id, a.first_name, 
        a.manager_id, b.employee_id,
         b.first_name
FROM employees a, employees b
WHERE a.manager_id = b.employee_id(+)
CONNECT BY a.manager_id = PRIOR a.employee_id
ORDER BY a.salary DESC;

--cf)

SELECT a.employee_id, a.first_name AS "사원명", a.salary, 
        a.manager_id, b.employee_id,
         b.first_name as "상사명"
FROM employees a, employees b
WHERE a.manager_id = b.employee_id(+)
START WITH a.manager_id is not null
CONNECT BY PRIOR a.manager_id = a.employee_id
ORDER BY a.salary DESC;

--문제9) EMPLOYEES 테이블에서 right join하여 
--      관리자(매니저)가 108번 상향식으로 급여는 역순으로 출력하라. 
SELECT a.employee_id, a.first_name AS "사원명", a.salary, 
        a.manager_id, b.employee_id,
         b.first_name as "상사명"
FROM employees a, employees b
WHERE a.manager_id(+) = b.employee_id
    AND a.manager_id = '108'
CONNECT BY PRIOR a.manager_id = a.employee_id
ORDER BY a.salary DESC;

--------------------------------------------------------------------scott4

-- 50) 모든 사원의 이름, 부서번호, 부서이름을 표시하시오.(emp,dept)
SELECT e.ename, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

SELECT e.ename, 
        e.deptno, d.deptno,
         d.dname
FROM emp e FULL OUTER JOIN dept d
    ON e.deptno = d.deptno;
    
--51) 업무가 MANAGER인 사원의 정보를 이름,업무,부서명,근무지 순으로
--    출력하시오.(emp,dept)
SELECT 
e.ename, e.job,
e.deptno, d.deptno,
d.dname, d.loc
FROM emp e, dept d
WHERE e.job = 'MANAGER'
    AND e.deptno = d.deptno;     
    
-- 52) 커미션을 받고 급여가 1,600이상인 사원의 사원이름,부서명,근무지를 출력하시오
SELECT 
e.ename, e.deptno, d.deptno,
d.dname, d.loc
FROM emp e, dept d
WHERE e.comm IS NOT NULL 
    AND e.comm <> 0
    AND e.sal >= 1600
    AND e.deptno = d.deptno;
    
-- 53) 근무지가 CHICAGO인 모든 사원의 이름,업무,부서번호 및 부서이름을 표시하시오.
SELECT 
e.ename, e.job, d.deptno,
d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno   
    AND d.loc = 'CHICAGO';
    
-- 54) 근무지별로 근무하는 사원의 수가 5명 이하인 경우, 인원이 적은 도시순으로 정렬하시오.
-- (근무 인원이 0명인 곳도 표시)
SELECT d.loc, COUNT(e.empno)
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
GROUP BY d.loc
HAVING COUNT(e.empno) <= 5
ORDER BY COUNT(e.empno) ASC;

SELECT d.loc, count(*)
FROM emp e FULL OUTER JOIN dept d
 ON e.deptno = d.deptno 
GROUP BY d.loc
HAVING count(d.loc) <= 5
ORDER BY d.loc;

-- 55) 사원의 이름 및 사원 번호를 관리자의 이름과 관리자 번호와 함께 표시하고 
-- 각각의 열 레이블은 employee, emp#, manager, mgr#로 지정하시오.
SELECT 
a.ename,
a.empno,
b.ename,
b.empno
FROM emp a, emp b
WHERE a.mgr = b.empno;

SELECT 
a.ename as employee, 
a.empno as emp#, 
b.ename as manager,
b.empno as mgr#
FROM emp a, emp b
WHERE a.mgr = b.empno;

-- 56) 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 표시하고 관리자보다 입사일이 빠른 사원을 산출하라.
-- 열 레이블을 각각 employee, emp hired, manager, mgr hired로 지정
SELECT 
a.ename as employee, 
a.empno as emp#, 
a.hiredate as "emp hired",
b.ename as manager,
b.empno as mgr#,
b.hiredate as "mgr hired"
FROM emp a, emp b
WHERE a.mgr = b.empno
 AND a.hiredate < b.hiredate;

-- 57) 사원의 이름 및 사원번호를 관리자의 이름과 관리자 번호와 함께 표시하고 
-- 각각의 열 레이블은 employee, emp#, manager, mgr#로 지정하는데 
-- King을 포함하여 관리자가 없는 모든 사원을 표시하도록 하고 
-- 결과를 사원번호를 기준으로 정렬
SELECT 
a.empno as emp#, 
a.ename as employee, 
a.mgr,
b.empno as mgr#,
b.ename as manager
FROM emp a, emp b
WHERE a.mgr = b.empno(+)
ORDER BY a.empno ASC;

-- 58) 지정한 부서번호, 사원이름 및 지정한 사원과 동일한 부서에서 근무하는 
-- 모든 사원을 표시하도록 질의를 작성하고 
-- 부서번호는 department, 사원이름은 employee, 동일한 부서에서 근무하는 사원은 colleague로 표시하시오.
-- (부서번호, 사원이름,동료 순으로 오름차순 정렬) 
SELECT a.empno, a.ename employee,a.deptno department, b.deptno, b.empno colleague, b.ename
FROM emp a, emp b
WHERE a.deptno = b.deptno
    AND a.empno != b.empno
ORDER BY a.deptno, a.ename, b.ename ASC;

-- 59)10번 부서에서 근무하는 사원들의 
-- 부서번호, 부서이름, 사원이름, 월급, 급여등급을 출력하시오.
SELECT d.deptno, d.dname, e.ename, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno
    AND e.deptno = 10
    AND (e.sal >= s.losal AND e.sal <= s.hisal);
--==AND (e.sal BETWEEN s.losal and s.hisal;
    