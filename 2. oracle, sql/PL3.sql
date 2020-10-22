/*
    Function
        매개변수, return값(반드시 필)
        SELECT 
*/
--------------------------------------------------------------------------------------------------------------------------------
-- 기본 형태
CREATE FUNCTION func(p_val IN NUMBER) 
    RETURN NUMBER
IS
    v_val NUMBER;
BEGIN
    v_val := p_val;
    v_val := v_val * 2;
    
    RETURN v_val;
END;
/

SELECT func(3)
FROM dual;

-- 명령문 하나씩 실행
VAR v NUMBER;
EXEC :v := func(12);                    -- 확인!!
PRINT v;

--------------------------------------------------------------------------------------------------------------------------------
CREATE FUNCTION tax(p_value IN NUMBER) 
    RETURN NUMBER
IS
BEGIN
    RETURN (p_value * 0.15);
END;
/

SELECT tax(10000) FROM dual;

--------------------------------------------------------------------------------------------------------------------------------
-- 월급과 커미션을 합친 급액의 세금을 계산
CREATE FUNCTION tax2(p_sal IN employees.salary%TYPE,
                     p_bonus IN employees.commission_pct%TYPE)
    RETURN NUMBER
IS
BEGIN
    RETURN ( (p_sal + NVL(p_bonus,0) * p_sal) * 0.15);
END;
/

SELECT first_name, salary + salary * NVL(COMMISSION_PCT,0) AS 실급여,
        tax2(salary, commission_pct) AS 세금
FROM employees;

--------------------------------------------------------------------------------------------------------------------------------
-- 사원번호를 입력하면, 업무명을 취득할 수 있는 함수
CREATE OR REPLACE FUNCTION getJobName(p_empno IN NUMBER)
    RETURN VARCHAR2
IS
    v_jobname jobs.job_title%TYPE;
BEGIN   
    SELECT j.job_title INTO v_jobname
    FROM employees e, jobs j
    WHERE e.job_id = j.job_id
        AND e.employee_id = p_empno;
    RETURN v_jobname;
END;
/
VAR jobname VARCHAR2(20);
EXEC :jobname := getjobname(120);
PRINT jobname;

--------------------------------------------------------------------------------------------------------------------------------
