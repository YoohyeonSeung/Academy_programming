package exam07;

public class WrapperInteger {

	public static void showData(Object obj) {
		System.out.println(obj);
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		Integer intInst = new Integer(10);

		showData(intInst);
		
		showData(new Integer(200));
	}

}
