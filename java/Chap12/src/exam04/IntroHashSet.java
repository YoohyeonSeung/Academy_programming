package exam04;

import java.util.HashSet;
import java.util.Iterator;

public class IntroHashSet {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();	
		
		// 데이터 저장
		set.add("First");     //엄밀히 말하면 set.add(new String("First"));
		set.add("Second");
		set.add("Third");
		set.add("Fourth");
		set.add("Second");
		
		//System.out.println(set.size());  //데이터의 중복을 허용하지 않기 때문에 size가 4이다.
		
		/*데이터 참조
		for(int i=0; i<set.size();i++) {
			set.get(i);                        ->정렬이 안되어 있기 때문에 get이라는 메소드가 존재 하지 않음
		}*/
		
		for (String e : set) {
			System.out.println(e);      //->저장 순서를 유지 하지 않기 때문에 출력도 순서가 없음
		}

		System.out.println("===========");
		
		Iterator<String> itr = set.iterator();        //5버전 이전에 읽어들이는 방법 위의 for each구문과 같은 방법
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
					
		}
	}

}
