-- * 오라클 - 저장 프로시저(Procedure)
--		. 복잡한 쿼리문(insert/update/delete)들을 필요할 때 마다 다시 입력할 필요 없이 
--		   간단하게 호출만 해서 복잡한 쿼리문의 실행 결과를 얻어올 수 있음.
--		. 성능도 향상되고, 호환성 문제도 해결
--		. 여러번 반복 호출해서 사용 할 수 있는 장점.

drop table emp01 purge;

create table emp01
as 
select * from emp;

SQL>ed proc01    --프로시저의 생성 코드 작업
SQL>@proc01  -- 프로시저 실행
SQL>execute del_all;   --프로시저 실행
SQL>select * from emp01;


-- [1] 저장 프로시저 조회하기
SQL>desc user_source;
SQL>select name, text from user_source;

-- [2] 저장프로시저의 매개변수
SQL>insert into emp01
		select * from emp;
SQL>ed proc02

-- proc02.sql 파일에 저장할 내용
create or replace procedure del_ename(vename emp01.ename%type)
is 
begin
  delete from emp01
  where ename = vename;
end;
/

SQL>@proc02
SQL>execute del_ename('SCOTT');

-- [3] IN, OUT, INOUT매개 변수(MODE)
--			. IN - 데이터를 전달 받을 때 사용.
--			. OUT - 수행된 결과를 받아갈 때 사용.
--			. INOUT - IN&OUT 두가지 목적 모두 사용.


SQL>ed proc03
--저장내용
create or replace procedure sel_empno(
     vempno   in   emp.empno%type,
     vename   out  emp.ename%type,
     vsal        out  emp.sal%type,
     vjob        out  emp.job%type
)
is 
begin
     select ename, sal, job into vename, vsal, vjob
     from emp
     where empno = vempno;
end;
/
SQL>@proc03
SQL> variable var_ename varchar2(16);
SQL> variable var_sal number;
SQL> variable var_job varchar2(9);
                                             --입력 파트
SQL>execute sel_empno(7788, :var_ename, :var_sal, :var_job);

SQL>print var_ename;
SQL>print var_sal; 
SQL>print var_job;

-- [4] 저장 함수
--			- 저장프로시저와 거의 유사한 용도로 사용.
-- 			- 함수는 실행 결과를 되돌려 받을 수 있다.
SQL>ed proc04
create or replace function cal_bonus(vempno in emp.empno%type)
     return number
is
     vsal    number(7, 2);
begin
     select sal into vsal
     from emp
     where empno = vempno;

     return(val * 200);
     
end;
/
SQL>@proc04
SQL>variable var_result number;
SQL>execute :var_result := cal_bonus(7788);
SQL>print var_result;


--[5] Cursor(커서)
--		 : 처리 결과가 여러 개의 행으로 구해지는 select문을 처리하면서 커서를 이용해야 됨.
SQL> select * from dept;
SQL> ed proc05
﻿create or replace procedure cursor_sample01
is

      vdept  dept%rowtype;       --로우의 모든 타입을 한번에 가져오겠다는것.
      cursor c1 
      is 
           select * from dept;
     
begin
      DBMS_OUTPUT.PUT_LINE('부서번호 / 부서명/ 지역명');
      DBMS_OUTPUT.PUT_LINE('-----------------------------');


      open c1;        --실제 c1이 가지고 있는 주소값을 보여줌

      LOOP
          fetch c1  into vdept.deptno, vdept.dname, vdept.loc;
          exit when c1%notfound;
         
          DBMS_OUTPUT.PUT_LINE(vdept.deptno ||' '|| vdept.dname ||' '|| vdept.loc);

      END LOOP;

      close c1;
end;
/


SQL>@proc05
SQL>execute cursor_sample01;



