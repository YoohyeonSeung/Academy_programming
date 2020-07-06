-- * 오라클 - 시퀀스(Sequence)
--        . 테이블 내의 유일한 숫자를 자동으로 생성하는 자동 번호 발생기.
--        . 테이블 생성 후 시퀀스(일련번호)를 따로 만들어야 한다. 

--[1] 샘플 테이블 생성
create table memos(
	num			number(4) constraint memos_num_pk primary key,
	name 		varchar2(20) constraint memos_num_nn not null,
	postDate	Date default(sysdate)                                   
);
--sysdate : 현재시간 땡겨오는 방법
	
--	[2] 해당 테이블의 시퀀스 생성
create sequence memos_seq
start with 1 increment by 1;

-- [3] 데이터 입력 :  일련번호 포함.
insert into MEMOS(num, name)
values (memos_seq.nextVal, '꼰택');
insert into MEMOS(num, name)
values (memos_seq.nextVal, '짐구');
insert into MEMOS(num, name)
values (memos_seq.nextVal, '개샛기');
insert into MEMOS(num, name)
values (memos_seq.nextVal, '그뤁');
insert into MEMOS(num, name)
values (memos_seq.nextVal, '식초');
insert into MEMOS(num, name)
values (memos_seq.nextVal, '짐수빈');
	
select * from memos;

--[4] 현재 시퀀스가 어디까지 증가되어 있는지 확인.
--		 주의) 반드시 command 창에서 확인 할것.

insert into MEMOS(num, name)
values(memos_seq.nextVal, '안창호');
	
select memos_seq.currVal from dual;
	

--[5] 시퀀스 수정 : 최대 증가값을 8까지로 제한.
alter sequence memos_seq maxvalue 8;

insert into memos(num, name)
values (memos_seq.nextVal, '강성욕');

insert into memos(num, name)
values (memos_seq.nextVal, '장멸공');

--[6] 시퀀스 삭제
drop sequence memos_seq;

--[7] 시퀀스 없는 상태에서 자동 증가값 구현?
select max(num) from memos;

insert into memos(num, name)
value(읽어온 결과값 : max(num)+1, 'ㅎㅎ');






	
	
	