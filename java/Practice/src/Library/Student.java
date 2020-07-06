package Library;

class Student extends Person {  //인적사항 자식클래스(학생)
	Person person;
	private String School;
	private String Major;
	
	Student(String name,  String age,  String phoneNumber, String address, String School, String Major, String Seat){
		super(name, age, phoneNumber, address, Seat);
		this.School = School;
		this.Major = Major;
	}
	
	public void ShowInfo() {
		super.ShowInfo();
		System.out.println("학교 : " + School);
		System.out.println("전공 : " + Major);
		super.ShowSeat();
	}
	public void ShowBasicInfo() {
		super.ShowBasicInfo();
	}
}
