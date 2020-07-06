package exam10;

public class AbstractInterface {

	public static void main(String[] args) {
		PersonalStorage person = new PersonalStorageImplement();
		
		// ui 화면 구성
		
		person.addPersonalInfo("홍길동", "72008629");
		person.addPersonalInfo("강감찬", "72008628");
		person.addPersonalInfo("이순신", "72008627");
		
		System.out.println(person.searchName("홍길동"));
		System.out.println(person.searchName("강감찬"));
		System.out.println(person.searchName("이순신"));
		
		
	}

}
