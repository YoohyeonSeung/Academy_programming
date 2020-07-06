-- * 오라클 - 뷰(View)
--     - 물리적인 테이블에 근거한 논리적인 가상 테이블.
--     - 가상이란 단어는 실질적으로 데이터를 저장하고 있지 않기 때문에 붙인 것이고, 
--       테이블이란 단어는 실질적으로 데이터를 저장하고 있지 않더라도 사용 계정자는 마치
--       테이블을 사용하는 것과 동일하게 뷰를 사용할 수 있기 때문에 붙인 것.
--     - 뷰는 기본테이블에서 파생된 객체로서 기본테이블에 대한 하나의 쿼리문임.
--     - 실제 테이블에 저장된 데이터를 뷰를 통해서 볼 수 있도록 함.
--     - 사용자에게 주어진 뷰를 통해서 기본 테이블을 제한적으로 사용하게 됨.
--     - 뷰는 이미 존재하고 있는 테이블에 제한적으로 접근하도록 한다.
--     - 뷰를 생성하기 위해서는 실질적으로 데이터를 저장하고 있는 물리적인 테이블이 
--        존재해야 되는데 이 테이블은 기본테이블이라고 한다.

--[1] 뷰의 기본 테이블 생성
--		(1) dept 테이블을 복사한 dept_copy 테이블을 생성해서 사용하도록 함.
select * from dept;
drop table dept_copy;
create table dept_copy
as 
select * from dept;

select * from dept_copy;

--		(2) emp 테이블에 복사한 emp_copy테이블을 생성해서 사용하도록 함.
create table emp_copy
as
select * from emp;

select * from emp_copy;


--[2] 뷰(view) 정의하기
----  . 뷰를 생성하기 위해서는 create view로 시작함.
----  . as 다음은 마치 서브쿼리문과 유사함.
----  .서브쿼리는 우리가 지금까지 사용하였던 select문을
----    기술하면 됨.

----  만일 30번 부서에 소속된 사원들의 사번과 이름과 
--     부서번호를 자주 검색한다고 가정하면
select empno, ename, deptno from emp_copy
where deptno=30;


-------- . 위와 같이 결과를 출력하기 위해서 매번 select문을
--           입력하기란 여간 번거로운 일이 아닐 수 없음.
-------- . 뷰는 이와같이 번거로운 select문을 매번 입력하는 
--            대신 보다 쉽게 원하는 결과를 얻고자 하는 바램에서
--            출발한 개념.



--[view를 생성할 수 있는 권한 부여]
--  :dos command 창에서 sqlplus로 연결 확인.


SQL> conn system/admin1234
SQL> show user
SQL> grant create view to scott;    --scott에서는 안되고 system계정에서만 가능!



create view emp_view30
as 
select empno, ename, deptno
from emp_copy
where deptno=30;

select * from emp_view30;



--[3] 뷰의 내부 구조와 user_views 데이터 딕셔너리
SQL>desc user_views;
SQL>select view_name, text from user_views;


--[4] 뷰의 동작원리
----   1. 사용자가 뷰에 대해서 질의를 하면 user_views에서
--          뷰에 대한 정의를 조회한다.
----   2. 기본 테이블에 대한 뷰의 접근 권한을 살핀다.
----   3. 뷰에 대한 질의를 기본테이블에 대한 질의로 변환.
----   4. 기본 테이블에 대한 질의를 통해 데이터를 검색.
----   5. 검색된 결과를 출력한다.

--[5] 뷰와 기본 테이블 관계 파악
---- 1. 뷰를 통한 데이터 저장이 가능?
insert into emp_view30
values(9999,'박찬호',10);

select * from emp_copy;



---- 2. insert문에 뷰(emp_view30)를 사용하였지만, 뷰는
--        쿼리문에 대한 이름일 뿐 새로운 레코드는 기본 테이블
--        (emp_copy)에 실질적으로 추가되는 것이다.

---- 3. 뷰는 실질적인 데이터를 저장한 기본 테이블을 볼 수
--        있도록한 투명한 창이다. 즉, 기본 테이블의 모양이 바
--        뀐 것이고 그 바뀐 내용을 뷰라는 창을 통해서 볼 
--        뿐이다. 뷰에 insert뿐만 아니라, update, delete 모두
--        사용 할 수 있는데, 이 명령문 역시 뷰의 텍스트에 
--        저장되어 있는 기본 테이블을 변경하는 것이다.

--[6] 뷰를 사용하는 이유
----  1. 복잡하고 긴 쿼리문을 뷰로 정의하면 접근을 단순화
--         시킬 수 있다.
----  2. 보안에 유리하다.
--          - 사용자마다 특정 객체만 조회할 수 있도록 권한을
--             부여할 수 있기 때문.

-- ex)인사과 뷰
create view emp_view
as 
select empno, ename, job, hiredate, deptno




-- [7] 뷰의 종류
----      : 뷰는 뷰를 정의하기 위해서 사용되는 기본 테이블의
--           수에 따라
--          - 단순 뷰(simple view)
--          - 복합 뷰(complex view)로 나눈다.

-------   - 특징
-------        . 단순 뷰
--                 - 하나의 테이블로 생성
--                 - 그룹함수의 사용이 불가능
--                 - distinct 사용이 불가능
--                 - insert/update/delete 등 사용 가능

-------        . 복합 뷰
--                 - 여러 개의 테이블로 생성
--                 - 그룹함수의 사용이 가능
--                 - distinct 사용이 가능
--                 - insert/update/delete 등 사용 불가능

---- [7-1] 단순 뷰에 대한 데이터 조작
insert into emp_view30
values(8010, 'John', 10);
select * from emp_view30;
select * from emp_copy;





---- [7-2] 단순 뷰의 컬럼에 별칭 부여하기
create view emp_view_copy(사원번호, 사원명, 급여, 부서번호)
as select empno, ename, sal, deptno
from emp_copy;

select * from emp_view_copy;

select * from emp_view_copy       --error deptno를 사원번호로 바꿨기 때문에 이런식으로 접근을 할 수 없음.
where deptno=30;

select * from emp_view_copy     
where 부서번호=30;

---- [7-3] 그룹 함수를 사용한 단순 뷰
--      중요) 뷰를 작성할 때 select 절 다음에 sum()이라는
--               그룹함수를 사용하면 결과를 뷰의 특정 컬럼처럼
--               사용하게 됨. 따라서 물리적인 컬럼이 존재하지
--               않는 가상 컬럼이기 때문에 컬럼명도 상속 받을
--               수 없음. 뷰를 생성할 때 가상 컬럼을 사용하려면
--               사용자가 반드시 이름을 따로 설정해야한다.
create view view_sal
as 
select deptno, sum(sal), avg(sal)  --여기 이후는 되나 view_sal을 만들 수가 없음
from emp_copy
group by deptno;


create view view_sal
as 
select deptno, sum(sal) as "SalSum", avg(sal) as "SalAvg"   --새로운 레이블 이름을 해줌으로써 가능!
from emp_copy
group by deptno;

select * from view_sal;



--      주의) 단순뷰의 경우 insert/update/delete 명령어의 조작이 불가능한 경우
--              1. 뷰 정의에 포함되지 않은 컬럼 중에 기본 테이블의 컬럼이 
--                  not null 제약 조건이 지정되어 있는 경우 insert문 사용 불가.
--              2. sal * 12 와 같은 산술 표현식으로 정의된
--                  가상 컬럼이 뷰에 정의되면 insert/update가
--                  불가능하다.
--              3. distinct를 포함한 경우에도 DML 명령 사용 불가-중복 데이터 하나만 가져옴.
--              4. 그룹함수나 group by 절을 포함한 경우에도 DML 명령 사용 불가.

create view view_sal_year
as
select ename, sal*12 "SalYear"
from emp_copy;

select * from view_sal_year;

insert into view_sal_year;
values('이순신', 5000);            --error이 뷰는 emp_copy를 참조 하기때문에 안됨

---- [7-4] 복합 뷰
select empno, ename, sal, e.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno;

create view emp_view_dept
as
select empno, ename, sal, e.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno
order by empno desc;

select * from emp_view_dept;

--[8] 뷰 삭제
drop view emp_view_dept;

--[9] 뷰 생성에 사용되는 다양한 옵션(or replace)
----   : 존재하지 않는 뷰이면 새로운 뷰를 생성하고, 기존에
--        존재하는 뷰이면 그 내용을 변경한다.
create or replace view emp_view30
as 
select empno, ename, comm, deptno
from emp_copy
where deptno=30;




--[10] 뷰 생성에 사용되는 다양한 옵션(force/noforce)
----   force : 기본테이블이 존재하지 않을 때도 뷰를 생성
--                해야 하는 경우 사용하는 옵션.
                  
----   noforce : 기본테이블이 존재하는 경우만 뷰가 생성(default).
select * from employees;      --없는 테이블

create or replace view employess_view   
as
select empno, ename, deptno
from employees
where deptno=30;        -- error!

create or replace force view employess_view   
as
select empno, ename, deptno
from employees
where deptno=30;         --no error

select * from employess_view;     --but there is a error.

select view_name, text
from user_views;              --이걸 통해 있는 것처럼 보임

insert into employess_view   --하지만 테이블이 존재 하지 않기때문에 입력이 안됨.
values(8020,'철수', 20);




--[11] 뷰 생성에 사용되는 다양한 옵션(with check option)
----  뷰를 생성할 때 조건 제시에 사용된 컬럼 값을 변경 
--     못하도록 하는 기능.
----  뷰를 설정할 때 조건으로 설정한 컬럼이외의 다른 컬럼의 내용은 변경할 수 있음.
create or replace force view emp_view30
as
select empno, ename, deptno
from emp_copy
where deptno=30;
select * from emp_view30;

-- 예시) 30번 부서에서 소속된 사원 중에 급여가 1200이상인 사원은 20번 부서로 이동 시켜보세요.
update emp_view30
set deptno=20
where sal>=1200
from emp_view30;

create or replace view view_chk30
as 
select empno, ename, sal, comm, deptno
from emp_copy
where deptno=30 with check option;

update view_chk30;      --error!
set deptno=20
where sal>=900;

-- with read only 차이점 : 뷰를 설정할 때 조건으로 설정한 컬럼이 아닌 컬럼에 대해서는 변경이 가능.
update view_chk30
set comm=1000;

select * from view_chk30;

--[12] 뷰 생성에 사용되는 다양한 옵션(with read only)
----    : 기본 테이블의 어떤 컬럼에 대해서도 뷰를 통한 내용 수정을 불가능하게 만드는 옵션.
create table emp_copy30
as
select * from emp;

create or replace view view_check30
as
select empno, ename, sal, comm, deptno
from emp_copy30
where deptno=30;

update view_check30
set comm=1000;

create or replace view view_read30
as
select empno, ename, sal, comm, deptno
from emp_copy30
where deptno=30 with read only;

update view_read30     --read only view옵션에 의해 수정 불가
set comm=1000;

--[13] Top 쿼리
----  top 쿼리 : 상위 몇 개의 data만을 출력하고 싶을 때
--         . 사원중에서 입사일이 가장 빠른 사원 5명(top-5)만을
--           얻어오는 질의문.
--         . 사원중에서 급여를 가장 많이 받는 사원 7명만을
--           얻어오는 질의문.
--         . TOP-N을 구하기 위해 rownum & inline view가 사용.

--[rownum] 컬럼 값 출력         --mysql이나 그런데서는 사용 못함

select rownum, empno, ename, hiredate  --여기서의 순서는 입력되어있는 순서
from emp;

select rownum empno, ename, hiredate
from emp
order by hiredate;

-- [rownum]의 특징
--     1. 오라클에서만 지원하는 기능.
--     2. 오름차순 정렬을 하더라도 rownum 컬럼 값은 바뀌지 않는다.
--     3. 오라클이 내부적으로 부여하는데, insert 문을 이용하여
--         입력하면 입력한 순서에 따라 1씩 증가되면서 값이 지정.
--     4. 정렬된 순서대로 rownum 컬럼 값이 매겨지도록 하려면
--         새로운 테이블이나 뷰로 새롭게 데이터를 저장해야만 한다.

create or replace view view_hire
as
select empno, ename, hiredate
from emp
order by hiredate;

select rownum, empno, ename, hiredate
from view_hire;


--[1] rownum을 이용
select rownum, empno, ename, hiredate
from view_hire
where rownum<=5;

select rnum, empno, ename, hiredate
from (select rownum rnum, empno, ename, hiredate
		  from view_hire order by hiredate)
where (rnum>=2) and (rnum<=7);

--[2] inline view(인라인 뷰)를 이용.
--		. sql문에서 사용 하는 서브쿼리의 일종으로
select rownum, empno, ename, hiredate
from (select rownum, empno, ename, hiredate   --괄호안에서 실행에 의해 만들어진 rownum은 emp가 만들어질때 부여된 번호이고 괄호밖에서는 입사날자에 의한 순서이다.
		from emp
		order by hiredate)
where rownum<5;


select rnum, empno, ename, hiredate
from (select rownum rnum, empno, ename, hiredate   
		from emp
		order by hiredate)
where rnum>=3and rnum<=5;
--또는 다음 코드도 같음
select*
from (select rownum rnum, empno, ename, hiredate
		 from (select empno, ename, hiredate
		 		  from emp order by hiredate))
where (rnum>=3) and (rnum<=5);


--[문제] 사원 중에서 급여를 가장 많이 받는 사원7명만을 출력하는 명령문을 인라인뷰를 이용해서 구현해보세요.
select * from emp;
select*
from (select rownum rnum, empno, ename, sal
		 from (select empno, ename, sal
		 		  from emp order by sal))
where rnum<=7;











