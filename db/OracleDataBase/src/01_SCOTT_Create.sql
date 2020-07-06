--* scott 계정 활성화[command 창 확인]
c:\>sqlplus system/admin1234

SQL>c:\scott.sql
SQL>alter user scott identified by tier;    --비밀번호 변경
SQL>conn scott/tiger      -- scott계정으로 변환
SQL>show user;
SQL>select * from tab;
SQL>select * from dept;
SQL>quit;