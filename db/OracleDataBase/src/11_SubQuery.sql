-- * 오라클 SQL 문 : 서브쿼리(Sub-Query) 문  !!아주많이 사용되는 구문!!

--. SQL> : Structured Query Language
--. 서브쿼리(Sub-Query) : 하나의 select 문장의 절 안에 포함된 또 하나의 select 문이다.
--. 메인쿼리(Main Query)/ 서브쿼리(Sub-Query)
--. 서브쿼리(Sub-Query)는 비교 연산자의 오른쪽에 기술해야 되고, 반드시 괄호로 둘러 쌓아야 한다.
--. 종  류 : 단일행 서브쿼리 / 다중행 서브쿼리

-- ex) 'SCOTT'이 근무하고 있는 부서명과 지역 출력(서로 다른 테이블에 데이터가 존재).
select deptno from emp where ename = 'SCOTT'; -- 20
select dname, loc from dept where deptno = 20; -- RESEARCH DALLAS

--[단일행 서브쿼리]
select dname, loc from dept 
where deptno = (select deptno from emp 
						  where ename = 'SCOTT'); -- RESEARCH DALLAS

--[예제] scott과 동일한 직급(job)을 가진 사원을 출력하는 sql문을 서브쿼리를 이용해서 작성해보세요.
select ename, job from emp 
where job=(select job from emp 
				   where ename = 'SCOTT');

--[예제] scott의 급여와 동일하거나 더 많이 받는 사원 이름과 급여를 출력해보세요.
select ename, sal from emp 
where sal >=(select sal from emp 
					 where ename = 'SCOTT');

--[서브쿼리 & 그룹함수]
-- 평균 급여보다 더 많은 급여를 받는 사원을 출력하세요.
select ename, sal from emp 
where sal> (select avg(sal) from emp);

--[다중행 서브쿼리]
--[예제] 급여를 3000이상 받는 사원이 소속된 부서와 동일한 부서에서 근무하는 사원들의 정보를 출력하세요.
select deptno from emp where sal >= 3000;
--[error]
select ename, sal, deptno from emp 
where deptno = (select deptno from emp 
						  where sal >= 3000);

--(1) [in 연산자] : 메인 쿼리의 비교조건('=' 연산자로 비교할 경우)이 서브쿼리의 결과중에서 하나라도 일치하면(or) 참이다.
select ename, sal, deptno from emp 
where deptno in (select deptno from emp 
						  where sal >= 3000);

--[문제] in연산자를 이용하여 부서별로 가장 급여를 많이 받는 사원의 정보(사원번호, 사원명, 급여, 부서번호)
select empno, ename, sal, deptno from emp 
where sal in (select max(sal) from emp group by deptno);

--(2) [all 연산자] : 메인쿼리의 비교 조건이 서브쿼리의 검색결과의 모든 값이 일치하면 참이다. 찾아진 값에 대해서 and 연산을 해서 ㅓ모두 참이면 참이된느 셈이다.
-- >all 은 '모든 비교값보다 크냐?' 고 묻는 것이 되므로 최대값보다 더 크면 참이 된다.

--[예시] 30번(부서번호) 소속 사원들 중에서 급여를 가장 많이 받는 사원보다 더 많은 급여를 받는 사원의 이름과 급여를 출력하세요.
select ename, sal, deptno from emp 
where sal >= (select max(sal) from emp where deptno = 30);

select ename, sal, deptno from emp 
where sal >=all (select sal from emp where deptno = 30);

--(3) [any 연산자] : any조건은 메인쿼리의 비교 조건이 서브쿼리의 검색 결과와 하나 이상만 일치하면 참이다. 
-- >any는 찾아진 값에 대해서 하나라도 크면 참이 된다. 그러므로 찾아진 값에서 가장 작은 값, 즉 최소값보다 크면 참이 된다.
--[문제] 부서번호가 30번인 사원들의 급여중에서 가장 낮은 급여보다 높은 급여를 받는 사원의 이름, 급여를 출력하는 명령을 작성해보세요.
--[단일행 서브쿼리]
select ename, sal from emp
where sal > (select min(sal) from emp where deptno = 30);
--[다중행 서브쿼리]
select ename, sal from emp 
where sal >any (select sal from emp where deptno = 30);

--[문제1] 부서번호가 30번인 사원들의 급여 중 가장 낮은 급여보다 높은 급여를 받는 사원들의 이름과 급여, 직급을 출력하는 명령문을 작성해 보세요.
select ename, sal, deptno from emp 
where sal >any (select sal from emp where deptno = 30);

--[문제2] 영업 사원들의 최소급여보다 많이 받는 사원들의 이름과 급여, 직급을 출력하되 영업사원은 출력하지 않습니다. 
select ename, sal from emp 
where sal >any(select sal from emp 
						where job = 'SALESMAN') 
						and job <> 'SALESMAN';

