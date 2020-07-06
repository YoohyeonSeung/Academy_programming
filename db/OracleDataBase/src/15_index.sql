-- * 오라클 : 인덱스(index)
--		 - 조회를 빠르게(빠른 검색) 하도록 도와줌.
--		 - sql 명령문의 처리 속도를 향상시키기 위해서 컬럼에 생겅하는 오라클 객체

--		 - 장점
--			. 검색 속도가 빨라진다
--			. 시스템에 걸리는 부화를 줄여서 시스템 전체 성능을 향상시킨다.

--		 - 단점
--			. 인덱스를 위한 추가적인 공간이 필요하다.
--			. 인덱스를 생성하는 시간이 걸린다.
--			. 데이터의 변경작업(insert/udpate/delete)이 일어나는 경우에는 오히려
--			  성능 자체가 떨어진다.

--[1] 인덱스 정보 조회
select index_name, table_name, column_name
from user_ind_columns
where table_name in ('EMP', 'DEPT');

--[2] 조회 속도 비교하기
-- 사원 테이블 복사하기
drop table emp01 purge;

create table emp01
as select * from emp;

-- 데이터 복사시 테이블 구조와 내용만 복사될 뿐, 네약 조건은 복사되지 않는다.
select table_name, column_name, index_name
from user_ind_columns
where table_name in ('EMP','EMP01');
select * from emp01;

-- 지금 실습 사항은 command 창에서 실행 / 확인
insert into emp01
select * from emp01;

insert into emp01(empno, ename)
values(8010, 'ANGEL');

set timing on 

select distinct empno, ename
from emp01
where ename = 'ANGEL';     --1.27sec(index 연결X)

--[3] 인덱스 생성
--		. 기본키나 유일키가 아닌 컬럼에 대해서 인덱스를 지정하려면 create index명령어 사용.
create index idx_emp01_ename
on emp01(ename);               --시간 오래걸림.

select table_name, index_name
from user_indexes
where table_name in ('EMP01');

select distinct empno, ename
from emp01
where ename = 'ANGEL';           --0.1초걸림(index 연결 o)


--[4] 인덱스 제거
drop index idx_emp01_ename;

select table_name, index_name
from user_indexes
where table_name in ('EMP01');