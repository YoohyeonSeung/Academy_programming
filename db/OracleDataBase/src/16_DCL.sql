--  * 오라클 : 사용자(User) 권한(Role)
--						 (DCL : Data Control Language)

-- [1] 권한의 역할과 종류
--		-권한 : 사용자가 특정 테이블에 접근 할 수 있도록 하거나 해당 테이블에 
--				 sql(select/insert/update/delete)문을 사용할 수 있도록 제한을 두는 것.
--		-데이터베이트 보안을 위한 권한은 시스템 권한과 객체 권한으로 나눌 수 있다.
--		-시스템 권한 : 사용자의 생성과 제거, DB 접근 및 각종 객체를 생성 할 수 있는 권한을 주로 DBA에 부여됨. 
--		-객체 권한 : 객체를 조작할 수 있는 권한.

-- [2] thomas 계정 생성(command 창에서 실행)
SQL> conn system/admin1234
SQL> show user;

SQL> create user thomas identified by tiger;   -->계정은 생성되었으나 권한은 아직 받지 못함.

--[3] 데이터베이스 접속 권한 부여
SQL> conn system/admin
SQL> grant create session to thomas; -- 접속권한 부여
SQL> conn thomas/tiger

SQL> create table emp01(
            empno    number(2),
            ename   varchar2(20), 
            job         varchar2(20), 
            deptno   number(2)
         );  --테이블 생성 권한 없음
         
--[4] 테이블 생성 권한
SQL>conn system/admin1234
SQL>grant create table to thomas; -- 테이블 생성 권한 부여

--그러나 테이블 저장공간 권한은 아직 없다.








--[5] 테이블 스페이스 확인
--		: 테이블 스페이스(table space)는 디스크 공간을 소비하는 테이블과 뷰를 그리고 그 밖의 다른 
--		  데이터베이스들이 저장되는 장소.
--		  cf) 오라클 xe버전의 경우 메모리 영역은 system으로 할당.
--		        오라클 full 버전의 경우 메모리 영역은 users으로 할당.
--				SQL>alter user thomas quota 2m on users;

SQL>conn system/admin1234
SQL>alter user thomas quota 2m on system;
SQL> create table emp01(
			empno	number(2),
			ename	varchar2(10),
			job		varchar2(10),
			deptno	number(2));
SQL> select * from tab;

-- ※계정 생성 및 테이블 생성까지의 권한 부여 정리
c:\>sqlplus system/admin1234
SQL> create user thomas identified by tiger;	
SQL> grant create session to thomas;
SQL>grant create table to thomas; 
SQL>alter user thomas quota 2m on system;

-- [6] with admin option
--			: 사용자에게 시스템 권한을 with admin option과 함께 부여하면 그 사용자는 데이터베이스 관리자가 
--			   아닌데도 불구하고 부여받은 시스템 권한을 다른 사용자에게 부여 할 수 있는 권한도 함께 부여 받게 됨.

-- tester1 계정 생성 및 권한 부여
c:\>sqlplus system/admin1234
SQL> create user tester1 identified by tiger;	
SQL> grant create session to tester1;
SQL>grant create table to tester1; 
SQL>alter user tester1 quota 2m on system;

SQL> conn tester1/tiger
SQL> grant create session to thomas;    --tester1은 부여 권한 없음 error!


-- tester2 계정 생성 및 권한 부여
drop user tester2;
c:\>sqlplus system/admin1234
SQL> create user tester2 identified by tiger;	
SQL> grant create session to tester2 with admin option;
SQL>grant create table to tester2; 
SQL>alter user tester2 quota 2m on system;


SQL> conn tester2/tiger
SQL> grant create session to thomas;

-- [7] 테이블 객체에 대한 select 권한 부여(scott/emp -> thomas)
SQL> conn scott/tiger
SQL> grant select on emp to thomas;
SQL> select * from emp;    --error!

--[8] 스키마(SCHEMA) : 객체를 소유한 사용자명을 의미.
SQL> select * from scott.emp;

--[9] 사용자에게 부여된 권한 조회
--		. user_tab_privs_made : 현재 사용자가 다른 사용자에게 부여한 권한 정보를 알려줌.
--		. user_tab_privs_recd : 자신에게 부여된 사용자 권한을 알고 싶을 때.

SQL>conn thomas/tiger
SQL>select * from user_tab_privs_made;
SQL>select * from user_tab_privs_recd;

-- [10] 비밀번호 변경시
SQL> conn system/admin1234
SQL> alter user thomas identified by thomas;

-- [11] 객체 권한 제거하기
SQL>conn scott/tiger
SQL>revoke select on emp from thomas;

-- [12] with grant option
--			: 사용자에게 객체 권한을 with grant option과 함께 부여하면 사용자는 
--			  객체를 접근할 권한을 부여받으면서 그 권한을 다른 사용자에게 부여 할 수 있는 
--			  권한도 함께 부여받게 됨.
SQL>conn scott/tiger
SQL>grant select on emp to tester1 with grant option;

SQL> conn tester1/tiger
SQL> grant select on scott.emp to tester2;

-- [13] 사용자 계정 제거
SQL> conn system/admin1234
SQL> drop user tester2;

-- [14] 롤(Role)
--			. 사용자에게 보다 효율적으로 권한을 부여 할 수 있도록 여러개의 권한을 묶어 놓은 것.
--			. 사용자를 생성했으면 그 사용자에게 각종 권한을 부여해야만 생성된 사용자가 데이터베이스를 사용할 수 있음.

--   1) connect Role
--       . 사용자가 데이터베이스에 접속 가능하도록 하기 
--         위해서 다음과 같이 가장 기본적인 시스템 권한
--         8가지 묶어 놓은 권한.
--       . alter session, create cluster, create database link,
--         create sequence, create session, create synonym,
--         create table, create view

--   2) resource Role
--       . 사용자가 객체(테이블, 시퀀스, 뷰)를 생성할 수 있도록
--         시스템 권한을 묶어 놓은 것.
--       . create cluster, create procedure, create sequence,
--         create table, create trigger

--   3) DBA Role
--       . 사용자들이 소유한 데이터베이스 객체를 관리하고 
--         사용자들이 작성하고 변경하고 제거할 수 있도록 하는
--         모든 권한을 가짐.

SQL>conn system/admin1234
SQL>create user tester identified by tiger;
SQL>grant connect, resource to tester2;
SQL>conn tester2/tiger
SQL>select * from dict
		where table_name like '%ROLE%';



