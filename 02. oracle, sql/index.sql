/*
    index : 색인
        목적은 검색
        원하는 정보의 위치를 빠르고 정확하게 알아낼 수 있는 방법
    -- 자동 생성 : Primary Key, Unique Key
    -- 수동 생성 : Query 문으로 만들어줌
    
    생성했을 때  효율적인 경우
        1. WHERE절이나 JOIN조건 안에 자주 사용되는 COLUMN
        2. NULL값이 많이 포함되어 있는 COLUMN
        3. WHERE절이나 JOIN조건 안에 두 개 이상을 사용하는 COLUMN
        
    생성했을 때 비효율적인 경우
        1. TABLE의 DATA의 수(ROW)가 적을 때(3000개 이하)
        2. TABLE이 자주 갱신되는 경우
*/

CREATE TABLE EMP_COPY
AS
SELECT * FROM employees; -- 다 포함 하지만 제약 조건이나 인덱스는 불포함
                         -- 그냥 테이블만 복사하는
-- 자동 생성
ALTER TABLE EMP_COPY
ADD
CONSTRAINT PK_EMPCOPY_01 PRIMARY KEY(EMPLOYEE_ID);
-- INDEX 확인
SELECT  *
FROM ALL_INDEXES
WHERE INDEX_NAME IN('PK_EMPCOPY_01'); -- 조건절 추가
-- 강제 생성
CREATE INDEX EMP_INDEX01
ON EMP_COPY(manager_id);
-- INDEX 확인
SELECT  *
FROM ALL_INDEXES
WHERE INDEX_NAME IN('EMP_INDEX01'); -- 조건절 추가