package Library;

class Person {     //인적사항 부모 클래스
	private String name;
	private String age;
	private String phoneNumber;
	private String address;
	private String Seat;

	Person(String name,  String age,  String phoneNumber, String address, String Seat){
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;	
		this.Seat = Seat;
	}
	
	
	public void ShowInfo() {
		System.out.println("이름 : " +name);
		System.out.println("나이 : " + age);
		System.out.println("연락처 : " + phoneNumber);
		System.out.println("주소 : " + address );
	}
	public void ShowSeat() {
		System.out.println("좌석 : "+ Seat );
	}
	
	public void ShowBasicInfo() {
		System.out.println("이름 : " +name);
		System.out.println("좌석 : "+ Seat );
	}
	
	
}
