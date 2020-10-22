/*
    PL/SQL
    Procedural == 처리자   Extension == 확장
    Process 처리하다 -> Procedure 처리자
    SQL을 확장한 순차적 언어 -> Procedure, Function, Trigger
        Procedure : in을 하면 out값이 없어도 됨      insert/delete/update
        Function  : in을 하면 out값 반드시 존재      select
        Trigger   : 자동 호출, 데이터가 있냐 없냐만 
    제어문 : if, while, for
        + Script
           구조
             1. 선언부    : 변수, 상수, 초기화
             2. 실행부    : 실제로 처리할 Queary 부분이나 제어문을 활용해서 처리하는 부분
             3. 예외처리부 : 각종 오류 처리
cf)pl의 목적 함수화?
*/
SET SERVEROUTPUT ON -- CONSOLE에 출력은 ON
BEGIN
   
    dbms_output.put_line('Hello PL');
END; --BEGIN 부분에서 실행문
/


SET SERVEROUTPUT OFF

DECLARE     --선언부
    message VARCHAR2(10);                                  -- STRING message
   
BEGIN       --실행부                                        
    message := 'hello pl';                                 -- message = "hello pl"
    SYS.dbms_output.put_line('message = '|| message);
    
                                                           -- 예외처리
END;
/

-- IF
DECLARE
    counter INTEGER;
BEGIN
    counter := 1;
    counter := counter + 1;
    
    IF counter IS NULL THEN  -- 변수도 오브젝트 (이조건이 참이였을때) ex) 조건을 나눠서 쿼리문 내보낼때
        dbms_output.put_line('result: counter is null');
    ELSE 
        dbms_output.put_line('result: counter is NOT null');
    END IF;
END;
/

-- FOR
DECLARE
    counter INTEGER;
    i INTEGER;

BEGIN

    FOR i IN 1..9 LOOP
        SYS.dbms_output.put_line('i = ' || i);
        counter := i * 2;
        SYS.dbms_output.put_line('2 * ' || i || ' = ' || counter);
    END LOOP;
END;
/

-- LOOP
DECLARE
    v_count NUMBER := 0;       -- 실행과 함께 초기화
    v_total NUMBER := 0;
BEGIN
    LOOP
        EXIT WHEN v_count = 10;
        
        v_count := v_count + 1;
        v_total := v_total + v_count;
    END LOOP;
    
    SYS.dbms_output.put_line('v_total = ' || v_total);
END;
/

-- while
DECLARE
    v_count NUMBER := 0;      
BEGIN
    
    WHILE v_count < 10 
    LOOP
        v_count := v_count + 1;
        SYS.dbms_output.put_line('v_count = ' || v_count);
    END LOOP;
END;
/

-- GOTO
DECLARE
    v_name VARCHAR2(10) := 'LEE';
    v_case NUMBER := 0;
BEGIN
    CASE WHEN MOD(v_case, 2) = 0 THEN
            GOTO test1;
         WHEN MOD(v_case, 2) = 1 THEN
            GOTO test2;
         ELSE
            GOTO err;
    END CASE;
<<test1>>
    SYS.dbms_output.put_line(v_name || ' is woman');
    GOTO sub_end;
<<test2>>
    SYS.dbms_output.put_line(v_name || ' is man');
    GOTO sub_end;
<<err>>
    SYS.dbms_output.put_line('ERROR');
<<sub_end>>
    SYS.dbms_output.put_line('Exit'); -- 다시 거쳐가기 때문에 일로 오게
    
END;
/

-- 예외처리부        1/0 분모가 0
DECLARE
    counter INTEGER;
BEGIN
    counter := 1;
    counter := counter / 0;

EXCEPTION WHEN OTHERS THEN
    SYS.dbms_output.put_line('예외가 발생하였습니다.');
END;
/

-- varray : Variable Array
DECLARE     --cf)타입은 예약어
    TYPE varray_test IS VARRAY(3) OF INTEGER;   -- 자바에선 int varray_test = new int[3];   -- 이 줄은 new int[3];  
    vArr varray_test;    -- 실제 배열변수                                                     -- 이 줄은 int varray_test = 
BEGIN
    vArr := varray_test(11, 22, 33);
    -- vArr[0] 자바 문법 vArr(0) 여기 문법
    SYS.dbms_output.put_line('vArr(1) = ' || vArr(1));
END;
/

-- ACCEPT 메세지 박스
ACCEPT p_deptno PROMPT '부서번호를 입력하시오(급여의 합)'

DECLARE
    v_salTotal NUMBER;
BEGIN
    SELECT SUM(salary) INTO v_salTotal          --select는 output
    FROM employees
    WHERE department_id = &p_deptno;            --&&&&&&&&&&&&&&& 외부에서
    
    SYS.dbms_output.put_line(&p_deptno || '번 부서 급여의 합은 ' || TO_CHAR(v_salTotal,'$999,999,999') || '입니다');

END;
/

-- 사원번호를 입력받고 그 사원의 급여에 1000을 더한 값으로 갱신(UPDATE)하라
-- 사원번호와 갱신된 급여를 출력하라.
ACCEPT p_empno PROMPT '사원 번호를 입력하세요'

DECLARE
    -- v_sal NUMBER(8,2) := 1000; byte나 자릿수를 찾아서 맞추기 힘드니까
    v_sal EMPLOYEES.salary%TYPE := 1000;
    v_salTotal NUMBER;
 
BEGIN
    -- 확인용
    SELECT salary INTO v_salTotal
    FROM employees
    WHERE employee_id = &p_empno;
    SYS.dbms_output.put_line(&p_empno || '번 사원의 급여: ' || v_salTotal);
    
    -- 갱신후
    UPDATE employees
    SET salary = salary + v_sal
    WHERE employee_id = &p_empno;
    -- 갱신 후 결과
    SELECT salary INTO v_salTotal
    FROM employees
    WHERE employee_id = &p_empno;
    SYS.dbms_output.put_line(&p_empno || '번 사원의 갱신 후 급여: ' || v_salTotal);
END;
/

--예제1) 사원번호를 입력 받고 그 사원의 급여에 세금을 출력하라(세금은 5%로 가정한다)
ACCEPT in_empno PROMPT '사원 번호를 입력하세요'

DECLARE
      -- TYPE 맞춰주기
    v_tax NUMBER;
BEGIN
    -- 확인용
    SELECT salary INTO v_tax
    FROM employees
    WHERE employee_id = &in_empno;
    SYS.dbms_output.put_line(&in_empno || '번 사원의 급여: ' || v_tax);
    
    -- 갱신후
    UPDATE employees
    SET salary = salary * 0.05
    WHERE employee_id = &in_empno;
    -- 갱신 후 결과
    SELECT salary INTO v_tax
    FROM employees
    WHERE employee_id = &in_empno;
    SYS.dbms_output.put_line(&in_empno || '번 사원의 세금: ' || v_tax);
    -- 롤백 말고 다시 돌리기
    UPDATE employees
    SET salary = salary * 20
    WHERE employee_id = &in_empno;
    SELECT salary INTO v_tax
    FROM employees
    WHERE employee_id = &in_empno;
    SYS.dbms_output.put_line(&in_empno || '번 사원의 다시 월급: ' || v_tax);
END;
/

/*예제2) 이름, 급여, 부서번호를 입력받아 EMP테이블에 자료를 등록하는 SCRIPT를 작성해라
단 10번 부서일 경우, 입력한 급여의 20%를 추가하고
초기 값이 9000부터 9999까지 1씩 증가하는 SEQUENCE(EMP_EMPNO_SEQ) 작성하여
사용하고 아래의 표를 참고하여라
이름    : 홍길동
급여    : 2000
부서번호 : 10
*/
SET SERVEROUTPUT ON

CREATE SEQUENCE EMP_EMPNO_SEQ
INCREMENT BY 1
START WITH 9000 --시작되는 번호 설정
MAXVALUE 9999;

ACCEPT p_name PROMPT '이름: '
ACCEPT p_salary PROMPT '월급: '
ACCEPT p_deptno PROMPT '부서번호: '

DECLARE
    v_name VARCHAR2(25) := '&p_name'; -- 문자열은 작은 따옴표
    v_sal employees.salary%TYPE := &p_sal;
    v_deptno employees.department_id%TYPE := &p_deptno;
BEGIN

    IF v_deptno = 10 THEN
        v_sal := v_sal * 1.2;
    END IF;
    
    INSERT INTO employees
    (employee_id, last_name, hire_date, salary, department_id, job_id, email)
    VALUES
    (EMP_EMPNO_SEQ.NEXTVAL, v_name, TO_DATE('200629','YYMMDD'), v_sal, v_deptno, 'IT_PROG', v_name || '@gmail.com');
END;
/
SELECT * FROM employees;

-- 프로시져와 구현 코드에는 주석문 X
-- dbms_output.put_line(v_name || ' ' || v_sal || ' ' || v_deptno);

---------------------------------------------------------------------
/*RE 구현 부분 코드 - FRAMEWORK, SKELETON스켈레톤 스펠확인
SET SERVEROUTPUT ON
DECLARE
    - 선언부, 초기화
    - 예외처리부
BEGIN
    - 구현부, Query
END;
/
SET SERVEROUTPUT OFF
*/
