-- * 오라클 : 트리거(Trigger)
--     . 이벤트가 발생하면 자동적으로 방아쇠가 당겨져서 총알이 발사되듯이 특정 테이블이 변경되면
--       이들 이벤트가 다른 테이블이 자동적으로 변경되로록 하기 위해 사용됨.
--     . 특정 동작을 이벤트로 그로 인해서만 실행되는 프로시저의 일종.
--       트리거의 타이밍
--         -[before] : 타이밍은 어떤 테이블에 insert, update, delete문이 실행될 때 해당
--				            문장이 실행되기 전에 트리거가 가지고 있는 begin ~ end 사이의 문장을 실행.
--         -[after] : 타이밍은 insert, update, delete문이 실행되고 난 후에 트리거가 가지고 있는 
--						begin ~end 사이의 문장 실행.


SQL>ed trigger01
SQL>@trigger01
--만약 입력 받았는데 문장이 출력되지 않는다면
set serveroutput on --얘를 먼저 실행시켜줘야한다.








