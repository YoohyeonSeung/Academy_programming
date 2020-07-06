-- * 오라클  : 데이터 무결성 제약 조건

--   1) 데이터 무결성 제약 조건(Data Integrity Constraint Rule)
--        :  테이블에 부적절한 자료(데이터)가 입력되는 것을 방지하기 위해서 테이블을 생성할 때 
--           각 컬럼에 대해서 정의하는 여러가지 규칙을 의미.

--   2) 종류
---         . Not null/null : null을 허용할 지 아니면 반드시 데이터를 입력받게 할 건지의 조건.
---         . Unique : 지정된 컬럼에 중복되지 않고 유일한 값만 저장되는 조건.
---         . Primary key(기본키) : unique + not null
---         . Check : 특정한 값만 저장되는 필드 조건.
---         . Default : 기본값으로 특정 값이 저장되도록 설정하는 조건. 
---         . Foreign key(외래키) : 다른 테이블의 컬럼에 들어있는 값만 저장을 허용하는 조건.

-- * USER_CONSTRAINTS 데이터 딕셔너리 뷰
--            : 제약 조건에 관한 정보를 알려 줌.

SQL>desc USER_CONSTRAINTS; -- [command] 창에서 확인할 것.
--       - owner : 제약 조건을 소유한 사용자명을 저장하는 컬럼.
--       - constraint_name : 제약 조건명을 저장하는 컬럼.
--       - constraint_type : 제약 조건 유형을 저장하는 컬럼.
--           . P : primary key
--           . R : foreign key
--           . U : unique
--           . C : check, not null
--       - table_name : 각 제약 조건들이 속한 테이블의 이름.
--       - search_condition : 어떤 내용이 조건으로 사용되었는지 설명.
--       - r_constraint_name : 제약 조건이 foreingkey인 경우
--                          어떤 primary key를 참조했는지를 대한 정보를 가짐.

-- Not null
drop table emp01 purge;
create table emp01(
	empno		number(4),
	ename		varchar2(10),
	job 			varchar2(10),
	deptno		number(2)
);

--[null 데이터 입력 연습]
insert into emp01 values(null, null, 'salesman', 40);

select * from emp01;


--[2] Not null 제약 조건을 걸고 테이블 생성
drop table emp02 purge;
create table emp02(
	empno		number(4) not null,        -- empno항목은 반드시 값이 담겨야 한다.
	ename		varchar2(10) not null,
	job			varchar2(10),
	deptno		number(2)
	);

insert into emp02
values(null, null, 'salesman', 40);    --error!

insert into emp02
values(1234,null,  'salesman', 40);    --error!

insert into emp02
values(1234, '홍길동',  'salesman', 40);


select * from emp02;

--[3] Unique 제약 조건을 설정하여 테이블 생성
drop table emp03 purge;      --혹시 모를 테이블 삭제 

create table emp03(
	empno		number(4) unique,        
	ename		varchar2(10) ,
	job			varchar2(10),
	deptno		number(2)
	);

insert into emp03
values(1234, '홍길동',  'salesman', 40);

insert into emp03
values(5678, '이순신',  'manager', 30);

insert into emp03
values(5678, '박지성',  'manager', 30);    --위의 사원번호가 겹쳐서 오류!

insert into emp03
values(null, '박지성',  'manager', 30);     --unique는 null도 가능함

insert into emp03
values(null, '박수빈',  'manager', 30);     --심지어 unique는 null이 겹쳐도 상관 없음.
 
--[4] 컬럼 레벨로 조건명 명시하기. not null & unique 제약 조건
--		. 사용자가 제약 조건을 지정하지 않고, 제약 조건만 명시할 경우 오라클 서버가 
--		  자동적으로 제약 조건명을 부여한다.
--		. 오라클이 부여하는 제약 조건명은 SYS_ 다음에 숫자를 나열한다.
--		. 어떤 제약 족건을 위배했는지 알 수 없기 때문에 사용자가 의미있게 제약 조건명을 명시할
--		  수 있도록 오라클은 제공
drop table emp04 purge;
create table emp04(
	empno	number(4) constraint emp04_empno_uk unique,
	ename	varchar2(20) constraint emp04_ename_nn not null,
	job		varchar2(20),
	deptno	number(2)
);

insert into emp04
values(1234,'홍길동','salesman',40);

insert into emp04
values(1234, '지성팍','salesman',40);

--[5] Primary key(기본키) 제약조건 설정
--			: not null + unique
drop table emp05 purge;
create table emp05(
	empno	number(4) constraint emp05_empno_PK primary key,
	ename	varchar2(20) constraint emp05_ename_nn not null,
	job		varchar2(20),
	deptno	number(2)
);

insert into emp05
values(1234,'홍길동','salesman',40);

insert into emp05
values(1234, '지성팍','salesman',40);

--[6] 참조 무결성을 위한 Foreign key(외래키) 제약 조건
--		. 부모키가 되기 위한 컬럼은 반드시 부모 테이블의 기본키
create table dept06(
	deptno	number(2) constraint dept06_deptno_pk primary key,
	dname	varchar2(20),
	loc		varchar2(20)


);


drop table emp06 purge;
create table emp06(
	empno	number(4) constraint emp06_empno_PK primary key,
	ename	varchar2(20) constraint emp06_ename_nn not null,
	job		varchar2(20),
	deptno	number(2) constraint emp06_deptno_fk references dept06(deptno)
);


insert into emp06
values(1234, '지성팍','salesman',40);

--[7] Check 제약 조건 설정하기
--		. 급여 컬럼 생성하되 값은 500~5000 사이의 값만 가능.
--		. 성별 저장 컬럼으로  gender를 정의하고, 'M', 'F' 둘중 하나의 값만 저장 가능.

create table emp07(
	empno		number(4) constraint emp07_empno_pk primary key,
	ename		varchar2(20) constraint emp07_empno_nn not null,
	sal				number(7,2) constraint emp07_sal_ck check(sal between 500 and 5000),
	gender		varchar2(1) constraint emp07_gender_ck check(gender in ('M', 'F'))
);
insert into emp07
values(1234,'홍길동', 400, 'M'); --error


insert into emp07
values(2222,'윤짐구', 550, 'F');

--[8] Default 제약 조건 설정하기
--		. 지역명(loc) 컬럼에 아무 값도 입력하지 않을 때, 디폴트 값인 'SEOUL' 입력되도록
--		  디폴트 제약 조건 지정.

drop table dept08;
create table dept08(
	deptno	number(2) constraint dept08_deptno_pk primary key,
	dname	varchar2(20) constraint dept08_dname_nn not null,
	loc		varchar2(20) default 'SEOUL'
);

insert into dept08(deptno, dname)
values(10, 'ACCOUNT');

insert into dept08
values(40, 'SALESMAN', 'PUSAN');


select * from dept08;

--[9] 제약 조건 명시 방법
--		1) 컬럼 레벨로 제약 조건명을 명시해서 제약 조건 형성.

create table emp09(
	empno		number(4) primary key,
	ename		varchar2(20) not null,
	job			varchar2(20) unique,
	deptno		number(2) references dept08(deptno)
);

--     2) 테이블 레벨 방식으로 제약 조건 설정.
--			주의) not null 조건은 테이블 레벨 방식으로 제약 조건을 지정 할 수 없다. 
drop table emp09;
create table emp09(
	empno		number(4),
	ename		varchar2(20) not null,
	job			varchar2(20), 
	deptno		number(2) ,
	constraint emp09_ename_pk primary key(empno),
	constraint emp09_job_uk unique(job),
	constraint emp09_deptno_fk
			foreign key(deptno) references dept08(deptno)
);


--[10] 제약 조건 추가하기
create table emp10(
	empno		number(4) ,
	ename		varchar2(20) ,
	job			varchar2(20),
	deptno		number(2) 
);

alter table emp10
add constraint emp10_empno_pk primary key(empno);

insert into emp10
values(null, '홍길동',null, null);  --error!

alter table emp10
add constraint emp10_deptno_fk
foreign key(deptno) references dept08(deptno);

--[11] not null 제약 조건 추가하기
alter table emp10
add constraint emp10_ename_nn not null(ename);  --error

alter table emp10
modify ename constraint emp10_ename_nn not null;

--[12] 제약 조건 삭제하기
alter table emp10
drop primary key;

--[13] 제약 조건(외래키) 삭제하기
delete from dept06
where deptno = 10; --error

--   1) 제약 조건의 비활성화
--        - 자식 테이블인 사원테이블(emp06)은 부모테이블(dept06)에 기본키인 부서번호를 참조하고 있다.
--        - 부서 테이블의 30번 부서는 사원테이블에 근무하는 30번 사원이 존재하기 때문에 삭제할 수 없다.
--        - 부모테이블의 부서번호 30번이 삭제되면 자식테이블에서 자신이 참조하는 부모를 잃어버리게 되므로
--           삭제할 수 없는 것이다.

--        - 어떻게 삭제?
--          (1) 부서 테이블의 30번 부서에서 근무하는 사원을 삭제한 후 부서 테이블에서 30번 부서를 삭제.
--          (2) 참조 무결정 때문에 삭제가 불가능하므로 emp06에서 제약 조건을 제거한 후에 30번 부서를 삭제.

--        - 제약조건의 비활성화
--          (1) 테이블에서 제약 조건을 삭제하지 않고 일시적으로 제약 조건이 적용되지 않도록하는 방법으로
--                제약 조건을 비활성화 하는 방법.
--          (2) .DISABLE CONSTRAINT : 제약 조건의 일시 비활성화
--               .ENABLE CONSTRAINT : 비활성화된 제약 조건을 해제하여 다시 활성화 

alter table emp06
disable constraint emp06_deptno_fk;

delete from dept06
where deptno=10;

insert into dept06
values(10,'ACCOUNT', 'SEOUL');

select * from dept06;

alter table emp06
enable constraint emp06_deptno_fk;

-- 2) cascade 옵션
--		- 부모테이블(dept06)과 자식 테이블(emp06)간의 참조설정(외래키)이 되어 있을때 부모 테이블의
--		   제약조건을 비활성화하면 이를 참조하고 있는 자식 테이블의 제약 조건까지 같이 비활성화 시켜주는 옵션.
--		- 제약 조건의 삭제에는 활용.
--		- 부모테이블의 제약조건을 삭제하면 이를 참조하고 있는 자식 테이블의 제약 조건도 같이 삭제됨.

alter table dept06
disable primary key cascade;


--cmd창에서 확인.
SQL>column constraint_name format a15
SQL>column constraint_type format a4
SQL>column table_name format a10
SQL>column r_constraint_name format a10

SQL> select constraint_name, constraint_type, table_name, r_constraint_name, status
		from user_constraints
		where table_name in ('DEPT06','EMP06');

alter table dept06   --이클립스에서 실행, 그리고 오류가 뜸
drop primary key;

alter table dept06   
drop primary key cascade;

alter table dept06   
add constraint dept06_deptno_pk primary key(deptno);




