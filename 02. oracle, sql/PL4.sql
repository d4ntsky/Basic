/*
    Trigger : �˹߽�Ű��, ������ �߻��ϴ�.
               �ڵ����� ȣ��Ǵ� �Լ�
                before, after
                        OLD,  NEW
                 ex) �̷��� �Լ��� ����Ǳ� ���̳� ��
                 INSERT INTO EMPLOYEES ���� �� ���� �߰�
                 DELETE
                 UPDATE
                 �Ȱ��� ����� �ִ��� Ȯ���� �ʿ�
                 
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
    SYS.dbms_output.put_line('���� �� �÷��� �� : ' || :OLD.department_name);
    SYS.dbms_output.put_line('���� �� �÷��� �� : ' || :NEW.department_name);
END;
/

UPDATE departments
SET department_name = '���������'
WHERE department_id = 60;

ROLLBACK;

--------------------------------------------------------------------------------------------------------------------------------
-- row�� �߰��ϴ� �� �׻� ��� �޿��� Ȯ��
CREATE TRIGGER avg_triger
    BEFORE
        INSERT OR UPDATE ON employees
        FOR EACH ROW
DECLARE
    avg_sal NUMBER;
BEGIN
    SELECT ROUND( AVG(salary), 3 ) INTO avg_sal
    FROM employees;
    
    SYS.dbms_output.put_line('�޿� ��� : ' || avg_sal);
END;
/

INSERT INTO employees
(employee_id, last_name, hire_date, department_id, job_id, salary, email)
VALUES
(501, 'Tiger', SYSDATE, 60, 'IT_PROG', 10000, 'Tiger1@naver.com');

SELECT * FROM employees;

ROLLBACK;

--------------------------------------------------------------------------------------------------------------------------------
-- �������� �ʵ��� �ϴ� ���  -- �߿��� ������ ���Ƴ��� �� ���
CREATE TRIGGER emp_triger
    BEFORE
        UPDATE OR DELETE OR INSERT ON employees
        FOR EACH ROW       
BEGIN
    IF UPDATING THEN
        IF :OLD.employee_id = '100' THEN
            RAISE_APPLICATION_ERROR(-20001, '�� ��ȣ�� ������ �� �����ϴ�');
        END IF;
    END IF;
END;
/
UPDATE employees       
SET salary = 2500
WHERE employee_id = 100;

SELECT * FROM employees;

--------------------------------------------------------------------------------------------------------------------------------
-- �Է� �Ұ��ǵ���
CREATE TRIGGER nodata_triger
    AFTER INSERT
    ON employees
BEGIN
    RAISE_APPLICATION_ERROR(-20000, '������ �Է��� �õ��Ͽ����ϴ�.');
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