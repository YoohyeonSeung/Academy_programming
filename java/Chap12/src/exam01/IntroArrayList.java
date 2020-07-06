package exam01;

import java.util.ArrayList;

public class IntroArrayList {

	public static void main(String[] args) {
		//Integer num1 = new Integer(10); //숫자 10을 클래스로 감싸서 객체처럼 쓸수 잇게 해주는 wrapper class
		
		/*Integer[] num = new Integer[3];    //stack영역에 24byte 할당(참조변수 3개를 할당 할 수 있는 공간), 만약 32비트 운영체제라면 하나당 4바이트 총 12바이트!
		
		num[0] = new Integer(10);
		num[1] = new Integer(20);
		num[2] = new Integer(30);*/
		
		//참조변수를 이용하여 위와 같은 코드를 관리하는 방법!(Generic)
		
		ArrayList<Integer> list = new ArrayList<>();
		
		// 데이터(참조변수-Instance) 저장방법

		list.add(new Integer(10));
		list.add(new Integer(20));
		list.add(new Integer(30));
	
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("\n====for each 문====");
		for ( Integer e : list   ) {
			System.out.println(e);			
		}	
		
		// 데이터 삭제
		System.out.println("\n====삭제====");
		list.remove(1);
		
		System.out.println(list.size());
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}
