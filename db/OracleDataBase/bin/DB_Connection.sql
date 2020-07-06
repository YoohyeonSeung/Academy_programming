--* 오라클 접속
c:\>sqlplus system/admin1234    -- 방법1 이렇게 하면 보완상 아주 안좋음(비밀번호 노출)

c:\>sqlplus      -- 방법 2
사용자명 입력 : sytem
암호 입력 : (admin1234)   -- 입력해도 안보임



--system계정으로 접속시에만 가능.
--[1]최고 관리자로 접속하여 hr사용자의 계정을 풀어줌.
SQL>alter user hr account unlock;
--[2]사용자 암포를 변경
SQL>alter user hr identified by tiger;
--[3] 현재 접속하고 있는 계정 확인
SQL>show user;
--[4] 접속 계정 변경
SQL>conn scott/tiger
--[5] 계정 사용 풀어줌 + 암호 변경
SQL>alter user scott identified by tiger account unlock;