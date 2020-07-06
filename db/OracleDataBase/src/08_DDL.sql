--* 오라클 SQL문 : 테이블 / 수정 / 삭제
--				(DDL : Data Definition Language)

--[1] 테이블 생성 : creat table 문
create table exam01( 
			exno      number(2),      
			exname    varchar2(20), 
			exsal     number(7,2)     
			);

select * from tab;
select * from exam01;

--[2] 기존테이블과 동일하게 테이블 만들기
create table exam02 as select * from emp;

select * from tab;
select * from exam02;


--[3] 기존 테이블에서 새로운 컬럼 추가 : alter 문
alter table exam01
add( exjob varchar2(10));

select * from exam01;


desc exam01; --이클립스에선 명령안됨 cmd에서 해볼것

--[4] 테이블 구조 수정 : 필드 수정
alter table exam01
modify(  exjob varchar2(20)             );

--[5] 테이블 구조 수정 : 필드 삭제
alter table exam01
drop column  exjob;

select * from exam01;

--[6] 테이블 수정 : 이름 변경
alter table exam01 rename to test01;           --방법1

rename test01 to exam01; --방법2

--[7] 테이블 삭제
drop table exam01;
select * from tab;
--cf. 오라클 10g부터는 테이블을 삭제하면 
-- BIN$0BZ/UBi+ShaFe+V/febkTA==$0 와 같이 임시 테이블로 교체된다. 
-- 임시테이블을 삭제하고 싶다면 : 
purge recyclebin;

--처음부터 테이블을 완전히 삭제하고 싶다면?
drop table exm02 purge;

--[8] 테이블 내의 모든 데이터(레코드) 삭제(테이블 유지) 동작원리는 테이블까지 다 삭제 한 이후에 테이블을 다시 생성해주는것임. 결과상으로는 09에서 delete와 같음
truncate table exam02;










































