package exam01;
//자식 클래스
class BusinMan extends Friend {      // 회사원 친구 
	

	private String company; // 회사명
	private String department; // 소속 부서
	private String businessNum; // 사번
	
	BusinMan(String name, String birth, String address, String email, String company, String department, String businessNum){
		
		//Friend(name, birth, address, email);    //우리가 직접 생성자를 호출 할 수 없어서  이런식으로 하면 오류가뜸.   
		super(name, birth, address, email);      // <- 상속의 관계에 있는 경우super를 쓰지만 그 외에는 전혀 의미가 없음.
		this.company = company;
		this.department = department;
		this.businessNum = businessNum;
	}
	
	public void diplayBusinInfo() {
		displayFriendInfo();
		// System.out.println(name); 이 경우 Friend의 name을 출력하고 싶은데 field에서 private로 선언 하였으므로 접근 할수 없다. 만약 그냥 String name으로 하였다면 해당코드는 가능하다.
		System.out.println("회사 이름 : "+ company);
		System.out.println("부  서  명 : "+ department);
		System.out.println("사       번 : "+ businessNum);
	}
	
	
	
}
