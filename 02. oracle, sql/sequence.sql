/*  
    Sequence : 유일한 값을 생성해주는 Oracle Object - SEQ라 칭함
        ex) 회원번호, 게시판 관리번호
            baseball member에서 
            1000번 or 2000번부터 baseball+1 - 선수등록번호
            1001 -> 1002 -> 1003
        초기화가 불가능. 삭제 후 다시 생성
           int count = 1;
           count++;
*/

-- sequence 생성
CREATE SEQUENCE TEST_SEQ
INCREMENT BY 1          -- 1씩 증가 = ++
START WITH 10           -- 시작 숫자
MAXVALUE 100
MINVALUE 1;

-- CURRVAL -- 현재의 SEQ 값
SELECT TEST_SEQ.CURRVAL
FROM dual;

-- NEXTVAL -- 진행 값
SELECT TEST_SEQ.NEXTVAL
FROM dual;

-- SEQUENCE 수정
ALTER SEQUENCE TEST_SEQ
INCREMENT BY 3;

-- 초기화 불가
DROP SEQUENCE TEST_SEQ;

INSERT INTO employees
(employee_id, last_name, email, hire_date, job_id)
VALUES
(employees_seq.nextval, '홍', 'HGD@NAVER.COM', '91/10/12', 'IT_PROG');
        
SELECT * FROM employees;              

------------------------------------------------------------
-- 동의어 ( SYNONYM / 객체의 별명 )
/*
    int array[];
    int alias[] = array;
*/
CREATE SYNONYM "사원들"
FOR EMPLOYEES; -- 테이블명 짧게 고쳐쓸 때

INSERT INTO "사원들"(employee_id, last_name, email, hire_date, job_id)
VALUES(EMPLOYEES_SEQ.nextval, '일', 'IJM@DAUM.NET', SYSDATE, 'ST_MAN');

SELECT * FROM employees;