--* 오라클 명령어 : select문(검색)

--[1]scott 사용자가 관리하는 테이블 목록
select * from tab;

--[2] 특정 테이블의 구조(필드 리스트/데이터 형식/제약 조건)
desc dept; --cmd창에서 입력후 확인

--[3] 특정 테이블의 data 표시    오라클에선 데이타 이름은 대소문자 비교를 하지만 다른건 대소문자를 비교하지않는다.
select * from dept;
select * from emp;

--[4] 모든 컬럼(필드명)이 아닌, 필요한 칼럼(필드명) 내용만 출력,
select dname, loc from dept;
select empno, ename, deptno from emp;

--[5] 각각의 필드명에 별칭을 주어서 출력
select deptno as 부서번호, dname as 부서명, loc as 부서위치 from dept;

select deptno 부서번호, dname 부서명, loc 부서위치 from dept; --부서 번호처럼 띄어쓰기 하면안됨. 띄어쓰기 하고 싶으면 밑의 코드처럼 하면됨.

select deptno "부서 번호", dname "부서명", loc "부서 위치" from dept; -- '과 "를 구별하지 않으나 구분해서 써야됨.

--[6] 사원들의 직업명을 중복 제거 후 출력
select * from emp;

select distinct job from emp;

--[7] 급여가 3000이상인 사원 정보 출력
select empno, ename, sal from emp
where sal>=3000;

--[8] 이름이 scott 사원의 정보 출력
--단, 데이터의 경우의 한해서만 대/소문자 구별.
select * from emp
where ename = 'SCOTT';

--[9] 1985년도 이후 입사한 사원의 정보
select empno, ename, hiredate
from emp
where hiredate >= '1985/01/01';

--[10] 부서번호가 10이고, 직업이 'manager'인 사원 출력
select * from emp
where deptno=10and job='MANAGER';

--[11] 부서번호가 10이거나, 직업이 'manager'인 사원 출력
select * from emp
where deptno=10 or job='MANAGER';

--[12] 부서번호가 10번이 아닌 사원
select * from emp
where not (deptno = 10); 
--위와 동일한 코드
select * from emp
where deptno <> 10; 

--[13] 급여가 1000~3000인 사원을 출력
select ename, sal from emp
where sal>=1000 and sal<=3000;

select ename, sal from emp
where sal between 1000 and 3000;


--[14]급여가 1300 이거나 1500 이거나 1600를 받는 사원의 정보
select ename, sal from emp
where sal=1300 or sal = 1500 or sal=1600;

select ename, sal from emp
where sal in (1300, 1500, 1600);

--[15] 이름이 'K'로 시작하는 사원 출력
select empno, ename from emp
where ename like 'K%';

--[16] 이름이 'K'로 끝나는 사원 출력
select empno, ename from emp
where ename like '%K';

--[17] 이름이 'K'를 포함하는 사원 출력
select empno, ename from emp
where ename like '%K%';

--[18] 2번째 자리에 'A'가 들어가 있는 사원 출력
select empno, ename from emp
where ename like '_A%';

--[19] 커미션을 받지 않는 사원 출력
select empno, ename, comm from emp
where comm= null or comm=0;       --원하는 결과 x

select empno, ename, comm from emp
where comm is null or comm = 0 ;

--[20] 커미션을 받는 사원 출력
select empno, ename, comm from emp
where comm <> null and comm <> 0 ;    --원하는 결과 출력 x

select empno, ename, comm from emp
where comm is not null and comm <> 0 ;

--[21] 사번의 정렬(오름차순)으로 출력
select empno, ename, comm from emp
order by empno asc;   --default (asc생략 가능)

--[22] 사번의 정렬(내림차순)으로 출력
select empno, ename, comm from emp
order by empno desc;

--[23] 사원의 연봉 출력
select ename, sal, sal*12 from emp;

select ename, sal, sal*12 as "연 봉" from emp;  --연봉이라는 별칭울 부여, as 생략 가능

--[24] 커미션을 포함한 최종 연봉 출력
select ename, sal, (sal*12)+comm as "최종 연봉" from emp;

--[25] [24]의 오류 해결법
select ename, sal, comm, sal*12+comm, nvl(comm, 0), sal*12+nvl(comm,0) from emp;
       --nvl(comm, 0)의 의미는 null로 저장된건 0으로 취급해서 처리해라 라는 의미













































