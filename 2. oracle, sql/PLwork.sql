--예제1) 
/*
EVEN_ODD(
    ID:NUMBER(4) 
    GUBUN:VARCHAR2(10)
) 
테이블을 작성하고 START숫자와 END숫자를 입력 받아 그 사이의 숫자를 ID에 저장하고  
ID의 숫자가 짝수이면 GUBUN에 “짝수”를 홀수이면 GUBUN에 “홀수”라고 입력하는 
SCRIPT를 WHILE문으로 작성하여라. st
예) 
START : 1,  END : 10 입력 ->  10개의 ROW가 된다.
*/
SET SERVEROUTPUT ON

CREATE TABLE EVEN_ODD(
    ID NUMBER(4), 
    GUBUN VARCHAR2(10)
);

ACCEPT p_start PROMPT 'start 숫자'
ACCEPT p_end PROMPT 'end 숫자'

DECLARE
    v_start NUMBER(4) := &p_start;
    v_end NUMBER(4) := &p_end;
BEGIN
    IF v_start > v_end THEN
        dbms_output.put_line('start가 end보다 큽니다');
    ELSE 
        WHILE v_start <= v_end LOOP
            IF MOD(v_start, 2) = 0 THEN
                INSERT INTO even_odd(id, gubun)
                VALUES(v_start, '짝수');
            ELSE 
                INSERT INTO even_odd(id, gubun)
                VALUES(v_start, '홀수');
            END IF;
            v_start := v_start + 1;
        END LOOP;
        
        SYS.dbms_output.put_line(&p_start || '로부터 ' || &p_end || '까지 ' 
                                || TO_CHAR(&p_end - &p_start + 1) || '개의 자료가 입력되었습니다');
    END IF;
END;
/
SELECT * FROM even_odd;

--예제2)사원번호를 입력 받으면 다음과 같이 출력되는 PROCEDURE를 작성하라
--     Purchasing 부서명의 사원입니다
CREATE PROCEDURE getDeptName (empno IN NUMBER, dname OUT VARCHAR2)
IS
BEGIN
    SELECT d.department_name INTO dname
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
        AND e.employee_id = empno;
END;
/
-- 하나씩 확인하기
VAR dname VARCHAR2;

EXEC getdeptname(100, :dname); --:확인

PRINT dname;

--예제3)사원번호를 입력받고, 소속부서의 최고, 최저연봉 차액을 파라미터로 출력하는 PROCEDURE를 작성하라.
CREATE PROCEDURE emp_deptTopMoney (empno IN NUMBER, diff OUT NUMBER)
IS
    deptno employees.department_id%TYPE;
BEGIN
    -- 입력된 사원의 부서 조사
    SELECT department_id INTO deptno
    FROM employees
    WHERE employee_id = empno;
    
    -- 최고, 최소의 차액
    SELECT (MAX(salary) - MIN(salary)) INTO diff
    FROM employees
    WHERE department_id = deptno;
END;
/
/*-- 확인 작업
SELECT MAX(salary), MIN(salary) INTO diff
FROM employees
WHERE department_id = 50;
*/
VAR di NUMBER;

ACCEPT p_empno PROMPT '사원번호'
EXEC emp_depttopmoney(&p_empno, :di);
PRINT di;

--------------------------------------------------------------------scott
--예제4) 두 숫자를 제공하면 덧셈을 해서 결과값을 반환하는 함수를 정의하시오.(함수명 add_num)
CREATE FUNCTION add_num(num1 IN INTEGER, num2 INTEGER)
    RETURN INTEGER
IS
BEGIN
    RETURN (num1 + num2);
END;
/

SELECT add_num(12,34) FROM dual;

--예제5) 부서번호를 입력하면 해당 부서에서 근무하는 사원 수를 반환하는 함수를 정의하시오.
--     (함수명 get_emp_count)
CREATE FUNCTION get_emp_count (dept_no IN NUMBER)
    RETURN NUMBER
IS
    v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count
    FROM emp
    WHERE deptno = dept_no
    GROUP BY deptno;
    
    RETURN v_count;
END;
/

VAR count NUMBER; -- count는 변수이름으로 부적합 

EXEC :count := get_emp_count(10);

PRINT count;

--예제6) emp테이블을 이용해서 입사일을 제공하면 근무연차를 구하는 함수를 정의하시오.
--      (소수점 자리 절삭, 함수명 get_info_hiredate)
CREATE FUNCTION get_info_hiredate(hire_date emp.hiredate%TYPE)
    RETURN NUMBER
IS
    v_year NUMBER;
BEGIN
    v_year := TRUNC ( ( MONTHS_BETWEEN(sysdate, hire_date) ) / 12 );
    RETURN v_year;
END;
/
--cf) MONTHS_BETWEEN/12 나누면 년수
SELECT MONTHS_BETWEEN(sysdate, '19/01/23')
from dual;

SELECT ename, get_info_hiredate(hiredate) AS "근무연차"
FROM emp;

--예제7) emp테이블을 이용해서 사원번호를 입력하면 해당 사원의 관리자 이름을 구하는 함수를
--      정의하시오.(함수명 get_mgr_name) - SELF JOIN
CREATE FUNCTION get_mgr_name(emp_no IN INTEGER)
    RETURN VARCHAR2
IS
    mgrname VARCHAR2(20);
BEGIN
    SELECT b.ename INTO mgrname
    FROM emp a, emp b
    WHERE a.mgr = b.empno
        AND a.empno = emp_no;
    
    RETURN mgrname;
END;
/

SELECT ename, get_mgr_name (empno) AS "관리자명"
FROM emp;

--예제8) emp테이블을 이용해서 사원번호를 입력하면 급여 등급을 구하는 함수를 정의하시오.
--4000~5000 A, 3000~4000미만 B, 2000~3000미만 C, 1000~200미만 D, 1000미만 F
-- 함수명 get_sal_grade
DROP FUNCTION get_sal_grade;

CREATE FUNCTION get_sal_grade(emp_no emp.empno%TYPE)
    RETURN VARCHAR2
IS
    sgrade CHAR(1); 
BEGIN
    SELECT
        CASE WHEN sal >= 4000 AND sal <= 5000 THEN 'A'
              WHEN sal >= 3000 AND sal < 4000 THEN 'B'
               WHEN sal >= 2000 AND sal < 3000 THEN 'C'
                WHEN sal >= 1000 AND sal <=2000 THEN 'D'
             ELSE 'F'
        END INTO sgrade
    FROM emp
    WHERE empno = emp_no;
    
    RETURN sgrade;
END;
/
SELECT ename, sal, get_sal_grade(empno) AS "급여 등급"
FROM emp;
