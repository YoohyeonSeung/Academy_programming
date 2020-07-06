package exam09;

import java.util.Iterator;
import java.util.TreeSet;

class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void showData() {
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
	}

	@Override //얘 없으면 Person에서 오류뜸
	public int compareTo(Person o) {
		/*if(age>o.age) {
			return 1;
		}else if(age==o.age)//->나이가 같으면 같은 데이터라고 본다.
			{  
			return 0;
		}else {
			return -1;
		}		*/
		return age - o.age;
	}
}


public class ComparablePerson {

	public static void main(String[] args) {
		TreeSet<Person> set = new TreeSet<Person>();
		
		set.add(new Person("그뤁", 30));
		set.add(new Person("양샛기", 30));
		set.add(new Person("꼰택", 30));
		set.add(new Person("식초", 30));
		set.add(new Person("짐수", 90));
		set.add(new Person("짐수빈", 29));
		
		
		Iterator<Person> itr = set.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
		}
		
	}
		

}
