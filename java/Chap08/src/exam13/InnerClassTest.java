package exam13;

public class InnerClassTest {

	public static void main(String[] args) {
		OuterClass outer1 = new OuterClass();
		OuterClass outer2 = new OuterClass();
		OuterClass outer3 = new OuterClass();

		//inner class사용방법
		
		OuterClass.InnerClass inner1 = outer1.new InnerClass();
		OuterClass.InnerClass inner2 = outer2.new InnerClass();
		OuterClass.InnerClass inner3 = outer3.new InnerClass();
		
	}

}
