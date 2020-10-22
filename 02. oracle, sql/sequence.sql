/*  
    Sequence : ������ ���� �������ִ� Oracle Object - SEQ�� Ī��
        ex) ȸ����ȣ, �Խ��� ������ȣ
            baseball member���� 
            1000�� or 2000������ baseball+1 - ������Ϲ�ȣ
            1001 -> 1002 -> 1003
        �ʱ�ȭ�� �Ұ���. ���� �� �ٽ� ����
           int count = 1;
           count++;
*/

-- sequence ����
CREATE SEQUENCE TEST_SEQ
INCREMENT BY 1          -- 1�� ���� = ++
START WITH 10           -- ���� ����
MAXVALUE 100
MINVALUE 1;

-- CURRVAL -- ������ SEQ ��
SELECT TEST_SEQ.CURRVAL
FROM dual;

-- NEXTVAL -- ���� ��
SELECT TEST_SEQ.NEXTVAL
FROM dual;

-- SEQUENCE ����
ALTER SEQUENCE TEST_SEQ
INCREMENT BY 3;

-- �ʱ�ȭ �Ұ�
DROP SEQUENCE TEST_SEQ;

INSERT INTO employees
(employee_id, last_name, email, hire_date, job_id)
VALUES
(employees_seq.nextval, 'ȫ', 'HGD@NAVER.COM', '91/10/12', 'IT_PROG');
        
SELECT * FROM employees;              

------------------------------------------------------------
-- ���Ǿ� ( SYNONYM / ��ü�� ���� )
/*
    int array[];
    int alias[] = array;
*/
CREATE SYNONYM "�����"
FOR EMPLOYEES; -- ���̺�� ª�� ���ľ� ��

INSERT INTO "�����"(employee_id, last_name, email, hire_date, job_id)
VALUES(EMPLOYEES_SEQ.nextval, '��', 'IJM@DAUM.NET', SYSDATE, 'ST_MAN');

SELECT * FROM employees;