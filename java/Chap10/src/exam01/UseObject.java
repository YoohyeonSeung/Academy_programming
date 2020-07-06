package exam01;

class Person extends Object{
	private String name;
	
	Person(String name){
		this.name = name;
	}
	
	@Override
	public String toString() {
		
		return name+"님 환영합니다.";
	}
	
	
}
public class UseObject {
	public static void main(String[] args) {
		Person person = new Person("홍길동");
		
		System.out.println(person.toString());
		System.out.println(person);            

	}

}
