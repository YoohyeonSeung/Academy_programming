-- * 오라클 명령어 : Group 함수 

--sum() :
select sum(sal) "총급여" from emp;

--count() :
select count(*) "사원수" from emp;

-- avg() :
select avg(sal) "평균 급여" from emp;

-- max():
select max(sal) "최고 급여 수령자" from emp;

--min():
select min(sal) "최저 급여 수령자" from emp;


-- Group by 절 :직업별 급여 평균 
select job, avg(sal) from EMP group by job;

-- Having 절 : 직업별 급여 평균(단, 급여 평균 2000이상 직업)
select job, avg(sal) from EMP group by job having avg(sal)>=2000;
