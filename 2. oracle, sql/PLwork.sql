--����1) 
/*
EVEN_ODD(
    ID:NUMBER(4) 
    GUBUN:VARCHAR2(10)
) 
���̺��� �ۼ��ϰ� START���ڿ� END���ڸ� �Է� �޾� �� ������ ���ڸ� ID�� �����ϰ�  
ID�� ���ڰ� ¦���̸� GUBUN�� ��¦������ Ȧ���̸� GUBUN�� ��Ȧ������� �Է��ϴ� 
SCRIPT�� WHILE������ �ۼ��Ͽ���. st
��) 
START : 1,  END : 10 �Է� ->  10���� ROW�� �ȴ�.
*/
SET SERVEROUTPUT ON

CREATE TABLE EVEN_ODD(
    ID NUMBER(4), 
    GUBUN VARCHAR2(10)
);

ACCEPT p_start PROMPT 'start ����'
ACCEPT p_end PROMPT 'end ����'

DECLARE
    v_start NUMBER(4) := &p_start;
    v_end NUMBER(4) := &p_end;
BEGIN
    IF v_start > v_end THEN
        dbms_output.put_line('start�� end���� Ů�ϴ�');
    ELSE 
        WHILE v_start <= v_end LOOP
            IF MOD(v_start, 2) = 0 THEN
                INSERT INTO even_odd(id, gubun)
                VALUES(v_start, '¦��');
            ELSE 
                INSERT INTO even_odd(id, gubun)
                VALUES(v_start, 'Ȧ��');
            END IF;
            v_start := v_start + 1;
        END LOOP;
        
        SYS.dbms_output.put_line(&p_start || '�κ��� ' || &p_end || '���� ' 
                                || TO_CHAR(&p_end - &p_start + 1) || '���� �ڷᰡ �ԷµǾ����ϴ�');
    END IF;
END;
/
SELECT * FROM even_odd;

--����2)�����ȣ�� �Է� ������ ������ ���� ��µǴ� PROCEDURE�� �ۼ��϶�
--     Purchasing �μ����� ����Դϴ�
CREATE PROCEDURE getDeptName (empno IN NUMBER, dname OUT VARCHAR2)
IS
BEGIN
    SELECT d.department_name INTO dname
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
        AND e.employee_id = empno;
END;
/
-- �ϳ��� Ȯ���ϱ�
VAR dname VARCHAR2;

EXEC getdeptname(100, :dname); --:Ȯ��

PRINT dname;

--����3)�����ȣ�� �Է¹ް�, �ҼӺμ��� �ְ�, �������� ������ �Ķ���ͷ� ����ϴ� PROCEDURE�� �ۼ��϶�.
CREATE PROCEDURE emp_deptTopMoney (empno IN NUMBER, diff OUT NUMBER)
IS
    deptno employees.department_id%TYPE;
BEGIN
    -- �Էµ� ����� �μ� ����
    SELECT department_id INTO deptno
    FROM employees
    WHERE employee_id = empno;
    
    -- �ְ�, �ּ��� ����
    SELECT (MAX(salary) - MIN(salary)) INTO diff
    FROM employees
    WHERE department_id = deptno;
END;
/
/*-- Ȯ�� �۾�
SELECT MAX(salary), MIN(salary) INTO diff
FROM employees
WHERE department_id = 50;
*/
VAR di NUMBER;

ACCEPT p_empno PROMPT '�����ȣ'
EXEC emp_depttopmoney(&p_empno, :di);
PRINT di;

--------------------------------------------------------------------scott
--����4) �� ���ڸ� �����ϸ� ������ �ؼ� ������� ��ȯ�ϴ� �Լ��� �����Ͻÿ�.(�Լ��� add_num)
CREATE FUNCTION add_num(num1 IN INTEGER, num2 INTEGER)
    RETURN INTEGER
IS
BEGIN
    RETURN (num1 + num2);
END;
/

SELECT add_num(12,34) FROM dual;

--����5) �μ���ȣ�� �Է��ϸ� �ش� �μ����� �ٹ��ϴ� ��� ���� ��ȯ�ϴ� �Լ��� �����Ͻÿ�.
--     (�Լ��� get_emp_count)
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

VAR count NUMBER; -- count�� �����̸����� ������ 

EXEC :count := get_emp_count(10);

PRINT count;

--����6) emp���̺��� �̿��ؼ� �Ի����� �����ϸ� �ٹ������� ���ϴ� �Լ��� �����Ͻÿ�.
--      (�Ҽ��� �ڸ� ����, �Լ��� get_info_hiredate)
CREATE FUNCTION get_info_hiredate(hire_date emp.hiredate%TYPE)
    RETURN NUMBER
IS
    v_year NUMBER;
BEGIN
    v_year := TRUNC ( ( MONTHS_BETWEEN(sysdate, hire_date) ) / 12 );
    RETURN v_year;
END;
/
--cf) MONTHS_BETWEEN/12 ������ ���
SELECT MONTHS_BETWEEN(sysdate, '19/01/23')
from dual;

SELECT ename, get_info_hiredate(hiredate) AS "�ٹ�����"
FROM emp;

--����7) emp���̺��� �̿��ؼ� �����ȣ�� �Է��ϸ� �ش� ����� ������ �̸��� ���ϴ� �Լ���
--      �����Ͻÿ�.(�Լ��� get_mgr_name) - SELF JOIN
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

SELECT ename, get_mgr_name (empno) AS "�����ڸ�"
FROM emp;

--����8) emp���̺��� �̿��ؼ� �����ȣ�� �Է��ϸ� �޿� ����� ���ϴ� �Լ��� �����Ͻÿ�.
--4000~5000 A, 3000~4000�̸� B, 2000~3000�̸� C, 1000~200�̸� D, 1000�̸� F
-- �Լ��� get_sal_grade
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
SELECT ename, sal, get_sal_grade(empno) AS "�޿� ���"
FROM emp;
