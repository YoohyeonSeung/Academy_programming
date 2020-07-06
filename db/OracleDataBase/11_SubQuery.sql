-- * 오라클 SQL 문 : 서브쿼리(Sub - Query ) 문

--. SQL> : Structured Query Language
--. 서브쿼리(Sub-Query) : 하나의 select 문자의 절 안에 포함된 또 하나의 select문이다.
--. 메인쿼리 / 서브쿼리
--. 서브쿼리는 비교 연산자의 오른쪽에 기술해야 되고, 반드시 괄호로 둘러 쌓아야 한다.
--. 종 류 : 단일행 서브쿼리 / 다중행 서브쿼리

-- ex) 'SCOTT'이 근무하는 부서명, 지역 출력(서로 다른 테이블에 데이터 존재)

select deptno from emp
where ename = 'SCOTT';

select dname loc from dept
where deptno = 20;

--[단일행 서브쿼리]
select dname, loc from dept
where deptno = (select deptno from emp
						  where ename = 'SCOTT');
						  
--[예제] scott와 동일한 직급(job)을 가진 사원을 출력하는 sql문을 서브쿼리를 이용하여 작성해보세요.
select ename, job from emp
where job = (select job from emp
					 where ename = 'SCOTT');

--[예제] scott의 급여와 동일하거나 더 많이 받는 사원의 이름과 급여를 출력해보세요.
select ename, sal from emp
where sal>=(select sal from emp
					where ename = 'SCOTT');
	  
--[서브쿼리& 그룹 함수]
--전체사원 평균 급여보다 더 많은 급여를 받는 사원을 출력하세요.
select ename, sal from emp
where sal>(select avg(sal) from emp	);					
					
					
					
						  
select * from emp;						  
						  
						  
						  
						  
						  
						  
						  
						  
						  
						  
						  
						  
						  
						  
						  
						  
						  
						  
						  
						  
						  