package exam03.protect;

public class FatherClass {
	protected int num1;
	
	/*FatherClass(){
		System.out.println("FatherClass 호출");
		
	}*/
	
	public FatherClass(int num1)	{
		this.num1=num1;
	}
	 /*생성자를 만들면 default로 FatherClass(){}로 하지 않고 위에 생성자로 된다. 이경우
	 밑에서 에러가 없을라면 ChildClass(){ super(5)}로 해줘야 한다. 만약 이게 없다면 
	 부모의 필드를 초기화하지 못하여 오류가 뜬다.*/
	
}
