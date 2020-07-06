create or replace procedure cursor_sample01
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