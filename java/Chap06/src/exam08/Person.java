package exam08;

class Person {
	private String name; //이름
	private int milID;  //군번
	private int birthYear; //태어난 해
	private int birthMonth; //태어난 월
	private int birthDay; //태어난 일
	
	Person(String name, int mID, int birthYear, int birthMonth, int birthDay){  
		this.name = name; 
		this.milID = mID;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
	}
	Person(String name, int birthYear, int birthMonth, int birthDay){  
		this(name, 0, birthYear, birthMonth, birthDay);
   /*  생성자를 오버로딩 해주기 위해 Person대신 this를 써서 할수 있음 만약 저렇게 안하면
    아래의 다섯줄을 모두 써야됨
	this.name = name;
	this.milID=0;
	this.birthYear = birthYear;
	this.birthMonth = birthMonth;
	this.birthDay = birthDay;
	*/
	}
	Person(String name, int mID){  
		this(name, mID, 0, 0, 0);
	
//		this.name = name; 
//		this.milID = mID;
//		this.birthYear = 0;
//		this.birthMonth = 0;
//		this.birthDay = 0;
	
	}
	Person(String name){  
		this(name, 0, 0, 0, 0);
	}
	
	public void ShowInfo() {
		if (milID==0) {
			System.out.println("이름 : " + name);
		}
		else {
			System.out.println("이름 : " + name);
			System.out.println("군번 : " + milID);
		}
		
		
	}
	
}
