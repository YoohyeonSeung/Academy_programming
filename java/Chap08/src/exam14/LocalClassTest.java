package exam14;



public class LocalClassTest {

	public static void main(String[] args) {
OuterClass outer = new OuterClass("First");
		
		readable localClass = outer.createLocalClassInst(5);
		localClass.read();
		

	}

}
