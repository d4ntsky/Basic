/*
    Trigger : 촉발시키다, 스스로 발생하다.
               자동으로 호출되는 함수
                before, after
                        OLD,  NEW
                 ex) 이러한 함수가 실행되기 전이나 후
                 INSERT INTO EMPLOYEES 직원 한 명을 추가
                 DELETE
                 UPDATE
                 똑같은 사람이 있는지 확인이 필요
                 
                           OLD    NEW
                  INSERT           O
                  DELETE    O       
                  UPDATE    O      O
*/ 
--------------------------------------------------------------------------------------------------------------------------------
SET SERVEROUTPUT ON

CREATE TRIGGER trigger_test
    BEFORE
        UPDATE ON departments
        FOR EACH ROW
BEGIN
    SYS.dbms_output.put_line('변경 전 컬럼의 값 : ' || :OLD.department_name);
    SYS.dbms_output.put_line('변경 후 컬럼의 값 : ' || :NEW.department_name);
END;
/

UPDATE departments
SET department_name = '정보기술부'
WHERE department_id = 60;

ROLLBACK;

--------------------------------------------------------------------------------------------------------------------------------
-- row를 추가하는 데 항상 평균 급여를 확인
CREATE TRIGGER avg_triger
    BEFORE
        INSERT OR UPDATE ON employees
        FOR EACH ROW
DECLARE
    avg_sal NUMBER;
BEGIN
    SELECT ROUND( AVG(salary), 3 ) INTO avg_sal
    FROM employees;
    
    SYS.dbms_output.put_line('급여 평균 : ' || avg_sal);
END;
/

INSERT INTO employees
(employee_id, last_name, hire_date, department_id, job_id, salary, email)
VALUES
(501, 'Tiger', SYSDATE, 60, 'IT_PROG', 10000, 'Tiger1@naver.com');

SELECT * FROM employees;

ROLLBACK;

--------------------------------------------------------------------------------------------------------------------------------
-- 수정되지 않도록 하는 경우  -- 중요한 데이터 막아놓을 때 사용
CREATE TRIGGER emp_triger
    BEFORE
        UPDATE OR DELETE OR INSERT ON employees
        FOR EACH ROW       
BEGIN
    IF UPDATING THEN
        IF :OLD.employee_id = '100' THEN
            RAISE_APPLICATION_ERROR(-20001, '이 번호는 수정할 수 없습니다');
        END IF;
    END IF;
END;
/
UPDATE employees       
SET salary = 2500
WHERE employee_id = 100;

SELECT * FROM employees;

--------------------------------------------------------------------------------------------------------------------------------
-- 입력 불가되도록
CREATE TRIGGER nodata_triger
    AFTER INSERT
    ON employees
BEGIN
    RAISE_APPLICATION_ERROR(-20000, '데이터 입력을 시도하였습니다.');
END;
/
INSERT INTO employees
(employee_id, last_name, hire_date, department_id, job_id, salary, email)
VALUES
(600, 'Tiger', SYSDATE, 60, 'IT_PROG', 10000, 'Tiger600naver.com');

DROP TRIGGER trigger_test;
DROP TRIGGER avg_triger;
DROP TRIGGER emp_triger;
DROP TRIGGER nodata_triger;