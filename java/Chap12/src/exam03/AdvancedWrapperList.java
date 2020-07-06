package exam03;

import java.util.LinkedList;

public class AdvancedWrapperList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.add(10);    //wrapper class로 안해도 오류가 안나는 이유는 5version이후에 autoBoxing 기능이 있기 때문이다. 
		list.add(20);
		list.add(30);
		list.add(40);
		
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

	}
}