--* 오라클 SQL문 : 데이터 입력 / 출력(select) / 수정 / 삭제
--  			(DML : Data Manipulation Language)

--[1]샘플 데이터 생성
create table exam01(
	deptno number(2),
	dname  varchar2(14),
	loc    varchar2(14)
);

--[2]데이터 입력(저장) : insert into ~ values()
insert into exam01(dname, deptno, loc)     --방법1 테이블 순서와 상관없음
values('ACCOUNT', 10, 'NEW YORK');

insert into exam01
values(20, 'RESEARCH','DALLAS');      --방법2 이경우는 테이블 순서를 맞춰서 넣어야됨

insert into exam01(loc, dname, deptno)
values('CHICAGO', 'SALES', 30); 

--[3] null 값 입력
insert into exam01
values(40, 'OPERATION');    --ERROR!

insert into exam01
values(40, 'OPERATION', null ); 


insert into exam01
values(40, 'OPERATION','' ); 

--[4] 데이터 출력(검색) : select문
--         03_select_command.sql실습 참조


--[5] 필드의 데이터를 변경 : 부서번호 변경
update exam01 set deptno = 30;

--[6]
drop table exam02 purge;

create table exam02 as select * from emp;


update exam02 set sal = sal * 1.1 ;       --임금10%인상

--[7] 부서번호가 10인 사원의 부서번호를 20으로 변경
update exam02 set deptno = 20
where deptno=10;

--[8] 급여가 3000이상인 사원만 급여를 10%인상
update exam02 set sal = sal *1.1
where sal>=3000;

--[9] 사원이름이 scott인 자료의 부서 번호를 10, 직급을 MANAGER로 변경
update exam02 
set deptno = 10,job = 'MANAGER'
where ename is 'SCOTT';

--[10] 30번 부서 사원을 삭제
delete from exam02
where deptno=30;

--[11]사원을 삭제
delete from exam02;







select * from exam02;
select * from exam01;
































