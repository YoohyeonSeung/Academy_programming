--  * 오라클 - 트랜잭션(transation)
----     : 데이터 처리의 한 단위.
----     : 오라클에서 발생하는 여러 개의 SQL 명령문들을
--          하나의 논리적인 작업 단위로 처리.
----     : 데이터의 일관성을 유지하면서 안정적으로 데이터를 복구.

--     . commit : 명령어 완전 실행(DB 최종 적용).
--     . rollback : 명령어 되돌리기(실행 해제).

-- 유의 사항
---- . DDL 자동 트랜젝션이 적용(commit).
---- . DML : 정상적으로 종료되었다면 자동으로 commit.
---- . 정전이 발생하거나 컴퓨터가 다운시 자동으로 rollback.



--[1] 테이블 생성
create table dept01
as select * from dept;

select * from dept01;

-- [2] command창에서 실행 할것
delete from dept01;

--[3]
drop table dept01 purge;
create table dept01
as select * from dept;


--이클립스에선 알아서 commit을 하기 때문에 수정사항이 있으면 cmd로 해서 해보고 
--rollback; 을 하면된다. 롤백은 가장 최근에 commit했던 내용으로 돌아간다. 