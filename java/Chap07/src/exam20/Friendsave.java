package exam20;

class Friendsave {
	/*private String[] friend = new String[4];*/
	private String name;
	private String PhoneNum;
	private String Address;
	private int age;
	
	Friendsave(String name,	String PhoneNum,	String Address, int age){
		this.name=name;
		this.PhoneNum=PhoneNum;
		this.Address=Address;
		this.age=age;
		
	}
	
	public void Output() {
		System.out.printf("His name is %s. \n", name);
		System.out.printf("His phone-number is %s. \n",PhoneNum);
		System.out.printf("His address is %s. \n", Address);
		System.out.printf("His age is %s. \n", age);
	}
	
}
