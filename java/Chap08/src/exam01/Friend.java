package exam01;

class Friend {  //부모클래스
	
	// 학생이나 직장인의 공통된 특징을 하나의 클래스로 묶고 다른데선 extends Friend로 해서 쓸 수 있게 함. 상속을 하는 구조
	
	private String name; // 이름
	private String birth;  // 생년월일
	private String address; // 주소
	private String email;  // 이메일
	
	Friend(String name, String birth, String address, String email){
		this.name = name;
		this.birth = birth;
		this.address = address;
		this.email = email;
		
	}
	
	public void displayFriendInfo() {
		System.out.println("이   름 : " + name );
		System.out.println("생   일 : " + birth );
		System.out.println("주   소 : " + address );
		System.out.println("이메일 : " + email );
	}
	
}
