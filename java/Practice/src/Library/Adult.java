package Library;

class Adult extends Person { //인석사항 자식클래스(성인)
	Person person;
	private String Job;

	
	Adult(String name,  String age,  String phoneNumber, String address, String Job, String Seat){
		super(name, age, phoneNumber, address, Seat);
		this.Job = Job;
	}
	
	public void ShowInfo() {
		super.ShowInfo();
		System.out.println("직업 : " + Job);
		super.ShowSeat();
	}
	public void ShowBasicInfo() {
		super.ShowBasicInfo();
	}
	
}
