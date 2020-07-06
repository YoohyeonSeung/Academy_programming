package exam02;

import java.util.Iterator;
import java.util.LinkedList;

public class IntroLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
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
		
		System.out.println("\n====삭제====");
		list.remove(1);
		
		System.out.println(list.size());
		
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		
		System.out.println("\n iterator 이용");
		Iterator<Integer> itr = list.iterator();        //5버전 이전에 읽어들이는 방법 위의 for each구문과 같은 방법
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
					
		}
	}

}
