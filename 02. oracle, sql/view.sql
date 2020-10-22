/*
    View : 가상 Table
        실체가 없는 테이블, 다른 테이블을 접근하기 위한 테이블
             Table <------------------- View ------------------- User
        장점: 1. 한 개의 테이블로 여러 개의 Table을 검색할 수 있다.
             2. 속도가 빠르다
             3. 제한 설정이 가능하다. --> Read Only
*/
--VIEW 생성
CREATE VIEW UB_TEST_01(JOB_ID, JOB_TITLE, MIN_SALARY)
AS
SELECT job_id, job_title, min_salary 
FROM jobs;
--VIEW를 보기
SELECT * FROM ub_test_01;   --vie를 통해서 검색
--실질적 입력해보기
INSERT INTO ub_test_01(JOB_ID, JOB_TITLE, MIN_SALARY) -- 여기 () 생략가능
VALUES('DEVELOPER', '개발자', 10000);  -- 
--확인
SELECT * FROM jobs;

ROLLBACK;  -- 작업 되돌리기
COMMIT;    -- 적용 : 커밋된 다음 롤백은 안됨
----------------------------------------------------------------------------
--테이블 만들기
CREATE TABLE TB_EMP
AS
SELECT employee_id, first_name, salary
FROM employees;
--중간 창문 만들기
CREATE VIEW UB_VIEW(employee_id, first_name, salary)
AS
SELECT employee_id, first_name, salary
FROM TB_EMP;
--데이터 넣기
INSERT INTO ub_view
VALUES(100, '홍길동', 10000);   -- 들어가는 곳은 TB_EMP
INSERT INTO ub_view
VALUES(101, '일지매', 9000);

SELECT * FROM TB_EMP;
SELECT * FROM UB_VIEW;

--Read Only
CREATE OR REPLACE VIEW DEPTVIEW(
    "부서번호",
    "부서명",
    "지역명"
    )
AS 
SELECT department_id, department_name, location_id
FROM departments
WITH READ ONLY; -- 읽기 전용
--읽기 전용에 값 넣어보면 오류나는
INSERT INTO DEPTVIEW("부서번호", "부서명", "지역명")
VALUES(280, '기획부', 1700);
SELECT * FROM deptview;
----------------------------------------------------------------------------
CREATE OR REPLACE VIEW DEPT_EMP_VIEW(empno, name, deptno, deptname, loc)
AS
SELECT e.employee_id, e.first_name, d.department_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id
WITH READ ONLY;

SELECT name, deptname
FROM dept_emp_view
WHERE name = 'Den';

SELECT
    *
FROM dept_tmp_view;
rollback;