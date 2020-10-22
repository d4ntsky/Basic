/*
    PL/SQL
    Procedural == ó����   Extension == Ȯ��
    Process ó���ϴ� -> Procedure ó����
    SQL�� Ȯ���� ������ ��� -> Procedure, Function, Trigger
        Procedure : in�� �ϸ� out���� ��� ��      insert/delete/update
        Function  : in�� �ϸ� out�� �ݵ�� ����      select
        Trigger   : �ڵ� ȣ��, �����Ͱ� �ֳ� ���ĸ� 
    ��� : if, while, for
        + Script
           ����
             1. �����    : ����, ���, �ʱ�ȭ
             2. �����    : ������ ó���� Queary �κ��̳� ����� Ȱ���ؼ� ó���ϴ� �κ�
             3. ����ó���� : ���� ���� ó��
cf)pl�� ���� �Լ�ȭ?
*/
SET SERVEROUTPUT ON -- CONSOLE�� ����� ON
BEGIN
   
    dbms_output.put_line('Hello PL');
END; --BEGIN �κп��� ���๮
/


SET SERVEROUTPUT OFF

DECLARE     --�����
    message VARCHAR2(10);                                  -- STRING message
   
BEGIN       --�����                                        
    message := 'hello pl';                                 -- message = "hello pl"
    SYS.dbms_output.put_line('message = '|| message);
    
                                                           -- ����ó��
END;
/

-- IF
DECLARE
    counter INTEGER;
BEGIN
    counter := 1;
    counter := counter + 1;
    
    IF counter IS NULL THEN  -- ������ ������Ʈ (�������� ���̿�����) ex) ������ ������ ������ ��������
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
    v_count NUMBER := 0;       -- ����� �Բ� �ʱ�ȭ
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
    SYS.dbms_output.put_line('Exit'); -- �ٽ� ���İ��� ������ �Ϸ� ����
    
END;
/

-- ����ó����        1/0 �и� 0
DECLARE
    counter INTEGER;
BEGIN
    counter := 1;
    counter := counter / 0;

EXCEPTION WHEN OTHERS THEN
    SYS.dbms_output.put_line('���ܰ� �߻��Ͽ����ϴ�.');
END;
/

-- varray : Variable Array
DECLARE     --cf)Ÿ���� �����
    TYPE varray_test IS VARRAY(3) OF INTEGER;   -- �ڹٿ��� int varray_test = new int[3];   -- �� ���� new int[3];  
    vArr varray_test;    -- ���� �迭����                                                     -- �� ���� int varray_test = 
BEGIN
    vArr := varray_test(11, 22, 33);
    -- vArr[0] �ڹ� ���� vArr(0) ���� ����
    SYS.dbms_output.put_line('vArr(1) = ' || vArr(1));
END;
/

-- ACCEPT �޼��� �ڽ�
ACCEPT p_deptno PROMPT '�μ���ȣ�� �Է��Ͻÿ�(�޿��� ��)'

DECLARE
    v_salTotal NUMBER;
BEGIN
    SELECT SUM(salary) INTO v_salTotal          --select�� output
    FROM employees
    WHERE department_id = &p_deptno;            --&&&&&&&&&&&&&&& �ܺο���
    
    SYS.dbms_output.put_line(&p_deptno || '�� �μ� �޿��� ���� ' || TO_CHAR(v_salTotal,'$999,999,999') || '�Դϴ�');

END;
/

-- �����ȣ�� �Է¹ް� �� ����� �޿��� 1000�� ���� ������ ����(UPDATE)�϶�
-- �����ȣ�� ���ŵ� �޿��� ����϶�.
ACCEPT p_empno PROMPT '��� ��ȣ�� �Է��ϼ���'

DECLARE
    -- v_sal NUMBER(8,2) := 1000; byte�� �ڸ����� ã�Ƽ� ���߱� ����ϱ�
    v_sal EMPLOYEES.salary%TYPE := 1000;
    v_salTotal NUMBER;
 
BEGIN
    -- Ȯ�ο�
    SELECT salary INTO v_salTotal
    FROM employees
    WHERE employee_id = &p_empno;
    SYS.dbms_output.put_line(&p_empno || '�� ����� �޿�: ' || v_salTotal);
    
    -- ������
    UPDATE employees
    SET salary = salary + v_sal
    WHERE employee_id = &p_empno;
    -- ���� �� ���
    SELECT salary INTO v_salTotal
    FROM employees
    WHERE employee_id = &p_empno;
    SYS.dbms_output.put_line(&p_empno || '�� ����� ���� �� �޿�: ' || v_salTotal);
END;
/

--����1) �����ȣ�� �Է� �ް� �� ����� �޿��� ������ ����϶�(������ 5%�� �����Ѵ�)
ACCEPT in_empno PROMPT '��� ��ȣ�� �Է��ϼ���'

DECLARE
      -- TYPE �����ֱ�
    v_tax NUMBER;
BEGIN
    -- Ȯ�ο�
    SELECT salary INTO v_tax
    FROM employees
    WHERE employee_id = &in_empno;
    SYS.dbms_output.put_line(&in_empno || '�� ����� �޿�: ' || v_tax);
    
    -- ������
    UPDATE employees
    SET salary = salary * 0.05
    WHERE employee_id = &in_empno;
    -- ���� �� ���
    SELECT salary INTO v_tax
    FROM employees
    WHERE employee_id = &in_empno;
    SYS.dbms_output.put_line(&in_empno || '�� ����� ����: ' || v_tax);
    -- �ѹ� ���� �ٽ� ������
    UPDATE employees
    SET salary = salary * 20
    WHERE employee_id = &in_empno;
    SELECT salary INTO v_tax
    FROM employees
    WHERE employee_id = &in_empno;
    SYS.dbms_output.put_line(&in_empno || '�� ����� �ٽ� ����: ' || v_tax);
END;
/

/*����2) �̸�, �޿�, �μ���ȣ�� �Է¹޾� EMP���̺� �ڷḦ ����ϴ� SCRIPT�� �ۼ��ض�
�� 10�� �μ��� ���, �Է��� �޿��� 20%�� �߰��ϰ�
�ʱ� ���� 9000���� 9999���� 1�� �����ϴ� SEQUENCE(EMP_EMPNO_SEQ) �ۼ��Ͽ�
����ϰ� �Ʒ��� ǥ�� �����Ͽ���
�̸�    : ȫ�浿
�޿�    : 2000
�μ���ȣ : 10
*/
SET SERVEROUTPUT ON

CREATE SEQUENCE EMP_EMPNO_SEQ
INCREMENT BY 1
START WITH 9000 --���۵Ǵ� ��ȣ ����
MAXVALUE 9999;

ACCEPT p_name PROMPT '�̸�: '
ACCEPT p_salary PROMPT '����: '
ACCEPT p_deptno PROMPT '�μ���ȣ: '

DECLARE
    v_name VARCHAR2(25) := '&p_name'; -- ���ڿ��� ���� ����ǥ
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

-- ���ν����� ���� �ڵ忡�� �ּ��� X
-- dbms_output.put_line(v_name || ' ' || v_sal || ' ' || v_deptno);

---------------------------------------------------------------------
/*RE ���� �κ� �ڵ� - FRAMEWORK, SKELETON���̷��� ����Ȯ��
SET SERVEROUTPUT ON
DECLARE
    - �����, �ʱ�ȭ
    - ����ó����
BEGIN
    - ������, Query
END;
/
SET SERVEROUTPUT OFF
*/
