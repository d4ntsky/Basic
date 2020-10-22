-- Standard Function ǥ�� �Լ�

-- DUAL Table   : ���� ���̺� -> ��� Ȯ�ο� Table
SELECT 1 FROM DUAL;
SELECT 'A' FROM DUAL;
SELECT '��' FROM DUAL;
SELECT 23 * 45 FROM DUAL;

-- ���� �Լ�
-- CHR(N)  ASCII���� ���ڷ� ��ȯ cf) N�� ����
SELECT CHR(65) FROM DUAL;
SELECT CHR(97) FROM DUAL;

-- ASCII <-> CHR
SELECT ASCII('A') FROM DUAL;
SELECT ASCII('a') FROM DUAL;

-- "�ȳ��ϼ���" + "�ǰ��ϼ���" = "�ȳ��ϼ���ǰ��ϼ���"
-- OR�� �ƴ�   ||        �ٿ�����
SELECT '�� ������ ' || CHR(65) || '�Դϴ�' FROM DUAL;

--LPAD(RPAD) : �������� ��ĭ(��������)���� ä���.
SELECT LPAD('BBB', 10) FROM DUAL;
SELECT RPAD('BBB', 10) FROM DUAL;
SELECT LPAD('BBB', 10, '-') FROM DUAL;
SELECT LPAD('123', 10, '0') FROM DUAL;

-- ������ ã�� INSTR == indexOf('a') defande 3�� ���Ծ���
select instr('123ABC456DEF', 'A') FROM DUAL; -- DB�� 0���� ����
select instr('123ABC456DEFABC', 'A', 7) FROM DUAL; -- 7��° ���� A
select instr('123ABC456DEFABCABC', 'A', 7, 2) FROM DUAL; --7��° ���� 2��° A
select instr('123ABC456DEF', 'Y') FROM DUAL; -- ��ã���� 0�� ����

-- REPLACE : ���ڿ� ġȯ
SELECT REPLACE('AAAAABCD', 'A') FROM DUAL; --A�� �� ���ڷ�
SELECT REPLACE('AAAAABCD', 'A', 'a') FROM DUAL; --A�� a�� �ٲ�
SELECT REPLACE('AAAAABCD', 'AA', 'a') FROM DUAL;

-- TRANSLATE : ���� ġȯ
SELECT TRANSLATE('AAAAABCD', 'A', 'a') FROM DUAL; 
SELECT TRANSLATE('AAAAABCD', 'AA', 'a') FROM DUAL; --AA��� ��� A�ո� ����
SELECT TRANSLATE('AAAAABCD', 'AB', 'a') FROM DUAL; --AB�� �������� 

-- ����
-- �ø�
SELECT CEIL(13.1) FROM DUAL;
-- ����
SELECT FLOOR(13.9) FROM DUAL;
-- ���� ������
SELECT MOD(3,2) FROM DUAL;
-- �¼�
SELECT POWER(3,2) FROM DUAL;
-- �ݿø�
SELECT ROUND(13.5) FROM DUAL;
-- ����
SELECT TRUNC(12.3456) FROM DUAL; --���� ����
SELECT TRUNC(12.3456, 2) FROM DUAL;
SELECT TRUNC(12.3456, -1) FROM DUAL;

-- SIGN(��ȣ +:1 0:0 -:-1 ) ��ȣ�� ����
SELECT SIGN(13.4) FROM DUAL;
SELECT SIGN(0) FROM DUAL;
SELECT SIGN(-12) FROM DUAL;


-- ��ȯ �Լ�
-- TO_CHAR 
-- DATE -> VARCHAR2
SELECT TO_CHAR(SYSDATE)
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD-HH-MI-SS')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD/ HH:MI:SS')
FROM DUAL;

SELECT TO_CHAR(100000000000, '$999,999,999,999')
FROM DUAL;

-- TO_DATE
-- VARCHAR2 -> DATE
SELECT TO_DATE('20200617') 
FROM DUAL;

SELECT TO_DATE('20201225', 'YYYYMMDD') 
FROM DUAL;

SELECT TO_DATE('12252020', 'MMDDYYYY')
FROM DUAL;

-- TO_NUMBER    VARCHAR2 -> NUMPER parseInt()
SELECT TO_NUMBER('123') + 12
FROM DUAL;

-- LAST_DAY
SELECT LAST_DAY('20/06/01')
FROM DUAL;

SELECT LAST_DAY( TO_DATE('200601', 'YYMMDD') )
FROM DUAL;              --20-06-01 ������ ������ �޶�

-- SUBSTR 1������ 1 /cf)substring(1,2)"ABCDE" -> BC  index���� 0���� �����ϴ� java
SELECT SUBSTR('ABCDE', 3) -- 3�������� ������
FROM DUAL; --CDE

SELECT SUBSTR('ABCDE', 3, 2) -- 3�������� 2��
FROM DUAL; --CD
