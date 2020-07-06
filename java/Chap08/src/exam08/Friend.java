package exam08;

class Friend extends Object {
	private String name, phoneNum, address;
	
	
	Friend(String name, String phoneNum, String address){
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void ShowBasicInfo() { }   //오버라이딩 하기 위해 씀 밑에는 있기 때문에
	
	public void ShowInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNum);
		System.out.println("주소 : " + address);
	}

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


