/*
    script -> blockȭ -> �Լ�ȭ
    �Ű�����, return ��
    
    PROCEDURE   - INSERT, DELETE, UPDATE (FUNCTION���� INSERT,DELETE,UPDATE�� �� ������)   
    FUNCTION    - SELECT (���� ����)
    TRIGGER     - Ȯ�ο�         -> CALLBACK(�ڵ� ȣ��)
    DB�� ������ �ִ� �� PROCEDURE            - ���� ȣ��   - return���� ���� ���� ���� ����
    DB�� ������� ����  FUNCTION             - ���� ȣ��   - return���� �ݵ�� �ִ�.
    �뵵�� ���̰� �ִ�    
 
    FUNCTION�� ū �ǹ̿��� �������� �����Ѵ�.
*/
SET SERVEROUTPUT ON
--cf)procedure�� ALTER�� �� ��ħ
--1) �Ű������� ���� ��
CREATE PROCEDURE HELLOPROC
IS
    msg VARCHAR2(10);
BEGIN
    msg := 'hello proc';
    
    SYS.dbms_output.put_line(msg || ' ȣ��Ǿ���');
END;
/
--�Ű� ������ ����. ȣ��Ȱ� �ƴϰ� ���ν����� ������ ����
EXEC helloproc; -- ȣ���ϴ� ��

--------------------------------------------------------------------------------------------------------------------------------
-- �Ű������� �ִ� ��               --varchar2�� ����Ʈ �ָ� �ȵ�
CREATE PROCEDURE MYPROC(inNum IN NUMBER, outNum OUT NUMBER)
IS
    --�����
BEGIN
    --
    SYS.dbms_output.put_line('inNum: ' || inNum);
    
    outNum := 333;
END;
/
-- ȣ���� ���� ���� ����( �� �� �� �����ϱ�! )
VAR val NUMBER;  -- java -  Integer val;       -- �� �پ� ����!
EXECUTE myproc(111, :val);                     -- �� �پ� ����!
PRINT val;                                     -- �� �پ� ����!

ROLLBACK;

--------------------------------------------------------------------------------------------------------------------------------
-- departments rows �߰�
INSERT INTO departments(department_id, department_name, location_id)
VALUES(300, '�űԺμ�', 1400);

-->> PROCEDURE�� �����
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
    SYS.dbms_output.put_line('�߰��� �����Ͽ����ϴ�');
    
    -- ROLLBACK;
END;
/
EXEC add_dept(300, '�űԺμ�', 2500);   -- �� �տ� PK�� �ߺ� �߰� �Ұ�

SELECT * FROM departments;

ROLLBACK;

--------------------------------------------------------------------------------------------------------------------------------
-- UPDATE SALARY
-- �����ȣ�� �Է¹޾� ������ 30%�� �λ��Ű�� PROCEDURE �ۼ��ϱ�
-- ���ν��� �̸� updateSal
--CREATE �ڿ� OR REPLACE�� �ϸ� ���� ���� ������
--V_EMPNO�տ� &�ʿ����.. ���� �����°� �ƴϱ� ������!!
CREATE PROCEDURE updateSal
(v_empno IN employees.employee_id%TYPE)
IS
BEGIN
    UPDATE employees
    SET salary = salary * 1.3
    WHERE employee_id = v_empno;
    
EXCEPTION WHEN OTHERS THEN 
    SYS.dbms_output.put_line('���ſ� �����Ͽ����ϴ�');
    
END;
/
ACCEPT empno PROMPT '�����ȣ: '
EXEC updateSal(&empno);   

SELECT * FROM employees;

ROLLBACK;

--------------------------------------------------------------------------------------------------------------------------------
-- SELECT
-- �����ȣ�� �Է¹��ϸ�, �̸�, �Ի���, ����޿��� ��µǴ� ���ν����� �ۼ�.
CREATE PROCEDURE emp_info(p_empno IN NUMBER)
IS
    v_emp employees%ROWTYPE;
BEGIN
    SELECT first_name, hire_date, salary
        INTO v_emp.first_name, v_emp.hire_date, v_emp.salary
    FROM employees
    WHERE employee_id = p_empno;
    
    SYS.dbms_output.put_line('�̸�: ' || v_emp.first_name);
    SYS.dbms_output.put_line('�Ի���: ' || v_emp.hire_date);
    SYS.dbms_output.put_line('�޿�: ' || v_emp.salary);
END;
/

exec emp_info(100);

--------------------------------------------------------------------------------------------------------------------------------
/*
    Cursor : ����Ǵ� �ּ� ���� -> pointer
        �Ͻ��� Ŀ��  : �ڵ� ����
            SQL%ROWCOUNT : ROW�� �� == JAVA������ SIZE()
            SQL%FOUNT    : ROW�� ���� �� �� �̻��� ���
            SQL%NOTFOUNT : ROW�� ���� 0 �� ���
        ����� Ŀ��  : ���� ����
            
*/
 -- �Ͻ��� Ŀ��
CREATE PROCEDURE implicit_cursor(p_empname IN employees.first_name%TYPE)
IS
    v_sal employees.salary%TYPE;
    v_update_row NUMBER;            -- �� ���� ���� �����Ǵ� �� �����ϴ� �κ��� ����
BEGIN
 /*   -- �˻�  cf) row�� �� �� �̻��̸� ������ �߻��Ѵ�.
    SELECT salary INTO v_sal
    FROM employees
    -- WHERE first_name = p_empname;
    WHERE first_name = p_empname AND last_name = p_emplastname;
    
    -- �˻� �� ������(row)�� �ִ� ���
    IF SQL&FOUND THEN
        dbms_output.put_line('�˻��� �����Ͱ� �ֽ��ϴ�.');
    END IF;
 */   
    -- ����
    UPDATE employees
    SET salary = salary * 1.1
    WHERE first_name = p_empname;
    
    v_update_row := SQL%ROWCOUNT;
    SYS.dbms_output.put_line('�޿��� �λ�� ��� ��: ' || v_update_row);
        
EXCEPTION WHEN NO_DATA_FOUND THEN
    SYS.dbms_output.put_line('�˻��� �����Ͱ� �����ϴ�.');
END;
/

SELECT * FROM employees
WHERE first_name = 'John';

EXEC implicit_cursor('John');

ROLLBACK;

--------------------------------------------------------------------------------------------------------------------------------
 --����� Ŀ��   
 --Object(Cursor) ���� -> fetch(���̴�)
CREATE PROCEDURE expCursor_test(v_deptno IN departments.department_id%TYPE)
IS
    CURSOR dept_avg
    IS
    SELECT 
    d.department_name, COUNT(e.employee_id) CNT, ROUND(AVG(salary), 3) SAL
    --INTO v_dname, emp_cnt, sal_avg; �غκ����� ��
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
        AND e.department_id = v_deptno                  -- �ܺηκ��� �Էµ� �μ���ȣ
    GROUP BY d.department_name;
    
    -- CURSOR�� FETCH�ϱ� ���� �������� ����
    v_dname departments.department_name%TYPE;
    emp_cnt NUMBER;
    sal_avg NUMBER;   
    
BEGIN
    -- CURSOR OPEN
    OPEN dept_avg;
    -- CURSOR FETCH
    FETCH dept_avg INTO v_dname, emp_cnt, sal_avg;
    
    SYS.dbms_output.put_line('�μ��� : ' || v_dname);
    SYS.dbms_output.put_line('����� : ' || emp_cnt);
    SYS.dbms_output.put_line('��տ���: ' || sal_avg);
    
    -- CURSOR CLOSE
    CLOSE dept_avg;
END;
/

EXEC expcursor_test(50);

ROLLBACK;