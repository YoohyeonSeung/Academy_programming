-- * 오라클 SQL 문 :  Join

-- [1] 'SCOTT'이 근무하는 부서명, 위치 출력.
--  원하는 정보가  두개이상의 데이터가 나뉘어져 있을 때 결과출력.

select deptno from emp
where ename = 'SCOTT';    --20

select dname, loc from dept
where deptno=20;

--[2] join(조인) :두개 이상의 테이블에 나뉘어져있는 데이터를 한 번의 sql문으로
--                    원하는 결과를 얻을 수 있는 기능.(이름이 scott인 사원의 부서명 출력)

--(1) cross join : 2개 이상의 테이블에 조인될 때 where절에 의해 공통이 되는 컬럼에 의 한
--						결합이 발생하지 않는 경우를 의미.

select * from emp, dept;

-- (2) equi join : 조인 대상이 되는 두 테이블에서 공통적으로 존재하는 컬럼의 값이 
--                     일치되는 행을 연결하여 결과를 생성하는 방법.

select * from emp, dept
where emp.deptno = dept.deptno;

-- 이름이 scott인 사원의 부서명,  출력
select ename, dname, loc, emp.deptno from emp, dept
where emp.deptno = dept.deptno 
and ename = 'SCOTT';

-- 테이블명에 별칭을 준 후 컬럼 앞에 소속 테이블을 지정하고자 할때는 반드시 붙여야 함.
select e.ename, d.dname, d.loc, e.deptno 
from emp e, dept d
where e.deptno = d.deptno 
and e.ename = 'SCOTT';

--(3) non-equi join
--		. 동일 컬럼이 없이 다른 조건을 사용하여 join
--		. 조인 조건에 특정 범위 내에 있는지를 조사하기 위해서
--		  조건절에 조인조건을 = 연산자 이외의 비교 연산자를 이용.

select * from emp;
select * from SALGRADE;

select ename, sal, grade
from emp, salgrade
where sal>=losal and sal<=hisal;

select ename, sal, grade
from emp, salgrade
where sal between losal and hisal;

--- emp, dept, salgrade 3개의 테이블 join
select ename, sal, grade, dname
from emp, dept, salgrade
where emp.deptno = dept.deptno
and sal between losal and hisal;

-- (4) self join : 

select ename, mgr from emp;

select employee.ename, employee.mgr, manager.ename
from emp employee, emp manager
where employee.mgr = manager.empno;

--(5) outer join : 조인 조건에 만족하지 못하는 해당 결과를 출력시에 누락된 문제점이
--						발생한다. 해당 레코드(row)를 출력하고 싶을 때 사용 하는 join방법.

select employee.ename, employee.mgr, manager.ename, manager.empno
from emp employee, emp manager
where employee.mgr = manager.empno(+);

--[3] ANSI join(조인) (이 조인 방법을 사용하는걸 권고하고 있음.)
--   (1)Ansi Cross join
select * from emp cross join dept;

--   (2)Ansi Inner join
select ename, dname
from emp inner join dept
on emp.deptno = dept.deptno
where ename = 'SCOTT';

select ename, dname
from emp inner join dept
using (deptno);

-- natural join 바로 위의 코드와 같은 결과물 출력
select ename, dname
from emp natural join dept;


--   (3) Ansi Outer join
drop table dept01 purge;
create table dept01(
	deptno    number(2),
	dname    varchar2(14) 
);

insert into dept01 values(10, 'ACCOUNTING');
insert into dept01 values(20, 'RESEARCH');
select * from dept01;


create table dept02(
	deptno    number(2),
	dname    varchar2(14) 
);

insert into dept02 values(10, 'ACCOUNTING');
insert into dept02 values(30, 'SALES');
select * from dept02;

-- 기존 방법
select * from dept01, dept02
where dept01.dname = dept02.dname(+);

select * from dept01, dept02
where dept01.dname(+) = dept02.dname;

select * from dept01, dept02
where dept01.dname(+) = dept02.dname(+);  --이런 명령어는 존재하지 않음.

----- Ansi
select * 
from dept01 left outer join dept02
on dept01.deptno = dept02.deptno;

select * 
from dept01 right outer join dept02
on dept01.deptno = dept02.deptno;

select * 
from dept01 full outer join dept02
on dept01.deptno = dept02.deptno;









select * from emp; 
select * from dept; 






























