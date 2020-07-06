package exam06;

import java.util.HashSet;
import java.util.Iterator;

class Person{
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}

	
	@Override
	public int hashCode() {
			
		return (name + age).hashCode();
	}	
	
	@Override
	public boolean equals(Object obj) {
		if (         obj instanceof Person     ) {
			Person tmp = (Person ) obj;
			return name.equals( tmp.name )&& (age==tmp.age);
			
		}
		
		return false;
				
	}


	@Override
	public String toString() {
		
		return name+":"+ age;
	}
	
		
	
}
public class HashSetEqual {

	public static void main(String[] args) {
		HashSet<Person> set = new HashSet<Person>();

		set.add(new Person("양샛기", 30));
		set.add(new Person("식초", 30));
		set.add(new Person("짐수빈", 29));
		set.add(new Person("짐구", 90));
		set.add(new Person("꼰택", 30));
		set.add(new Person("그뤁", 30));
		set.add(new Person("식초", 30));
		
		Iterator<Person> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());				
		}
		
	}

}
