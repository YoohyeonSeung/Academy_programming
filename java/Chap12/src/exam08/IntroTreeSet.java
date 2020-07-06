package exam08;

import java.util.Iterator;
import java.util.TreeSet;

public class IntroTreeSet {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		
		//데이터 저장 방법
		set.add(50);      //autoboxing으로 인해 알아서 됨 원래는 new Integer(50)해줘야됨
		set.add(10);
		set.add(150);
		set.add(52);
		set.add(74);
		set.add(4);

		Iterator<Integer> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());  //순서는 알아서 해줌 작은 숫자 순
		}
		
		set.remove(4);
		
		
		/*while(itr.hasNext()) {                          
			System.out.println(itr.next()); 
		}*/
		/*결과값이 출력되지 않음 
		 * itr의 여섯번째가 이미 끝난 이후라 7번째를 쳐다보게된다. 그런데 7번째 부턴 값이 저장된것이 없기 때문에 
		 * 값이 출력될 수 없다.  
		*/
			
		System.out.println("\n=====삭제 후 결과 출력=====");
		itr = set.iterator();               // 삭제 후에 다시 정의됨.
		while(itr.hasNext()) {
			System.out.println(itr.next());  //순서는 알아서 해줌 작은 숫자 순
		}
		//만약 참조변수라면 정렬의 방법을 우리가 직접 알려줘야 한다. 
	}

}
