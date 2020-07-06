--* 오라클 명령어 : 내장 함수

--[1] 샘플 테이블인 dual 테이블
select * from dual; --비어있는 가상 테이블 , 비어있음

--[2] 임시 데이터 출력
select 1234*1234 from dual; --듀얼을 이용하여 출력가능

-- ** 문자열 처리 관련 함수 **--
--[3] lower() : 모든 문자를 소문자로
select lower('Hong Kil Dong') as "소문자" from dual;

--[4] upper() : 모든 문자를 대문자로
select upper('Hong Kil Dong') as "대문자" from dual;

--[5] initcap() : 첫문자를 대문자로
select initcap('hong kil dong') as "첫글자만 대문자" from dual;

--[6] concat() : 문자열 연결
select concat('더 조은 ','인재 개발원') from dual;

--[7] length() : 문자열 길이 계산
select length('더 조은 인재 개발원'), length('The Joeun Academy') from dual;

--[8] substr() : 문자열 추출 (데이터, 인덱스(1부터), 카운트)
select substr('홍길동 만세',2,4) from dual;

--[9] instr() : 문자열 시작 위치
select instr('홍길동 만세','동') from dual;

--[10] lpad(), rpad() : 왼쪽 오른쪽에 자리 채우기 (데이터, 자릿수, 채울데이터)
select lpad('Oracle',20,'#') from dual;
select rpad('Oracle',20,'#') from dual;

--[11]  trim() : 컬럼이나 대상 문자열에서 특정 문자가 첫번째 글자이거나 마지막 글자이면 잘라내고 남은 문자열만 반환.
select trim('a' from 'aaaOracleaaaaaa') from dual;
select trim(' ' from '   Oracle        ') from dual; --여백제거


-- *** 수식 처리 관련 함수 ***
--[12] round() : 반올림
select round(12.3456,3) from dual;

select deptno, sal, round(sal,-3) from emp where deptno = 30;

--[13] abs() : 절대값
select abs(-10) from dual;

--[14] floor() : 소수자리 버리기
select floor(12.3456) from dual;

--[15] trunc() : 특정자리 버리기 (실수, 자리수 이하 소수점 버림)
select trunc(12.3456, 1) from dual;

--[16] mod() : 나머지 
select mod(8,5) from dual;

--*** 날짜 처리 관련 함수 ***
--[17] sysdate : 날짜
select sysdate from dual; -- 2018-11-28 12:58:48.0

-- 날짜 포맷 출력 변경
alter session set nls_date_format ='yyyy/mm/dd hh12:mi:ss'

--[18] months_between(): 개월수 구하기 (기준시간, 입력시간)
select ename, hiredate, months_between(sysdate, hiredate) from emp where deptno = 10;

--[19] add_months(): 개월 수 더하기
select add_months(sysdate, 200) from dual;
select add_months(sysdate, -200) from dual;

--[20] next_day(): 다가올 요일에 해당하는 날짜
select next_day(sysdate, '일요일') from dual;

--[21] last_day(): 해당 달의 마지막 일 수
select last_day(sysdate) from dual;

--[22] to_char(): 문자열로 변환
select to_char(sysdate, 'yyyy-mm-dd')from dual;

--[23] to_date(): 날짜형(date)으로 변환
select to_date('2009/13/31', 'yyyy/mm/dd')from dual;

--[24] nvl() : NULL인 데이터를 다른 데이터로 변경.
select ename, comm, nvl(comm, 0) from emp;


--[25] decode() : swich 문과 같은 기능
select ename, deptno, decode(deptno, 
								10, 'A', 
								20, 'R',
								30, 'S',
								40, 'O') as "부서 약자" from emp;
								
								
--[26] case() : if ~ else if ~와 같은 함수
select ename, deptno, 
		case when deptno = 10 then 'ACCOUNT'
			 when deptno = 20 then 'RESEARCH'
			 when deptno = 30 then 'SALES'
			 when deptno = 40 then 'OPERATION'
		end as "부서명" from emp;								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								

































