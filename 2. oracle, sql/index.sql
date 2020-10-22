/*
    index : ����
        ������ �˻�
        ���ϴ� ������ ��ġ�� ������ ��Ȯ�ϰ� �˾Ƴ� �� �ִ� ���
    -- �ڵ� ���� : Primary Key, Unique Key
    -- ���� ���� : Query ������ �������
    
    �������� ��  ȿ������ ���
        1. WHERE���̳� JOIN���� �ȿ� ���� ���Ǵ� COLUMN
        2. NULL���� ���� ���ԵǾ� �ִ� COLUMN
        3. WHERE���̳� JOIN���� �ȿ� �� �� �̻��� ����ϴ� COLUMN
        
    �������� �� ��ȿ������ ���
        1. TABLE�� DATA�� ��(ROW)�� ���� ��(3000�� ����)
        2. TABLE�� ���� ���ŵǴ� ���
*/

CREATE TABLE EMP_COPY
AS
SELECT * FROM employees; -- �� ���� ������ ���� �����̳� �ε����� ������
                         -- �׳� ���̺� �����ϴ�
-- �ڵ� ����
ALTER TABLE EMP_COPY
ADD
CONSTRAINT PK_EMPCOPY_01 PRIMARY KEY(EMPLOYEE_ID);
-- INDEX Ȯ��
SELECT  *
FROM ALL_INDEXES
WHERE INDEX_NAME IN('PK_EMPCOPY_01'); -- ������ �߰�
-- ���� ����
CREATE INDEX EMP_INDEX01
ON EMP_COPY(manager_id);
-- INDEX Ȯ��
SELECT  *
FROM ALL_INDEXES
WHERE INDEX_NAME IN('EMP_INDEX01'); -- ������ �߰�