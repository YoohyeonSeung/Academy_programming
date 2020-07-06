package exam09;

abstract class Friend extends Object {
	//abstract라 붙으면 단독으로 사용하는 클래스가 아니라 상속의 구조에서 부모의 클래스로 쓰겟다는거
	private String name, phoneNum, address;
	
	
	Friend(String name, String phoneNum, String address){
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	public String getName() {
		return name;
	}
		
	public void ShowInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNum);
		System.out.println("주소 : " + address);
	}
	
	abstract public void ShowBasicInfo();    //오버라이딩 하기 위해 씀 밑에는 있기 때문에
	//추상 메서드가 하나라도 있다면 그 클래스는 추상클래스로 정의 해줘야 한다.
	//이 경우 자식 클래스에서 같은 이름의 메소드를 삭제할 경우 오류를 냄
}

class HighSch extends Friend {

	private String work;
	
	HighSch(String name, String phoneNum, String address, String work){
		super(name, phoneNum, address);
		this.work = work;
		
	}
	public void ShowInfo(int l) {
		super.ShowInfo();
		System.out.println("직업 : "+ work);
	}
	public void ShowBasicInfo(){
		System.out.println("이름 : "+getName());
		System.out.println("직업 : "+ work);
	}
	
	
}

class UnivFriend  extends Friend {

	private String SchName;
	
	UnivFriend(String name, String phoneNum, String address, String SchName){
		super(name, phoneNum, address);
		this.SchName = SchName;
		
	}
	public void ShowInfo() {
		super.ShowInfo();
		System.out.println("학교 : "+ SchName);
	}
	
	@Override //오버라이딩 한거라고 알려주는 표시
	public void ShowBasicInfo(){
		System.out.println("이름 : "+getName());
		System.out.println("학교 : "+ SchName);
	}
	
	/*public void ShowInfo() {
		super.ShowInfo();
		System.out.println("학교 : "+ SchName);*/
		
	
}



class MiddleFriend  extends Friend {

	private String Class;
		
	MiddleFriend(String name, String phoneNum, String address, String Class){
		super(name, phoneNum, address);
		this.Class = Class;
		
	}
	public void ShowInfo() {
		super.ShowInfo();
		System.out.println("반 : "+ Class);
	}
	public void ShowBasicInfo(){
		System.out.println("이름 : "+getName());
		System.out.println("반 : "+ Class);
	}
}
	/*public void ShowInfo() {
		super.ShowInfo();
		System.out.println("반 : "+ Class);
	
	}*/


