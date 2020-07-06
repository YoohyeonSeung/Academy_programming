package exam12;

public class NestedClassTest {

	public static void main(String[] args) {
		OuterClassOne one = new OuterClassOne();
		OuterClassTwo two = new OuterClassTwo();
		
		
		OuterClassOne.NestedClass nst1 = new OuterClassOne.NestedClass();	
		//class 안의 static으로 선언된 nested class를 선언하는 방법임.

		//new OuterClassTwo.NestedClass();
		//private을 썼으므로 OuterClassTwo밖에서는 호출 불가
		
		
		//one.simpleMethod(); // error

		one.WhoAreYou();
		
		
		
		
		
		
	}

}
