-- * 오라클 SQL 문 : 조인(Join)

-- DB는 데이터를 중복시켜 보관하면 안된다. 작업시에 다양한 오류와 불필요한 리소스 사용 등의 문제가 발생...
--따라서 테이블마다 고유의 데이터를 담고 있으나 이것을 통합하여 보관하지 않는다. 서로다른 두개 이상의 테이블을 출력하기 위해서는 조인 명령어가 필요

--[1] 'SCOTT'이 근무하는 부서명, 지역출력.
-- 원하는 정보가 두 개 이상의 테이블에 나뉘어져 있을 때 결과 출력.

select * from emp; -- 근무부서
select * from DEPT; -- 부서명, 지역

select deptno from emp where ename ='SCOTT'; --20
select dname, loc from dept where deptno = 20;

--[2] join  : 두개 이상의 테이블에 나뉘어진 데이터를 한번의 SQL문으로 원하는 결과를 얻을 수 있는 기능
-- 이름이 SCOTT인 사원의 부서명 출력

--(1) cross join : 2개 이상의 테이블이 조인될 때 where 절에 의해 공통되는 컬럼에 의한 결합이 발생하지 않는 경우를 의미.
select * from emp, dept; -- 단순 조합 14레코드x4레코드

--(2) equl join : 조인 대상이 되는 두 테이블에서 공통적으로 존재하는 컬럼의 값이 일치되는 행을 연결하여 결과를 생성하는 방법.
select * from emp, dept where emp.deptno = dept.deptno; 

-- 이름이 SCOTT인 사원의 부서명, 위치 출력
select ename, dname, loc, emp.deptno from emp, dept where emp.deptno = dept.deptno and  ename='SCOTT';

-- 컬럼명 앞에 테이블명을 기술하여 컬럼 소속을 명확히 밝힐 수 있다.(표시효과가 있으나 생략가능)
select emp.ename, dept.dname, DEPT.loc, emp.deptno from emp, dept where emp.deptno = dept.deptno and  ename='SCOTT';

-- 테이블명에 별칭을 준후 컬럼앞에 소속 테이블을 지정하고자 할 때는 별칭을 반드시 붙여야함(self join을 위한 유용한 툴)
select e.ename, d.dname, d.loc, e.deptno from emp e, dept d where e.deptno = d.deptno and  e.ename='SCOTT';

--(3) non-equi join 
-- 		. 동일한 컬럼 항목이 없어도 다른 조건을 사용하여 join.
--		. 조인 조건에 특정 범위 내에 있는 지를 조사하기 위해서 조건 절에 조인 조건을 = 연사자 이외의 비교 연산자(ex >,< 등)를 이용.
select * from emp;
select * from SALGRADE;

select ename, sal, grade from emp, salgrade where sal >= losal and sal <= hisal;

select ename, sal, grade from emp, salgrade where sal between losal and  hisal;

-- emp, dept, salgrade 3개의 테이블 join
select ename, sal, grade, dname,loc from emp, dept, salgrade where emp.deptno = dept.deptno and sal between losal and  hisal;

--(4) self join : 하나의 테이블 내에서, 자기 자신과 조인을 통해 원하는 자료를 얻는 방법. 별칭을 통해서...
select ename, mgr from emp;

select employee.ename, employee.mgr, manager.ename as mgrname from emp employee, emp manager where employee.mgr = manager.empno;

--(5) outer join : 조인 조건에 만족하지 못하는 해당 결과를 출력시에 누락이 되는 문제점이 발생. 해당 레코드를 출력하고 싶을때 사용하는 join 방법.
select employee.ename, employee.mgr, manager.ename as mgrname, manager.empno as mgrno from emp employee, emp manager where employee.mgr = manager.empno(+);

--[3] ANSI join : 
--(1) Ansi cross join
select * from emp cross join dept;

--(2) Ansi Inner join
select ename, dname from emp inner join dept on emp.deptno = dept.deptno;  -- "," 대신 inner join으로 명확히 하고, where대신 on이 쓰임
select ename, dname from emp inner join dept on emp.deptno = dept.deptno where ename = 'SCOTT';  -- "," 대신 inner join으로 명확히 하고, where대신 on이 쓰임
select ename, dname from emp inner join dept using (deptno);

-- natrual join
select ename, dname from emp natural join dept;

--(3) Ansi Outer join
drop table dept01 purge;
create table dept01(
	deptno 	number(2),
	dname	varchar2(14)
); 
select * from dept01;
insert into dept01 values(10, 'ACCOUNT');
insert into dept01 values(20, 'RESEARCH');
delete 
create table dept02(
	deptno 	number(2),
	dname	varchar2(14)
);

insert into dept02 values(10, 'ACCOUNT');
insert into dept02 values(30, 'SALES');
select * from dept02;

--기존방법
select * from dept01, dept02 where dept01.deptno=dept02.deptno;
select * from dept01, dept02 where dept01.deptno=dept02.deptno(+);
select * from dept01, dept02 where dept01.deptno(+)=dept02.deptno;
select * from dept01, dept02 where dept01.deptno(+)=dept02.deptno(+); --에러

-- Ansi
select * from dept01 left outer join dept02 on dept01.deptno = dept02.deptno;
-- dept01의 매칭이 안되는 데이터도 함께 출력
select * from dept01 right outer join dept02 on dept01.deptno = dept02.deptno;
-- dept02의 매칭이 안되는 데이터도 함께 출력
select * from dept01 full outer join dept02 on dept01.deptno = dept02.deptno;
-- dept01과 dept02 모두의 매칭이 안되는 데이터도 함께 출력