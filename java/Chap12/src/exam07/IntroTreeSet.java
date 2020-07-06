package exam07;

import java.util.TreeSet;
import java.util.Iterator;

public class IntroTreeSet {

	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<String>();
		
		//데이터 저장
		set.add("First");
		set.add("Second");
		set.add("Third");
		set.add("First");
		set.add("Fourth");
		
		System.out.println(set.size());     //HashSet과는 문자열 자료형 처리는 가능!
		
		Iterator itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());  //순서는 알아서 해줌 알파벳순서
		}
		
		
	}

}
