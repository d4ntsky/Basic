/*
    script -> block화 -> 함수화
    매개변수, return 값
    
    PROCEDURE   - INSERT, DELETE, UPDATE (FUNCTION에선 INSERT,DELETE,UPDATE가 안 먹힌다)   
    FUNCTION    - SELECT (제일 많다)
    TRIGGER     - 확인용         -> CALLBACK(자동 호출)
    DB에 영향을 주는 건 PROCEDURE            - 수동 호출   - return값이 있을 수도 없을 수도
    DB를 갖고오는 것은  FUNCTION             - 수동 호출   - return값이 반드시 있다.
    용도의 차이가 있다    
 
    FUNCTION의 큰 의미에선 세가지다 포함한다.
*/
SET SERVEROUTPUT ON
--cf)procedure는 ALTER로 못 고침
--1) 매개변수가 없는 것
CREATE PROCEDURE HELLOPROC
IS
    msg VARCHAR2(10);
BEGIN
    msg := 'hello proc';
    
    SYS.dbms_output.put_line(msg || ' 호출되었음');
END;
/
--매개 변수가 없다. 호출된게 아니고 프로시저에 생성만 됐음
EXEC helloproc; -- 호출하는 것

--------------------------------------------------------------------------------------------------------------------------------
-- 매개변수가 있는 것               --varchar2에 바이트 주면 안됨
CREATE PROCEDURE MYPROC(inNum IN NUMBER, outNum OUT NUMBER)
IS
    --선언부
BEGIN
    --
    SYS.dbms_output.put_line('inNum: ' || inNum);
    
    outNum := 333;
END;
/
-- 호출할 때의 변수 선언( 한 줄 씩 실행하기! )
VAR val NUMBER;  -- java -  Integer val;       -- 한 줄씩 실행!
EXECUTE myproc(111, :val);                     -- 한 줄씩 실행!
PRINT val;                                     -- 한 줄씩 실행!

ROLLBACK;

--------------------------------------------------------------------------------------------------------------------------------
-- departments rows 추가
INSERT INTO departments(department_id, department_name, location_id)
VALUES(300, '신규부서', 1400);

-->> PROCEDURE로 만들면
CREATE PROCEDURE add_dept
(p_deptno IN departments.department_id%TYPE,
 p_deptname IN departments.department_name%TYPE,
 p_deptloc IN departments.location_id%TYPE)
IS
BEGIN
    INSERT INTO departments(department_id, department_name, location_id)
    VALUES(p_deptno, p_deptname, p_deptloc);
    
    -- COMMIT;
    
EXCEPTION WHEN OTHERS THEN 
    SYS.dbms_output.put_line('추가에 실패하였습니다');
    
    -- ROLLBACK;
END;
/
EXEC add_dept(300, '신규부서', 2500);   -- 맨 앞에 PK라 중복 추가 불가

SELECT * FROM departments;

ROLLBACK;

--------------------------------------------------------------------------------------------------------------------------------
-- UPDATE SALARY
-- 사원번호를 입력받아 월급을 30%를 인상시키는 PROCEDURE 작성하기
-- 프로시저 이름 updateSal
--CREATE 뒤에 OR REPLACE로 하면 위에 덮어 씌워짐
--V_EMPNO앞에 &필요없다.. 값이 들어오는게 아니기 때문에!!
CREATE PROCEDURE updateSal
(v_empno IN employees.employee_id%TYPE)
IS
BEGIN
    UPDATE employees
    SET salary = salary * 1.3
    WHERE employee_id = v_empno;
    
EXCEPTION WHEN OTHERS THEN 
    SYS.dbms_output.put_line('갱신에 실패하였습니다');
    
END;
/
ACCEPT empno PROMPT '사원번호: '
EXEC updateSal(&empno);   

SELECT * FROM employees;

ROLLBACK;

--------------------------------------------------------------------------------------------------------------------------------
-- SELECT
-- 사원번호를 입력받하면, 이름, 입사일, 사원급여가 출력되는 프로시저를 작성.
CREATE PROCEDURE emp_info(p_empno IN NUMBER)
IS
    v_emp employees%ROWTYPE;
BEGIN
    SELECT first_name, hire_date, salary
        INTO v_emp.first_name, v_emp.hire_date, v_emp.salary
    FROM employees
    WHERE employee_id = p_empno;
    
    SYS.dbms_output.put_line('이름: ' || v_emp.first_name);
    SYS.dbms_output.put_line('입사일: ' || v_emp.hire_date);
    SYS.dbms_output.put_line('급여: ' || v_emp.salary);
END;
/

exec emp_info(100);

--------------------------------------------------------------------------------------------------------------------------------
/*
    Cursor : 저장되는 주소 공간 -> pointer
        암시적 커서  : 자동 생성
            SQL%ROWCOUNT : ROW의 수 == JAVA에서의 SIZE()
            SQL%FOUNT    : ROW의 수가 한 개 이상의 경우
            SQL%NOTFOUNT : ROW의 수가 0 인 경우
        명시적 커서  : 수동 생성
            
*/
 -- 암시적 커서
CREATE PROCEDURE implicit_cursor(p_empname IN employees.first_name%TYPE)
IS
    v_sal employees.salary%TYPE;
    v_update_row NUMBER;            -- 몇 개의 행이 수정되는 지 조사하는 부분의 변수
BEGIN
 /*   -- 검색  cf) row가 한 개 이상이면 에러가 발생한다.
    SELECT salary INTO v_sal
    FROM employees
    -- WHERE first_name = p_empname;
    WHERE first_name = p_empname AND last_name = p_emplastname;
    
    -- 검색 된 데이터(row)가 있는 경우
    IF SQL&FOUND THEN
        dbms_output.put_line('검색된 데이터가 있습니다.');
    END IF;
 */   
    -- 수정
    UPDATE employees
    SET salary = salary * 1.1
    WHERE first_name = p_empname;
    
    v_update_row := SQL%ROWCOUNT;
    SYS.dbms_output.put_line('급여가 인상된 사원 수: ' || v_update_row);
        
EXCEPTION WHEN NO_DATA_FOUND THEN
    SYS.dbms_output.put_line('검색된 데이터가 없습니다.');
END;
/

SELECT * FROM employees
WHERE first_name = 'John';

EXEC implicit_cursor('John');

ROLLBACK;

--------------------------------------------------------------------------------------------------------------------------------
 --명시적 커서   
 --Object(Cursor) 선언 -> fetch(붙이다)
CREATE PROCEDURE expCursor_test(v_deptno IN departments.department_id%TYPE)
IS
    CURSOR dept_avg
    IS
    SELECT 
    d.department_name, COUNT(e.employee_id) CNT, ROUND(AVG(salary), 3) SAL
    --INTO v_dname, emp_cnt, sal_avg; 밑부분으로 감
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
        AND e.department_id = v_deptno                  -- 외부로부터 입력된 부서번호
    GROUP BY d.department_name;
    
    -- CURSOR에 FETCH하기 위한 변수들을 선언
    v_dname departments.department_name%TYPE;
    emp_cnt NUMBER;
    sal_avg NUMBER;   
    
BEGIN
    -- CURSOR OPEN
    OPEN dept_avg;
    -- CURSOR FETCH
    FETCH dept_avg INTO v_dname, emp_cnt, sal_avg;
    
    SYS.dbms_output.put_line('부서명 : ' || v_dname);
    SYS.dbms_output.put_line('사원수 : ' || emp_cnt);
    SYS.dbms_output.put_line('평균월급: ' || sal_avg);
    
    -- CURSOR CLOSE
    CLOSE dept_avg;
END;
/

EXEC expcursor_test(50);

ROLLBACK;