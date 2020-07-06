package exam03;

import exam03.protect.FatherClass;

class ChildClass extends FatherClass{
	
	ChildClass(){
		super(5);       
	}
	
	public void accessFieldFatherClass() {
		System.out.println("num1 = "+ num1);   
		
		
		/*exam02의 예제와는 다르게 같은 폴더에서는 이 코드가 오류가 없지만 
		 * num1에서 오류가 없게 하려면 FatherClass에서 field에서 선언된 변수 앞에 protected를 넣어줘야함
		 */
	}
	
}


public class DefaultSuper {
	public static void main(String[] args) {
		
		new ChildClass();
	}
}