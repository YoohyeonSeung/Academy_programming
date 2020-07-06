package exam04.calc;

public class Calculator {  // 계산기,  다른 소스에서 쓰기위해 public을 앞에 써줌
	Adder Plus;   //field에 선언을 하면 지역변수로 되지 않기 때문에 밑에 주석에서 말한 오류가 발생하지 않음.
	Subtractor Minus;
	
	public Calculator(){   // 계산기 자료형, 다른 소스에서 쓰기위해 public을 앞에 써줌
		Plus = new Adder();  //Adder cal =new Adder();라 하면 지역변수이다 보니 여기 있다가 밑으로 내려가면 소멸됨
		Minus = new Subtractor();				
	}
	
	public int calAddTwoNum(int num1, int num2) {
		//Adder Plus =new Adder(); 이렇게 하면 메소드가 호출될때마다 메모리가 계속 할당되고 결과 count가 하나씩 늘어나지 않는다.
		int result;  
		result = Plus.addTwoNumber(num1, num2);
		System.out.println("덧셈 횟수 : "+Plus.getCntAdd());
		return result;
	}
	
	public int calSubTwoNum(int num1, int num2) {
		int result;
		result = Minus.subTwoNumber(num1, num2);
		System.out.println("뺄셈 횟수 : "+ Minus.getCntSub());
		return result;
		
	}
	
}


