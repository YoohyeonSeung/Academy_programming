package exam05;

import java.util.HashSet;
import java.util.Iterator;
class Num{
	int num;
	
	Num(int num){ this.num = num;    }

	@Override
	public String toString() {
		return String.valueOf(num);
	}
	@Override
	public int hashCode() {
		return num%3;
	}	
	
	@Override
	public boolean equals(Object obj) {
		Num comp = (Num) obj;
		
		if(comp.num == num) {
			return true;}
		else {
			return false;
		}
	}

}
public class HashSetEqual {

	public static void main(String[] args) {
		HashSet<Num> set = new HashSet<Num>();		
		
		set.add(new Num(10));
		set.add(new Num(20));
		set.add(new Num(10));
		set.add(new Num(30));
		
		System.out.println(set.size()); 
		// 참조변수이기 때문에 주소값이 저장된 것이므로 사이즈가 4이다. 
		
		Iterator<Num> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());				
		}
	}

}
