package exam11;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class IntroTreeMap {

	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		
		map.put(6, "data6");
		map.put(5, "data5");
		map.put(4, "data4");
		map.put(3, "data3");
		map.put(2, "data2");
		map.put(1, "data1");
		
		NavigableSet<Integer> navi= map.navigableKeySet();
		
		System.out.println("===오름차순===");

		Iterator<Integer> itr = navi.iterator();		
		
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next()));   //itr.next()로 하면 key값이 반환됨.
		}
		
		System.out.println("===내림차순===");
		itr = navi.descendingIterator();
		
		while(itr.hasNext()) {
			System.out.println(map.get(itr.next()));   //itr.next()로 하면 key값이 반환됨.
		}
		
		
	}

}
