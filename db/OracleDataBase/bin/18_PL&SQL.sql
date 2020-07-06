-- * 오라클 : PL&SQL

-- [1] 'Hello World' 출력
SQL>set serveroutput on
SQL>begin
			DBMS_OUTPUT.PUT_LINE('Hello world');
		end;
		/

-- [2]변수 사용하기
SQL> declare
		 vempno	  number(4); 
		 vename  varchar2(10);
		 begin
			 vempno := 7788; 
			 vename := 'SCOTT';
			 DBMS_OUTPUT.PUT_LINE('사번 / 이름');
			 DBMS_OUTPUT.PUT_LINE('--------------------');
			 DBMS_OUTPUT.PUT_LINE(vempno || '/' || vename);
		 end; 
		 /

		 
SQL> declare
		     vempno   emp.empno%type;
		     vename   emp.ename%type;
		 begin
			 DBMS_OUTPUT.PUT_LINE('사번 / 이름');
			 DBMS_OUTPUT.PUT_LINE('--------------------');
			
			 select empno, ename into vempno, vename
			 from emp
			 where ename='SCOTT';
			 
			 DBMS_OUTPUT.PUT_LINE(vempno || '/' || vename);
		 end; 
		 /
		 
		 
-- [3] record type 사용
--			.emp 테이블에서 scott 사원의 정보를 출력.

SQL>declare
			--레코드 타입을 정의
			type emp_record_type
			is record(
				v_empno  emp.empno%type,
				v_ename  emp.ename%type,
				v_job       emp.job%type,
				v_deptno  emp.deptno%type
			);
			
			emp_record   emp_record_type;
		begin
			select empno, ename, job, deptno
			into emp_record
			from emp
			where ename = 'SCOTT';
			
			DBMS_OUTPUT.PUT_LINE('사원번호' || TO_CHAR(emp_record.v_empno));
			DBMS_OUTPUT.PUT_LINE('사원이름' || TO_CHAR(emp_record.v_ename));
			DBMS_OUTPUT.PUT_LINE('담당업무' || TO_CHAR(emp_record.v_job));
			DBMS_OUTPUT.PUT_LINE('부서번호' || TO_CHAR(emp_record.v_deptno));
		end; 
		 /
		 
-- [4] 조건문
--		  . 사원번호가 7788인 사원의 부서 번호를 얻어와서 부서번호에 따른 부서명을 구하세요. 
SQL>declare
			vempno     number(4);
			vename     varchar2(20);
			vdeptno     emp.deptno%type;
			vdname     varchar2(20) := null;
		begin
			select empno, ename, deptno 
			into vempno, vename, vdeptno
			from emp
			where empno=7788;
			if(vdeptno = 10) then
			   vdname:='ACCOUNTING';
			elsif(vdeptno=20) then
			   vdname:='RESEARCH';
			elsif(vdeptno=30) then
			   vdeptno:='SALES';
			elsif(vdeptno=40) then
			   vdeptno:='OPERATION';
			--else
			--else는 생략가능
			end if;         --빼먹으면 안됨		
			
			 DBMS_OUTPUT.PUT_LINE('사번 / 이름 / 부서명');
			 DBMS_OUTPUT.PUT_LINE('--------------------');
			 DBMS_OUTPUT.PUT_LINE(vempno || '/' || vename || '/' || vdname);
		end;
		 /
		 
--[5] 반복문
--		1) basic loop문
SQL>declare
          n    number:=1;
        begin
	        LOOP
	        DBMS_OUTPUT.PUT_LINE(n);
	        n:=n+1;
	        
	        if(n>5) then
	            exit;
	        end if;
	        
	        end LOOP;
        end; 
		 /
		 

--		2) for loop 문
SQL>declare
		begin
			for n in 1..5 LOOP
			    DBMS_OUTPUT.PUT_LINE(n);
			END LOOP;
		end; 
		/ 
		
		
--		3) while loop 문
SQL>declare
			n     number := 1;
		begin
			while(n<=5) LOOP
				DBMS_OUTPUT.PUT_LINE(n);
				n:=n+1;
			end LOOP;		
		end; 
		 /
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 